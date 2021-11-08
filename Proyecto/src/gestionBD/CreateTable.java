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
	
	public static void createTableSubtareas(String name)
    {
        // SQLite connection string
        String url = "jdbc:sqlite:" + name;

        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS subtareas (\n"
                + "    id integer PRIMARY KEY,\n"
                + "    nombre text NOT NULL,\n"
                + "    hecho boolean NOT NULL\n"
                + "    prioridad hecho NOT NULL\n"
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
	
	public static void createTableTareas(String name)
    {
        // SQLite connection string
        String url = "jdbc:sqlite:" + name;

        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS subtareas (\n"
                + "    id integer PRIMARY KEY,\n"
                + "    nombre text NOT NULL,\n"
                + "    hecho boolean NOT NULL\n"
                + "    prioridad hecho NOT NULL\n"
                + "    descripcion text NOT NULL,\n"
                /*dates*
                 * ArrayList
                 */
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
	
	public static void createTableUsuarios(String name)
    {
        // SQLite connection string
        String url = "jdbc:sqlite:" + name;

        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS subtareas (\n"
                + "    id integer PRIMARY KEY,\n"
                + "    nickUsuario text NOT NULL,\n"
                + "    contrasena text NOT NULL\n"
                + "    nombre text NOT NULL\n"
                + "    mail text NOT NULL\n"
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
	
	public static void createTableProyectos(String name)
    {
        // SQLite connection string
        String url = "jdbc:sqlite:" + name;

        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS subtareas (\n"
                + "    id integer PRIMARY KEY,\n"
                + "    nombre text NOT NULL,\n"
                + "    favorito boolean NOT NULL\n"
                /*Usuarios y arraylist*/
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
