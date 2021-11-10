package logicaDeDatos;


import java.util.ArrayList;

public class Proyecto {
	private String nombre;
	private boolean favorito;
	private ArrayList<Usuario> usuarios;
	private ArrayList<Tarea> tareas;
	
	public Proyecto(String nombre, boolean favorito, ArrayList<Usuario> usuarios, ArrayList<Tarea> tareas) {
		super();
		this.nombre = nombre;
		this.favorito = favorito;
		this.usuarios = usuarios;
		this.tareas = tareas;
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

	public ArrayList<Tarea> getTareas() {
		return tareas;
	}

	public void setTareas(ArrayList<Tarea> tareas) {
		this.tareas = tareas;
	}
	
}
