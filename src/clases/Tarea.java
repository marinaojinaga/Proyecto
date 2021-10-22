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
	String descripción;
	LocalDate fechaFinal;
	LocalDate fechaRealización;
	String etiqueta;
	int prioridad;
	boolean hecho;
	ArrayList<Tarea> subtareas = new ArrayList<Tarea>();
}
