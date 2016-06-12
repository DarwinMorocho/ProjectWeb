<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
	<%@page import="java.util.List, modelo.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


	<table>
	
			<tr>
				<th>Produco</th>
				<th>Cantidad</th>
				<th>Desripcion</th>
				<th>Subtotal</th>
				<th>Total</th>
			</tr>
		<%
			List<DetalleFactura> detalles = (List<DetalleFactura>) request
					.getAttribute("DETALLES");

			if (detalles != null) {
				for (DetalleFactura df : detalles) {
		%>
		<tr>
			<td><input type="text" name="producto_factura" value="sd" /></td>
			<td><input type="text" name="cantidad_factura" value="<%=df.getDetCantidad()%>" /></td>
			<td><input type="text" name="descripcion_factura" value="<%=df.getDetDescripcion()%>" /></td>
			<td><input type="text" name="subtotal_factura" 	value="<%=df.getDetSubtotal()%>" /></td>
			<td><input type="text" name="total_factura"	value="<%=df.getDetTotal()%>" /></td>
			<!-- <td><input type="submit" value="agregar" /></td> -->

		</tr>
		<%
			}

			}
		%>
	</table>
</body>
</html>