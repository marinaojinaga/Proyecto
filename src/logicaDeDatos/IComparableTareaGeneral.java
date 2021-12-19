package logicaDeDatos;

public interface IComparableTareaGeneral<t> {
    public boolean compararAlfabetico (t objeto);
    public boolean compararBool(t objeto);
    public boolean compararPrioridad(t objeto);

}
