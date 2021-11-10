
package logicaDeDatos;

/**
 * La clase subtarea representas la subtareas contenidas dentre de una tarea. 
 * Hereda de la clase TareaGeneral
 * @author Marina Ojinaga
 * @version 2.0
 * @since 1.0
 */
public class Subtarea extends TareaGeneral {

	/**
	 * Crea una subtarea con los parámetros necesarios.
	 * @param nombre es el nombre de la subtarea
	 * @param hecho Es un valor booleano de si la subtarea se encuentra hecha
	 * @param prioridad Es un entero que va desde 0 hasta 4 mostrando la prioridad que tiene 
	 */
	public Subtarea(String nombre, boolean hecho, int prioridad) {
		super(nombre, hecho, prioridad);
	}

	
}
