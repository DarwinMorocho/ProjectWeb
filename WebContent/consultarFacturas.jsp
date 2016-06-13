<%@page import="java.util.List"%>
<%@page import="modelo.Factura"%>
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
<title>Listado de Facturas</title>
</head>
<body>
	<%
		String tituloPagina = "Crear Local";
	%>
	<%@include file="../commons/header.jsp"%>

	<center>
		<form method="post" action="BuscarFacturaCtrl">
			Número de factura: <input type="text" name="txtBuscar" /> <input type="submit"
				value="Buscar" class="boton" />
		</form>
	</center>

	<center>
	<th><a style="color: red;float:right: ;" href="BuscarProductoCtrl?mensaje=consultaProductosCombo">
        Nuevo</a></th>
		<table>
			<tr>
				<th style='display: none;'>Id<</th>
				<th>Numero</th>
				<th>Cliente</th>
				<th>Usuario</th>
				<th>Fecha</th>
				<th>Total</th>
				<th>Actualizar</th>
				<th>Eliminar</th>
				
			</tr>
			<%
				List<Factura> listaFacturas = (List<Factura>) request.getAttribute("FACTURA");
				if (listaFacturas != null) {
					for (Factura factura : listaFacturas) {
			%>
			<tr>
				<td style='display: none;'><%=factura.getIdFactura()%></td>
				<td><%=factura.getFacNumero()%></td>
				<td><%=factura.getCliente().getCliNombre()%></td>
				<td><%=factura.getUsuario().getUsuNombre()%></td>
				<td><%=factura.getFacFecha()%></td>
				<td><%=factura.getFacTotal()%></td>
				

				<td><a href="ActualizarFacturaCtrl?id=<%=factura.getIdFactura()%>">Actualizar</a></td>
				<td><a href="EliminarFacturaCtrl?id=<%=factura.getIdFactura()%>">Eliminar</a></td>
			</tr>
			<%
				}
				}
			%>
		</table>
	</center>
</body>
</html>
