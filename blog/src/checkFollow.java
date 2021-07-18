

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
 * Servlet implementation class checkFollow
 */
@WebServlet("/checkFollow")
public class checkFollow extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public checkFollow() {
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
		String result = (String)session.getAttribute("search");
		String us = (String)session.getAttribute("user");
		ArrayList<String> usersList = (ArrayList<String>)session.getAttribute("users");
		session.setAttribute("users", usersList);
		String act = "fshdj";
		
		try {
			Class.forName("org.postgresql.Driver");
			
			c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/sample", "postgres", "1234");

			System.out.println("Successfully connected.");

			stmt = c.createStatement();

			ResultSet re = stmt.executeQuery("select following from public.blog_follow where follower = '" + us + "' ;"); 

			while (re.next()) {
				
				String follow = re.getString("following");
	
					if (follow.contentEquals(result)) {

						System.out.print("working");
						act = "unfollow";
					}
					else {
						act = "follow";
					}
					
			}
				session.setAttribute("act", act);
				session.setAttribute("us", us);
				
				
				RequestDispatcher rd = request.getRequestDispatcher("search.jsp");
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
