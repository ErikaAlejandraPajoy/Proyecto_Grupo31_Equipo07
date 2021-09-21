package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import modelo.UsuariosDAO;
import modelo.UsuariosDTO;

/**
 * Servlet implementation class ControlUsuario
 */
@WebServlet("/ControlUsuario")
public class ControlUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ControlUsuario() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UsuariosDAO userDAO = new UsuariosDAO();
		if(request.getParameter("crear")!=null) {
			
			String cedula, nombre, correo, usuario, clave;
			
			cedula = request.getParameter("cedula");
			nombre = request.getParameter("nombre");
			correo = request.getParameter("correo");
			usuario = request.getParameter("usuario");
			clave = request.getParameter("clave");
			
			UsuariosDTO userDTO = new UsuariosDTO(cedula, nombre, correo, usuario, clave);
			
			if(userDAO.insertarUsuario(userDTO)) {
				JOptionPane.showMessageDialog(null, "usuario registrado");
				response.sendRedirect("Usuarios.jsp");

			}else {
				JOptionPane.showMessageDialog(null, "usuario no registrado");
				response.sendRedirect("Usuarios.jsp");
			}
			
		}
		
		if(request.getParameter("consulta")!=null) {
			
			String cedula, nombre, correo, usuario, clave;
			
			cedula = request.getParameter("cedula");
			UsuariosDTO user = userDAO.consultarUsuario(cedula);
			
			cedula = user.getCedula();
			nombre = user.getNombre();
			correo = user.getCorreo();
			usuario = user.getUsuario();
			clave = user.getClave();
			
			response.sendRedirect("Usuarios.jsp?cedula=" + cedula + "&&nombre=" + nombre + "&&correo=" + correo + "&&usuario=" + usuario + "&&clave=" + clave);
			
		}

		if(request.getParameter("actualizar")!=null) {
			
			String cedula, nombre, correo, usuario, clave;
			
			cedula = request.getParameter("cedula");
			nombre = request.getParameter("nombre");
			correo = request.getParameter("correo");
			usuario = request.getParameter("usuario");
			clave = request.getParameter("clave");
			
			UsuariosDTO userDTO = new UsuariosDTO(cedula, nombre, correo, usuario, clave);
			
			if(userDAO.actualizarUsuario(userDTO)) {
				JOptionPane.showMessageDialog(null, "usuario actualizado");
				response.sendRedirect("Usuarios.jsp");

			}else {
				JOptionPane.showMessageDialog(null, "usuario no actualizado");
				response.sendRedirect("Usuarios.jsp");
			}
			
		}
		
		if(request.getParameter("borrar")!=null) {
			String cedula;
			cedula = request.getParameter("cedula");
			if(userDAO.eliminarUsuario(cedula)) {
				JOptionPane.showMessageDialog(null, "Usuario eliminado");
				response.sendRedirect("Usuarios.jsp");

			}else {
			 JOptionPane.showMessageDialog(null, "Usuario no eliminado");
				response.sendRedirect("Usuarios.jsp");

			}
	}
	}

}
