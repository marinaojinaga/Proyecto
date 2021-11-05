package gestionBD;

import java.sql.*;

public class CreateBD {
	
	public static void crearNuevaBasedeDatos (String nombre) {
		String url = "jbdc:sqlite:"+nombre;
		
		try (Connection conn = DriverManager.getConnection(url)){
			if (conn !=null) {
				DatabaseMetaData meta = conn.getMetaData();
				System.out.println("El nombre del driver es"+meta.getDriverName());
				System.out.println("Has creado una nueva base de datos");
			}
		}catch (SQLException e) {
				// TODO: handle exception
				System.out.println(e.getMessage());
			}
	}
}
	
