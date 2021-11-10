package gestionBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CerrarBD {
	private Connection conn;
	private String BDname = "proyecto.bd";
	private final String URL = "jdbc:sqlite:";
	
	 public void createLink() throws SQLException
	    {
		 	this.BDname = this.URL + BDname;
	        try
	        {
	            this.conn = DriverManager.getConnection(this.BDname);
	        }
	        catch (SQLException e)
	        {
	            System.out.println("BadAss error creating connection. " + e.getMessage());
	        }
	    }
	
	public void closeLink() throws SQLException
    {
        try
        {
            if (this.conn != null)
            {
                this.conn.close();
            }
        }
        catch (SQLException ex)
        {
            System.out.println("BadAss error closing connection" + ex.getMessage());
        }
    }

}
