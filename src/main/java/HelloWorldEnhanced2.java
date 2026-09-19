import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet1
 */
@WebServlet("/HelloWorldEnhanced2")
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

		// JDBC driver name and database URL
		// String JDBC_DRIVER = "com.mysql.jdbc.Driver";
		String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";

		// String DB_URL = "jdbc:mysql://52.71.253.100:3306/testDB";
		String DB_URL = "jdbc:mysql://localhost:3306/testDB";

		// Database credentials
		String USER = "appuser1";
		String PASS = "T0mc4t4610!";
		Connection conn = null;
		Statement stmt = null;

		//STEP 2: Register JDBC driver
		try {
			Class.forName(JDBC_DRIVER);

			//STEP 3: Open a connection
			System.out.println("Connecting to database...");
			conn = (Connection) DriverManager.getConnection(DB_URL,USER,PASS);
			
			System.out.println("Connection successful!");

			//STEP 4: Execute a query
			System.out.println("Creating statement...");
			stmt = (Statement) conn.createStatement();
			String sql;
			sql = "SELECT * FROM STUDENT;";
			ResultSet rs = (ResultSet) stmt.executeQuery(sql);
			
			//STEP 5: Extract data from result set
			while(rs.next()){
				//Retrieve by column name
				String myName = rs.getString("NAME");
				String Myexperience = rs.getString("EXPERIENCE");
				//Display values
				System.out.print("name: " + myName);
				System.out.println(", experience: " + Myexperience);
				//return the query results to client
				name = name + "-" + myName;
				experience = experience + "-" + Myexperience;
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String docType = "<!doctype html public \"-//w3c//dtd html 4.0 transitional//en\">\n";
		out.println(docType +
			"<html>\n" +
			"<head><title>User Registration</title></head>\n" +
			"<body>\n" +
			"<h1 align=\"center\"><img src='http://54.81.47.117/Thanksgiving.gif' alt='Thanksgiving Gif'> Welcome "+ name + "</h1>" +
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