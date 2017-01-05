package by.it_academy.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author head4max
 *
 */
@WebServlet("/university")
public class UniversityServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6458809598480399931L;

	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		
		String login = request.getSession().getAttribute("login").toString();
		String password = request.getSession().getAttribute("login").toString();
		
		
		
		request.getRequestDispatcher("University.jspx").forward(request, response);
/*		response.setContentType("text/html"); // Задаем формат ответа - HTML
		
		String uri = request.getRequestURI();
		this.context.log("Requested Resource::"+uri);
		
		HttpSession session = request.getSession(false);
		
		if(session == null && !(uri.endsWith("LogOnPage"))){
			this.context.log("Unauthorized access request");
			response.sendRedirect("LogOnPage.jspx");
		}*/
	}
}
