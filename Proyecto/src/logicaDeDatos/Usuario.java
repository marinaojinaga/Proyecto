package logicaDeDatos;

import java.util.ArrayList;

public class Usuario {
	private String usuario;
	private String contrase�a;
	private String nombre;
	private String mail;
	private ArrayList<Proyecto> proyectos;
	
	public Usuario(String usuario, String contrase�a, String nombre, String mail, ArrayList<Proyecto> proyectos) {
		super();
		this.usuario = usuario;
		this.contrase�a = contrase�a;
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

	public String getContrase�a() {
		return contrase�a;
	}

	public void setContrase�a(String contrase�a) {
		this.contrase�a = contrase�a;
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
