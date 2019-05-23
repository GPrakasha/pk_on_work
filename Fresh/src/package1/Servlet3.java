package package1;

import java.io.IOException;
import java.io.PrintWriter;
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
 * Servlet implementation class Servlet3
 */
@WebServlet("/Servlet3")
public class Servlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static String databasename="iihtproject";
	static String url="jdbc:mysql://localhost:3306/"+databasename;
	static String username ="root";
	static String password="root";
    public Servlet3() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection= DriverManager.getConnection(url,username,password);
		Statement stmt=connection.createStatement();
		PrintWriter pw=response.getWriter();
		String asd1=request.getParameter("ttopic");
		String sql = "INSERT INTO topics(topicname) VALUES(?)";
		String sql1 = "CREATE TABLE "+asd1+" (Qid int NOT NULL AUTO_INCREMENT,QName varchar(255) NOT NULL,Answer varchar(255) NOT NULL,PRIMARY KEY (`Qid`)) ";
		PreparedStatement ptm=connection.prepareStatement(sql);
		Statement st=connection.createStatement();
		ptm.setString(1, asd1);
		st.executeUpdate(sql1);
		ptm.executeUpdate();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		response.sendRedirect("AdminLanding.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
