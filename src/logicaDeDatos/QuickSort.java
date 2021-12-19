package logicaDeDatos;

import java.util.ArrayList;

public class QuickSort <t extends IComparable<t>> implements IOrdenable<t>{

    public int pivotAlfabetico(ArrayList<t> array, int low, int high){
        t pivot = array.get(low);
        int leftwall = low;

        for(int i=low+1;i==high;i++){
            if(pivot.compararPrioridad(array.get(i))==1){
                t aux = array.get(leftwall);
                array.set(leftwall,array.get(i));
                array.set(i,aux);
                leftwall += 1;
            }
            t aux = pivot;
            pivot = array.get(leftwall);
            array.set(leftwall,aux);
        }
        return leftwall;
    }

    @Override
    public ArrayList<t> orden(ArrayList<t> ArrayList, int low, int high) {
        if(ArrayList.size()<=1){
        }else{
            if(low<high){
                int p = 0;
                p = pivotAlfabetico(ArrayList,low,high);
                orden(ArrayList,low,p);
                orden(ArrayList,p+1,high);
            }
        }
        return ArrayList;
    }

    public static void main(String[] args) {
        QuickSort<Tarea> tareaQuickSort = new QuickSort<Tarea>();
        Tarea t1 = new Tarea("x",true,Prioridad.Media,"Tarea",4,2);
        Tarea t2 = new Tarea("c",true,Prioridad.Baja,"Tarea",4,2);
        Tarea t3 = new Tarea("a",true,Prioridad.Alta,"Tarea",4,2);
        ArrayList<Tarea> introducir = new ArrayList<Tarea>();
        introducir.add(t1);
        introducir.add(t2);
        introducir.add(t3);

        ArrayList<Tarea> sacar = tareaQuickSort.orden(introducir,0,introducir.size()-1);
        for(int i=0;i<sacar.size();i++){
            System.out.println(sacar.get(i).getNombre());
        }

    }

}
