package logicaDeDatos;

import java.util.ArrayList;

public class Usuario {
	private String usuario;
	private String contraseña;
	private String nombre;
	private String mail;
	private ArrayList<Proyecto> proyectos;
	
	public Usuario(String usuario, String contraseña, String nombre, String mail, ArrayList<Proyecto> proyectos) {
		super();
		this.usuario = usuario;
		this.contraseña = contraseña;
		this.nombre = nombre;
		this.mail = mail;
		this.proyectos = proyectos;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public ArrayList<Proyecto> getProyectos() {
		return proyectos;
	}

	public void setProyectos(ArrayList<Proyecto> proyectos) {
		this.proyectos = proyectos;
	}

	
}
