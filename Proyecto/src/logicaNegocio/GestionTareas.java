package logicaNegocio;

import java.util.ArrayList;

import logicaDeDatos.Proyecto;
import logicaDeDatos.Subtarea;
import logicaDeDatos.Tarea;

/**
 * Esta clase tendrá las distintas acciones que se usarán para gestionar las tareas
 * @author Marina Ojinaga
 * @version 1
 * @since 2
 */
public class GestionTareas {
	
	/**
	 * Mostrará el porcentaje de las subtareas que están completadas
	 * @param t Tarea sobre la que vamos a hacer los cálculos
	 * @return Devuelve un decimal que será el porcentaje de subtareas que se han hecho
	 */
	public double porcentajeCompletado(Tarea t) {
		ArrayList<Subtarea> subtarea = t.getSubtareas();
		int sHecho = 0;
		double porcentaje;
		int sub = subtarea.size();
		for(int i=0; i<subtarea.size();i++) {
			if(subtarea.get(i).isHecho()) {
				sHecho = sHecho + 1;
			}
		}
		porcentaje = (sub/sHecho)*100;
		return porcentaje;
	}
	
	/**
	 * Añade una nueva subtarea a una tarea.
	 * @param t La tarea a la que añadiremos la subtarea
	 * @param s La subtarea que vamos a añadir
	 */
	public void anyadirSubtarea(Tarea t, Subtarea s) {
		ArrayList<Subtarea> sub = t.getSubtareas();
		sub.add(s);
		t.setSubtareas(sub);
	}
	
	/**
	 * Quita una de las subtareas de la lista de subtareas
	 * @param t La tarea a la que vamos a quitar la subtarea
	 * @param s La subtarea que vamos a quitar
	 */
	public void quitarSubtarea(Tarea t, Subtarea s) {
		ArrayList<Subtarea> sub = t.getSubtareas();
		sub.remove(s);
		t.setSubtareas(sub);
	}
	
	/**
	 * Ordena las subtareas de prioridad de mayor prioridad a menor prioridad
	 * @param t La tarea de la que vamos a ordenar las subtareas
	 * @return Un arrayList de subtareas con estas ya ordenadas de mayor a menor.
	 */
	public ArrayList<Subtarea> ordenarTareasXPrioridad(Tarea t) {
		ArrayList<Subtarea> subtareas= t.getSubtareas();
		ArrayList<Subtarea> subtareasOrdenadas = new ArrayList<Subtarea>();
		
		for(int i=0;i<subtareas.size();i++) {
			if(subtareas.get(i).getPrioridad()==4) {
				subtareasOrdenadas.add(subtareas.get(i));
			}
		}
		for(int i=0;i<subtareas.size();i++) {
			if(subtareas.get(i).getPrioridad()==3) {
				subtareasOrdenadas.add(subtareas.get(i));
			}
		}
		for(int i=0;i<subtareas.size();i++) {
			if(subtareas.get(i).getPrioridad()==2) {
				subtareasOrdenadas.add(subtareas.get(i));
			}
		}
		for(int i=0;i<subtareas.size();i++) {
			if(subtareas.get(i).getPrioridad()==1) {
				subtareasOrdenadas.add(subtareas.get(i));
			}
		}
		return subtareasOrdenadas;
	}
	
	/**
	 * Ordena las subtareas de una tarea con las que no están hechas al principio y las hechas al final
	 * @param t Meto la tarea de la que voy a ordenar las subtareas
	 * @return Devuelve el ArrayList de subtareas ya ordenado
	 */
	public ArrayList<Subtarea> ordenarSiHecho(Tarea t){
		ArrayList<Subtarea> subtareas = t.getSubtareas();
		ArrayList<Subtarea> subtareasOrdenadas = new ArrayList<Subtarea>();
		for(int i=0; i<subtareas.size();i++) {
			if(!subtareas.get(i).isHecho()) {
				subtareasOrdenadas.add(subtareas.get(i));
			}
		}
		for(int i=0; i<subtareas.size();i++) {
			if(subtareas.get(i).isHecho()) {
				subtareasOrdenadas.add(subtareas.get(i));
			}
		}
		return subtareasOrdenadas;
	}
}
