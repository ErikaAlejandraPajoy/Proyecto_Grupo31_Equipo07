package controlador;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;

public class Conexion {
	
	private Connection connection = null;


	private String bd = "minuto_85";
	private String url = "jdbc:mysql://localhost:3306/" + bd;
	private String user = "root";
	private String pass = "1234";
	
	
	public Connection Conectar() {
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(url,user,pass);
		//	JOptionPane.showMessageDialog(null, "** CONEXION OK **");
			
			
		} catch (Exception e) {
		//	JOptionPane.showMessageDialog(null, "** ERROR DE CONEXION **" +e);
		}
		
		return connection;
		
	}
	
}
	