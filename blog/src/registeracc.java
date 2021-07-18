

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class registeracc
 */
@WebServlet("/registeracc")
public class registeracc extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public registeracc() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String email = request.getParameter("email");
		String username = request.getParameter("username");
		String password1 = request.getParameter("password1");
		String password2 = request.getParameter("password2");
		
		if( !password1.equals(password2)){
			String error = "Password didn't match.";
			HttpSession session = request.getSession();
			session.setAttribute("notmatch", error);
			RequestDispatcher rd = request.getRequestDispatcher("/register.jsp");
			rd.forward(request, response);
		}
		
		else {
		
		Connection c = null;

		Statement stmt = null;
		
		try {
			Class.forName("org.postgresql.Driver");
			
			c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/sample", "postgres", "1234");

			System.out.println("Successfully connected.");
 
			stmt = c.createStatement(); 
			
			((java.sql.Statement) stmt).execute("insert into blog(email, username, password) values ('" + email + "','" + 
					username + "','" + password1 + "');");
			
			RequestDispatcher rd = request.getRequestDispatcher("/home.jsp");
			rd.forward(request, response);
			
		}catch (Exception e) {
			response.getWriter().append(e.getClass().getName() + ":" + e.getMessage());
		}
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
