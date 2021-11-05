package logicaDeDatos;

import java.awt.Color;
import java.util.ArrayList;

public class Proyecto {
	private String nombre;
	private boolean favorito;
	private ArrayList<Usuario> usuarios;
	private Color color;
	
	public Proyecto(String nombre, boolean favorito, ArrayList<Usuario> usuarios) {
		super();
		this.nombre = nombre;
		this.favorito = favorito;
		this.usuarios = usuarios;
		this.color = color.white;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public boolean isFavorito() {
		return favorito;
	}

	public void setFavorito(boolean favorito) {
		this.favorito = favorito;
	}

	public ArrayList<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(ArrayList<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
	

}
