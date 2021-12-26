package logicaDeDatos;

import java.util.ArrayList;
import java.util.Calendar;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ProyectoTest {
	
	Proyecto p,p2;
	
	@Before
	public void setUp() {
		p = new Proyecto(null, false, 0, 0);
		p2 = new Proyecto(null, false, 0, 0);
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

	@Test
	public void getId_proyectoTest(){
		p.setId_proyecto(2);
		assertEquals(p.getId_proyecto(),2);
	}

	@Test
	public void getId_usuarioTest(){
		p.setId_usuario(4);
		assertEquals(p.getId_usuario(),4);
	}

	@Test
	public void toStringTest(){
		String nombre = "Nombre";
		p.setNombre(nombre);
		assertEquals(p.getNombre(),nombre);
	}

	@Test
	public void compararAlfabeticoTest(){
		p.setNombre("b");
		p2.setNombre("A");
		assertTrue(p.compararAlfabetico(p2));
	}

	@Test
	public void compararBoolTest(){
		p.setFavorito(false);
		p2.setFavorito(true);
		assertTrue(p.compararBool(p2));
	}



}
