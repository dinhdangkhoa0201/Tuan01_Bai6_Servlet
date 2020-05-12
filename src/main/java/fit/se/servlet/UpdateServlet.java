package fit.se.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bson.types.ObjectId;

import fit.se.entities.Person;
import fit.se.dao.PersonDAO;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/Update")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private PersonDAO personDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
        super();
        personDAO = new PersonDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String  id = request.getParameter("id");
			String  name = request.getParameter("txtName");
			String  country = request.getParameter("txtCountry");
			
			Person p = personDAO.getPerson(new ObjectId(id));
			p.setName(name);
			p.setCountry(country);
			
			boolean result = personDAO.update(p);
			if(result) {
				response.sendRedirect("PersonServlet");  
			}				
			
		}catch (Exception e) {
			e.printStackTrace();
			new ServletException(e);
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
