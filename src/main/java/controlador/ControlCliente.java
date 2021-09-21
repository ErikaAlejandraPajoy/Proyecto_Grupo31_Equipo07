package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import modelo.ClientesDAO;
import modelo.ClientesDTO;
import modelo.UsuariosDAO;
import modelo.UsuariosDTO;

/**
 * Servlet implementation class ControlCliente
 */
@WebServlet("/ControlCliente")
public class ControlCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControlCliente() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ClientesDAO clienteDAO = new ClientesDAO();
		
		if(request.getParameter("crear")!=null) {
			
			String cedula, nombre, direccion, telefono, correo;
			
			cedula = request.getParameter("cedula");
			nombre = request.getParameter("nombre");
			direccion = request.getParameter("direccion");
			telefono = request.getParameter("telefono");
			correo = request.getParameter("correo");
			
			ClientesDTO clienteDTO = new ClientesDTO(cedula, nombre, direccion, telefono, correo);
			
			if(clienteDAO.insertarCliente(clienteDTO)) {
				JOptionPane.showMessageDialog(null, "cliente registrado");
				response.sendRedirect("Clientes.jsp");

			}else {
				JOptionPane.showMessageDialog(null, "cliente no registrado");
				response.sendRedirect("Clientes.jsp");
			}
			
		}
		
		if(request.getParameter("consulta")!=null) {
			
			String cedula, nombre, direccion, telefono, correo;
			
			cedula = request.getParameter("cedula");
			ClientesDTO cliente = clienteDAO.consultarCliente(cedula);
			
			cedula = cliente.getCedula();
			nombre = cliente.getNombre();
			direccion = cliente.getDireccion();
			telefono = cliente.getTelefono();
			correo = cliente.getCorreo();

			
			response.sendRedirect("Clientes.jsp?cedula=" + cedula + "&&nombre=" + nombre + "&&direccion=" + direccion + "&&telefono=" + telefono + "&&correo=" + correo);
			
		}

		if(request.getParameter("actualizar")!=null) {
			
			String cedula, nombre, direccion, telefono, correo;
			
			cedula = request.getParameter("cedula");
			nombre = request.getParameter("nombre");
			direccion = request.getParameter("direccion");
			telefono = request.getParameter("telefono");
			correo = request.getParameter("correo");
			
			ClientesDTO clienteDTO = new ClientesDTO(cedula, nombre, direccion, telefono, correo);
			
			if(clienteDAO.actualizarCliente(clienteDTO)) {
				JOptionPane.showMessageDialog(null, "cliente actualizado");
				response.sendRedirect("Clientes.jsp");

			}else {
				JOptionPane.showMessageDialog(null, "cliente no actualizado");
				response.sendRedirect("Clientes.jsp");
			}
			
		}
		
		if(request.getParameter("borrar")!=null) {
			String cedula;
			cedula = request.getParameter("cedula");
			if(clienteDAO.eliminarCliente(cedula)) {
				JOptionPane.showMessageDialog(null, "cliente eliminado");
				response.sendRedirect("Clientes.jsp");

			}else {
			 JOptionPane.showMessageDialog(null, "cliente no eliminado");
				response.sendRedirect("Clientes.jsp");

			}
	}
	}

}
