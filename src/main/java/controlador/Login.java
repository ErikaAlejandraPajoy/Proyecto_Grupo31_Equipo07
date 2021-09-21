package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import modelo.UsuariosDAO;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		UsuariosDAO usuDAO = new UsuariosDAO();

		String usuario, password;
		if (request.getParameter("enviar") != null) {
			usuario = request.getParameter("usuario");
			password = request.getParameter("pass");
			if (usuario.equals("admininicial") && password.equals("admin123456")) {
				// JOptionPane.showMessageDialog(null,"Bienvenido "+ usuario+ " Usuario
				// administrador");
				response.sendRedirect("Principal.jsp?usuario=" + usuario);
			} else {
				JOptionPane.showMessageDialog(null, "Error de usuario o contraseña");
				response.sendRedirect("Login.jsp");
			}
		}

	}

}
