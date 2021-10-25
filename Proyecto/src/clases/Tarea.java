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
	private String descripción;
	private LocalDate fechaFinal;
	private LocalDate fechaRealización;
	private String etiqueta;
	private int prioridad;
	private boolean hecho;
	private ArrayList<Tarea> subtareas = new ArrayList<Tarea>();
	
	public Tarea(String descripción, LocalDate fechaFinal, LocalDate fechaRealización, String etiqueta, int prioridad,
			boolean hecho, ArrayList<Tarea> subtareas) {
		super();
		this.descripción = descripción;
		this.fechaFinal = fechaFinal;
		this.fechaRealización = fechaRealización;
		this.etiqueta = etiqueta;
		this.prioridad = prioridad;
		this.hecho = hecho;
		this.subtareas = subtareas;
	}
	public String getDescripción() {
		return descripción;
	}
	public void setDescripción(String descripción) {
		this.descripción = descripción;
	}
	public LocalDate getFechaFinal() {
		return fechaFinal;
	}
	public void setFechaFinal(LocalDate fechaFinal) {
		this.fechaFinal = fechaFinal;
	}
	public LocalDate getFechaRealización() {
		return fechaRealización;
	}
	public void setFechaRealización(LocalDate fechaRealización) {
		this.fechaRealización = fechaRealización;
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
