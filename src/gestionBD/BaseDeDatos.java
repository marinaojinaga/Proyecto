package gestionBD;

import java.sql.*;
import java.util.List;

public class BaseDeDatos {
	 private Connection conn;
	 private String BDname;
	 private final String URL = "jdbc:sqlite:";
	 
	public BaseDeDatos(Connection conn, String bDname) {
		this.BDname = this.URL + BDname;
	}
	 
	public void createLink() throws SQLException
    {
        try
        {
            this.conn = DriverManager.getConnection(this.BDname);
        }
        catch (SQLException e)
        {
            System.out.println("BadAss error creating connection. " + e.getMessage());
        }
    }
	
	 public void createNewTableUsuarios() throws SQLException
	    {
	        // SQL statement for creating a new table
	        String sql = "CREATE TABLE IF NOT EXISTS TablaUsuarios (\n"
	                + "    id_usuario INTEGER PRIMARY KEY,\n"
	                + "    nickUsuario VARCHAR NOT NULL,\n"
	                + "    contrasena VARCHAR NOT NULL,\n"
	                + "    nombre VARCHAR NOT NULL\n"
	                + "    mail VARCHAR NOT NULL\n"
	                + ");";

	        try
	                (
	                        // This is a try with resources syntax, resources taken here will be automatically freed at the end of the try block
	                        Statement stmt = this.conn.createStatement()
	                )
	        {
	            // create a new table
	            boolean result = stmt.execute(sql);
	        }
	        catch (SQLException e)
	        {
	            System.out.println("BadAss error creating table. " + e.getMessage());
	            System.out.println(sql);
	        }
	    }
	 
	 public void createNewTableTareas() throws SQLException
	    {
	        // SQL statement for creating a new table
	        String sql = "CREATE TABLE IF NOT EXISTS TablaTareas (\n"
	                + "    id_table INTEGER PRIMARY KEY,\n"
	                + "    nombre VARCHAR NOT NULL,\n"
	                + "    hecho BIT NOT NULL,\n"
	                + "    prioridad INTEGER NOT NULL,\n"
	                + "    descripcion VARCHAR NOT NULL,\n"
	                + "    fechaLimite TIMESTAMP NOT NULL,\n"
	                + "    fechaRealizacion TIMESTAMP NOT NULL\n"
	                + "    id_proyectos INTEGER NOT NULL, "
					+ "    FOREIGN KEY (id_proyectos) REFERENCES TablaProyectos(id_proyectos)"
	                + ");";

	        try
	                (
	                        // This is a try with resources syntax, resources taken here will be automatically freed at the end of the try block
	                        Statement stmt = this.conn.createStatement()
	                )
	        {
	            // create a new table
	            boolean result = stmt.execute(sql);
	        }
	        catch (SQLException e)
	        {
	            System.out.println("BadAss error creating table. " + e.getMessage());
	            System.out.println(sql);
	        }
	    }
	 
	 public void createNewTableSubtareas() throws SQLException
	    {
	        // SQL statement for creating a new table
	        String sql = "CREATE TABLE IF NOT EXISTS TablaSubtareas (\n"
	                + "    id_subtareas INTEGER PRIMARY KEY,\n"
	                + "    nombre VARCHAR NOT NULL,\n"
	                + "    prioridad INTEGER NOT NULL,\n"
	                + "    hecho BIT NOT NULL,\n"
					+ "    FOREIGN KEY (id_tarea) REFERENCES TableTareas (id_tarea)"
	                + ");";

	        try
	                (
	                        // This is a try with resources syntax, resources taken here will be automatically freed at the end of the try block
	                        Statement stmt = this.conn.createStatement()
	                )
	        {
	            // create a new table
	            boolean result = stmt.execute(sql);
	        }
	        catch (SQLException e)
	        {
	            System.out.println("BadAss error creating table. " + e.getMessage());
	            System.out.println(sql);
	        }
	    }
	 
	 public void createNewTableProyectos() throws SQLException
	    {
	        // SQL statement for creating a new table
	        String sql = "CREATE TABLE IF NOT EXISTS TablaProyectos (\n"
	                + "    id_proyectos INTEGER PRIMARY KEY,\n"
	                + "    nombre VARCHAR NOT NULL,\n"
	                + "    favorit BIT NOT NULL,\n"
	                + "    hecho BIT NOT NULL,\n"
	                + ");";

	        try
	                (
	                        // This is a try with resources syntax, resources taken here will be automatically freed at the end of the try block
	                        Statement stmt = this.conn.createStatement()
	                )
	        {
	            // create a new table
	            boolean result = stmt.execute(sql);
	        }
	        catch (SQLException e)
	        {
	            System.out.println("BadAss error creating table. " + e.getMessage());
	            System.out.println(sql);
	        }
	    }
	 
	 /*public void saveData(List<String> data) throws SQLException
	    {
	        for (String current : data)
	        {
	            this.insert(current);
	        }
	    }*/
	 
	 
	 

}
