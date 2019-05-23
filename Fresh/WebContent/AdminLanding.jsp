<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
            <%@page import="java.io.*"%>
    <%@ page import="java.sql.*" %>
    <%@ page import="javax.servlet.http.HttpSession" %>
    <%ResultSet resultset =null;%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body background="https://i.pinimg.com/originals/4c/2d/e5/4c2de5df7ec88fb93d5f89cd68600ddd.jpg">
<%
    try{
Class.forName("com.mysql.jdbc.Driver").newInstance();

Connection connection = 
         DriverManager.getConnection
            ("jdbc:mysql://localhost/iihtproject?user=root&password=root");
	   PrintWriter pw=response.getWriter();
	   HttpSession session1=request.getSession();  
	   pw.print(session1);
	   String name="admin";
       session1.setAttribute("name",name);  
	   Statement statement = connection.createStatement() ;
       pw.print("<h1>List Of Topics </h1>");
       resultset=statement.executeQuery("select * from topics");
       pw.print("<ul class='list-group'>");
       while(resultset.next()){
       String asd=resultset.getString("topicname");
       pw.print("<form method='get' action='Servlet4'>");
       pw.print("<form action='Servlet4'><input type='hidden' name='topic' value="+asd+" /><input class='btn btn-lg btn-primary btn-block' type='submit' value="+asd+"></form>");
       pw.print("</form>");
       int id=resultset.getInt("topicid");
       //pw.print(asd+"  "+id);
       
       
       pw.print("<form method='get' action='Delete'>");
       pw.print("<input type='hidden' name='topic' value="+asd+" />");
       pw.print("<input type='hidden' name='id' value="+id+" />");
       pw.print("<input class='btn btn-warning' type='submit' value='DELETE'>");
       pw.print("</form>");
       %>
    	   <%   	   
       }%>
       <div class="w3-container">
  
  <button onclick="document.getElementById('id01').style.display='block'" class="w3-button w3-black">Add New Topic</button>
  
  <a style="margin-left: 300px" href="index.html" class="btn btn-info btn-lg">
          <span class="glyphicon glyphicon-log-out"></span> Logg out
        </a>
<form action="Servlet3" method="get">
  <div id="id01" class="w3-modal">
    <div class="w3-modal-content w3-card-4">
      <header class="w3-container w3-teal"> 
        <span onclick="document.getElementById('id01').style.display='none'" 
        class="w3-button w3-display-topright">&times;</span>
        <h2>Add Topic</h2>
      </header>
      <div class="w3-container">
        <input type='text' name='ttopic'></input>
      </div>	
      <footer class="w3-container w3-teal">
   <button class="btn btn-lg btn-primary btn-block" type="submit">ADD</button>  <br>
         </footer>
    </div>
  </div>
</form></div>
       <%
    pw.print("<ul>");
    }
catch(Exception e)
{
     out.println("wrong entry"+e);
}
%>
</body>
</html>