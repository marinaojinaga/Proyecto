package logicaDeDatos;


import java.util.ArrayList;

public class Proyecto {
	private String nombre;
	private boolean favorito;
	private int id_proyecto;
	private int id_usuario;
	
	public Proyecto(String nombre, boolean favorito,int id_proyecto,int id_usuario) {
		super();
		this.nombre = nombre;
		this.favorito = favorito;
		this.id_proyecto = id_proyecto;
		this.id_usuario = id_usuario;

	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public boolean isFavorito() {
		return favorito;
	}

	public void setFavorito(boolean favorito) {
		this.favorito = favorito;
	}

	public int getId_proyecto(){
		return id_proyecto;
	}

	public void setId_proyecto(int id_proyecto){
		this.id_proyecto = id_proyecto;
	}

	public int getId_usuario(){
		return id_usuario;
	}

	public void setId_usuario(int id_usuario){
		this.id_usuario = id_usuario;
	}

	@Override
	public String toString(){
		return getNombre();
	}
	
}
