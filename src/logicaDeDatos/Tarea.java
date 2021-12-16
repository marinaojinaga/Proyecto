package logicaDeDatos;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * Representa una tarea. La clase extiende de la clase TareaGeneral.
 * @author Marina Ojinaga
 * @version 1.0
 * @since 1.0
 */
public class Tarea extends TareaGeneral implements iEnumAString{
	
	/**Descripcion de la tarea 0
	 */
	private String descripcion;

	private int id_tarea;

	/** Lista de subtareas incluidas dentro de una tarea
	 */
	private int id_proyecto;

	
	/**
	 * Crea una tarea con los parámetros siguientes
	 * @param nombre String con el nombre que tendra la tarea. Parametro heradado de TareaGeneral.
	 * @param hecho Booleano que representa si se ha hecho la tarea. Parametro hereado de TareaGeneral.
	 * @param prioridad Enumerado que tiene tres posibles valores que son Alta, Media y Baja. Parametro herado de TareaGeneral.
	 * @param descripcion String con una breve descripcion de la tarea.
	 * @param id_tarea Entero de la tarea.
	 * @param id_proyecto Entero que se refiere a la clase
	 */
	public Tarea(String nombre, boolean hecho, Prioridad prioridad, String descripcion, int id_tarea,int id_proyecto) {
		super(nombre, hecho, prioridad);
		this.descripcion = descripcion;
		this.id_tarea = id_tarea;
		this.id_proyecto = id_proyecto;
	}

	/**
	 * Devuelve un String con la descripcion de la tarea
	 * @return descripcion de tipo String
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * Establece la descripcion de la tarea
	 * @param descripcion que es un String
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getId_tarea(){
		return id_tarea;
	}
	public void setId_tarea(int id_tarea){
		this.id_tarea = id_tarea;
	}

	public int getId_proyecto(){
		return id_proyecto;
	}
	public void setId_proyecto(int id_proyecto){
		this.id_proyecto = id_proyecto;
	}

	@Override
	public String deEnumAString() {
		String s = getPrioridad().toString();
		return s;
	}

}
