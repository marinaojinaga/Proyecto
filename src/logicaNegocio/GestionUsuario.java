package logicaNegocio;

import logicaDeDatos.Usuario;

/**
 * Esta clase tendr� las distintas acciones que se usar�n para gestionar a los usuarios
 * @author Marina
 * @version 2
 */

public class GestionUsuario {
	
	/**
	 * Cambiar� la contrase�a de un usuario comprobando antes que es el, mediante la contrase�a
	 * @param u Es el usuario que quiere cambiar la contrase�a
	 * @param contraIntro Es la contrase�a que introduce el usuario como la suya anterior
	 * @param contraNueva Es la contrase�a nueva que quiere poner el usuario
	 */
	public void cambiarContrasenya(Usuario u, String contraIntro, String contraNueva) {
		if(u.getContrasena().equals(contraIntro)) {
			u.setContrasenya(contraNueva);
			System.out.println("Contrase�a cambiada con exito.");
		}else {
			System.out.println("La contrase�a intoducida no es la correcta.");
		}
		
	}
	
	/**
	 * Cambia el mail de un usario comprobando antes que es el, gracias a la contrase�a.
	 * @param u Es el usuario que quiere cambiar el mail.
	 * @param contrasenya Es la contrase�a del usuario para comprobar que es el.
	 * @param emailNuevo Es el nuevo email que va a tener el usuario
	 */
	public void cambiarMail(Usuario u, String contrasenya, String emailNuevo) {
		if(u.getContrasena().equals(contrasenya)) {
			u.setMail(emailNuevo);
			System.out.println("Mail cambiado");
		}else {
			System.out.println("La contrase�a introducida no es correcta.");
		}
	}
	
	public boolean acceder(Usuario u, String mail, String contrasenya) {
		boolean acceso = u.getMail().equals(mail)&&u.getContrasena().equals(contrasenya);
		return acceso;
	}

}
