package logicaNegocio;

import logicaDeDatos.Usuario;

/**
 * Esta clase tendrá las distintas acciones que se usarán para gestionar a los usuarios
 * @author Marina
 * @version 1
 */

public class GestionUsuario {
	
	/**
	 * Cambiará la contraseña de un usuario comprobando antes que es el, mediante la contraseña
	 * @param u Es el usuario que quiere cambiar la contraseña
	 * @param contraIntro Es la contraseña que introduce el usuario como la suya anterior
	 * @param contraNueva Es la contraseña nueva que quiere poner el usuario
	 */
	public void cambiarContraseña(Usuario u, String contraIntro, String contraNueva) {
		if(u.getContraseña().equals(contraIntro)) {
			u.setContraseña(contraNueva);
			System.out.println("Contraseña cambiada con exito.");
		}else {
			System.out.println("La contraseña intoducida no es la correcta.");
		}
		
	}
	
	/**
	 * Cambia el mail de un usario comprobando antes que es el, gracias a la contraseña.
	 * @param u Es el usuario que quiere cambiar el mail.
	 * @param contraseña Es la contraseña del usuario para comprobar que es el.
	 * @param emailNuevo Es el nuevo email que va a tener el usuario
	 */
	public void cambiarMail(Usuario u, String contraseña, String emailNuevo) {
		if(u.getContraseña().equals(contraseña)) {
			u.setMail(emailNuevo);
			System.out.println("Mail cambiado");
		}else {
			System.out.println("La contraseña introducida no es correcta.");
		}
	}
	

}
