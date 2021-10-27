package clases;
import java.time.*;
import java.util.*;
/**
 * Represents the class Tarea
 * @author Marina Ojinaga
 * @version 1.0
 * @since 1.0
 */
public class Tarea {
	String descripci�n;
	LocalDate fechaFinal;
	LocalDate fechaRealizaci�n;
	String etiqueta;
	int prioridad;
	boolean hecho;
	ArrayList<Tarea> subtareas = new ArrayList<Tarea>();
}
