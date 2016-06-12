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
<title>Insert title here</title>
</head>
<body>
	<%
		String tituloPagina = "Crear Local";
	%>
	<%@include file="../commons/header.jsp"%>



	<form method="post" action="ActualizarClienteCtrl">
		<%
			Cliente p = (Cliente)

			request.getAttribute("CLIENTE");
		%>
		<center>
			<table>
				<tr>
					<th colspan="2">Actualizar cliente</th>

				</tr>
				<tr>
					<th style='display: none;'></th>
					<th style='display: none;'><input type="text" name="id"
						value=<%=p.getIdCliente()%> /></th>

				</tr>
				<tr>
					<th>Cedula:</th>
					<th><input type="text" name="ced" value=<%=p.getCliCedula()%> /></th>

				</tr>
				<tr>
					<th>Nombre:</th>
					<th><input type="text" name="name" value=<%=p.getCliNombre()%> /></th>

				</tr>
				<tr>
					<th>Razon social:</th>
					<th><input type="text" name="raz"
						value=<%=p.getCliRazonSocial()%> /></th>

				</tr>
				<tr>
					<th>Direccion:</th>
					<th><input type="text" name="dir"
						value=<%=p.getCliDireccion()%> /></th>

				</tr>
				<tr>
					<th>Telefono:</th>
					<th><input type="text" name="tel"
						value=<%=p.getCliTelefono()%> /></th>

				</tr>
				<tr>
					<th>Movil:</th>
					<th><input type="text" name="mov" value=<%=p.getCliMovil()%> /></th>

				</tr>
				<tr>
					<th>Correo:</th>
					<th><input type="text" name="cor" value=<%=p.getCliCorreo()%> /></th>

				</tr>
				<tr>
					<th></th>
					<th><input type="submit" value="Guardar" class="boton" /> <a
						style="color: blue; float: right:;"
						href="http://localhost:8080/ProjectWeb/consultarcliente.jsp">
							Regresar</a></th>

				</tr>


			</table>
		</center>





	</form>


</body>
</html>
