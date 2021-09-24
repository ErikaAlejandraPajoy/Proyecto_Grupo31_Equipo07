package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import controlador.Conexion;

public class ProveedoresDAO {

	Conexion cnn= new Conexion();
	Connection con = cnn.Conectar();
	
	PreparedStatement ps=null;
	ResultSet res = null;

	
	
	public boolean insertarProveedor(ProveedoresDTO pro){
		
		boolean resul = false;
		try {
			String sql = "insert into proveedores values(?,?,?,?,?)";
			
			ps = con.prepareStatement(sql);
			ps.setString(1, pro.getNit());
			ps.setString(2, pro.getCiudad());
			ps.setString(3, pro.getDireccion());
			ps.setString(4, pro.getNombre());
			ps.setString(5, pro.getTelefono());
			
			
			resul = ps.executeUpdate()>0;
			
		}
		
		catch(SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error al insertar proveedor" + ex);
		}
		return resul;
	}
	
	public ProveedoresDTO consultarProveedores(String nit) {
		
		ProveedoresDTO pro=null;
		
		try {
			String sql = "select * from proveedores where nit_proveedor=?";
			
			ps = con.prepareStatement(sql);
			ps.setString(1, nit);
			res = ps.executeQuery();
			while(res.next()) {
				pro = new ProveedoresDTO(res.getString(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5));
				JOptionPane.showMessageDialog(null, "Consulta realizada");
		}
		}catch(SQLException e) {
			JOptionPane.showMessageDialog(null, "Error al consultar proveedor.");
		}
		return pro;
	}
	
	public boolean actualizarProveedores(ProveedoresDTO pro){
		boolean resul = false;
		try {
			String sql = "update proveedores set nombre_proveedor=?, direccion_proveedor=?, telefono_proveedor=?, ciudad_proveedor=? where nit_proveedor=?";
			ps = con.prepareStatement(sql);
			
			ps = con.prepareStatement(sql);
			
			ps.setString(1, pro.getNombre());
			ps.setString(2, pro.getDireccion());
			ps.setString(3, pro.getTelefono());
			ps.setString(4, pro.getCiudad());
			ps.setString(5, pro.getNit());

			
			resul = ps.executeUpdate()>0;
			JOptionPane.showMessageDialog(null, "Actualizacion realizada");
			
		}
		
		catch(SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error al actualizar proveedor" + ex);
		}
		return resul;
	}
	
	public boolean eliminarProveedor(String nit) {
		boolean resul = false;
		try {
		String sql = "delete from proveedores where nit_proveedor = ?";
		ps = con.prepareStatement(sql);
		ps.setString(1, nit);
		
		resul = ps.executeUpdate()>0;
		
	}catch(SQLException ex) {
		JOptionPane.showMessageDialog(null, "El proveedor no se elimino");
	}
	return resul;
}
}
