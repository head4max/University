/**
 * 
 */
package by.it_academy.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author head4max
 *
 */
public class UniversityServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6458809598480399931L;

	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
		
		response.setContentType("text/html"); // Задаем формат ответа - HTML
		
		PrintWriter out;
		
		out = response.getWriter(); // Получаем объект, позволяющий
		out.write("<!DOCTYPE html>\n"			// записать контент в ответ
				+	"<html>\n"
				+ "<h1>Hello Max</h1>\n"
				+ "</body></html>");
	}
}
