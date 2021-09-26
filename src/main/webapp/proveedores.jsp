<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,
user-scalable=no, 
initial-scale=1.0, maximum-scale=1.0, minimum-sclae=1.0">
<link rel="stylesheet" href="css/prueba.css" />
<title>Interfaz proveedores</title>
</head>

<body>
<%
String nit, nombre, direccion, telefono, ciudad;
nit = request.getParameter("nit");
nombre = request.getParameter("nombre");
direccion = request.getParameter("direccion");
telefono = request.getParameter("telefono");
ciudad = request.getParameter("ciudad");

%>
	<h1 class="titulo">Proveedores Minuto 85</h1>
	<form action="ControlProveedores" method="post">
		<div class="contenedor-todo">
		<label for="">NIT </label><input type="number" name="nit" id="nit" value="<%=nit%>"><br><br>
    	<label for="">Ciudad </label><input type="text" name="ciudad" id="ciudad" value="<%=ciudad%>"><br><br>
    	<label for="">Direccion </label><input type="text" name="direccion" id="direccion" value="<%=direccion%>" ><br><br>
    	<label for="">Nombre Completo </label><input type="text" name="nombre" id="nombre" value="<%=nombre%>"><br><br>
		<label for="">Telefono </label><input type="text" name="telefono" id="telefono" value="<%=telefono%>"><br><br>
	
	
		    
    	<input type="submit" name="crear" value="Crear">        
    	<input type="submit" name="actualizar" value="Actualizar">    
    	<input type="submit" name="borrar" value="Borrar">
    	
    	
    	<hr>
   			<div>
   				<label>NIT del proveedor: </label><input type="text" name="codigo">
   				<input type="submit" name="consulta" value="Consultar">
			</div>   
		</div>

</form> 

</body>
</html>