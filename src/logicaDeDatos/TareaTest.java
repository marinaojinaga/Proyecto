package logicaDeDatos;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TareaTest {
	
	Tarea tarea;
	
	@Before
	public void setUp() {
		tarea = new Tarea(null, false, 0, null, null, null, null);
	}
	
	@After
	public void tearDown() {
		tarea = null;
	}
	
	@Test
	public void getNombreTest() {
		String nombre = "Nombre";
		tarea.setNombre(nombre);
		
		assertEquals(nombre, tarea.getNombre());
	}
	
	@Test
	public void isHechoTest() {
		boolean b = true;
		tarea.setHecho(b);
		
		assertTrue(tarea.isHecho());
	}
	
	@Test
	public void getPrioridadTest() {
		int prioridad= 3;
		tarea.setPrioridad(prioridad);
		
		assertEquals(prioridad, tarea.getPrioridad());
	}
	
	@Test
	public void getDescripcionTest() {
		String descripcion = "Esta es la descripcion";
		
		tarea.setDescripcion(descripcion);
		assertEquals(tarea.getDescripcion(), descripcion);
	}
	
	@Test
	public void getFechaLimiteTest() {
		Calendar fecha = Calendar.getInstance();
		fecha.set(2000, 10, 23);
		
		tarea.setFechaLimite(fecha);
		assertEquals(fecha, tarea.getFechaLimite());
	}
	
	@Test
	public void getFechaRealizacionTest() {
		Calendar fecha = Calendar.getInstance();
		fecha.set(2001, 01, 22);
		
		tarea.setFechaRealizacion(fecha);
		assertEquals(fecha, tarea.getFechaRealizacion());
	}
	
	@Test
	public void getSubtareasTest() {
		Subtarea s1 = new Subtarea("s1", false, 4);
		Subtarea s2 = new Subtarea("s2", true, 2);
		Subtarea s3 = new Subtarea("s3", false, 3);
		Subtarea s4 = new Subtarea("s4", true, 1);
		ArrayList<Subtarea> subtareas = new ArrayList<Subtarea>();
		subtareas.add(s1);
		subtareas.add(s2);
		subtareas.add(s3);
		subtareas.add(s4);
		
		tarea.setSubtareas(subtareas);
		assertEquals(subtareas, tarea.getSubtareas());
	}

}
