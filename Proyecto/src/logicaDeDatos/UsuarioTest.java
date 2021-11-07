package logicaDeDatos;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;



public class UsuarioTest {
	
	Usuario usuario;
	
	@Before
	public void setUp(){
		usuario = new Usuario(null, null, null, null, null);
	}
	
	@After
	public void tearDown() {
		usuario = null;
	}
	
	@Test
	public void getNickUsuarioTest() {
		String nick = "josePerez";
		usuario.setnickUsuario(nick);
		assert(usuario.getnickUsuario().equals(nick));
		
	}
	
	public void getContrasena() {
		String contrasena = "12345678A";
		usuario.setContraseña(contrasena);
		assert(usuario.getContrasena().equals(contrasena));
		
	}
	
	public void getNombreTest() {
		String nombre = "Jose Perez";
		usuario.setNombre(nombre);
		assert(usuario.getNombre().equals(nombre));
		
	}
	
	public void getMailTest() {
		String mail = "joseperez@gmail.com";
		usuario.setMail(mail);
		assert(usuario.getMail().equals(mail));
		
	}
	
}
