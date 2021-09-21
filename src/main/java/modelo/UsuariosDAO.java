package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import controlador.Conexion;


public class UsuariosDAO {
	
	Conexion cnn= new Conexion();
	Connection con = cnn.Conectar();
	
	PreparedStatement ps=null;
	ResultSet res = null;

	
	
	public boolean insertarUsuario(UsuariosDTO user){
		boolean resul = false;
		try {
			String sql = "insert into usuarios values(?,?,?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, user.getCedula());
			ps.setString(2, user.getNombre());
			ps.setString(3, user.getCorreo());
			ps.setString(4, user.getUsuario());
			ps.setString(5, user.getClave());
			
			resul = ps.executeUpdate()>0;
			
		}
		
		catch(SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error al insertar" + ex);
		}
		return resul;
	}
	
	public UsuariosDTO consultarUsuario(String cedula) {
		
		UsuariosDTO user = null;
		
		try {
			String sql = "select * from usuarios where cedula = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, cedula);
			res = ps.executeQuery();
			while(res.next()) {
				user = new UsuariosDTO(res.getString(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5));
			}
		}catch(SQLException e) {
			JOptionPane.showMessageDialog(null, "Error al consultar");
		}
		return user;
	}
	
	public boolean actualizarUsuario(UsuariosDTO user){
		boolean resul = false;
		try {
			String sql = "update usuarios set nombre = ?, correo = ?, usuario = ?, clave = ? where cedula = ?";
			ps = con.prepareStatement(sql);
			
			ps.setString(1, user.getNombre());
			ps.setString(2, user.getCorreo());
			ps.setString(3, user.getUsuario());
			ps.setString(4, user.getClave());
			ps.setString(5, user.getCedula());
			
			resul = ps.executeUpdate()>0;
			
		}
		
		catch(SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error al actualizar" + ex);
		}
		return resul;
	}
	
	public boolean eliminarUsuario(String cedula) {
		boolean resul = false;
		try {
		String sql = "delete from usuarios where cedula = ?";
		ps = con.prepareStatement(sql);
		ps.setString(1, cedula);
		
		resul = ps.executeUpdate()>0;
		
	}catch(SQLException ex) {
		JOptionPane.showMessageDialog(null, "El usuario no se elimino");
	}
	return resul;
}
}
