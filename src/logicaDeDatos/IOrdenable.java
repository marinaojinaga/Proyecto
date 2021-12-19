package logicaDeDatos;

import java.util.ArrayList;

public interface IOrdenable<t> {
    public ArrayList<t> orden(ArrayList<t> ArrayList,int low,int high);
}
