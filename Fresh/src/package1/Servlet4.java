package package1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet4
 */
@WebServlet("/Servlet4")
public class Servlet4 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static String databasename="iihtproject";
	static String url="jdbc:mysql://localhost:3306/"+databasename;
	static String username ="root";
	static String password="root";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet4() {
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
		PrintWriter pw=response.getWriter();
		String asd1=request.getParameter("topic");
		String sql = "SELECT * FROM "+asd1;
		ResultSet resultset = stmt.executeQuery(sql);
		pw.print("<html><head><link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css'>");
pw.print("<link rel='stylesheet' href='https://www.w3schools.com/w3css/4/w3.css'>");
pw.print("<style>* { box-sizing: border-box;}.column {float: left;width: 33.33%;padding: 5px;}.row::after {content: '';clear: both;display: table;}</style>");
pw.print("<body background=\"https://i.pinimg.com/originals/4c/2d/e5/4c2de5df7ec88fb93d5f89cd68600ddd.jpg\">");
pw.print("<div>");
pw.print("<ul class='list-group'>");

pw.print("<div><div class='w3-container'>");  
pw.print("<button onclick=\"document.getElementById('id01').style.display='block'\" class='w3-button w3-black'>Add New Question</button>");
pw.print("<form action='AddQuestion' method='get'>");
pw.print("<div id='id01' class='w3-modal'>");
pw.print("<div class='w3-modal-content w3-card-4'>");
pw.print("<header class='w3-container w3-teal'>"); 
pw.print("<span onclick=\"document.getElementById('id01').style.display='none'\" class='w3-button w3-display-topright'>&times;</span>");
pw.print("<h2>Add Topic</h2></header>");
pw.print("<div class='w3-container'>");
pw.print("<input type='text' class='list-group-item' name='question' style=\"height:100%; width:100%\" placeholder='Enter the question' required></input>");
pw.print("</div>");
pw.print("<div class='w3-container'>");
pw.print("<input type='text' class='list-group-item' name='answer' placeholder='Enter the answer' required></input>");
pw.print("</div>");	
pw.print("<input type='hidden' class='list-group-item' name='topic' value='"+asd1+"'");
pw.print("<footer class='w3-container w3-teal'>");
pw.print("<button class='btn btn-lg btn-primary btn-block' type='submit'>ADD</button>  <br>");
pw.print("</footer></div></div></form></div></div>");
		while(resultset.next())
		{
			String Qid  = resultset.getString("Qid");
			String Ques = resultset.getString("QName");
			String Ans  = resultset.getString("Answer");
			pw.print("<div style='margin-left:20px; background-color:white' class='row'><div class='column'>"+Qid+"</div><div class='column'>"+Ques+"</div>"); 
			pw.print("<div class='column'>"+Ans+"</div>"); 
			pw.print("<div class='column'><button onclick=\"document.getElementById('id02').style.display='block'\" class=\"w3-button w3-black\">Update</button><br>");
			pw.print("</div>");
			pw.print("</div>");
			pw.print("</li>");
//			pw.print("</body>");
//			pw.print("</html>");
			
			pw.print("<form action='UpdateQues' method='get'>");
			pw.print(" <div id='id02' class='w3-modal'>");
			pw.print("<div class='w3-modal-content w3-card-4'>");
			pw.print("<header class='w3-container w3-teal'>"); 
			pw.print("<span onclick='document.getElementById('id02').style.display='none'class='w3-button w3-display-topright'>&times;</span>");
			pw.print("<h2>Add Topic</h2></header>");
			pw.print("<div class='w3-container'>");
			pw.print("<input type='hidden' name='topic' value="+asd1+"  required></input>");
			pw.print("<input type='text' name='qid' value='enter id of row to update' required ></input>");
			
			pw.print("<input type='text' name='question' style=\\\"height:100%; width:100%\\\" value='insert question' required></input></div>");
			pw.print("<input type='text' name='answer' value='insert answer' required></input></div>");
			pw.print("<footer class='w3-container w3-teal'>");
			pw.print("<button class='btn btn-lg btn-primary btn-block' type='submit'>ADD</button>  <br>");
			pw.print("</footer></div></div></div></form>");
			
			pw.print("<form method='get' action='DeleteQuestion'>");
		       pw.print("<input type='hidden' name='topic' value="+asd1+" />");
		       pw.print("<input type='hidden' name='id' value="+Qid+" />");
		       pw.print("<input class='btn btn-warning' type='submit' value='DELETE'>");
		       pw.print("</form>");
			
		}
		

		
		pw.print("</ul></div>");
		pw.print("<a style='margin-left: 300px' href='index.html' class='btn btn-info btn-lg'><span class='glyphicon glyphicon-log-out'></span> Logg out</a>");
		pw.print("</body>");
		pw.print("</html>");
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
