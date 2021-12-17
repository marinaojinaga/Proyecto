package logicaNegocio;

import gestionBD.GestorBD;
import logicaDeDatos.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

public class ExtraerBD {
    GestorBD g = new GestorBD();

    public ArrayList<Usuario> extraerUsuarios() throws SQLException {
        ArrayList<String> s = new ArrayList<String>();
        ArrayList<Usuario> u = new ArrayList<Usuario>();
        s = g.selectUsuario();
        for(int i=0;i<s.size();i++){
            String[] r = s.get(i).split("\\s+");
            Usuario ux = new Usuario(r[1],r[2],r[3],r[4],Integer.parseInt(r[0]));
            u.add(ux);
        }
     return u;
    }

    public ArrayList<Tarea> extraerTareas() throws SQLException{
        ArrayList<String> s = new ArrayList<String>();
        ArrayList<Tarea> t = new ArrayList<Tarea>();
        s = g.selectTareas();
        for(int i=0;i<s.size();i++){
            String[] r = s.get(i).split("\\s+");
            Tarea p = new Tarea(r[1],deStringABoolean(r[2]),deStringAPrioridad(r[3]),r[4],Integer.parseInt(r[0]),Integer.parseInt(r[5]));
            t.add(p);
        }
        return t;
    }

    public ArrayList<Subtarea> extraerSubtareas() throws SQLException{
        ArrayList<String> s = new ArrayList<String>();
        ArrayList<Subtarea> subtareas = new ArrayList<Subtarea>();
        s = g.selectSubtareas();
        for(int i=0;i<s.size();i++){
            String[] r = s.get(i).split("\\s+ ");
            Subtarea sub = new Subtarea(r[1], deStringABoolean(r[2]),deStringAPrioridad(r[3]),Integer.parseInt(r[0]),Integer.parseInt(r[4]));
            subtareas.add(sub);
        }
        return subtareas;
    }
    public ArrayList<Proyecto> extraerProyecto() throws SQLException{
        ArrayList<String> s = new ArrayList<String>();
        ArrayList<Proyecto> proyectos = new ArrayList<Proyecto>();
        s = g.selectProyecto();
        for(int i=0;i<s.size();i++){
            String[] r = s.get(i).split("\\s+");
            Proyecto p = new Proyecto(r[1], deStringABoolean(r[2]),Integer.parseInt(r[0]),Integer.parseInt(r[3]));
            proyectos.add(p);
        }
        return proyectos;
    }

    public boolean deStringABoolean(String a){
        boolean b;
        if(Integer.parseInt(a) == 0){
            b = false;
        }else{
            b = true;
        }
        return b;
    }

    public Prioridad deStringAPrioridad(String a){
        Prioridad p = Prioridad.Baja;
        if(a.equals("Alta")){
            p = Prioridad.Alta;
        }else if(a.equals("Media")){
            p = Prioridad.Media;
        }else if(a.equals("Baja")){
            p = Prioridad.Baja;
        }
        return p;
    }

}
