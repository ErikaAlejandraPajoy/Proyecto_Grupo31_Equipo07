package modelo;

public class UsuariosDTO {
	
	private String cedula;
	private String nombre;
	private String correo;
	private String usuario;
	private String clave;
	
	public UsuariosDTO(String cedula, String nombre, String correo, String usuario, String clave) {
		super();
		this.cedula = cedula;
		this.nombre = nombre;
		this.correo = correo;
		this.usuario = usuario;
		this.clave = clave;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}
	
	

}
