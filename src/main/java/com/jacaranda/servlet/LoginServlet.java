package com.jacaranda.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.digest.DigestUtils;

import com.jacaranda.control.UserControl;
import com.jacaranda.control.UserControlException;
import com.jacaranda.model.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(description = "Servlet for login", urlPatterns = { "/LoginServlet" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final String HTML_PART1 = "<!DOCTYPE html>\r\n"
			+ "<html lang=\"en\">\r\n"
			+ "<head>\r\n"
			+ "    <meta charset=\"UTF-8\">\r\n"
			+ "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n"
			+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
			+ "    <title>Confirmación de acceso</title>\r\n"
			+ "    <link rel=\"stylesheet\" type=\"text/css\" href=\"CSS/error.css\">\r\n"
			+ "</head>\r\n"
			+ "<body>\r\n"
			+ "\r\n"
			+ "    <div class=\"site_wrap\">\r\n"
			+ "        <div class=\"title\">\r\n"
			+ "        <h1>Comestibles Correa</h1>\r\n"
			+ "        </div>\r\n"
			+ "        <div class=\"error\">";
	
	private static final String HTML_PART2 =  "</div>\r\n"
			+ "        <div class=\"back\">\r\n"
			+ "            <a href=\"index.jsp\">Volver al inicio</a>\r\n"
			+ "        </div>\r\n"
			+ "        <div class= \"footer\">\r\n"
			+ "        <p>&copy; Comestibles Correa</p>\r\n"
			+ "        </div>\r\n"
			+ "    </div>\r\n"
			+ "</body>\r\n"
			+ "</html>";
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String encriptedPassword = DigestUtils.md5Hex(password);
		response.setContentType("text/html");

		try {
			User user = UserControl.checkUser(userName, encriptedPassword);
			
			if(user != null) {

			response.getWriter()
					.append("<!DOCTYPE html>\r\n" + "<html lang=\"en\">\r\n" + "<head>\r\n"
							+ "    <meta charset=\"UTF-8\">\r\n"
							+ "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n"
							+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
							+ "    <title>Confirmación de acceso</title>\r\n" + "</head>\r\n" + "<body>\r\n"
							+ "<h1>Bienvenido</h1>\r\n" + "</body>\r\n" + "</html>");
			} else {
				response.getWriter()
				.append(HTML_PART1 + "<h3>El usuario o la contraseña no son válidos.</h3>" + HTML_PART2);
			}
		} catch (UserControlException e) {

			response.getWriter()
			.append(HTML_PART1 + "<h3>El usuario o la contraseña no son válidos.</h3>" + HTML_PART2);
		}

	}

}
