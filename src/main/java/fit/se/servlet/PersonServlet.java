package fit.se.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import fit.se.entities.*;
import fit.se.dao.*;

@WebServlet("/PersonServlet")
public class PersonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PersonDAO personDAO;

	public PersonServlet() {
		personDAO = new PersonDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		listPerson(request, response);
	}

	private void listPerson(HttpServletRequest request, HttpServletResponse response) {
		List<Person> list = personDAO.getPeople();
		PrintWriter out = null;
		try {
			out = response.getWriter();
			out.println("<!DOCTYPE html>" + 
					"<html>" + 
					"<head>" + 
					"<meta charset=\"UTF-8\">" + 
					"<title>Person Information</title>" + 
					"</head>" + 
					"<body>" + 
					"	<form action=\"Add\" method=\"post\" name=\"frmPerson\">" + 
					"		<table>" + 
					"			<tr>" + 
					"				<td>Name:</td>" + 
					"				<td><input type=\"text\" name=\"txtName\" size=\"40\"" + 
					"					required=\"required\" /></td>" + 
					"			</tr>" + 
					"			<tr>" + 
					"				<td>Country:</td>" + 
					"				<td><input type=\"text\" name=\"txtCountry\" size=\"40\"" + 
					"					required=\"required\" /></td>" + 
					"			</tr>" + 
					"			<tr>" + 
					"				<td><input type=\"submit\" value=\"Add Person\" name=\"senddata\" />" + 
					"				</td>" + 
					"				<td></td>" + 
					"			</tr>" + 
					"		</table>");

			out.println("<table><tr><th>Id</th><th>Name</th><th>Country</th><th>Edit</th><th>Delete</th>");
			for(Person x : list) {
				out.println();
				out.println("<tr><td>" + x.getId() +"</td><td>" + x.getName() + "</td><td>" + x.getCountry()+ 
						"</td><td><a href='FormEditServlet?id="+x.getId()+"'>edit</a>" +
						"</td><td><a href='Delete?id="+x.getId()+"'>delete</a>" + "</td></tr>");
			}
			out.println("</table></form></body></html>");

		}catch (Exception e) {
			e.printStackTrace();
			new ServletException(e);
		}finally {
			out.close();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}