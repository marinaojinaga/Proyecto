package logicaDeDatos;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Calendar;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ProyectoTest {
	
	Proyecto p;
	
	@Before
	public void setUp() {
		p = new Proyecto(null, false, 0, 0);
	}
	
	@After
	public void tearDown() {
		p = null;
	}
	
	@Test
	public void getNombreTest() {
		String nombre = "Marina";
		p.setNombre(nombre);
		
		assertEquals(nombre, p.getNombre());
	}
	
	@Test
	public void isFavoritoTest() {
		p.setFavorito(true);
		
		assertTrue(p.isFavorito());
	}

}
