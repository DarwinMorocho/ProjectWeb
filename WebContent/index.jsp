<%@page import="java.util.List"%>
<%@page import="modelo.Usuario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="stylesheet" href="css/style.css" type="text/css" media="all" />
	<script src="js/jquery-1.4.1.min.js" type="text/javascript"></script>
	<script src="js/jquery.jcarousel.pack.js" type="text/javascript"></script>
	<script src="js/jquery-func.js" type="text/javascript"></script>
<title>Login</title>
</head>
<body>
	<%
		String tituloPagina = "Crear Local";
	%>
<%-- 	<%@include file="../commons/header.jsp"%> --%>

	

	<form method="post" action="Login">
		<table style="margin: 10% 30% 20% 30%;">
			<tr>
				<th>Usuario:</th> 
				<th> <input type="text" name="usuario" /></th>
				
			</tr>
			<tr>
				<th>Contraseña:</th> 
				<th> <input type="text" name="password" /></th>
				
			</tr>
			<tr>
				<th></th> 
				<th> <input type="submit" value="Ingresar" class="boton" /></th>
				
			</tr>
		</table>




		
	</form>


</body>
</html>
