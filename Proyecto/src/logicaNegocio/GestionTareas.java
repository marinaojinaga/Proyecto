package logicaNegocio;

import java.util.ArrayList;

import logicaDeDatos.Subtarea;
import logicaDeDatos.Tarea;

public class GestionTareas {
	
	public int porcentajeCompletado(Tarea t) {
		ArrayList<Subtarea> subtarea = t.getSubtareas();
		int sHecho = 0;
		int porcentaje;
		int sub = subtarea.size();
		for(int i=0; i<subtarea.size();i++) {
			if(subtarea.get(i).isHecho()) {
				sHecho = sHecho + 1;
			}
		}
		porcentaje = sub/sHecho;
		return porcentaje;
	}
	
	
}
