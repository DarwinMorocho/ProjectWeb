<%@page import="modelo.Categoria"%>
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

	<center>

		<form method="post" action="NuevoProductoCtrl">


			<table>
				<tr>
					<th colspan="2">Nuevo Producto</th>
				</tr>
				<tr>
					<th>Codigo:</th>
					<th><input type="text" name="cod" /></th>

				</tr>

				<tr>
					<th>Nombre:</th>
					<th><input type="text" name="name" /></th>

				</tr>
				<tr>
					<th>Costo:</th>
					<th><input type="text" name="cost" /></th>

				</tr>
				<tr>
					<th>Categor�a:</th>
					<th><select name="opcionSeleccionada">
				<%List<Categoria> categorias  = (List<Categoria>) request.getAttribute("CATEGORIAS"); 
					if(categorias!=null){
					for(Categoria cat: categorias){
					%>
							<option name="categoria" value="<%=cat.getIdCategoria()%>"><%= cat.getCatNombre()%></option>

							<%} 
					}%>
					</select></th>

				</tr>
				<tr>
					<th></th>
					<th><input type="submit" value="Guardar" class="boton" /> <a
						style="color: blue; float: right:;"
						href="http://localhost:8080/ProjectWeb/consultarproductos.jsp">
							Regresar</a></th>

				</tr>


			</table>





		</form>
	</center>
</body>
</html>
