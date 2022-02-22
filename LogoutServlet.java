-:Validation User Login:-
Index.html:-
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Validation User Login</title>
</head>
<body style="background-color:grey;">
<h1>Welcome to simplilearn</h1>  
<a href="login.html">Login</a>
    
<a href="DashboardServlet">Dashboard</a>   
</body>
</html>
Login.html:-
<body style="background-color:grey;">
<form action="LoginServlet" method="post"> 
Name:<input type="text" name="name"><br>  
Password:<input type="password" name="password"><br>
<input type="submit" value="login"> 
</form> 
</body>

Link.html:-
<body style="background-color:grey;">
<a href="login.html">Login</a> |  
<a href="LogoutServlet">Logout</a> |  
<a href="DashboardServlet">Dashboard</a>
<hr>  
</body>







LoginServlet.java:-
package com.simplilearn.validation;

import java.io.IOException;  
import java.io.PrintWriter;  
import javax.servlet.ServletException;  
import javax.servlet.http.Cookie;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
public class LoginServlet extends HttpServlet {  
    protected void doPost(HttpServletRequest request, HttpServletResponse response)  
                           throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
          
        request.getRequestDispatcher("link.html").include(request, response);  
          
        String name=request.getParameter("name");  
        String password=request.getParameter("password");  
          
        if(password.equals("shalini777")&&name.equals("shalini")){  
            out.print("You are successfully logged in!");  
            out.print("<br>Welcome, "+name);  
              
            Cookie ck=new Cookie("name",name);  
            response.addCookie(ck);  
        }else{  
            out.print("sorry, username or password error!");  
            request.getRequestDispatcher("login.html").include(request, response);  
        }  
          
        out.close();  
    }   
}

DashboardServlet.java:-
package com.simplilearn.validation;

import java.io.IOException;  
import java.io.PrintWriter;  
import javax.servlet.ServletException;  
import javax.servlet.http.Cookie;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
public class DashboardServlet extends HttpServlet {  
    protected void doGet(HttpServletRequest request, HttpServletResponse response)  
                          throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
          
        request.getRequestDispatcher("link.html").include(request, response);  
          
        Cookie ck[]=request.getCookies();  
        if(ck!=null){  
         String name=ck[0].getValue();  
        if(!name.equals("")||name!=null){  
            out.print("<b>Welcome to Dashboard</b>");  
            out.print("<br>Welcome, "+name);  
        }  
        }else{  
            out.print("Please login first");  
            request.getRequestDispatcher("login.html").include(request, response);  
        }  
        out.close();  
    }  
}

LogoutServlet:-
package com.simplilearn.validation;

import java.io.IOException;  
import java.io.PrintWriter;  
import javax.servlet.ServletException;  
import javax.servlet.http.Cookie;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
public class LogoutServlet extends HttpServlet {  
    protected void doGet(HttpServletRequest request, HttpServletResponse response)  
                        throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
          
          
        request.getRequestDispatcher("link.html").include(request, response);  
          
        Cookie ck=new Cookie("name","");  
        ck.setMaxAge(0);  
        response.addCookie(ck);  
          
        out.print("you are successfully logged out!");  
    }  
}  
Web.xml:-
<?xml version="1.0" encoding="UTF-8"?>
<web-app>
  <display-name>ValidUserLogin</display-name>
  <welcome-file-list>
    <welcome-file>index.html</welcome-file>
  </welcome-file-list>
  <servlet>  
    <description></description>  
    <display-name>LoginServlet</display-name>  
    <servlet-name>LoginServlet</servlet-name>  
    <servlet-class>com.simplilearn.validation.LoginServlet</servlet-class>  
  </servlet>  
  <servlet-mapping>  
    <servlet-name>LoginServlet</servlet-name>  
    <url-pattern>/LoginServlet</url-pattern>  
  </servlet-mapping>  
  <servlet>  
    <description></description>  
    <display-name>DashboardServlet</display-name>  
    <servlet-name>DashboardServlet</servlet-name>  
    <servlet-class>com.simplilearn.validation.DashboardServlet</servlet-class>  
  </servlet>  
  <servlet-mapping>  
    <servlet-name>DashboardServlet</servlet-name>  
    <url-pattern>/DashboardServlet</url-pattern>  
  </servlet-mapping>  
  <servlet>  
    <description></description>  
    <display-name>LogoutServlet</display-name>  
    <servlet-name>LogoutServlet</servlet-name>  
    <servlet-class>com.simplilearn.validation.LogoutServlet</servlet-class>  
  </servlet>  
  <servlet-mapping>  
    <servlet-name>LogoutServlet</servlet-name>  
    <url-pattern>/LogoutServlet</url-pattern>  
  </servlet-mapping>  
</web-app>

