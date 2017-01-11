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

import by.it_academy.model.dao_impl.UserDAOImpl;
import by.it_academy.model.entity4dao.User;
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
		
		try {
			
			udaoi.create(new UserListInit().getList());
		} catch (SQLException e) {
			System.out.println("fail to create");
		}
		
		/*System.out.println("демонстраиця удаления");
		System.out.println(udaoi.delete(133771986));*/
		System.out.println("демонстраиця гетид");
		System.out.println(udaoi.getById(500424833));
		System.out.println("демонстраиця гетол");
		for(User u:udaoi.getAll()){
			System.out.println(u);
		}
		System.out.println("демонстраиця гетбайлогинпас");
		System.out.println(udaoi.getByLoginPassword("head4max@gmail.com", "user1"));
		System.out.println(udaoi.getByLoginPassword("head4max@gmail.com", "user5"));
	}
	
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		
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
