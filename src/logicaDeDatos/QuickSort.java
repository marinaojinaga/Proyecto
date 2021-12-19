package logicaDeDatos;

import java.util.ArrayList;
import java.util.Collections;

public class QuickSort <t extends IComparableTareaGeneral<t>> implements IOrdenable<t>{

    public int partitionAlfabetico(ArrayList<t> a, int low, int high){
        t pivot = a.get(high);
        int i= (low-1);
        for(int j=low;j<high;j++){
            if(!a.get(j).compararAlfabetico(pivot)){
                i++;
                Collections.swap(a,i,j);
            }
        }
        Collections.swap(a,i+1,high);
        return (i+1);
    }

    public int partitionPrioridad(ArrayList<t> a, int low, int high){
        t pivot = a.get(high);
        int i= (low-1);
        for(int j=low;j<high;j++){
            if(!a.get(j).compararPrioridad(pivot)){
                i++;
                Collections.swap(a,i,j);
            }
        }
        Collections.swap(a,i+1,high);
        return (i+1);
    }

    public int partitionBoolean(ArrayList<t> a, int low, int high){
        t pivot = a.get(high);
        int i= (low-1);
        for(int j=low;j<high;j++){
            if(!a.get(j).compararBool(pivot)){
                i++;
                Collections.swap(a,i,j);
            }
        }
        Collections.swap(a,i+1,high);
        return (i+1);
    }

    @Override
    public void SortAlfabetico(ArrayList<t> ArrayList, int low, int high) {
        if(ArrayList.size()>1){
            if(low<high){
                int pivot_location=partitionAlfabetico(ArrayList,low,high);
                SortAlfabetico(ArrayList,low,pivot_location-1);
                SortAlfabetico(ArrayList,pivot_location+1,high);
            }
        }
    }

    @Override
    public void SortPrioridad(ArrayList<t> ArrayList, int low, int high) {
        if(low<high){
            int pivot_location=partitionPrioridad(ArrayList,low,high);
            SortPrioridad(ArrayList,low,pivot_location-1);
            SortPrioridad(ArrayList,pivot_location+1,high);
        }
    }

    @Override
    public void SortBooleanos(ArrayList<t> ArrayList, int low, int high) {
        if(low<high){
            int pivot_location=partitionBoolean(ArrayList,low,high);
            SortBooleanos(ArrayList,low,pivot_location-1);
            SortBooleanos(ArrayList,pivot_location+1,high);
        }
    }


    public static void main(String[] args) {
        QuickSort<Tarea> tareaQuickSort = new QuickSort<Tarea>();
        Tarea t1 = new Tarea("x",true,Prioridad.Media,"Tarea",4,2);
        Tarea t2 = new Tarea("c",true,Prioridad.Baja,"Tarea",4,2);
        Tarea t3 = new Tarea("a",true,Prioridad.Alta,"Tarea",4,2);
        ArrayList<Tarea> introducir = new ArrayList<Tarea>();
        ArrayList<Tarea> introducir1 = new ArrayList<Tarea>();
        introducir1.add(t1);
        introducir1.add(t2);
        introducir1.add(t3);

        QuickSort<Tarea> quickSort = new QuickSort<Tarea>();
        quickSort.SortAlfabetico(introducir1,0,introducir1.size()-1);
        for(int i=0;i<introducir1.size();i++){
            System.out.println(introducir1.get(i).getNombre());
        }

    }

}
