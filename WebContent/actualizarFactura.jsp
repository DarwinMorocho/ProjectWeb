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
<title>Insert title here</title>
</head>
<body>
	<%
		String tituloPagina = "Crear Local";
	%>
	<%@include file="../commons/header.jsp"%>


	<center>
		<form method="post" action="ActualizarFacturaCtrl">
			<%
			Factura factura = (Factura)request.getAttribute("FACTURA");
			%>

			<table>
			<tr>
					<th colspan="2">Actualizar Factura</th>
					
				</tr>
				<tr>
					<th style='display: none;'></th>
					<th style='display: none;'><input type="text" name="id" value="<%=factura.getIdFactura()%>" /></th>

				</tr>
				<tr>
					<th>Cliente:</th>
					<th><input type="text" name="fac_cliente" value="<%=factura.getCliente().getIdCliente()%>"/></th>

				</tr>

				<tr>
					<th>Numero de factura:</th>
					<th><input type="text" name="fac_numero" value="<%=factura.getFacNumero()%>"/></th>

				</tr>
				<tr>
					<th>Fecha:</th>
					<th><input type="date" name="fac_fecha" value="<%=factura.getFacFecha()%>"/></th>

				</tr>
				<tr>
					<th>Subtotal:</th>
					<th><input type="text" name="fac_subtotal" value="<%=factura.getFacSubtotal()%>"/></th>

				</tr>

				<tr>
					<th>Iva:</th>
					<th><input type="text" name="fac_iva" value="<%=factura.getFacIva()%>"/></th>

				</tr>
				<tr>
					<th>Total:</th>
					<th><input type="text" name="fac_total" value="<%=factura.getFacTotal()%>"/></th>

				</tr>
				<tr>
					<th></th>
					<th><input type="submit" value="Guardar" class="boton" /> <a
						style="color: blue; float: right:;"
						href="http://localhost:8080/ProjectWeb/consultarFacturas.jsp">
							Regresar</a></th>

				</tr>


			</table>






		</form>
	</center>

</body>
</html>
