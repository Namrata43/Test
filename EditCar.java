package wp.java;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EditBook
 */
@WebServlet("/EditBook")
public class EditBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditBook() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out= res.getWriter();
		out.println("Edit Book");
		String id = req.getParameter("id");
		String cname = req.getParameter("cname");
		String cbrand = req.getParameter("cbrand");
        String cprice = req.getParameter("cprice");
        out.println(cname);
        out.println("<form action='EditOPeration' method='POST'>");
        out.print("<table>");  
        out.print("<tr><td></td><td><input type='hidden' name='id' value='"+id+"'/></td></tr>");  
        out.print("<tr><td>Car Name:</td><td><input type='text' name='cname' value='"+cname+"'/></td></tr>");
        out.print("<tr><td>Car Brand:</td><td><input type='text' name='cbrand' value='"+cbrand+"'/></td></tr>");
        out.print("<tr><td>Car Price:</td><td><input type='text' name='cprice' value='"+cprice+"'/></td></tr>"); 
        out.println("<tr><td></td><td><input type='submit'value='EditCar'></td>");
        out.println("</table></form>");
	}

	

}
