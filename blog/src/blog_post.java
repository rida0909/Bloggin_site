
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
 * Servlet implementation class blog_post
 */
@WebServlet("/blog_post")
public class blog_post extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public blog_post() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());

		HttpSession session = request.getSession();
		String us = (String) session.getAttribute("user");

		Connection c = null;

		Statement stmt = null;

		try {
			Class.forName("org.postgresql.Driver");

			c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/sample", "postgres", "1234");

			stmt = c.createStatement();

			ResultSet re = stmt.executeQuery("select * from\"blog_posts\" ;");

			ArrayList<String> username = new ArrayList<String>();
			ArrayList<String> blogpost = new ArrayList<String>();
			ArrayList<String> posted = new ArrayList<String>();

			while (re.next()) {

				String user = re.getString("username");
				String msg = re.getString("post");
				String dt = re.getString("date");

				username.add(user);
				blogpost.add(msg);
				posted.add(dt);

				session.setAttribute("un", username);
				session.setAttribute("bp", blogpost);
				session.setAttribute("pdate", posted);

			}

			session.setAttribute("us", us);

		} catch (Exception e) {

			response.getWriter().append(e.getClass().getName() + ":" + e.getMessage());
			// System.err.println(e.getClass().getName() + ":" + e.getMessage());
			// System.exit(0);
		}

		try {
			Class.forName("org.postgresql.Driver");

			c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/sample", "postgres", "1234");

			stmt = c.createStatement();

			ResultSet re = stmt.executeQuery("select * from public.blog_posts where username = '" + us + "' ;");

			ArrayList<String> myPost = new ArrayList<String>();
			ArrayList<String> myDate = new ArrayList<String>();
			ArrayList<String> myId = new ArrayList<String>();

			while (re.next()) {

				String post = re.getString("post");
				String date = re.getString("date");
				String id = re.getString("post_id");

				myPost.add(post);
				myDate.add(date);
				myId.add(id);

				session.setAttribute("myPost", myPost);
				session.setAttribute("myDate", myDate);
				session.setAttribute("myId", myId);

			}

			RequestDispatcher rd = request.getRequestDispatcher("mainPage.jsp");
			rd.forward(request, response);

		} catch (Exception e) {

			response.getWriter().append(e.getClass().getName() + ":" + e.getMessage());
			// System.err.println(e.getClass().getName() + ":" + e.getMessage());
			// System.exit(0);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
