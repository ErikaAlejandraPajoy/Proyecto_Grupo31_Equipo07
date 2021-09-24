package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import modelo.ProveedoresDAO;
import modelo.ProveedoresDTO;
import modelo.UsuariosDAO;
import modelo.UsuariosDTO;

/**
 * Servlet implementation class ControlProveedores
 */
@WebServlet("/ControlProveedores")
public class ControlProveedores extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControlProveedores() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ProveedoresDAO proDAO = new ProveedoresDAO();
		
		if(request.getParameter("crear")!=null) {
			
			String nit, nombre, direccion, telefono, ciudad;
			
			nit = request.getParameter("nit");
			nombre = request.getParameter("nombre");
			direccion = request.getParameter("direccion");
			telefono = request.getParameter("telefono");
			ciudad = request.getParameter("ciudad");
			
			ProveedoresDTO proDTO = new ProveedoresDTO(nit, nombre, direccion, telefono, ciudad);
			
			if(proDAO.insertarProveedor(proDTO)) {
				JOptionPane.showMessageDialog(null, "Proveedor registrado");
				response.sendRedirect("proveedores.jsp");

			}else {
				JOptionPane.showMessageDialog(null, "Proveedor no registrado");
				response.sendRedirect("proveedores.jsp");
			}
			
		}
		
		if(request.getParameter("consulta")!=null) {
			
			String nit, nombre, direccion, telefono, ciudad;
			
			nit = request.getParameter("codigo");
			ProveedoresDTO pro = proDAO.consultarProveedores(nit);
			
			nit = pro.getNit();
			nombre = pro.getNombre();
			direccion = pro.getDireccion();
			telefono = pro.getTelefono();
			ciudad = pro.getCiudad();
			
			response.sendRedirect("proveedores.jsp?nit=" + nit + "&&nombre=" + nombre + "&&direccion=" + direccion + "&&telefono=" + telefono + "&&ciudad=" + ciudad);
			
		}

		if(request.getParameter("actualizar")!=null) {
			
			String nit, nombre, direccion, telefono, ciudad;
			
			nit = request.getParameter("nit");
			nombre = request.getParameter("nombre");
			direccion = request.getParameter("direccion");
			telefono = request.getParameter("telefono");
			ciudad = request.getParameter("ciudad");
			
			ProveedoresDTO proDTO = new ProveedoresDTO(nit, nombre, direccion, telefono, ciudad);
			
			if(proDAO.actualizarProveedores(proDTO)) {
				JOptionPane.showMessageDialog(null, "Proveedor actualizado");
				response.sendRedirect("proveedores.jsp");

			}else {
				JOptionPane.showMessageDialog(null, "Proveedor no actualizado");
				response.sendRedirect("proveedores.jsp");
			}
			
		}
		
		if(request.getParameter("borrar")!=null) {
			String nit;
			nit = request.getParameter("nit");
			if(proDAO.eliminarProveedor(nit)) {
				JOptionPane.showMessageDialog(null, "Proveedor eliminado");
				response.sendRedirect("proveedores.jsp");

			}else {
			 JOptionPane.showMessageDialog(null, "Proveedor no eliminado");
				response.sendRedirect("proveedores.jsp");

			}
	}
	}

}
