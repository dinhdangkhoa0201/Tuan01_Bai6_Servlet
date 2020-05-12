package fit.se.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import fit.se.entities.Person;
import fit.se.dao.PersonDAO;


@WebServlet("/Add")
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private PersonDAO personDAO ;


	public AddServlet() {
		super();
		personDAO = new PersonDAO();
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String  name = request.getParameter("txtName");
			String  country = request.getParameter("txtCountry");

			Person p = new Person(name, country);
			boolean result = personDAO.insert(p);
			if(result) {
				response.sendRedirect("PersonServlet");
			}				
		}catch (Exception e) {
			e.printStackTrace();
			new ServletException(e);
		}


	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
