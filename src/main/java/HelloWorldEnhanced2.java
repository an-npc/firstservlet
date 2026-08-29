import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet1
 */
@WebServlet("/register")
public class HelloWorldEnhanced2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloWorldEnhanced2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		final PrintWriter out = response.getWriter();

		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String location = request.getParameter("location");
		String gender = request.getParameter("gender");
		String experience = request.getParameter("experience");

		String docType = "<!doctype html public \"-//w3c//dtd html 4.0 transitional//en\">\n";
		out.println(docType +
			"<html>\n" +
			"<head><title>User Registration</title></head>\n" +
			"<body>\n" +
			"<h1 align=\"center\"><img src='media/Thanksgiving.gif'> Welcome "+ name + "</h1>" +
			"<ul>\n" +
			"<li><b>Your name</b>: " + name + "\n" +
			"<li><b>Your email</b>: " + email + "\n" +
			"<li><b>Your location</b>: " + location + "\n" +
			"<li><b>Your gender</b>: " + gender + "\n" +
			"<li><b>Your experience</b>: " + experience + "\n" +
			"</ul>\n" +
			"</body></html>"
		);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}