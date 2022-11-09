<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registro de usuarios</title>
<link rel="stylesheet" type="text/css" href="css/index.css">
<script>
	function TDate() {
		var today = new Date();
		var dd = today.getDate();
		var mm = today.getMonth() + 1; //January is 0!
		var yyyy = today.getFullYear();
		if (dd < 10) {
			dd = '0' + dd;
		}
		if (mm < 10) {
			mm = '0' + mm;
		}
		today = yyyy + '-' + mm + '-' + dd;
		document.getElementById("dob").setAttribute("max", today);
	}
</script>
</head>
<body>

<div class="site_wrap">
	<div class="title">
	<h1>Comestibles Correa - Registro</h1>
	</div>
	<div class="form">
		<form action="SignInServlet" method="post">
			
			<label for="userName">Usuario: </label><br>
			<input type="text" id="userName" name="userName" minlenght="2" maxlength="20" required><br>
			
			<label for="password">Contraseña: </label><br>
			<input type ="password" id="password" name="password" minlegnth="5" maxlength="15" required><br>

			<label for="name">Nombre: </label><br>
			<input type="text" id="name" name="name" minlenght="2" maxlength="100" required><br>
			
			<label for="lastname">Apellido: </label><br>
			<input type="text" id="lastname" name="lastname" minlenght="2" maxlength="100" required><br>
			
			<label>Fecha de nacimiento: </label><br>
			<input type="date" id="dob" name="dob" min='1899-01-01' max='2000-13-13' onclick="TDate()" required><br>
			
			<label for="sex">Sexo: </label><br>
			Hombre <input type="radio" id="sex" name="sex" value="H" required><br>
			Mujer <input type="radio" id="sex" name="sex" value="M"><br>
			
			<input type="hidden" id="admin" name="admin" value="0"><br>
			
			<button type="submit" id="sigIn">Registarse</button>
		</form>
	</div>
	<div class= "footer">
	<p>&copy; Comestibles Correa</p>
	</div>
</div>
</body>
</html>

	<!--
  `userName` varchar(20) NOT NULL,
  `password` varchar(32) DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL,
  `lastname` varchar(100) DEFAULT NULL,
  `dob` date DEFAULT NULL,
  `sex` char(1) DEFAULT NULL,
  `admin` tinyint(1) DEFAULT NULL -->