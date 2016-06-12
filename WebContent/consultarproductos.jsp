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
		<form method="post" action="BuscarProductoCtrl">
			Nombre: <input type="text" name="txtBuscar" /> <input type="submit"
				value="Buscar" class="boton" />
		</form>
	</center>

	<center>
	
		<table>
			<tr>
				<th style='display: none;'>Id<</th>
				<th>Codigo</th>
				<th>Nombre</th>
				<th>Costo</th>
				<th>Actualizar</th>
				<th>Eliminar</th>
				<th><a style="color: red;float:right: ;" href="http://localhost:8080/ProjectWeb/nuevoproducto.jsp">
        Nuevo</a></th>
			</tr>
			<%
				List<Producto> listaProdu = (List<Producto>) request
						.getAttribute("PRODUCTO");
				if (listaProdu != null) {
					for (Producto l : listaProdu) {
			%>
			<tr>
				<td style='display: none;'><%=l.getIdProducto()%></td>
				<td><%=l.getProdCodigo()%></td>
				<td><%=l.getProdNombre()%></td>
				<td><%=l.getPordCostoVentaFinal()%></td>

				<td><a href="ActualizarProcutoCtrl?id=<%=l.getIdProducto()%>">
						Actualizar </a></td>
				<td><a href="EliminarProductoCtrl?id=<%=l.getIdProducto()%>">Eliminar</td>
			</tr>
			<%
				}
				}
			%>
		</table>
	</center>
</body>
</html>
