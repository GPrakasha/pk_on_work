package package1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Servlet1
 */
@WebServlet("/Servlet1")
public class Servlet1 extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
	static String databasename="iihtproject";
	static String url="jdbc:mysql://localhost:3306/"+databasename;
	static String username ="root";
	static String password="root";
    /**
     * Default constructor. 
     */
    public Servlet1() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {PrintWriter out=response.getWriter();
		
		
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection= DriverManager.getConnection(url,username,password);
			Statement stmt=connection.createStatement();
			
			String name=request.getParameter("usr");
			String password=request.getParameter("pwd");
			String sql="select username , userpassword from users";
			ResultSet rst=stmt.executeQuery(sql);
			
			
			while(rst.next())
			{
				String un=rst.getString("username");
				String pw=rst.getString("userpassword");
				if(name.equals("prakasha"))
				{
					if(password.equals(pw)) {
						response.sendRedirect("http://localhost:8080/Fresh/AdminLanding.jsp");
					}else
					{
						out.print("wrong input of info");
						RequestDispatcher  rd= request.getRequestDispatcher("/index.html");
						rd.include(request, response);
						
					}
				}
				else if(name.equals(un))
				{
					if(password.equals(pw)) {
						response.sendRedirect("http://localhost:8080/Fresh/CandidateLanding.jsp");
					}else
					{
						out.print("wrong input of info");
						RequestDispatcher  rd= request.getRequestDispatcher("/index.html");
						rd.include(request, response);
					}
				}else {
					out.print("wrong input of info");
					RequestDispatcher  rd= request.getRequestDispatcher("/index.html");
					rd.include(request, response);
				}
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
