

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
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class loginacc
 */
@WebServlet("/loginacc")
public class loginacc extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginacc() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		Connection c = null;

		Statement stmt = null;
		
		try {
			Class.forName("org.postgresql.Driver");

			c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/sample", "postgres", "1234");

			stmt = c.createStatement();
			
			String une = request.getParameter("enter_username");
			String eid = request.getParameter("enter_email");
			String pwd = request.getParameter("enter_password");

			ResultSet re = stmt.executeQuery("select * from public.blog where username= '" +une + "' ;"); 
				
			while(re.next()) {
			
				String id = re.getString("email");
				String un = re.getString("username");
				String pd = re.getString("password");
				
			
			if(id.equals(eid) && pd.equals(pwd)) {
				
				HttpSession session = request.getSession();
				session.setAttribute("user", un);
				RequestDispatcher rs = request.getRequestDispatcher("/blog_post");
				rs.forward(request, response);
				
			}
			
			else {
				
				String error = "Invalid email or password";
				request.setAttribute("error", error);
				RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
				rd.forward(request, response);
				
			}
			
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
