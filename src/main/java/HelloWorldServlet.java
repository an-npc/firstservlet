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
@WebServlet("/HelloWorldServlet")
public class HelloWorldServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloWorldServlet() {
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
            "<p>HelloWorld:</p>\n" +
            "<p>Welcome back: " + name + "</p>\n" +
			"<p>Your name: " + name + "</p>\n" +
			"<p>Your email: " + email + "</p>\n" +
			"<p>Your location: " + location + "</p>\n" +
			"<p>Your gender: " + gender + "</p>\n" +
			"<p>Your experience: " + experience + "</p>\n" +
			"</body></html>"
		);
        // out.printf("%s <html>\n <head><title>User Registration</title></head>\n <body>\n <p>%s</p> <p>%s</p> <p>%s</p> <p>%s</p> <p>%s</p> </body></html>", docType, name, email, location, gender, experience);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}