package logicaDeDatos;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TareaGeneralTest {
	
	Subtarea subtarea;
	Tarea tarea;
	
	@Before
	public void setUp() {
		subtarea = new Subtarea(null, false, 0, null);
		tarea = new Tarea(null, true, 0, null, null, null, null);
	}
	
	@After
	public void tearUp() {
		subtarea = null;
		tarea = null;
	}
	
	@Test
	public void getNombreTest() {
		String nombre = "Hacer ejercicio 2";
		subtarea.setNombre(nombre);
		tarea.setNombre(nombre);
		
		assert(subtarea.getNombre().equals(nombre));
		assert(tarea.getNombre().equals(nombre));
	}
	
	public void isHecho() {
		assertFalse(subtarea.isHecho());
		assertTrue(tarea.isHecho());
		subtarea.setHecho(true);
		tarea.setHecho(false);
		assertFalse(tarea.isHecho());
		assertTrue(subtarea.isHecho());
	}
	
	public void getPrioridadTest() {
		int p1 = 2;
		int p2 = 4;
		tarea.setPrioridad(p2);
		subtarea.setPrioridad(p1);
		assert(tarea.getPrioridad()==p2);
		assert(subtarea.getPrioridad() == p1);
	}

}
