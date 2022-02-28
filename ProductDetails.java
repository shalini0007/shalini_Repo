Adding a New Product in the Database using Hibernate
Code:

Index.html:


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="HibernateTestServlet" method="get">
	Enter Product id<input type="text" name="txtPid"><br>
	Enter Product name<input type="text" name="txtName">
	<input type="submit" value="Click">
</body>
</html>



ProductDetails.java class:

package beans;

public class ProductDetails {

	private int productid;
	private String productname;
	
	
	public int getProductid() {
		return productid;
	}
	public void setProductid(int productid) {
		this.productid = productid;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	
	
}


HibernateTestServlet.java servlet:

package services;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import beans.ProductDetails;


/**
 * Servlet implementation class HibernateTestServlet
 */
@WebServlet("/HibernateTestServlet")
public class HibernateTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public HibernateTestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    void register(ProductDetails pd){
		
		SessionFactory sessionFactory=new Configuration().configure(new File("C:\\Users\\varad\\eclipse-workspace\\HibernateAddProduct\\src\\main\\java\\hibernate.cfg.xml")).buildSessionFactory();
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.save(pd);
		
		session.getTransaction().commit();
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//Reading parameters from html
		int pid=Integer.parseInt(request.getParameter("txtPid"));
		String pname=request.getParameter("txtName");
				
		//create Object of UserDetails
		ProductDetails pd=new ProductDetails();
		pd.setProductid(pid);
		pd.setProductname(pname);
		
		//call register method
		register(pd);
	}

}




hibernate.cfg.xml:

<?xml version="1.0" encoding="UTF-8"?>

<!--~ Hibernate Search, full-text search for your domain model~~ License: GNU Lesser General Public License (LGPL), version 2.1 or later~ See the lgpl.txt file in the root directory or <http://www.gnu.org/licenses/lgpl-2.1.html>. -->

<!DOCTYPE hibernate-configuration PUBLIC 
	"-//Hibernate/Hibernate Configuration DTD//EN"
	"http://www.hibernate.org/dtd/hibernate-configuration-3.0.dtd">

<hibernate-configuration>

<session-factory>

	<property name="connection.driver_class">com.mysql.cj.jdbc.Driver</property>

	<property name="connection.url">jdbc:mysql://localhost:3306/Work</property>

	<property name="connection.username">Work</property>

	<property name="connection.password">Simplilearn@123</property>

	<!-- JDBC connection pool (use the built-in) -->
	<property name="connection.pool_size">1</property>

	<!-- SQL dialect -->
	<property name="dialect">org.hibernate.dialect.MySQL5Dialect</property>

	
	<!-- Echo all executed SQL to stdout -->
	<property name="show_sql">true</property>

	<!-- Drop and re-create the database schema on startup -->
	<property name="hbm2ddl.auto">create-drop</property>

	<mapping resource="ProductDetails.hbm.xml"/>

</session-factory>

</hibernate-configuration>




ProductDetails.hbm.xml:

<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE hibernate-mapping PUBLIC "-//Hibernate/Hibernate Mapping DTD 3.0//EN"
"http://www.hibernate.org/dtd/hibernate-mapping-3.0.dtd">


<hibernate-mapping package="beans" default-access="field">
  <class name="ProductDetails" table="ProductDetails" >
     <id name="productid" column="id" type="java.lang.Integer"></id>
        <property name="productname" length="20"></property>
  </class>
</hibernate-mapping>







Web.xml:


<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns="http://java.sun.com/xml/ns/javaee" xsi:schemaLocation="http://java.sun.com/xml/ns/javaee http://java.sun.com/xml/ns/javaee/web-app_3_0.xsd" id="WebApp_ID" version="3.0">
  <display-name>HibernateAddProduct</display-name>
  <welcome-file-list>
    <welcome-file>index.html</welcome-file>
    
  </welcome-file-list>
</web-app>
