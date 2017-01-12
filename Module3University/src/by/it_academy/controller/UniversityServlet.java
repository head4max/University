package by.it_academy.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.it_academy.model.dao_impl.CertificateDAOImpl;
import by.it_academy.model.dao_impl.ObjectNameDAOImpl;
import by.it_academy.model.dao_impl.UserDAOImpl;
import by.it_academy.model.entity4dao.Certificate;
import by.it_academy.model.entity4dao.ObjectNameInfo;
import by.it_academy.model.entity4dao.User;
import by.it_academy.model.entity4dao.init_list.CertificateListInit;
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
		
		
	}
	
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		
		UserDAOImpl udaoi = new UserDAOImpl();
		ObjectNameDAOImpl ondaoi = new ObjectNameDAOImpl();
		CertificateDAOImpl cdaoi = new CertificateDAOImpl();
		
		System.out.println(new CertificateListInit().getList());
		for(Certificate u:new CertificateListInit().getList()){
			System.out.println(u);
		}
		

		udaoi.create(new UserListInit().getList());
		ondaoi.create(new ObjectNameListInit().getList());
		cdaoi.create(new CertificateListInit().getList());

		System.out.println("демонстраиця гетид");
		System.out.println(cdaoi.getById(841471883));
		System.out.println("демонстраиця удаления");
		System.out.println(cdaoi.delete(133771986));
		/*System.out.println("демонстраиця гетол");
		for(ObjectNameInfo u:cdaoi.getAll()){
			System.out.println(u);
		}*/
		
//		String login = request.getSession().getAttribute("login").toString();
//		String password = request.getSession().getAttribute("login").toString();
		
		
		
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
