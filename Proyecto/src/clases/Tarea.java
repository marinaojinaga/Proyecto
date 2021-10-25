package clases;
import java.time.*;
import java.util.*;
/**
 * Represents the class Tarea
 * @author Marina Ojinaga
 * @version 1.1
 * @since 1.0
 */
public class Tarea {
	private String descripci�n;
	private LocalDate fechaFinal;
	private LocalDate fechaRealizaci�n;
	private String etiqueta;
	private int prioridad;
	private boolean hecho;
	private ArrayList<Tarea> subtareas = new ArrayList<Tarea>();
	
	public Tarea(String descripci�n, LocalDate fechaFinal, LocalDate fechaRealizaci�n, String etiqueta, int prioridad,
			boolean hecho, ArrayList<Tarea> subtareas) {
		super();
		this.descripci�n = descripci�n;
		this.fechaFinal = fechaFinal;
		this.fechaRealizaci�n = fechaRealizaci�n;
		this.etiqueta = etiqueta;
		this.prioridad = prioridad;
		this.hecho = hecho;
		this.subtareas = subtareas;
	}
	public String getDescripci�n() {
		return descripci�n;
	}
	public void setDescripci�n(String descripci�n) {
		this.descripci�n = descripci�n;
	}
	public LocalDate getFechaFinal() {
		return fechaFinal;
	}
	public void setFechaFinal(LocalDate fechaFinal) {
		this.fechaFinal = fechaFinal;
	}
	public LocalDate getFechaRealizaci�n() {
		return fechaRealizaci�n;
	}
	public void setFechaRealizaci�n(LocalDate fechaRealizaci�n) {
		this.fechaRealizaci�n = fechaRealizaci�n;
	}
	public String getEtiqueta() {
		return etiqueta;
	}
	public void setEtiqueta(String etiqueta) {
		this.etiqueta = etiqueta;
	}
	public int getPrioridad() {
		return prioridad;
	}
	public void setPrioridad(int prioridad) {
		this.prioridad = prioridad;
	}
	public boolean isHecho() {
		return hecho;
	}
	public void setHecho(boolean hecho) {
		this.hecho = hecho;
	}
	public ArrayList<Tarea> getSubtareas() {
		return subtareas;
	}
	public void setSubtareas(ArrayList<Tarea> subtareas) {
		this.subtareas = subtareas;
	}
	
}
