
package logicaDeDatos;

/**
 * La clase subtarea representas la subtareas contenidas dentre de una tarea. 
 * Hereda de la clase TareaGeneral
 * @author Marina Ojinaga
 * @version 2.0
 * @since 1.0
 */
public class Subtarea extends TareaGeneral implements iEnumAString, IComparableTareaGeneral<Subtarea> {
	int id_subtarea;
	int id_tarea;

	/**
	 * Crea una subtarea con los parámetros necesarios.
	 * @param nombre es el nombre de la subtarea
	 * @param hecho Es un valor booleano de si la subtarea se encuentra hecha
	 * @param prioridad Es un entero que va desde 0 hasta 4 mostrando la prioridad que tiene
	 * @param id_subtarea es el id de la subtarea en cuestion
	 * @param id_tarea es el id de la tarea a la que pertenece la subtarea
	 */
	public Subtarea(String nombre, boolean hecho, Prioridad prioridad,int id_subtarea,int id_tarea) {
		super(nombre, hecho, prioridad);
		this.id_subtarea=id_subtarea;
		this.id_tarea = id_tarea;
	}

	public int getId_subtarea() {
		return id_subtarea;
	}
	public void setId_subtarea(int id_subtarea){
		this.id_subtarea = id_subtarea;
	}

	public int getId_tarea(){
		return id_tarea;
	}

	public void setId_tarea(int id_tarea){
		this.id_tarea=id_tarea;
	}
	@Override
	public String deEnumAString() {
		String s = getPrioridad().toString();
		return s;
	}

	@Override
	public String toString(){
		return getNombre();
	}

	@Override
	public boolean compararAlfabetico(Subtarea objeto) {
		boolean resultado= false;
		int compare = objeto.getNombre().compareTo(this.getNombre());
		if(compare<0)
			resultado = true;
		else if(compare>0)
			resultado = false;
		return resultado;
	}

	@Override
	public boolean compararBool(Subtarea objeto) {
		boolean resultado = false;
		if (this.isHecho()&&!objeto.isHecho())
			resultado = true;
		if(!this.isHecho()&&objeto.isHecho())
			resultado = false;
		return resultado;
	}

	@Override
	public boolean compararPrioridad(Subtarea objeto) {
		boolean resultado = false;
		int prioridadObjeto = dePrioridadAInt(objeto.getPrioridad());
		int prioridadThis = dePrioridadAInt(this.getPrioridad());
		if(prioridadObjeto>prioridadThis)
			resultado = true;
		else if(prioridadObjeto<prioridadThis){
			resultado = false;
		}
		return resultado;
	}
	public int dePrioridadAInt(Prioridad p){
		int prioridad = 1;
		if(p.equals(Prioridad.Alta))
			prioridad=3;
		else if(p.equals(Prioridad.Media))
			prioridad = 2;
		else if(p.equals(Prioridad.Baja))
			prioridad = 1;
		return prioridad;
	}
}
