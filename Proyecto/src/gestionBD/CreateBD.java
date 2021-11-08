package gestionBD;

import java.sql.*;

/**
 * Clase para crear la base de datos
 * @author sqlitetutorial.net
 * @version 1.0
 * @since 1.0
 */

public class CreateBD {
	
	public static void crearNuevaBasedeDatos () {
		String url = "jbdc:sqlite:"+"Proyecto";
		
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
	
