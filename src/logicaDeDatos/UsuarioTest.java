package logicaDeDatos;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;



public class UsuarioTest {
	
	Usuario usuario;
	
	@Before
	public void setUp(){
		usuario = new Usuario(null, null, null, null,0);
	}
	
	@After
	public void tearDown() {
		usuario = null;
	}
	
	@Test
	public void getNickUsuarioTest() {
		String nick = "josePerez";
		usuario.setnickUsuario(nick);
		assertEquals(usuario.getnickUsuario(), nick);
		
	}
	
	@Test
	public void getContrasenaTest() {
		String contrasena = "12345678A";
		usuario.setContrasenya(contrasena);
		assertEquals(usuario.getContrasena(),contrasena);
		
	}
	
	@Test
	public void getNombreTest() {
		String nombre = "Jose Perez";
		usuario.setNombre(nombre);
		assertEquals(usuario.getNombre(),nombre);
		
	}
	
	@Test
	public void getMailTest() {
		String mail = "joseperez@gmail.com";
		usuario.setMail(mail);
		assertEquals(usuario.getMail(),mail);
		
	}

	@Test
	public void getId_usuarioTest(){
		usuario.setId_usuario(3);
		assertEquals(usuario.getId_usuario(),3);
	}
	
}
