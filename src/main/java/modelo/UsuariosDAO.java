package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import controlador.Conexion;


public class UsuariosDAO {
	
	Conexion cnn= new Conexion();
	Connection con = cnn.Conectar();
	
	PreparedStatement ps=null;
	ResultSet res = null;

}
