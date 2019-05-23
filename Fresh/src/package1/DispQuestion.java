package package1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DispQuestion
 */
@WebServlet("/DispQuestion")
public class DispQuestion extends HttpServlet {
	
	static String databasename="iihtproject";
	static String url="jdbc:mysql://localhost:3306/"+databasename;
	static String username ="root";
	static String password="root";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DispQuestion() {
        super();
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
			String a=request.getParameter("topic");
			String sql="select * from "+a;
			ResultSet rst=stmt.executeQuery(sql);
			
			out.print("<html><head><link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css'>");
			out.print("<link rel='stylesheet' href='https://www.w3schools.com/w3css/4/w3.css'>");
			out.print("<style>.wrapper {	\r\n" + 
					"	margin-top: 80px;\r\n" + 
					"  margin-bottom: 100px;\r\n" + 
					"}\r\n" + 
					"\r\n" + 
					".form-signin {\r\n" + 
					"  max-width: 380px;\r\n" + 
					"  padding: 15px 35px 45px;\r\n" + 
					"  margin: 0 auto;\r\n" + 
					"  background-color: #fff;\r\n" + 
					"  border: 1px solid black;  \r\n" + 
					"}\r\n" + 
					"</style>");
			out.print("<body background=\"https://i.pinimg.com/originals/4c/2d/e5/4c2de5df7ec88fb93d5f89cd68600ddd.jpg\">");
			out.print("<h1 style='background-color:white' class=\"text-center\">List Of Questions on "+a+"</h1>");
			out.print("<div class=\"wrapper\">");
			while(rst.next())
			{			
				int id=rst.getInt("Qid");
				
				out.print("<form class=\"form-signin\" method='get' action='Evaluate'>");
				String question=rst.getString("QName");
				out.print("<input type='hidden' name='topic' value="+a+"></input>");
				out.print("<div class=\"wrapper\">");
				out.print(question);
				out.print("<input type='text' name='uans' required>");
				out.print("</div>");
			}
			out.print("<input class='btn btn-lg btn-primary btn-block' type='submit' value='submit'>");
			out.print("</form>");
			out.print("</div>");
			
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
