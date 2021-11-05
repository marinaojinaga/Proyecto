package logicaDeDatos;

/**Representa unos atributos generales que van a compartir las clases Tarea y Subtarea
 * @author Marina Ojinaga
 * @version 1.0
 * @since 1.0
 */

public abstract class TareaGeneral {
	/**Representa el nombre de la tarea
	 */
	private String nombre;
	
	/**Representa el si la tarea está hecha
	 */
	private boolean hecho;
	
	/**Representa la prioridad que tiene la tarea e irá desde 0 a 4
	 */
	private int prioridad;
	
	
	/**
	 * Crea parte de la tarea
	 * @param nombre String que representa el nombre de la tarea.
	 * @param hecho Booleano que representa si la tarea está hecha.
	 * @param prioridad Número entero que representa la prioridad de la tarea.
	 */
	public TareaGeneral(String nombre, boolean hecho, int prioridad) {
		this.nombre = nombre;
		this.hecho = hecho;
		
		this.prioridad = prioridad;
	}
	
	/**
	 * Devuelve el nombre de la tarea
	 * @return un String que representa el nombre de la tarea
	 */
	public String getNombre() {
		return nombre;
	}
	
	/**
	 * Establece el nombre de la tarea
	 * @param nombre Un String que representa el nombre de la tarea
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	/**
	 * Devuelve el valor booleano de la variable hecho.
	 * @return Un booleano que dirá el valor de la variable hecho
	 */
	public boolean isHecho() {
		return hecho;
	}
	
	/**
	 * Establece el valor booleano de la variable hecho
	 * @param hecho es un booleano que representa si la tarea está hecha
	 */
	public void setHecho(boolean hecho) {
		this.hecho = hecho;
	}
	
	/**
	 * Devuelve el valor de prioridad, siendo este valor un entero
	 * @return Un entero que representa la prioridad que tiene la tarea del 0 al 4
	 */
	public int getPrioridad() {
		return prioridad;
	}
	
	/**
	 * Establece el valor de la prioridad que tiene la tarea
	 * @param prioridad Entero de 0 a 4. Si se sale de estos parámetros devuelve error.
	 */
	public void setPrioridad(int prioridad) {
		if(prioridad>=0 && prioridad<=4) {
			this.prioridad = prioridad;
		}else {
			System.out.println("La prioridad solo puede ir de 0 a 4.");
		}
		
	}
	
}
