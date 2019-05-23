<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@page import="java.io.*"%>
    <%@ page import="java.sql.*" %>
    <%@ page import="javax.servlet.http.HttpServletRequest"%>
<%@ page import="javax.servlet.http.HttpServletResponse" %>
    <%ResultSet resultset =null;%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<style>
li a:hover {
  background-color: #111;
}</style>
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

       Statement statement = connection.createStatement() ;
      pw.print("<h1>List Of Topics </h1>");
       resultset=statement.executeQuery("select * from topics");
      pw.print("<ul class='list-group'>");
     
       


//request.setAttribute("name",asd);
//
//RequestDispatcher dis = request.getRequestDispatcher
//("DispQuestion");

//dis.forward(request,response);
       
       
	      pw.print("<ul class='list-group'>");
	      
	      while(resultset.next()){
	       String as=resultset.getString("topicname");
	       int asd1=resultset.getInt("topicid");
	       pw.print("<form method='get' action='DispQuestion'>");
	       pw.print("<form action='Servlet4'><input type='hidden' name='topic' value="+as+" /><input class='btn btn-lg btn-primary btn-block' type='submit' value="+as+"></form>");
	       pw.print("</form>");
	      }
	    pw.print("<ul>");
	  
    	    	   
       
    pw.print("<ul>");
    }
catch(Exception e)
{
     out.println("wrong entry"+e);
}
%>
 
</body>
</html>