

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class update
 */
@WebServlet("/update")
public class update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public update() {
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
		
		String content = request.getParameter("content");
		
		HttpSession session = request.getSession();
		
		String post = (String)session.getAttribute("post");
		String post_id = (String)session.getAttribute("id");
		String username = (String)session.getAttribute("user");
		String date = (String)session.getAttribute("date");
		
		try {
			Class.forName("org.postgresql.Driver");

			c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/sample", "postgres", "1234");

			stmt = c.createStatement();

			((java.sql.Statement) stmt).execute("update public.blog_posts set post = '" + content + "' , username = '" + username + "' , date = '" + date + "' , post_id = " + post_id + " where post_id = " + post_id + ";"); 
			
			session.setAttribute("user", username);

			RequestDispatcher rs = request.getRequestDispatcher("/blog_post");
			rs.forward(request, response);

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
