package logicaNegocio;

import gestionBD.GestorBD;
import logicaDeDatos.*;
import logicaDePrestacion.VentanaLogin;

import java.awt.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

public class ExtraerBD {
    GestorBD g = new GestorBD();


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

    public static void main(String[] args) throws SQLException {
        ExtraerBD e = new ExtraerBD();
        //IMPRIMIR LOS USUARIOS QUE TENGO
        GestorBD gestor = new GestorBD();
        ArrayList<Proyecto> array = gestor.selectProyecto();
        ArrayList<Usuario> ux = gestor.selectUsuario();
        for(int i=0; i<ux.size();i++){
            System.out.println(ux.get(i).getId_usuario());
        }
    }

}