

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
 * Servlet implementation class follow
 */
@WebServlet("/follow")
public class follow extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public follow() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		HttpSession session = request.getSession();
		String us = (String)session.getAttribute("user");
		 session.setAttribute("page", "follow"); 
		
		Connection c = null;

		Statement stmt = null;
		
		try {
			Class.forName("org.postgresql.Driver");

			c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/sample", "postgres", "1234");

			stmt = c.createStatement();

			ResultSet re = stmt.executeQuery("select following from blog_follow where follower = '" +us+ "' ;"); 
			
			ArrayList<String> followings = new ArrayList<String>() ;
				
			while(re.next()) {
			
				String following = re.getString("following");
				
					followings.add(following);
					
					session.setAttribute("follow", followings);
				
			}
			
			session.setAttribute("us", us);
			session.setAttribute("action", "followings");
			session.setAttribute("fol", "unfollow");
			
			RequestDispatcher rd = request.getRequestDispatcher("/followers.jsp");
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
