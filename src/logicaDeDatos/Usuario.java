package logicaDeDatos;

import java.util.ArrayList;

public class Usuario {
	private String nickUsuario;
	private String contrasena;
	private String nombre;
	private String mail;
	private int id_usuario;
	
	public Usuario(String nickUsuario, String contrasena, String nombre, String mail,int id_usuario) {
		super();
		this.nickUsuario = nickUsuario;
		this.contrasena = contrasena;
		this.nombre = nombre;
		this.mail = mail;
		this.id_usuario =id_usuario;
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

	public void setContrasenya(String contrasenya) {
		this.contrasena = contrasenya;
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

	public int getId_usuario(){
		return id_usuario;
	}

	public void setId_usuario(int id_usuario){
		this.id_usuario = id_usuario;
	}


	
}
