package gestionBD;

import logicaDeDatos.Proyecto;
import logicaDeDatos.Subtarea;
import logicaDeDatos.Tarea;
import logicaDeDatos.Usuario;
import logicaNegocio.GestorArrayLists;
import org.sqlite.util.StringUtils;

import java.sql.*;
import java.text.ParseException;

public class GestorBD {
    private Connection conn;

    //HACER UNA CONEXI�N
    private void conectarse() {
        try {
            String BDnombre  =  "jdbc:sqlite:BaseDeDatos.db";
            this.conn = DriverManager.getConnection(BDnombre);
        }catch (SQLException e){
            System.out.println("BadAss error creating connection. "+ e.getMessage());
        }

    }

    //EJECUTAR UN STATEMENT
    private void ejecutarStatement(String sql) throws SQLException {
        Statement stmt = this.conn.createStatement();
        try
        {
            boolean result =  stmt.execute(sql);

        }catch (SQLException e) {
            System.out.println("BadAss error creating table "+e.getMessage());
            System.out.println(sql);
        }

    }

    //CERRAR LA CONNEXION
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

    //CREATE TABLES
    private void createNewTableTareas() throws SQLException {
        conectarse();

        String sql = "CREATE TABLE IF NOT EXISTS tareas (\n"
                +" id INTEGER PRIMARY KEY, \n"
                + "nombre TEXT NOT NULL, \n"
                + "hecho INTEGER NOT NULL, \n"
                + "prioridad INTEGER NOT NULL, \n"
                + "descripcion TEXT NOT NULL, \n"
                + "fechaLimite DATETIME NOT NULL, \n"
                + "fechaRealizacion DATE NOT NULL, \n"
                + "subtareas TEXT NOT NULL, \n"
                + ");";

        ejecutarStatement(sql);
        closeLink();
    }
    private void createNewTableUsuario() throws SQLException {
        conectarse();

        String sql = "CREATE TABLE IF NOT EXISTS usuarios (\n"
                +" id INTEGER PRIMARY KEY, \n"
                + "nickUsuario TEXT NOT NULL, \n"
                + "contrasena TEXT NOT NULL, \n"
                + "nombre TEXT NOT NULL, \n"
                + "mail TEXT NOT NULL, \n"
                + ");";

        ejecutarStatement(sql);
        closeLink();
    }

    private void createNewTableSubtareas() throws SQLException {
        conectarse();

        String sql = "CREATE TABLE IF NOT EXISTS subtareas (\n"
                +" id INTEGER PRIMARY KEY, \n"
                + "nombre TEXT NOT NULL, \n"
                + "hecho INTEGER NOT NULL, \n"
                + "prioridad INTEGER NOT NULL, \n"
                + ");";

        ejecutarStatement(sql);
        closeLink();
    }

    private void createNewTableProyecto() throws SQLException{
        conectarse();

        String sql = "CREATE TABLE IF NOT EXISTS proyectos (\n"
                +" id INTEGER PRIMARY KEY, \n"
                + "nombre TEXT NOT NULL, \n"
                + "favorito INTEGER NOT NULL, \n"
                + "usuarios TEXT NOT NULL, \n"
                + "tareas TEXT NOT NULL, \n"
                + ");";

        ejecutarStatement(sql);
        closeLink();
    }

    //Inserts
    public void insertTarea(Tarea t)
    {
        conectarse();
        String sql = "INSERT INTO tareas(nombre,hecho,prioridad,descripcion,fechaLimite,fechaRealizacion,subtareas)"
                +"VALUES(?,?,?,?,?,?,?)";

        try
                (
                        PreparedStatement pstmt = conn.prepareStatement(sql)
                        )
        {
            Date d2 = (Date)t.getFechaRealizacion().getTime();
            Date d1 = (Date) t.getFechaLimite().getTime();
            GestorArrayLists g = new GestorArrayLists();

            pstmt.setString(1,t.getNombre());
            pstmt.setBoolean(2, t.isHecho());
            pstmt.setInt(3,t.getPrioridad());
            pstmt.setString(4, t.getDescripcion());
            pstmt.setDate(5,d1);
            pstmt.setDate(6,d2);
            pstmt.setString(7,g.ArrayListSubtareas(t.getSubtareas()));
            pstmt.executeUpdate();
            closeLink();


        } catch (SQLException e) {
            System.out.println("BadAss error executing insert. "+e.getMessage());
        }
    }

    public void insertUsuarios(Usuario u){
        conectarse();
        String sql = "INSERT INTO usuarios(nickUsuario,contrasena,nombre,mail) VALUES (?,?,?,?)";
        conectarse();
        try
                (
                        PreparedStatement pstmt = conn.prepareStatement(sql);
                        )
        {
            pstmt.setString(1,u.getnickUsuario());
            pstmt.setString(2,u.getContrasena());
            pstmt.setString(3,u.getNombre());
            pstmt.setString(4,u.getMail());
            pstmt.executeUpdate();
            closeLink();
        }
        catch (SQLException e){
            System.out.println("BadAss error executing insert. "+e.getMessage());
        }
    }

    public void insertSubtareas(Subtarea s){
        conectarse();
        String sql = "INSERT INTO subtareas(nombre,hecho,prioridad) VALUES (?,?,?)";
        try(
                PreparedStatement pstmt = conn.prepareStatement(sql);
                )
        {
            pstmt.setString(1,s.getNombre());
            pstmt.setBoolean(2,s.isHecho());
            pstmt.setInt(3,s.getPrioridad());
            pstmt.executeUpdate();
            closeLink();
        }catch (SQLException e) {
            System.out.println("BadAss error executing insert. " + e.getMessage());
        }
    }

    public void insertProyecto(Proyecto p){
        conectarse();
        String sql = "INSERT INTO proyectos(nombre,favorito,usuarios,tareas) VALUES (?,?,?,?)";
        try(
                PreparedStatement pstmt = conn.prepareStatement(sql);
                )
        {
            GestorArrayLists g = new GestorArrayLists();
            pstmt.setString(1,p.getNombre());
            pstmt.setBoolean(2,p.isFavorito());
            pstmt.setString(3,g.ArrayListUsuarios(p.getUsuarios()));
            pstmt.setString(4,g.ArrayListTareas(p.getTareas()));
            pstmt.executeUpdate();
            closeLink();
        }catch (SQLException e){
            System.out.println("BadAss error executing insert "+e.getMessage());
        }
    }

}
