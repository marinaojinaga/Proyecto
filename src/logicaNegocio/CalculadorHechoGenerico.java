package logicaNegocio;

import logicaDeDatos.Prioridad;
import logicaDeDatos.Tarea;
import logicaDeDatos.TareaGeneral;

import java.util.ArrayList;

public class CalculadorHechoGenerico<E extends TareaGeneral> {

    /**
     * Va a recorrer todo el array y va a devolver el porcentaje que están hechas
     * @param array Es el arrayList que le vamos a pasar
     * @return devuelve el porcentaje
     */
    public String calcular(ArrayList<E> array){
        float hechos = (float)array.stream().filter(a->a.isHecho()).count();
        float total = (float)array.stream().count();
        float porcentaje = hechos/total*100;
        String p = porcentaje+"%";
        return p;
    }


}
