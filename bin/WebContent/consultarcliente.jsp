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
<title>Listado de productos</title>
</head>
<body>
	<%
		String tituloPagina = "Crear Local";
	%>
	<%@include file="../commons/header.jsp"%>

	<center>
		<form method="post" action="ConsultatClienteCtrl">
			Nombre: <input type="text" name="txtBuscar" /> <input type="submit"
				value="Buscar" class="boton" />
		</form>
	</center>

	<center>
<th><a style="color: red; float: right:;"
					href="http://localhost:8080/ProjectWeb/nuevocliente.jsp">
						Nuevo</a></th>
		<table style="width: 100%">
			<tr>
				<th style='display: none;'>Id<</th>
				<th>Cedula</th>
				<th>Nombre</th>
				<th>Razon social</th>
				<th>Direccion</th>
				<th>Telefono</th>
				<th>Movil</th>
				<th>Correo</th>
					<th>Actualizar</th>
				<th>Eliminar</th>
				
			</tr>
			<%
				List<Cliente> listaCli = (List<Cliente>) request
						.getAttribute("CLIENTE");
				if (listaCli != null) {
					for (Cliente l : listaCli) {
			%>
			<tr>
				<td><%=l.getCliCedula()%></td>
				<td><%=l.getCliNombre()%></td>
				<td><%=l.getCliRazonSocial()%></td>
				<td><%=l.getCliDireccion()%></td>
				<td><%=l.getCliTelefono()%></td>
				<td><%=l.getCliMovil()%></td>
				<td><%=l.getCliCorreo()%></td>

				<td><a href="ActualizarClienteCtrl?id=<%=l.getIdCliente()%>">
						Actualizar </a></td>
				<td><a href="EliminarClienteCtrl?id=<%=l.getIdCliente()%>">Eliminar</td>
				<td><a href="ConcultaFacturasCtrl?id=<%=l.getIdCliente()%>">Facturas</td>
			</tr>
			<%
				}
				}
			%>
		</table>
	</center>
</body>
</html>
