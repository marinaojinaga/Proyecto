package gestionBD;

import java.sql.*;

/**
 * Crear tablas
 * @author Marina Ojinaga
 * @version 1.0
 * @since 1.0
 *
 */

public class CreateTable {
	
	public static void createTableSubtareas()
    {
        // SQLite connection string
        String url = "jdbc:sqlite:" + "proyecto";

        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS subtareas (\n"
                + "    id integer PRIMARY KEY,\n"
                + "    nombre text NOT NULL,\n"
                + "    hecho integer NOT NULL,\n"
                + "    prioridad integer NOT NULL\n"
                + ");";

        try
                (
                        Connection conn = DriverManager.getConnection(url);
                        Statement stmt = conn.createStatement()
                )
        {
            // create a new table
            stmt.execute(sql);
        } catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }
	
	public static void createTableTareas()
    {
        // SQLite connection string
        String url = "jdbc:sqlite:" + "proyecto";

        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS tareas (\n"
                + "    id integer PRIMARY KEY,\n"
                + "    nombre text NOT NULL,\n"
                + "    hecho int NOT NULL\n"
                + "    prioridad int NOT NULL\n"
                + "    descripcion text NOT NULL,\n"
                + "    fechaLimite real NOT NULL, \n"
                + "    fechaRealizacion real NOT NULL, \n"
                + "    subtareas text NOT NULL \n"
                + ");";

        try
                (
                        Connection conn = DriverManager.getConnection(url);
                        Statement stmt = conn.createStatement()
                )
        {
            // create a new table
            stmt.execute(sql);
        } catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }
	
	public static void createTableUsuarios()
    {
        // SQLite connection string
        String url = "jdbc:sqlite:" + "proyecto";

        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS usuarios (\n"
                + "    id integer PRIMARY KEY,\n"
                + "    nickUsuario text NOT NULL,\n"
                + "    contrasena text NOT NULL,\n"
                + "    nombre text NOT NULL,\n"
                + "    mail text NOT NULL,\n"
                + ");";

        try
                (
                        Connection conn = DriverManager.getConnection(url);
                        Statement stmt = conn.createStatement()
                )
        {
            // create a new table
            stmt.execute(sql);
        } catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }
	
	public static void createTableProyectos()
    {
        // SQLite connection string
        String url = "jdbc:sqlite:" + "proyecto";

        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS proyectos (\n"
                + "    id integer PRIMARY KEY,\n"
                + "    nombre text NOT NULL,\n"
                + "    favorito integer NOT NULL,\n"
                + "    usuarios text NOT NULL,\n"
                + "    tareas text NOT NULL \n"
                + ");";

        try
                (
                        Connection conn = DriverManager.getConnection(url);
                        Statement stmt = conn.createStatement()
                )
        {
            // create a new table
            stmt.execute(sql);
        } catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }

}
