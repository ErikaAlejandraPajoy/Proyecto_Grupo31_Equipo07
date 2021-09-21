<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Iniciar Sesión</title>
<link href="css/estilos.css" rel="stylesheet" />
</head>
<body>
	<div class="contenedor-todo">
		<div class="ctn-form">
			<div class="ctn-LogoTexto">
				<img src="image/logomin.jfif" alt="" class="logo" />
				<h1 class="texto">Minuto 85' Venta y cambio</h1>
			</div>
			<h1 class="titulo">Iniciar Sesión</h1>
			<form action="Login" method="post">
				<label for="usuario">Usuario</label> <input type="text" id="usuario"
					name="usuario" required="true" /> <label for="password">Contraseña</label>
				<input type="password" id="pass" name="pass" required="true" /> <input
					type="submit" value="Iniciar" name="enviar" />
			</form>
		</div>
		<div class="ctn-texto">
			<div class="capa"></div>
			<h1 class="titulo-descripcion">Minuto 85 venta y cambio</h1>
			<p class="texto-descripcion">En minuto 85' encontraras articulos deportivos originales a unos excelentes precios, es un espacio para
				que los coleccionistas puedan adquirir sus camisas, chaquetas, gorras y un sin fin de productos los cuales tenemos listos para ustedes.
				
				<br><br>
				 Contamos tambien con sistema de compra de productos
				deportivos, donde un grupo de expertos evaluara el estado y el
				precio de compra</p>
		</div>
	</div>
</body>
</html>
