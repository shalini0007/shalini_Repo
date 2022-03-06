import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/GetByProductId")
public class GetByProductId extends HttpServlet {

	 private static final long serialVersionUID = 1L;
     
	    /**
	* @see HttpServlet#HttpServlet()
	*/
	    public GetByProductId() {
	        super();
	        // TODO Auto-generated constructor stub
	    }
	    
	   

	        /**
	         * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	         */
	        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	                // TODO Auto-generated method stub
	                
	                try {
	                        PrintWriter out = response.getWriter();
	                        out.println("<html><body>");
	                         
	                        InputStream in = getServletContext().getResourceAsStream("/WEB-INF/config.properties");
	                        Properties props = new Properties();
	                        //props.load(in);
	                        
	                        //connection information
	                        DBConnection conn = new DBConnection("jdbc:mysql://localhost:3306/db_world", "root", "root");
	                        Statement stmt = conn.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
	                      //  stmt.executeUpdate("insert into products (productid, price, date_added) values ('New Product', 17800.00, now())");
	                        
	                        //query the table and get all information
	                        ResultSet rst = stmt.executeQuery("select * from products");
	                        
	                        //find what the user typed into the search box
	                        String productid = request.getParameter("productid");
	                        
	                        //user hasn't typed anything so display table
	                        if(productid == null)
	                        {	
		                        out.println("The following are the elements in the products table" + "<Br>" + "<Br>");
		                        //simple while loop to print all elements in table
		                        while (rst.next()) {
		                                out.println("Product Id "+rst.getInt("productid") + ":	 " +" Product name : "+ rst.getString("productname") + " 	" 
		                                +" Product Price : "+ rst.getDouble("productprice") + "<Br>");
		                        }
	                        }
	                        //user typed something
	                        else 
	                        {
	                        	//select the row corresponding to the id number
	                        	String sql_res= "select * from products where productid=" + productid;
	                            ResultSet inTable = stmt.executeQuery(sql_res);
	                            
	                            //if not empty then print all product details
	                            if(inTable.next())
	                            	out.println("Product Id "+inTable.getInt("productid") + ":	 " +" Product name : "+ inTable.getString("productname") + "	 " 
	                            		+" Product Price : "+ inTable.getInt("productprice") + "<Br>");
	                            //empty so print error message
	                            else
	                            	out.println("There was no element with product ID: " + productid + " found in the table, please try again");
	                           
	                        }
	                    	
	                        stmt.close();
	                        
	                        
	                        
	                        out.println("</body></html>");
	                        conn.closeConnection();
	                        
	                } catch (ClassNotFoundException e) {
	                        e.printStackTrace();
	                } catch (SQLException e) {
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

class DBConnection {

    private Connection connection;
    
    public DBConnection(String dbURL, String user, String pwd) throws ClassNotFoundException, SQLException{
            
            Class.forName("com.mysql.jdbc.Driver");
            this.connection = DriverManager.getConnection(dbURL, user, pwd);
    }
    
    public Connection getConnection(){
            return this.connection;
    }
    
    public void closeConnection() throws SQLException {
            if (this.connection != null)
                    this.connection.close();
    }
}

	


Products.java

public class Products {

	private int id;
	private String name;
	private double price;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", price=" + price + "]";
	}
	
}

Index.html
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="./GetByProductId?productid=productid">
Enter ProductId<br>
<input type="text" name="productid" ><br>
<button type="Submit"> search

</form>
</body>
</html>

Web.xml
<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns="http://java.sun.com/xml/ns/javaee" xsi:schemaLocation="http://java.sun.com/xml/ns/javaee http://java.sun.com/xml/ns/javaee/web-app_2_5.xsd" id="WebApp_ID" version="2.5">
  <display-name>PracticeProject2</display-name>
  <welcome-file-list>
    <welcome-file>index.html</welcome-file>
    <welcome-file>index.htm</welcome-file>
    <welcome-file>index.jsp</welcome-file>
    <welcome-file>default.html</welcome-file>
    <welcome-file>default.htm</welcome-file>
    <welcome-file>default.jsp</welcome-file>
  </welcome-file-list>
  <servlet>
    <description></description>
    <display-name>GetByProductId</display-name>
    <servlet-name>GetByProductId</servlet-name>
    <servlet-class>GetByProductId</servlet-class>
  </servlet>
  <servlet-mapping>
    <servlet-name>GetByProductId</servlet-name>
    <url-pattern>/GetByProductId</url-pattern>
  </servlet-mapping>
</web-app>
