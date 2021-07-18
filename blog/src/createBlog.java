

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class createBlog
 */
@WebServlet("/createBlog")
public class createBlog extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public createBlog() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String content = request.getParameter("content");
		
		Connection c = null;

		Statement stmt = null;
		
		HttpSession session = request.getSession();
		String username = (String)session.getAttribute("user");
		
		try {
			Class.forName("org.postgresql.Driver");
			
			c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/sample", "postgres", "1234");

			System.out.println("Successfully connected.");
 
			stmt = c.createStatement(); 
			
			Date date = Calendar.getInstance().getTime();
			
			((java.sql.Statement) stmt).execute("insert into blog_posts(post, username, date) values ('" + content + "','" + 
					username + "','" + date + "');");
			
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
