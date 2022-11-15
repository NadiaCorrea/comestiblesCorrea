package com.jacaranda.servlet;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.digest.DigestUtils;

import com.jacaranda.control.ConnectionDBException;
import com.jacaranda.control.ElementControl;
import com.jacaranda.control.UserControl;
import com.jacaranda.control.UserControlException;
import com.jacaranda.model.Element;
import com.jacaranda.model.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(description = "Servlet for login", urlPatterns = { "/LoginServlet" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final String HTML_SUCCESS1 = "<!DOCTYPE html>\r\n" + "<html lang=\"en\">\r\n" + "<head>\r\n"
			+ "    <meta charset=\"UTF-8\">\r\n" + "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n"
			+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
			+ "    <title>Confirmación de acceso</title>\r\n"
			+ "    <link rel=\"stylesheet\" type=\"text/css\" href=\"CSS/productsList.css\">\r\n" + "</head>\r\n"
			+ "<body>\r\n" + "\r\n" + "    <div class=\"site_wrap\">\r\n" + "        <div class=\"title\">\r\n"
			+ "        <h1>Comestibles Correa</h1>\r\n" + "        </div>\r\n" + "        <div class=\"session\">";

	private static final String HTML_SUCCESS2 = "</div>\r\n" + "        <div class=\"back\">\r\n"
			+ "            <a href=\"index.jsp\">Volver al inicio</a>\r\n" + "        </div>\r\n"
			+ "        <div class= \"footer\">\r\n" + "        <p>&copy; Comestibles Correa</p>\r\n"
			+ "        </div>\r\n" + "    </div>\r\n" + "</body>\r\n" + "</html>";

	private static final String HTML_ERROR1 = "<!DOCTYPE html>\r\n" + "<html lang=\"en\">\r\n" + "<head>\r\n"
			+ "    <meta charset=\"UTF-8\">\r\n" + "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n"
			+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
			+ "    <title>Confirmación de acceso</title>\r\n"
			+ "    <link rel=\"stylesheet\" type=\"text/css\" href=\"CSS/error.css\">\r\n" + "</head>\r\n"
			+ "<body>\r\n" + "\r\n" + "    <div class=\"site_wrap\">\r\n" + "        <div class=\"title\">\r\n"
			+ "        <h1>Comestibles Correa</h1>\r\n" + "        </div>\r\n" + "        <div class=\"error\">";

	private static final String HTML_ERROR2 = "</div>\r\n" + "        <div class=\"back\">\r\n"
			+ "            <a href=\"index.jsp\">Volver al inicio</a>\r\n" + "        </div>\r\n"
			+ "        <div class= \"footer\">\r\n" + "        <p>&copy; Comestibles Correa</p>\r\n"
			+ "        </div>\r\n" + "    </div>\r\n" + "</body>\r\n" + "</html>";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	//It gets the parameters(userName and password) sent on the form
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");

		try {
			//if the parameters aren't empty the password is encrypted
			if (!password.isBlank() && !userName.isBlank()) {
				String encryptedPassword = DigestUtils.md5Hex(password);
				response.setContentType("text/html");
				
				//It check if the user exist
				User user = UserControl.checkUser(userName, encryptedPassword);
				
				//If user exist then creates the session and shows the list of products depending on the role
				if (user != null) {
					HttpSession session = request.getSession(true);
					session.setAttribute("user", user.getName());
					session.setAttribute("admin", user.isAdmin());
					
					List<Element> elements = ElementControl.getElements(); 
					String htmlResult = "<table><tr><td>Nombre de producto</td><td>Descripción</td><td>Precio</td><td>Categoria</td></tr>";
					
					Iterator<Element> iterator = elements.iterator();
					
					while(iterator.hasNext()) {
						Element iElement= iterator.next();
						
						htmlResult += "<tr id="+ iElement.getEleId() +">"
								+ "<td>"+ iElement.getName() +"</td>"
								+ "<td>"+ iElement.getDescription()+"</td>"
								+ "<td>"+ iElement.getPrice()+"</td>"
								+ "<td>"+ iElement.getCategory().getName()+"</td>"
								+ "</tr>";
					}
					
					response.getWriter().append(HTML_SUCCESS1 + "<h1>Bienvenido " + session.getAttribute("user")
							+ "</h1>\r\n"
							+ getAddButton(user.isAdmin()) //it only shows this option if the user has an admin role
							+ "</div>" 
							+ "<div class = table>"
							+ htmlResult 
							+ "</table>"
							+ HTML_SUCCESS2);
				} else {
					response.getWriter()
							.append(HTML_ERROR1 + "<h3>El usuario o la contraseña no son válidos.</h3>" + HTML_ERROR2);
				}

			} else {
				response.getWriter()
				.append(HTML_ERROR1 + "<h3>Ni el usuario ni la contrase&ntildea pueden estar vac&iacute;os.</h3>" + HTML_ERROR2);
			}

		} catch (UserControlException | ConnectionDBException e) {

			response.getWriter()
					.append(HTML_ERROR1 + "<h3>" + e.getMessage() +"</h3>" + HTML_ERROR2);
		}

	}

	private String getAddButton(boolean admin) {
		String result = "";
		if (admin) {
			result = "<a href='addProduct.jsp'>Añadir producto</a>";
		}
		
		return result;
	}

}
