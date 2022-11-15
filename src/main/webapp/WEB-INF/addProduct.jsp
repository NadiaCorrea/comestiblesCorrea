<%@page import="com.jacaranda.model.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Añadir Producto</title>
</head>
<body>

<%
	HttpSession se = request.getSession();
	User loggedUser = (User) se.getAttribute("user");
	if(loggedUser != null && loggedUser.isAdmin()){%>

<div class="site_wrap">
	<div class="title">
	<h1>Comestibles Correa - Añadir nuevo Producto</h1>
	</div>
	<div class="form">
		<form action="Servlet" method="post">
		
			<label for="name">Nombre del producto: </label><br>
			<input type="text" id="name" name="name" minlength="2" maxlength="100" required><br>
			
			<label for="description">Descripción: </label><br>
			<input type ="text" id="description" name="description" minlength="5" maxlength="15" required><br>

			<label for="price">Precio: </label><br>
			<input type="number" id="price" name="price" step="0.01" required><br>
			
			<label for="category">Categoría: </label><br>
			<input type="text" id="category" name="category" minlength="2" maxlength="100" required><br>
		
			<button type="submit" id="addProduct">Añadir</button>
		</form>
	</div>
	<div class="back">
         <a href="">Volver</a>
     </div>
	<div class= "footer">
	<p>&copy; Comestibles Correa</p>
	</div>
</div>
		
		
		
	<%}else{
		//mostar error no te estas logueado		
	}
	%>
	


</body>
</html>