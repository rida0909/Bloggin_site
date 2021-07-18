

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
 * Servlet implementation class req_follow
 */
@WebServlet("/req_follow")
public class req_follow extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public req_follow() {
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
		String username = (String)session.getAttribute("us");
		String userFollow = (String)session.getAttribute("search");
		String action = (String)session.getAttribute("act");
		
		try {
			Class.forName("org.postgresql.Driver");
			c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/sample", "postgres", "1234");
			stmt = c.createStatement();
			
			if (action.contentEquals("follow")) {
				
			((java.sql.Statement) stmt).execute("insert into blog_follow(follower, following) values ('" + username + "', '" + userFollow + "');");
			
			}
			
			else {
				
				((java.sql.Statement) stmt).execute("delete from blog_follow where follower = '" + username + "' and following = '" + userFollow + "' ;");
			}
			session.setAttribute("user", username);
			
			RequestDispatcher rd = request.getRequestDispatcher("/blog_post");
			rd.forward(request, response);
		}catch (Exception e) {
			response.getWriter().append(e.getClass().getName() + ":" + e.getMessage());
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
