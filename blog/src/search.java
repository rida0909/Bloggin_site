

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class search
 */
@WebServlet("/search")
public class search extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public search() {
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
		
		HttpSession session = request.getSession();
		String userSearch = request.getParameter("search");
		String us = (String)session.getAttribute("user"); 
		

		try {
			Class.forName("org.postgresql.Driver");

			c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/sample", "postgres", "1234");

			System.out.println("Successfully connected.");

			stmt = c.createStatement();

			ResultSet re = stmt.executeQuery("select * from\"blog\" ;"); 
			
			ArrayList<String> users = new ArrayList<String>();

			while (re.next()) {
				
				String user = re.getString("username");
				
				if (user.equalsIgnoreCase(userSearch)) {
					System.out.println(user);
					users.add(user);
				}
			
				}
			session.setAttribute("users", users);
			session.setAttribute("us", us);
			session.setAttribute("search", userSearch);
			RequestDispatcher rd = request.getRequestDispatcher("/checkFollow");
			rd.forward(request, response);
			

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
