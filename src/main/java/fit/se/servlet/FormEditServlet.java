package fit.se.servlet;



import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import fit.se.dao.*;
import fit.se.entities.*;

import org.bson.types.ObjectId;

/**
 * Servlet implementation class FromEditServlet
 */
@WebServlet("/FormEditServlet")
public class FormEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private PersonDAO personDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FormEditServlet() {
        super();
        personDAO = new PersonDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<h1>Update Employee</h1>");
		String id=request.getParameter("id");
		
		Person p = personDAO.getPerson(new ObjectId(id));
		
		out.print("<form action='Update' method='post'>");
		out.print(	"<html><body><table>"+
						"<tr><td></td><td><input type='hidden' name='id' value='"+p.getId()+"'/></td></tr>" +
						"<tr><td>Name:</td><td><input type='text' name='txtName' value='"+p.getName()+"'/></td></tr>" +
						"<tr><td>Country:</td><td><input type='text' name='txtCountry' value='"+p.getCountry()+"'/></td></tr>" +
						"<tr><td colspan='2'><input type='submit' value='Save'/></td></tr>" +
						"</table>" + 
						"</form></body></html>");
		
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
