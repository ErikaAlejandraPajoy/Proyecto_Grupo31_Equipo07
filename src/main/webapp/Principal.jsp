<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>Principal | Minuto 85' Venta y cambios</title>

<link rel="stylesheet" href="css/principalEstilos.css">

</head>

<body>

	<header class="header">

		<div class="header-contenedor">


			<h1>
				<a href="#">Minuto 85'<span> Venta y cambios</span></a>
			</h1>

			<nav>
				<a href="http://localhost:8080/ProyectoMinuto85/Usuarios.jsp" >Usuarios</a> <a href="http://localhost:8080/ProyectoMinuto85/Clientes.jsp">Clientes</a> <a
					href="http://localhost:8080/ProyectoMinuto85/proveedores.jsp">Proveedores</a> <a href="#">Productos</a> <a href="#">Ventas</a>
				<a href="#">Reportes</a>
			</nav>

			<a href="index.jsp" class="logout-button"> <%
 String nombre = request.getParameter("usuario");
 %> <%=nombre%> | Cerrar Sesión
			</a>
		</div>

	</header>
<!--  
	<div>
		<iframe src="Usuarios.jsp" width="1300" height="700" > </iframe>
	</div>
-->
</body>

</html>
