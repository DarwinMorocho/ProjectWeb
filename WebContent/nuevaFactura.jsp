<%@page import="java.util.List"%>
<%@page import="modelo.*"%>
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
		String tituloPagina = "Crear Factura";
	%>
	<%@include file="../commons/header.jsp"%>

	<center>

		<form method="post" action="NuevaFacturaCtrl">


			<table>
				<tr>
					<th colspan="2">Nueva Factura</th>
				</tr>
				<tr>
					<th>Cliente:</th>
					<th><input type="text" name="fac_cliente" /></th>

				</tr>

				<tr>
					<th>Numero de factura:</th>
					<th><input type="text" name="fac_numero" /></th>

				</tr>
				<tr>
					<th>Fecha:</th>
					<th><input type="date" name="fac_fecha" /></th>

				</tr>
				<tr>
					<th>Subtotal:</th>
					<th><input type="text" name="fac_subtotal" /></th>

				</tr>

				<tr>
					<th>Iva:</th>
					<th><input type="text" name="fac_iva" value="14.0"/></th>

				</tr>
				<tr>
					<th>Total:</th>
					<th><input type="text" name="fac_total" /></th>

				</tr>
				<tr>
					<th></th>
					<th><input type="submit" value="Guardar" class="boton" /> <a
						style="color: blue; float: right:;"
						href="http://localhost:8080/ProjectWeb/consultarFacturas.jsp">
							Regresar</a></th>

				</tr>


			</table>

		<table>

			<tr>
				<th>Produco</th>
				<th>Cantidad</th>
				<th>Desripcion</th>
				<th>Subtotal</th>
				<th>Total</th>
			</tr>

			<tr>
				<td><SELECT NAME="selCombo">
						<%List<Producto> productos= (List<Producto>) request.getAttribute("PRODUCTO");
					for(Producto p: productos){
			%>
						<OPTION name="producto_factura"><%=p.getProdNombre()%></OPTION>
						<%} %>
				</SELECT></td>
				<td><input type="text" name="cantidad_factura" /></td>
				<td><input type="text" name="descripcion_factura" /></td>
				<td><input type="text" name="subtotal_factura" disabled/></td>
				<td><input type="text" name="total_factura" disabled/></td>
				<td><input type="submit" value="agregar" /></td>

			</tr>
			<%
				List<DetalleFactura> detalles = (List<DetalleFactura>) request
						.getAttribute("DETALLES");

				if (detalles != null) {
					for (DetalleFactura df : detalles) {
			%>
			<tr>
				<td><p><%=df.getProducto().getProdNombre()%></p></td>
				<td><input type="text" name="cantidad_factura"
					value="<%=df.getDetCantidad()%>" /></td>
				<td><input type="text" name="descripcion_factura"
					value="<%=df.getDetDescripcion()%>" /></td>
				<td><input type="text" name="subtotal_factura"
					value="<%=df.getDetSubtotal()%>" /></td>
				<td><input type="text" name="total_factura"
					value="<%=df.getDetTotal()%>" /></td>
				<!-- <td><input type="submit" value="agregar" /></td> -->

			</tr>
			<%
				}

				}
			%>
		</table>

		<input type="submit" value="Guardar factura" class="button" />



		</form>
		</center>
</body>
</html>
