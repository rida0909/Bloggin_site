

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class changepassword
 */
@WebServlet("/changepassword")
public class changepassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public changepassword() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String un = request.getParameter("username");
		String pd1 = request.getParameter("password1");
		String pd2 = request.getParameter("password2");
		String oldpd = request.getParameter("passwordold");
		
		Connection c = null;

		Statement stmt = null;
		
		try {
			Class.forName("org.postgresql.Driver");

			c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/sample", "postgres", "1234");

			System.out.println("Successfully connected.");

			stmt = c.createStatement();
			
			try {
				Class.forName("org.postgresql.Driver");

				c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/sample", "postgres", "1234");

				stmt = c.createStatement();

				ResultSet re = stmt.executeQuery("select * from public.blog where username= '" +un + "' ;"); 
					
				while(re.next()) {
				
					String pwd = re.getString("password");
					
					if( !pwd.equals(oldpd)){
						String error = "Your current password is incorrect.";
						request.setAttribute("notmatch", error);
						RequestDispatcher rd = request.getRequestDispatcher("/pwdchange.jsp");
						rd.forward(request, response);
					}
					
				}

			RequestDispatcher rs = request.getRequestDispatcher("/home.jsp");
			rs.forward(request, response);

	}catch (Exception e) {

		response.getWriter().append(e.getClass().getName() + ":" + e.getMessage());
		// System.err.println(e.getClass().getName() + ":" + e.getMessage());
		//System.exit(0);
	}

			((java.sql.Statement) stmt).execute("update public.blog set password = '" + pd1 + "' where username = '" + un + "' ;"); 
			

			if( !pd1.equals(pd2)){
				String error = "Password didn't match.";
				request.setAttribute("notmatch", error);
				RequestDispatcher rd = request.getRequestDispatcher("pwdchange.jsp");
				rd.forward(request, response);
			}
			
			
		}
		
		catch (Exception e) {

			response.getWriter().append(e.getClass().getName() + ":" + e.getMessage());
			// System.err.println(e.getClass().getName() + ":" + e.getMessage());
			//System.exit(0);
		}
			
		 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
