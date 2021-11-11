package logicaNegocio;

import logicaDeDatos.Subtarea;
import logicaDeDatos.Usuario;
import logicaDeDatos.Tarea;

import java.util.ArrayList;

public class GestorArrayLists {

    public String ArrayListUsuarios(ArrayList<Usuario> usuarios){
        String u = "";
        String aux;
        for(int i=0; i<usuarios.size(); i++){
            aux = usuarios.get(i).getnickUsuario();
            u = u+aux;
        }
        return u;
    }

    public String ArrayListTareas (ArrayList<Tarea> tareas){
        String t = "";
        String aux;
        for(int i=0; i<tareas.size();i++){
            aux=tareas.get(i).getNombre();
            t=t+aux;
        }
        return t;
    }

    public String ArrayListSubtareas (ArrayList<Subtarea> subtareas){
        String s = "";
        String aux;
        for(int i=0; i<subtareas.size();i++){
            aux =subtareas.get(i).getNombre();
            s=s+aux;
        }
        return s;
    }
}
