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
	                + "    id INTEGER PRIMARY KEY,\n"
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
	                + "    id INTEGER PRIMARY KEY,\n"
	                + "    nombre VARCHAR NOT NULL,\n"
	                + "    hecho BIT NOT NULL,\n"
	                + "    prioridad INTEGER NOT NULL,\n"
	                + "    descripcion VARCHAR NOT NULL,\n"
	                + "    fechaLimite TIMESTAMP NOT NULL,\n"
	                + "    fechaRealizacion TIMESTAMP NOT NULL\n"
	               /* + "    subtareas ? NOT NULL\n"*/
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
	                + "    id INTEGER PRIMARY KEY,\n"
	                + "    nombre VARCHAR NOT NULL,\n"
	                + "    prioridad INTEGER NOT NULL,\n"
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
	 
	 public void createNewTableProyectos() throws SQLException
	    {
	        // SQL statement for creating a new table
	        String sql = "CREATE TABLE IF NOT EXISTS TablaProyectos (\n"
	                + "    id INTEGER PRIMARY KEY,\n"
	                + "    nombre VARCHAR NOT NULL,\n"
	                + "    favorit BIT NOT NULL,\n"
	               /* + "  Usuarios ? NOT NULL,\n"*/
	                /* + "  tareas ? NOT NULL,\n"*/
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
