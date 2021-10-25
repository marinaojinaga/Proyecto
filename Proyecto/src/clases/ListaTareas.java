package clases;

import java.util.ArrayList;

/**
 * Una lista que tendrá dentro tareas
 * @author Marina Ojinaga
 * @version 1.0
 * @since 1.0
 */

public class ListaTareas {
	private String nombre;
	private ArrayList<Tarea> lista = new ArrayList<Tarea>();
	private String comentarios;
	
	
	public ListaTareas(String nombre, ArrayList<Tarea> lista, String comentarios) {
		super();
		this.nombre = nombre;
		this.lista = lista;
		this.comentarios = comentarios;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public ArrayList<Tarea> getLista() {
		return lista;
	}
	public void setLista(ArrayList<Tarea> lista) {
		this.lista = lista;
	}
	public String getComentarios() {
		return comentarios;
	}
	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}
	
	
}
