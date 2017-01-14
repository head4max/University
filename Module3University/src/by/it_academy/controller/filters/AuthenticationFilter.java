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

		/*System.out.println("end with Logon " + uri.endsWith("LogOn.jspx"));
		System.out.println("end with Module3 " + uri.endsWith("Module3University/"));
		System.out.println("sesion " + session);*/
		if(session == null && !(uri.endsWith("LogOn.jspx") || uri.endsWith("Module3University/"))) {
			System.out.println("redirect to start page");
			res.sendRedirect("LogOn.jspx");
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
