package by.it_academy.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
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
import by.it_academy.model.entity4dao.ExtendedUser;
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
@WebServlet("/university")
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

		udaoi.create(new UserListInit().getList());
		ondaoi.create(new ObjectNameListInit().getList());
		cdaoi.create(new CertificateListInit().getList());
		fdaoi.create(new FacultyListInit().getList());
		ssdaoi.create(new ArrayList<StudentStatement>());
		
	}
	
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		
		response.setContentType("text/html");
		String uri = request.getRequestURI();
		HttpSession session = request.getSession(false);
		
		System.out.println("servlet end with Logon " + uri.endsWith("LogOn.jspx"));
		System.out.println("servlet end with Module3 " + uri.endsWith("Module3University/"));
		System.out.println("servlet sesion " + session);
		if ( session == null) {
			System.out.println("session=null");

			System.out.println("req param " + request.getParameterMap());
			System.out.println("req param " + request.getParameter("login"));
//			System.out.println( request.getParameter("login"));
			String loginUser = (String) request.getAttribute("login");
//			System.out.println(loginUser);
			String passwordUser = (String) request.getAttribute("password");
//			System.out.println(passwordUser);
			ExtendedUser eu = null;
			if(loginUser != null && passwordUser!= null){
				eu = (ExtendedUser) new UserDAOImpl().getByLoginPassword(loginUser, passwordUser);
			}
			if (eu != null) {
				session = request.getSession();
				System.out.println("fantomas");
				request.setAttribute("user", (User) eu);
				switch (eu.getAccessType()) {
				case 1:
					response.sendRedirect("StudentUniversity.jspx");
					break;
				case 2:
					response.sendRedirect("University.jspx");
					break;
				default:
					response.sendRedirect("InspectorUniversity.jspx");
				}
			}
		}
		
//		System.out.println("dfsfsf");
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
