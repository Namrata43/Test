package wp.java;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EditOperation
 */
@WebServlet("/EditOperation")
public class EditOperation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditOperation() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out= res.getWriter();
		String id= req.getParameter("id");
		String cname= req.getParameter("cname");
		String cbrand= req.getParameter("cbrand");
		String cprice= req.getParameter("cprice");
    	try
		{
   Class.forName("com.mysql.cj.jdbc.Driver");
   String updateSQL = "UPDATE car SET bname=?,bprice=? WHERE id=?";
   Connection con= DriverManager.getConnection("jdbc:mysql://localhost/namrta","root","namrta@1234");
   PreparedStatement pst=  con.prepareStatement(updateSQL);
   pst.setString(1,cname);
   pst.setString(2,cbrand);
   pst.setString(3,cprice);
   pst.setString(4,id);
   pst.executeUpdate();
   out.println("Car Updated");
   out.println("<a href =\"Validate\">Show Cars</a>");
   System.out.print("Car Updated");
		}
    	catch(Exception e)
    	{
    		System.out.print(e);
    	}
	}

}
