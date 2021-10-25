package clases;

import java.util.ArrayList;

/**
 * La clase proyecto que representa que será una clase que aunará todas las listas de tareas
 * @author Marina Ojinaga
 * @version 1.0
 * @since 1.0
 */
public class Proyecto {
	private String nombre;
	private ArrayList<ListaTareas> listaDeListas = new ArrayList<ListaTareas>();
	
	public Proyecto(String nombre, ArrayList<ListaTareas> listaDeListas) {
		super();
		this.nombre = nombre;
		this.listaDeListas = listaDeListas;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<ListaTareas> getListaDeListas() {
		return listaDeListas;
	}

	public void setListaDeListas(ArrayList<ListaTareas> listaDeListas) {
		this.listaDeListas = listaDeListas;
	}
	
}
