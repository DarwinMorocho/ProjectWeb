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
			<th>Numero</th>
			<th>Fecha</th>
			<th>Subtotal</th>
			<th>Iva</th>
			<th>Total</th>
			<th>Estado</th>
			<th>Tipo</th>
			<th>Ir detalles</th>
		</tr>
		<%
			List<Factura> facturas = (List<Factura>) request
					.getAttribute("FACTURAS");

			if (facturas != null) {
				for (Factura f : facturas) {
		%>
		<tr>
			<td><input type="text" name="numero_factura"
				value="<%=f.getFacNumero()%>" /></td>
			<td><input type="text" name="fecha_factura" value="<%=f.getFacFecha()%>" /></td>
			<td><input type="text" name="subtotal_factura"
				value="<%=f.getFacSubtotal()%>" /></td>
			<td><input type ="text" name="iva_factura" value="<%=f.getFacIva()%> " /></td>
			<td><input type="text" name="total_factura" value="<%=f.getFacTotal()%>" /></td>
			<td><input type="text" name="estado_factura"
				value="<%=f.getFacEstado()%>" /></td>
			<td><input type="text" name="tipo_factura" value="<%=f.getFacTipo()%>" /></td>
			<td><a href="BuscarDetalleFacturaCtrl?id=<%=f.getIdFactura()%>">Detalle</a></td>
		</tr>
		<%
			}
			}
		%>
	</table>
</body>
</html>