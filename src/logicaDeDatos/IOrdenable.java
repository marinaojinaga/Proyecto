package logicaDeDatos;

import java.util.ArrayList;

public interface IOrdenable<t> {
    public void SortAlfabetico(ArrayList<t> ArrayList,int low,int high);
    public void SortPrioridad(ArrayList<t> ArrayList,int low,int high);
    public void SortBooleanos(ArrayList<t> ArrayList,int low,int high);

}
