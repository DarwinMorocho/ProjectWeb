<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@page import="java.util.List, modelo.Categoria"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<center>
	<a href="http://localhost:8080/ProjectWeb/nuevaCategoria.jsp">Nueva categor�a</a>
	<a href="http://localhost:8080/ProjectWeb/consultarproductos.jsp">Menu</a>
	</center>
		<table>
			<tr>
				<th>Categoria</th>
				<th>Actualizar</th>
			</tr>

			<%
				List<Categoria> categorias = (List<Categoria>) request
						.getAttribute("CATEGORIAS");
				if (categorias != null) {
					for (Categoria cat : categorias) {
			%>
			<tr>

				<td><%=cat.getCatNombre()%></td>
				<td>Actualizar</td>
			</tr>
			<%
				}
				}
			%>

		</table>
	
</body>
</html>