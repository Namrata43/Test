package wp.java;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Derails
 */
@WebServlet("/Derails")
public class Derails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Derails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = res.getWriter();
		String id = req.getParameter("id");
		String cname = req.getParameter("cname");
		String cbrand = req.getParameter("cbrand");
        String cprice = req.getParameter("cprice");
        
        // Display the received variables
        out.println("<html>");
        out.println("<body> <center>");
        out.println("<h1>Car Name: " + cname + "</h1>");
        out.println("<h1>Car Brand: " + cbrand + "</h1>");
        out.println("<h1>Car Price: " + cprice + "</h1>");
        
        
        String delUrl="Delete?id="+id;
        out.println("<a href='" + delUrl + "'>" + "Delete" + "</a>");
        
        String editUrl="EditCar?id="+id+"&cname="+cname+"&cbrand="+cbrand+"&bprice="+cprice;
        out.println("<a href='" + editUrl + "'>" + "Edit" + "</a>");
        
        
        out.println("</center></body>");
        out.println("</html>");
        
        out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
