package fit.se.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bson.types.ObjectId;

import fit.se.entities.Person;
import fit.se.dao.PersonDAO;

@WebServlet("/Delete")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private PersonDAO personDAO;

	public DeleteServlet() {
		super();
		personDAO = new PersonDAO();
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		try{
			PrintWriter out = response.getWriter();
			String id=request.getParameter("id");  
			Person p = personDAO.getPerson(new ObjectId(id));
			boolean result = personDAO.delete(p);
			if(result) {
				response.sendRedirect("PersonServlet");
				
			}else
				out.println("<h3>Chưa xóa được</h3>");
		}catch (Exception e) {
			e.printStackTrace();
			new ServletException(e);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
