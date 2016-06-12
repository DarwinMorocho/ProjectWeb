<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@page import="java.util.List, modelo.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/style.css" type="text/css" media="all" />
<script src="js/jquery-1.4.1.min.js" type="text/javascript"></script>
<script src="js/jquery.jcarousel.pack.js" type="text/javascript"></script>
<script src="js/jquery-func.js" type="text/javascript"></script>
<script src="js/insertaFila.js"></script>
<title>Factura</title>
</head>
<body>

	<%
		String tituloPagina = "Crear Local";
	%>
	<%@include file="../commons/header.jsp"%>
	<section> 

	<% %>
	<form action="AgregarDetalleTablaCtrl" method="post">
	
		<div>
	<label>Número: </label>
	<input type="text" name="numero_factura"/>
	<label>Fecha: </label>
	<input type="text" name="fecha_factura"/>
	<label>Subtotal: </label>
	<input type="text" name="subtotal_factura"/>
	<label>IVA: </label>
	<input type="text" name="iva_factura"/>
	<label>Total: </label>
	<input type="text" name="total_factura"/>
	<label>Estado: </label>
	<input type="text" name="estado_factura"/>
	<label>tipo: </label>
	<input type="text" name="tipo_factura"/>	
	
	</div>
		<table id="dataTable">
			<tr>
				<th>Produco</th>
				<th>Cantidad</th>
				<th>Desripcion</th>
				<th>Subtotal</th>
				<th>Total</th>
			</tr>
			<tr>
				<td><input id="1" type="text" name="producto_factura" /></td>
				<td><input id="2" type="text" name="cantidad_factura" /></td>
				<td><input id="3" type="text" name="descripcion_factura" /></td>
				<td><input id="4" type="text" name="subtotal_factura" /></td>
				<td><input id="5" type="text" name="total_factura" /></td>
				<!-- <td><input type="submit" value="agregar" /></td>  -->
				<td><INPUT type="button" value="Ingresar" onclick="addRow('dataTable')" /></td>
			</tr>

		</table>
			<%-- <table>
			<%List<DetalleFactura> detalles = (List<DetalleFactura>) request.getAttribute("DETALLES");
			
		if(detalles != null){
			for(DetalleFactura df: detalles ){
		%>
			<tr>
				<td><input type="text" name="producto_factura" value="sd" /></td>
				<td><input type="text" name="cantidad_factura" value="<%=df.getDetCantidad()%>"/></td>
				<td><input type="text" name="descripcion_factura" value="<%=df.getDetDescripcion()%>"/></td>
				<td><input type="text" name="subtotal_factura" value="<%=df.getDetSubtotal()%>"/></td>
				<td><input type="text" name="total_factura" value="<%=df.getDetTotal()%>"/></td>
				<!-- <td><input type="submit" value="agregar" /></td> -->

			</tr>
			<% }
			
			request.setAttribute("DETALLES1", detalles);
		}
		
		
		%>
		</table>  --%>



	</form>


	</section>
</body>
</html>