package by.it_academy.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.it_academy.model.dao_impl.CertificateDAOImpl;
import by.it_academy.model.dao_impl.FacultiesDAOImpl;
import by.it_academy.model.dao_impl.ObjectNameDAOImpl;
import by.it_academy.model.dao_impl.StudentStatementDAOImpl;
import by.it_academy.model.dao_impl.UserDAOImpl;
import by.it_academy.model.entity4dao.Certificate;
import by.it_academy.model.entity4dao.Faculty;
import by.it_academy.model.entity4dao.ObjectNameInfo;
import by.it_academy.model.entity4dao.StudentStatement;
import by.it_academy.model.entity4dao.User;
import by.it_academy.model.entity4dao.init_list.CertificateListInit;
import by.it_academy.model.entity4dao.init_list.FacultyListInit;
import by.it_academy.model.entity4dao.init_list.ObjectNameListInit;
import by.it_academy.model.entity4dao.init_list.UserListInit;

/**
 * @author head4max
 *
 */
@WebServlet("/University")
public class UniversityServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6458809598480399931L;

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		
		UserDAOImpl udaoi = new UserDAOImpl();
		ObjectNameDAOImpl ondaoi = new ObjectNameDAOImpl();
		CertificateDAOImpl cdaoi = new CertificateDAOImpl();
		FacultiesDAOImpl fdaoi = new FacultiesDAOImpl();
		StudentStatementDAOImpl ssdaoi =  new StudentStatementDAOImpl();
		
		System.out.println(new FacultyListInit().getList());
		for(Faculty u:new FacultyListInit().getList()){
			System.out.println(u);
		}
		

		udaoi.create(new UserListInit().getList());
		ondaoi.create(new ObjectNameListInit().getList());
		cdaoi.create(new CertificateListInit().getList());
		fdaoi.create(new FacultyListInit().getList());
		ssdaoi.create(new ArrayList<StudentStatement>());
		
	}
	
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		
		
		System.out.println("dfsfsf");
		/*System.out.println("демонстраиця гетид");
		System.out.println(fdaoi.getById(-164354418));
		System.out.println("демонстраиця удаления");
		System.out.println(fdaoi.delete(133771986));
		System.out.println("демонстраиця гетол");
		for(Faculty u:fdaoi.getAll()){
			System.out.println(u);
		}*/
		
//		String login = request.getSession().getAttribute("login").toString();
//		String password = request.getSession().getAttribute("login").toString();
		
		
		
//		request.getRequestDispatcher("University.jspx").forward(request, response);
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
