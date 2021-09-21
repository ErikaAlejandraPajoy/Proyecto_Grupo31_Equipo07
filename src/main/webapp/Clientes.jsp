<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Interfaz clientes</title>
</head>
<body>
<%
String nombre, cedula, correo, direccion, telefono;
nombre = request.getParameter("nombre");
cedula = request.getParameter("cedula");
direccion = request.getParameter("direccion");
telefono = request.getParameter("telefono");
correo = request.getParameter("correo");

%>
	<h1>CLIENTES</h1>
	<form action="ControlCliente" method="post">
	<label for="">Cedula: </label><input type="number" name="cedula" id="cedula" value="<%=cedula%>"><br><br>
    <label for="">Nombre Completo: </label><input type="text" name="nombre" id="nombre" value="<%=nombre%>"><br><br>
	<label for="">Direccion: </label><input type="text" name="direccion" id="direccion" value="<%=direccion%>"><br><br>
   	<label for="">Telefono: </label><input type="text" name="telefono" id="telefono" value="<%=telefono%>"><br><br>
    <label for="">Correo Electronico: </label><input type="text" name="correo" id="correo" value="<%=correo%>" ><br><br>
	<input type="submit" name="consulta" value="Consultar">    
    <input type="submit" name="crear" value="Crear">        
    <input type="submit" name="actualizar" value="Actualizar">    
    <input type="submit" name="borrar" value="Borrar">   

</form> 

</body>
</html>