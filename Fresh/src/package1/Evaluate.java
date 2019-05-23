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
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Evaluate
 */
@WebServlet("/Evaluate")
public class Evaluate extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static String databasename="iihtproject";
	static String url="jdbc:mysql://localhost:3306/"+databasename;
	static String username ="root";
	static String password="root";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Evaluate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection= DriverManager.getConnection(url,username,password);
		Statement stmt=connection.createStatement();
		String str=request.getParameter("topic");
		PrintWriter pw= response.getWriter();
		pw.print("<body background=\"https://i.pinimg.com/originals/4c/2d/e5/4c2de5df7ec88fb93d5f89cd68600ddd.jpg\"");
		pw.print("<h1>Topic:"+str+"</h1>");
		String[] a = request.getParameterValues("uans");
		
		String sql="select * from "+str;
		ResultSet rst=stmt.executeQuery(sql);
		int i=0;
		int count=0;
		pw.print("<table style=\"background-color:B3ACF2\">");
		while(rst.next())
		{
			pw.print("<tr style='border: 1px solid white;'><td style=' border: 1px solid white;'>"+rst.getString("QName")+"</td></tr>");
			pw.print("<tr style='border: 1px solid black;' colspan=\"2\"><td style='border: 1px solid black;'><h3>actual ans</h3>"+rst.getString("Answer"));
			pw.print("<td style='border: 1px solid black;'><h3>Your ans</h3>"+a[i]+"</tr>");
			String answer=rst.getString("Answer");
			if(answer.equalsIgnoreCase(a[i]))
			{
				count++;
			}i++;
		}
		pw.print("</table>");
		pw.println("<h1 style=\"background-color:white;\">your score :"+count+"</h1>");
		pw.print("<html><head><link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css'>");
		pw.print("<link rel='stylesheet' href='https://www.w3schools.com/w3css/4/w3.css'>");
		pw.print("<style>* { box-sizing: border-box;}.column {float: left;width: 33.33%;padding: 5px;}.row::after {content: '';clear: both;display: table;}</style>");
		pw.print("<body>");
		pw.print("<a style='margin-left: 500px' href='CandidateLanding.jsp' class='btn btn-info btn-lg'><span></span> Want to take another test?</a>");
		pw.print("<a style='margin-left: 300px' href='index.html' class='btn btn-info btn-lg'><span class='glyphicon glyphicon-log-out'></span> Logg out</a>");
		pw.print("</body></html>");
	
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}

	private ServletRequest servletContext() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
