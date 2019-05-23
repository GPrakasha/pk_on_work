package package1;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet
 */
@WebServlet("/Servlet2")
public class Servlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static String databasename="iihtproject";
	static String url="jdbc:mysql://localhost:3306/"+databasename;
	static String username ="root";
	static String password="root";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection= DriverManager.getConnection(url,username,password);
			Statement stmt=connection.createStatement();
//			PrintWriter out=response.getWriter();
			String name=request.getParameter("usr");
			String password=request.getParameter("pwd");
			String mail=request.getParameter("mail");
			String phno=request.getParameter("phno");
			String sql = "INSERT INTO users(username,usermail,userpassword,userphno) VALUES(?,?,?,?)";
			PreparedStatement ptm=connection.prepareStatement(sql);
			ptm.setString(1, name);
			ptm.setString(2, mail);
			ptm.setString(3, password);
			ptm.setString(4, phno);
			ptm.executeUpdate();
			response.sendRedirect("http://localhost:8080/Fresh/index.html");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.getWriter().append("Served at: ").append(request.getContextPath());
		doGet(request, response);
	}

}
