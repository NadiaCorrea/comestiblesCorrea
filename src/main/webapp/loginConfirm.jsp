<%@page import="com.jacaranda.control.UserControl"%>
<%@page import="com.jacaranda.model.User"%>
<%@page import="org.apache.commons.codec.digest.DigestUtils"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UFT-8">
<title>Confirmación de acceso</title>
</head>
<body>

<%
	String userName = request.getParameter("userName");
	String password = request.getParameter("password");
	String encriptedPassword = DigestUtils.md5Hex(password);
	
	User user = UserControl.checkUser(userName, encriptedPassword);
	
	
	if (user!= null){%>
		
		<jsp:forward page="productsList.jsp"></jsp:forward>
		
		
	<%} else{
	
		String message = "El usuario o la clave no son correctos.";
	
	%>
	
		<jsp:forward page="error.jsp"><jsp:param value="<%= message %>" name="message"/>  </jsp:forward>
	
	
	<%}

%>
</body>
</html>