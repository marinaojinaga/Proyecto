/*package logicaNegocio;

import logicaDeDatos.Prioridad;
import logicaDeDatos.Usuario;

import java.util.ArrayList;

import logicaDeDatos.Proyecto;
import logicaDeDatos.Tarea;

/**
 * Contiene las distintas acciones para gestionar un proyecto.
 * @author Marina Ojinaga
 * @version 1
 * @since 1
 */
/*public class GestionProyecto {

	/**
	 * Añade una nueva tarea a la lista de tareas de un proyecto
	 * @param p Es el proyecto al que vamos a añadir la tarea
	 * @param t Es la tarea que queremos añadir al proyecto
	 */
	/*public void anyadirTarea(Proyecto p, Tarea t){
		ArrayList<Tarea> tProyecto = p.getTareas();
		tProyecto.add(t);
		p.setTareas(tProyecto);
	}

	/**
	 * Añade un usuario que podrá acceder al proyecto
	 * @param p Es el proyecto al que podemos 
	 * @param u Es el usuario al que queremos dar acceso al proyecto p.
	 */
	/*public ArrayList<Usuario> anyadirUsuario(Proyecto p, Usuario u) {
		ArrayList<Usuario> us = p.getUsuarios();
		us.add(u);
		p.setUsuarios(us);
		return p.getUsuarios();
	}
	
	/**
	 * Quita una tarea de la lista de tareas de un proyecto
	 * @param p Es el proyecto al que le quitaremos una tarea
	 * @param t Es la tarea que queremos quitar.
	 */
	/*public void quitarTarea(Proyecto p, Tarea t) {
		ArrayList<Tarea> tQuitar= p.getTareas();
		tQuitar.remove(t);
		p.setTareas(tQuitar);
	}
	
	/**
	 * Quita un usuario del proyecto.
	 * @param p Es el proyecto al que vamos a quitar un usuario
	 * @param u Es el usuario que vamos a quitar del proyecto
	 */
	/*public void quitarUsuario(Proyecto p, Usuario u) {
		ArrayList<Usuario> usuarioQuitar = p.getUsuarios();
		usuarioQuitar.remove(u);
		p.setUsuarios(usuarioQuitar);
	}
	
	/**
	 * Ordena las distintas tareas de un proyecto en orden de prioridad
	 * @param t El proyecto del que vamos a ordenar las distintas tareas
	 * @return La lista de tareas ya ordenada
	 */
/*	public ArrayList<Tarea> ordenarTareasXPrioridad(Proyecto t) {
		ArrayList<Tarea> tareas= t.getTareas();
		ArrayList<Tarea> tareasOrdenadas = new ArrayList<Tarea>();

		for(int i=0;i<tareas.size();i++) {
			if(tareas.get(i).getPrioridad().equals(Prioridad.Alta)) {
				tareasOrdenadas.add(tareas.get(i));
			}
		}
		for(int i=0;i<tareas.size();i++) {
			if(tareas.get(i).getPrioridad().equals(Prioridad.Media)) {
				tareasOrdenadas.add(tareas.get(i));
			}
		}
		for(int i=0;i<tareas.size();i++) {
			if(tareas.get(i).getPrioridad().equals(Prioridad.Baja)) {
				tareasOrdenadas.add(tareas.get(i));
			}
		}
		return tareasOrdenadas;
	}
	
	/*public ArrayList<Tarea> ordenarXfechaLimite(Proyecto p) {*/

	/**
	 * Ordena las distinas tareas de un proyecto con las no hechas al principio y después las hechas
	 * @param p Es el proyecto del que vamos a ordenar las distintas tareas
	 * @return La lista de tareas del proyecto ya ordenadas
	 */
	/*public ArrayList<Tarea> ordenarSiHecho(Proyecto p){
		ArrayList<Tarea> tareas = p.getTareas();
		ArrayList<Tarea> tareasOrdenadas = new ArrayList<Tarea>();
		for(int i=0; i<tareas.size();i++) {
			if(!tareas.get(i).isHecho()) {
				tareasOrdenadas.add(tareas.get(i));
			}
		}
		for(int i=0; i<tareas.size();i++) {
			if(tareas.get(i).isHecho()) {
				tareasOrdenadas.add(tareas.get(i));
			}
		}
		return tareasOrdenadas;
	}
}
	 */
