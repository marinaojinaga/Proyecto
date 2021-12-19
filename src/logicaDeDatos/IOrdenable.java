package logicaDeDatos;

import java.util.ArrayList;

public interface IOrdenable<t> {
    public void QuickSortAlfabetico(ArrayList<t> ArrayList,int low,int high);
    public void QuickSortPrioridad(ArrayList<t> ArrayList,int low,int high);
    public void QuickSortBooleanos(ArrayList<t> ArrayList,int low,int high);

}
