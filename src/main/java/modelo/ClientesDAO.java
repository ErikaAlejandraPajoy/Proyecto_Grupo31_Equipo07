package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import controlador.Conexion;

public class ClientesDAO {

	Conexion cnn= new Conexion();
	Connection con = cnn.Conectar();
	
	PreparedStatement ps=null;
	ResultSet res = null;

	
	
	public boolean insertarCliente(ClientesDTO cliente){
		boolean resul = false;
		try {
			String sql = "insert into clientes values(?,?,?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, cliente.getCedula());
			ps.setString(2, cliente.getNombre());
			ps.setString(3, cliente.getDireccion());
			ps.setString(4, cliente.getTelefono());
			ps.setString(5, cliente.getCorreo());

			resul = ps.executeUpdate()>0;
			
		}
		
		catch(SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error al insertar el cliente" + ex);
		}
		return resul;
	}
	
	public ClientesDTO consultarCliente(String cedula) {
		
		ClientesDTO cliente = null;
		
		try {
			String sql = "select * from clientes where cedula = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, cedula);
			res = ps.executeQuery();
			while(res.next()) {
				cliente = new ClientesDTO(res.getString(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5));
			}
		}catch(SQLException e) {
			JOptionPane.showMessageDialog(null, "Error al consultar");
		}
		return cliente;
	}
	
	public boolean actualizarCliente(ClientesDTO cliente){
		boolean resul = false;
		try {
			String sql = "update clientes set nombre = ?, direccion = ?, telefono = ?, correo = ? where cedula = ?";
			ps = con.prepareStatement(sql);
			
			ps.setString(1, cliente.getNombre());
			ps.setString(3, cliente.getDireccion());
			ps.setString(4, cliente.getTelefono());
			ps.setString(2, cliente.getCorreo());
			ps.setString(5, cliente.getCedula());
			
			resul = ps.executeUpdate()>0;
			
		}
		
		catch(SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error al actualizar cliente" + ex);
		}
		return resul;
	}
	
	public boolean eliminarCliente(String cedula) {
		boolean resul = false;
		try {
		String sql = "delete from clientes where cedula = ?";
		ps = con.prepareStatement(sql);
		ps.setString(1, cedula);
		
		resul = ps.executeUpdate()>0;
		
	}catch(SQLException ex) {
		JOptionPane.showMessageDialog(null, "El cliente no se elimino");
	}
	return resul;
}
}
