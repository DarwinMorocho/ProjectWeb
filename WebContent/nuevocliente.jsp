<%@page import="modelo.Cliente"%>
<%@page import="java.util.List"%>
<%@page import="modelo.Producto"%>
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
<title>nuevo cliente</title>
</head>
<body>
	<%
		String tituloPagina = "Crear Local";
	%>
	<%@include file="../commons/header.jsp"%>



	<center>
		<form method="post" action="NuevoClienteCtrl">
			<%
				Cliente p = (Cliente)

				request.getAttribute("CLIENTE");
			%>

			<table>
				<tr>
					<th colspan="2">Nuevo Cliente</th>
				</tr>
				<tr>
					<th>Cedula:</th>
					<th><input type="text" name="ced" /></th>

				</tr>
				<tr>
					<th>Nombre:</th>
					<th><input type="text" name="name" /></th>

				</tr>
				<tr>
					<th>Razon social:</th>
					<th><input type="text" name="raz" /></th>

				</tr>
				<tr>
					<th>Direccion:</th>
					<th><input type="text" name="dir" /></th>

				</tr>
				<tr>
					<th>Telefono:</th>
					<th><input type="text" name="tel" /></th>

				</tr>
				<tr>
					<th>Movil:</th>
					<th><input type="text" name="mov" /></th>

				</tr>
				<tr>
					<th>Correo:</th>
					<th><input type="text" name="cor" /></th>

				</tr>
				<tr>
					<th></th>
					<th><input type="submit" value="Guardar" class="boton" /> <a
						style="color: blue; float: right:;"
						href="http://localhost:8080/ProjectWeb/consultarcliente.jsp">
							Regresar</a></th>

				</tr>


			</table>






		</form>
	</center>


</body>
</html>
