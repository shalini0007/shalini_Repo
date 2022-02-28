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
public class Detail extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Details() {
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		String Id = request.getParameter("id");
	
		PrintWriter out = response.getWriter();		
		
		String query="select * from eproduct where ID=?";
		out.print("<body style=\"background-color:grey; text-align: center\">");
		out.print("<h1 style=\"background-color:coral;\">Product Details</h1>");
		out.print("<table style=\"background-color:#92a8d1; margin: auto\" border='1'><tr><th>Product Id</th><th>Product Name</th><th>Product Price</th><th>Praduct Date</th></tr>");
		
		try {
	      Class.forName("com.mysql.cj.jdbc.Driver");
	      Connection dbCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce", "codebind", "12345@");
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
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html  PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta  http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
	<h3>Header</h3>
 	<h2>Welcome to Product Details Page. </h2>
</center>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <jsp:include page="header.jsp"></jsp:include>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<br>
<jsp:useBean id="index" class="com.simplilearn.pdetails_portal.Product" scope="session"/>
	<jsp:setProperty property="id" name="index"/>  
	<jsp:setProperty property="pname" name="index"/>  
	<jsp:setProperty property="ptype" name="index"/>  
	<jsp:setProperty property="pprice" name="index"/>  <br><br>
	
	<h2 style="text-align: center;"><a href = "detail.jsp"><b>Click here to get the Product Details</b></a></h2>

</body>
</html>

package com.simplilearn.pdetails_portal;

public class Product {
	private int id;
	private String pname;
	private String ptype;
	private int pprice;
	
	public Product() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getPtype() {
		return ptype;
	}

	public void setPtype(String ptype) {
		this.ptype = ptype;
	}

	public int getPprice() {
		return pprice;
	}

	public void setPprice(int pprice) {
		this.pprice = pprice;
	}
	
	
}

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
		
		response.setContentType("text/html");
		
		String Id = request.getParameter("id");
	
		PrintWriter out = response.getWriter();		
		
		String query="select * from eproduct where ID=?";
		out.print("<body style=\"background-color:grey; text-align: center\">");
		out.print("<h1 style=\"background-color:coral;\">Product Details</h1>");
		out.print("<table style=\"background-color:#92a8d1; margin: auto\" border='1'><tr><th>Product Id</th><th>Product Name</th><th>Product Price</th><th>Praduct Date</th></tr>");
		
		try {
	      Class.forName("com.mysql.cj.jdbc.Driver");
	      Connection dbCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce", "codebind", "12345@");
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
