package wp.java;

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

/**
 * Servlet implementation class Validate
 */
@WebServlet("/Validate")
public class Validate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Validate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out= res.getWriter();
    	try
		{
   Class.forName("com.mysql.cj.jdbc.Driver");
   Connection con= DriverManager.getConnection("jdbc:mysql://localhost/namrta","root","namrta@1234");
   PreparedStatement pst=  con.prepareStatement("Select * from car");
   ResultSet rs=  pst.executeQuery();
   while(rs.next())
   		{
	   String id=rs.getString(1);
	   String cname=rs.getString(2);
	   String cbrand=rs.getString(3);
	   String cprice=rs.getString(4);
	   String linkUrl = "Details?cname=" + cname + "&cbrand=" + cbrand+ "&cprice=" + cprice+ "&id=" + id;
       out.println("<html>");
       out.println("<body>");
       out.println("<a href='" + linkUrl + "'>" + cname + "</a>");
       out.println("</body>");
       out.println("</html>");
      }
   out.close();
		}//try end
    	catch(Exception e)
    	{
    		System.out.println(e);
    	}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
