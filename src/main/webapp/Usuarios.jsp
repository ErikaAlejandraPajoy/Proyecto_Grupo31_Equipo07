<%@ page import = "controlador.Conexion"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Interfaz usuarios</title>
</head>
<body>
<%
String nombre, cedula, correo, usuario, clave;
nombre = request.getParameter("nombre");
cedula = request.getParameter("cedula");
correo = request.getParameter("correo");
usuario = request.getParameter("usuario");
clave = request.getParameter("clave");

%>
	<h1>USUARIOS</h1>
	<form action="ControlUsuario" method="post">
	<label for="">Cedula: </label><input type="number" name="cedula" id="cedula" value="<%=cedula%>"><br><br>
    <label for="">Nombre Completo: </label><input type="text" name="nombre" id="nombre" value="<%=nombre%>"><br><br>
    <label for="">Correo Electronico: </label><input type="text" name="correo" id="correo" value="<%=correo%>" ><br><br>
	<label for="">Usuario: </label><input type="text" name="usuario" id="usuario" value="<%=usuario%>"><br><br>
   	<label for="">Contraseña: </label><input type="text" name="clave" id="clave" value="<%=clave%>"><br><br>
	<input type="submit" name="consulta" value="Consultar">    
    <input type="submit" name="crear" value="Crear">        
    <input type="submit" name="actualizar" value="Actualizar">    
    <input type="submit" name="borrar" value="Borrar">   

</form> 

</body>
</html>