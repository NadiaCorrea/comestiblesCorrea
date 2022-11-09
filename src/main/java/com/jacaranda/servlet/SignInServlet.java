package com.jacaranda.servlet;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.digest.DigestUtils;

import com.jacaranda.control.UserControl;
import com.jacaranda.model.User;

/**
 * Servlet implementation class SignInServlet
 */
@WebServlet(description = "servlet for signning in", urlPatterns = { "/SignInServlet" })
public class SignInServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final String HTML_START = "";
	private static final String HTML_END = "";
	private static final String HTML_ERROR1 = "<!DOCTYPE html>\r\n"
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
       
	private static final String HTML_ERROR2 = "</div>\r\n"
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
    public SignInServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String lastname = request.getParameter("lastname");
		LocalDate dob = LocalDate.parse(request.getParameter("dob"));
		char sex = request.getParameter("sex").charAt(0);
		
		String encriptedPassword = DigestUtils.md5Hex(password);
		boolean admin = false;
		
	
		response.setContentType("text/html");
		
		try {
			User newUser = UserControl.addUser(userName, encriptedPassword, name, lastname, dob, sex, admin);
			
			if (newUser != null) {
				//usuario creado - llevar a listado
				response.getWriter().append(HTML_ERROR1 + "<h3>bienvenido</h3>" + HTML_ERROR2);
			} else {
				// error 
				response.getWriter().append(HTML_ERROR1 + "<h3>El usuario ya existe.</h3>" + HTML_ERROR2);
			}
		} catch (Exception e) {
			response.getWriter().append(HTML_ERROR1 + "<h3>Ha ocurrido un error inesperado. Contacte con el administrador.</h3>" + HTML_ERROR2);
		}
	}

}
