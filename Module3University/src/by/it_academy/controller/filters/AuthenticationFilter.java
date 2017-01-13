package by.it_academy.controller.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
//import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.it_academy.model.dao_impl.UserDAOImpl;
import by.it_academy.model.entity4dao.ExtendedUser;
import by.it_academy.model.entity4dao.User;

/**
 * authorisation filter
 * @author head4max
 *
 */
public class AuthenticationFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain fc)
			throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		
		response.setContentType("text/html");
		String uri = req.getRequestURI();
		HttpSession session = req.getSession(false);

		System.out.println("end with " + uri.endsWith("LogOn.jspx"));
		System.out.println("sesion " + session);
		if(session == null) {
			if ((uri.endsWith("LogOn.jspx"))) {

				ExtendedUser eu = (ExtendedUser) new UserDAOImpl().getByLoginPassword(
						req.getAttribute("login").toString(), req.getAttribute("password").toString());
				if (eu != null) {
					session = req.getSession();
					req.setAttribute("user", (User) eu);
					switch (eu.getAccessType()) {
					case 1:
						res.sendRedirect("StudentUniversity.jspx");
						break;
					case 2:
						res.sendRedirect("University.jspx");
						break;
					default:
						res.sendRedirect("InspectorUniversity.jspx");
					}
				} else {
					res.sendRedirect("LogOn.jspx");
				}
			}
		}
		
		fc.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}

	@Override
	public void destroy() {
	}

}
