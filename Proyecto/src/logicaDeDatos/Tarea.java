package logicaDeDatos;

import java.util.ArrayList;
import java.util.Date;

/**
 * Representa una tarea. La clase extiende de la clase TareaGeneral.
 * @author Marina Ojinaga
 * @version 1.0
 * @since 1.0
 */
public class Tarea extends TareaGeneral{
	
	/**Descripcion de la tarea 
	 */
	private String descripcion;
	
	/**Fecha limite en la que hay que entregar la tarea o quieres tenerla hecha
	 */
	private Date fechaLimite;
	
	/** Fecha en la que planeas hacer la tarea
	 */
	private Date fechaRealizacion;
	
	/** Lista de subtareas incluidas dentro de una tarea
	 */
	private ArrayList<Subtarea> subtareas;
	
	/**
	 * Crea una tarea con los parámetros siguientes
	 * @param nombre String con el nombre que tendra la tarea. Parametro heradado de TareaGeneral.
	 * @param hecho Booleano que representa si se ha hecho la tarea. Parametro hereado de TareaGeneral.
	 * @param prioridad Entero del 0 al 4 con la prioridad de la tarea. Parametro herado de TareaGeneral.
	 * @param descripcion String con una breve descripcion de la tarea.
	 * @param fechaLimite Tipo Date que indica la fecha limite de realizacion de la tarea.
	 * @param fechaRealizacion Tipo Date que indica la fecha en la qeu planeas hacer la tarea
	 * @param subtareas ArrayList que contendrá las subtareas de una tarea
	 */
	public Tarea(String nombre, boolean hecho, int prioridad, String descripcion, Date fechaLimite,
			Date fechaRealizacion, ArrayList<Subtarea> subtareas) {
		super(nombre, hecho, prioridad);
		this.descripcion = descripcion;
		this.fechaLimite = fechaLimite;
		this.fechaRealizacion = fechaRealizacion;
		this.subtareas = subtareas;
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

	/**
	 * Devuelve la fecha limite en la que tienes que tener hecho algo
	 * @return fechaLimite de tipo Date
	 */
	public Date getFechaLimite() {
		return fechaLimite;
	}

	/**
	 * Establece la fecha limite de una tarea
	 * @param fechaLimite es una variable de tipo Date
	 */
	public void setFechaLimite(Date fechaLimite) {
		this.fechaLimite = fechaLimite;
	}

	/**
	 * Devuelve la fecha de realizacion de una tarea
	 * @return fechaRealizacion de tipo Date
	 */
	public Date getFechaRealizacion() {
		return fechaRealizacion;
	}

	/**
	 * Establece la fecha en la que has pensado realizar una tarea
	 * @param fechaRealizacion de tipo Date
	 */
	public void setFechaRealizacion(Date fechaRealizacion) {
		this.fechaRealizacion = fechaRealizacion;
	}

	/**
	 * Devuelve la lista de subtareas que tiene una tarea
	 * @return un arraylist que contiene subtareas al que llamamos subtareas
	 */
	public ArrayList<Subtarea> getSubtareas() {
		return subtareas;
	}

	/**
	 * Establece la lista de subtareas dentro de una tarea
	 * @param subtareas que es un arraylist de subtareas.
	 */
	public void setSubtareas(ArrayList<Subtarea> subtareas) {
		this.subtareas = subtareas;
	}
	
}
