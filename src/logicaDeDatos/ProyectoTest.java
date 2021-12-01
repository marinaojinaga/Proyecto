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
		p = new Proyecto(null, false, null, null);
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
	public void getUsuarioTest() {
		Usuario u1 = new Usuario("abc", "123", "Abelio", "abelio@gmail.com");
		Usuario u2 = new Usuario("bca", "456", "Bernardo", "bernardo@gmail.com");
		Usuario u3 = new Usuario("cba", "789", "Cecilia", "cecilia@gmail.com");
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		usuarios.add(u1);
		usuarios.add(u2);
		usuarios.add(u3);
		
		p.setUsuarios(usuarios);
		assertEquals(usuarios, p.getUsuarios());
	}
	
	@Test
	//Muy raro. Esta bien?
	public void getTareasTest() {
		Calendar f1 = Calendar.getInstance();
		f1.set(2020, 4, 12);
		Calendar f2 = Calendar.getInstance();
		f2.set(2020, 5, 20);
		
		Subtarea s2 = new Subtarea("Subtarea 2", true, Prioridad.Alta);
		Subtarea s3 = new Subtarea("Subtarea 3", false, Prioridad.Media);
		Subtarea s4 = new Subtarea("Subtarea 4", true, Prioridad.Alta);
		ArrayList<Subtarea> subs1 = new ArrayList<Subtarea>();
		ArrayList<Subtarea> subs2 = new ArrayList<Subtarea>();
		subs1.add(s4);
		subs1.add(s2);
		subs2.add(s2);
		subs2.add(s3);
		
		Tarea t1 = new Tarea("t1", false, Prioridad.Baja, "Descripcion", f1, f2, subs1);
		Tarea t2 = new Tarea("t2", true, Prioridad.Media, "Descripcion2", f2, f1, subs2);
		ArrayList<Tarea> tareas = new ArrayList<Tarea>();
		tareas.add(t1);
		tareas.add(t2);
		
		p.setTareas(tareas);
		
		assertEquals(p.getTareas(), tareas);
	}
}
