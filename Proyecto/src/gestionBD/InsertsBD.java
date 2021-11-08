package gestionBD;

import java.sql.*;
import java.util.ArrayList;

/**
 * 
 * @author Marina Ojinaga
 * @author sqlitetutorial.net
 */

public class InsertsBD {
	
	 private Connection connect()
	    {
	        // SQLite connection string
		 	String name = "Proyecto";
	        String url = "jdbc:sqlite:"+name;
	        Connection conn = null;

	        try
	        {
	            conn = DriverManager.getConnection(url);
	        } catch (SQLException e)
	        {
	            System.out.println(e.getMessage());
	        }

	        return conn;
	    }
	 
	 public void insertToSubtareas(String nombre, boolean hecho,int prioridad)
	    {
	        String sql = "INSERT INTO subtareas(nombre,hecho,prioridad) VALUES(?,?,?)";

	        try
	                (
	                        Connection conn = this.connect();
	                        PreparedStatement pstmt = conn.prepareStatement(sql)
	                )
	        {
	            pstmt.setString(1, nombre);
	            pstmt.setBoolean(2, hecho);
	            pstmt.setInt(3, prioridad);
	            pstmt.executeUpdate();
	        }
	        catch (SQLException e)
	        {
	            System.out.println(e.getMessage());
	        }
	    }
	 public void insertToTareas(String nombre, int hecho, int prioridad, String descripcion, float fLimite, float fRealizacion, String subtareas)
	    {
	        String sql = "INSERT INTO tareas(nombre,hecho,prioridad,descripcion,fechaLimite,fechaRealizacion,subtareas) VALUES(?,?,?,?,?,?,?)";

	        try
	                (
	                        Connection conn = this.connect();
	                        PreparedStatement pstmt = conn.prepareStatement(sql)
	                )
	        {
	            pstmt.setString(1, nombre);
	            pstmt.setInt(2, hecho);
	            pstmt.setInt(3, prioridad);
	            pstmt.setString(4, descripcion);
	            pstmt.setFloat(5, fLimite);
	            pstmt.setFloat(6, fRealizacion);
	            pstmt.setString(7, subtareas);
	            pstmt.executeUpdate();
	        }
	        catch (SQLException e)
	        {
	            System.out.println(e.getMessage());
	        }
	    }
	 
	 public void insertToUsuario(String nickUsuario, String contrasena, String nombre, String mail)
	    {
	        String sql = "INSERT INTO usuarios(nick,contrasena,nombre,mail) VALUES(?,?,?,?)";

	        try
	                (
	                        Connection conn = this.connect();
	                        PreparedStatement pstmt = conn.prepareStatement(sql)
	                )
	        {
	            pstmt.setString(1, nickUsuario);
	            pstmt.setString(2, contrasena);
	            pstmt.setString(3, nombre);
	            pstmt.setString(4, mail);
	            pstmt.executeUpdate();
	        }
	        catch (SQLException e)
	        {
	            System.out.println(e.getMessage());
	        }
	    }
	 
	public void insertToProyecto(String nombre, int favorito, String usuarios, String tareas)
    {
        String sql = "INSERT INTO proyectos(nombre,favorito,usuarios,tareas) VALUES(?,?,?,?)";

        try
                (
                        Connection conn = this.connect();
                        PreparedStatement pstmt = conn.prepareStatement(sql)
                )
        {
            pstmt.setString(1, nombre);
            pstmt.setInt(2, favorito);
            pstmt.setString(3, usuarios);
            pstmt.setString(4, tareas);
            pstmt.executeUpdate();
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }

	

}
