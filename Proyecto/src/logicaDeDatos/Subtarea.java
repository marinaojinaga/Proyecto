
package logicaDeDatos;

/**
 * La clase subtarea representas la subtareas contenidas dentre de una tarea. 
 * Hereda de la clase TareaGeneral
 * @author Marina Ojinaga
 * @version 1.0
 * @since 1.0
 */
public class Subtarea extends TareaGeneral {
	/**
	 * Representa la tarea a la que pertenece la subtarea
	 */
	private Tarea tareaMadre;

	/**
	 * Crea una subtarea con los parámetros necesarios.
	 * @param nombre es el nombre de la subtarea
	 * @param hecho Es un valor booleano de si la subtarea se encuentra hecha
	 * @param prioridad Es un entero que va desde 0 hasta 4 mostrando la prioridad que tiene 
	 * @param tareaMadre Es la tarea de la que depende esta subtarea
	 */
	public Subtarea(String nombre, boolean hecho, int prioridad, Tarea tareaMadre) {
		super(nombre, hecho, prioridad);
		this.tareaMadre = tareaMadre;
	}

	/**
	 * Devuelve la Tarea de la que depende esta subtarea
	 * @return Un valor Tarea
	 */
	public Tarea getTareaMadre() {
		return tareaMadre;
	}

	/**
	 * Establece a que tarea pertenece esta subtarea en concreto
	 * @param tareaMadre Es un parámetro de la clase Tarea
	 */
	public void setTareaMadre(Tarea tareaMadre) {
		this.tareaMadre = tareaMadre;
	}
	
}
