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
		tarea = new Tarea(null, false, null, null, 0, 0);
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
		Prioridad prioridad= Prioridad.Alta ;
		tarea.setPrioridad(prioridad);
		
		assertEquals(prioridad, tarea.getPrioridad());
	}
	
	@Test
	public void getDescripcionTest() {
		String descripcion = "Esta es la descripcion";
		
		tarea.setDescripcion(descripcion);
		assertEquals(tarea.getDescripcion(), descripcion);
	}


}
