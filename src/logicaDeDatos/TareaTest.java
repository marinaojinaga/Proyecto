package logicaDeDatos;



import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TareaTest {
	
	Tarea tarea,tarea2;
	
	@Before
	public void setUp() {
		tarea = new Tarea(null, false, null, null, 0, 0);
		tarea2 = new Tarea(null,false,null,null,0,0);
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
		tarea.setHecho(true);
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

	@Test
	public void deEnumAStringTest(){
		tarea.setPrioridad(Prioridad.Alta);
		String prioridad = "Alta";
		assertEquals(tarea.deEnumAString(),prioridad);
	}

	@Test
	public void compararAlfabeticoTest(){
		tarea.setNombre("b");
		tarea2.setNombre("A");
		assertTrue(tarea.compararAlfabetico(tarea2));
	}

	@Test
	public void compararBoolTest(){
		tarea.setHecho(false);
		tarea2.setHecho(true);
		assertFalse(tarea.compararBool(tarea2));
	}

	@Test
	public void comparaPrioridadTest(){
		tarea.setPrioridad(Prioridad.Media);
		tarea2.setPrioridad(Prioridad.Alta);
		assertTrue(tarea.compararPrioridad(tarea2));
	}

	@Test
	public void dePrioridadAIntTest(){
		assertEquals(tarea.dePrioridadAInt(Prioridad.Media),2);
	}

}
