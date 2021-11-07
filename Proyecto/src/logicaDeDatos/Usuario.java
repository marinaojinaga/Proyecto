package logicaDeDatos;

import java.util.ArrayList;

public class Usuario {
	private String nickUsuario;
	private String contrasena;
	private String nombre;
	private String mail;
	
	public Usuario(String nickUsuario, String contrasena, String nombre, String mail, ArrayList<Proyecto> proyectos) {
		super();
		this.nickUsuario = nickUsuario;
		this.contrasena = contrasena;
		this.nombre = nombre;
		this.mail = mail;
	}

	public String getnickUsuario() {
		return nickUsuario;
	}

	public void setnickUsuario(String nickUsuario) {
		this.nickUsuario = nickUsuario;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContraseña(String contraseña) {
		this.contrasena = contraseña;
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


	
}
