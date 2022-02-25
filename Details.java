Index.html:-
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome to Ecommerce</title>
</head>
<body style="background-color:green;">
<h1 style="background-color:red;">Welcome to Ecommerce...</h1>
<form action="ProductDetails" method="get">
<center>
	Product Id: <input name="id" type="number"><br><br>
	<button>Search</button>
</center>
</form>
</body>
</html>

Details.java:-
package com.simplilearn.productlist;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/ProductDetails")
public class Details extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Details() {
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url="jdbc:mysql://localhost:3306/ecommerce";
		String uname="root";
		String pass="Siba143sahoo";
		response.setContentType("text/html");
		String Id = request.getParameter("id");
		PrintWriter out = response.getWriter();		
		
		String query="select * from eproduct where ID=?";
		out.print("<body style=\"background-color:grey;\">");
		out.print("<h1 style=\"background-color:red;\">Displaying the Product Details...</h1>");
		out.print("<table style=\"background-color:green;\" border='1'><tr><th>Product Id</th><th>Product Name</th><th>Product Price</th><th>Praduct Date</th></tr>");
		
		try {
	      Class.forName("com.mysql.cj.jdbc.Driver");
	      Connection dbCon = DriverManager.getConnection(url, uname, pass);
	      PreparedStatement st=  dbCon.prepareStatement(query);	     
	      st.setString(1, Id);
	      
	      ResultSet rs =st.executeQuery();  
	      while(rs.next()) {
	    	  
	    	  out.print("<tr><td>");
	    	  out.println(rs.getInt(1));
	    	  out.print("</td>");
	    	  out.print("<td>");
	    	  out.print(rs.getString(2));
	    	  out.print("</td>");
	    	  out.print("<td>");
	    	  out.print(rs.getBigDecimal(3));
	    	  out.print("</td>");
	    	  out.print("<td>");
	    	  out.print(rs.getTimestamp(4));
	    	  out.print("</td>");
	    	  out.print("</tr>");
	    	    	  
			}	
		}
		catch(Exception e){
			System.out.println("Some Issue : "+ e.getMessage());
		}
		out.print("</table>");
		out.print("</body>");		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
web.xml:-
<?xml version="1.0" encoding="UTF-8"?>
<web-app>
  <display-name>Product List</display-name>
  <welcome-file-list>
    <welcome-file>index.html</welcome-file>
  </welcome-file-list>
  <servlet>
    <description></description>
    <display-name>Details</display-name>
    <servlet-name>Details</servlet-name>
    <servlet-class>com.simplilearn.productlist.Details</servlet-class>
  </servlet>
  <servlet-mapping>
    <servlet-name>Details</servlet-name>
    <url-pattern>/Details</url-pattern>
  </servlet-mapping>
</web-app>
