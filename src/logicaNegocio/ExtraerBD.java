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

    public void extraerTareas() throws SQLException{
        ArrayList<String> s = new ArrayList<String>();
        ArrayList<Tarea> t = new ArrayList<Tarea>();
        s = g.selectTareas();
        /*for(int i=0;i<s.size();i++){
            String[] r = s.get(i).split("\\s+");
        }*/
    }

    public void extraerSubtareas() throws SQLException{
        ArrayList<String> s = new ArrayList<String>();
        s = g.selectSubtareas();
        for(int i=0;i<s.size();i++){
            String[] r = s.get(i).split(" ");
            Subtarea sub = new Subtarea(r[1], deStringABoolean(r[3]),deStringAPrioridad(r[2]),Integer.valueOf(r[0]),Integer.valueOf(r[4]));
        }
    }
    public void extraerProyecto() throws SQLException{
        ArrayList<String> s = new ArrayList<String>();
        s = g.selectProyecto();
        for(int i=0;i<s.size();i++){
            String[] r = s.get(i).split(" ");
            Proyecto p = new Proyecto(r[1], deStringABoolean(r[2]),Integer.valueOf(r[0]),Integer.valueOf(r[3]));
        }
    }

    public static void main(String[] args) throws SQLException {
        ExtraerBD e = new ExtraerBD();

        /* IMPRIMIR LOS USUARIOS QUE TENGO
        GestorBD gestor = new GestorBD();
        ArrayList<String> array = gestor.selectUsuario();
        for(int i=0; i<array.size();i++){
            System.out.println(array.get(i));
        }*/

        ArrayList<Usuario> usuarios = e.extraerUsuarios();
        System.out.println(usuarios.get(0).getId_usuario());

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
