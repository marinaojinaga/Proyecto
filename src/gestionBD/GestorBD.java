package gestionBD;

import logicaDeDatos.Proyecto;
import logicaDeDatos.Subtarea;
import logicaDeDatos.Tarea;
import logicaDeDatos.Usuario;
import logicaNegocio.GestorArrayLists;

import java.sql.*;

public class GestorBD {
    Connection conn = null;
    //HACER UNA CONEXIÓN
    private Connection conectarse() {
        try {
            String BDnombre  =  "jdbc:sqlite:BaseDeDatos.db";
            conn = DriverManager.getConnection(BDnombre);
        }catch (SQLException e){
            System.out.println("BadAss error creating connection. "+ e.getMessage());
        }
        return conn;
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
                + "mail TEXT NOT NULL \n"
                + ");";

        ejecutarStatement(sql);
        closeLink();
    }

    private void createNewTableSubtareas() throws SQLException {
        conectarse();

        String sql = "CREATE TABLE IF NOT EXISTS TablaSubtareas (\n"
                + "    id_subtareas INTEGER PRIMARY KEY,\n"
                + "    nombre VARCHAR NOT NULL,\n"
                + "    prioridad INTEGER NOT NULL,\n"
                + "    hecho BIT NOT NULL,\n"
                + "    FOREIGN KEY (id_tarea) REFERENCES TableTareas (id_tarea)"
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
                + "tareas TEXT NOT NULL \n"
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
            pstmt.setString(3,t.deEnumAString());
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
            pstmt.setString(3,s.deEnumAString());
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

    //SELECTS
    public void selectTareas() throws SQLException{
        String sql = "SELECT id,nombre, hecho,prioridad,descripcion,fechaLimite,fechaRealizacion,subtareas FROM tareas";
        try
                (
                        Connection conn = this.conectarse();
                        Statement stmt = conn.createStatement();
                        ResultSet rs = stmt.executeQuery(sql)
                        )
        {
            while(rs.next()){
                System.out.println(
                        rs.getInt("id") + "\t"+
                        rs.getString("nombre")+ "\t"+
                        rs.getInt("hecho")+ "\t"+
                        rs.getInt("prioridad")+ "\t"+
                        rs.getString("descripcion")+ "\t"+
                        rs.getDate("fechaLimite")+ "\t"+
                        rs.getDate("fechaRealizacion")+ "\t"+
                        rs.getString("subtareas"));
            }
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public void selectUsuario() throws SQLException{
        String sql = "SELECT id,nickUsuario,contrasena,nombre,mail FROM usuarios";
        try
                (
                        Connection conn = this.conectarse();
                        Statement stmt = conn.createStatement();
                        ResultSet rs = stmt.executeQuery(sql)
                )
        {
            while (rs.next())
            {
                System.out.println(
                        rs.getInt("id") + "\t" +
                                rs.getString("nickUsuario") + "\t" +
                                rs.getString("contrasena") + "\t" +
                                rs.getString("nombre") + "\t" +
                                rs.getString("mail"));
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void selectSubtareas(){
        String sql = "SELECT id,nombre,hecho,prioridad FROM subtareas";
        try
                (
                        Connection conn = this.conectarse();
                        Statement stmt = conn.createStatement();
                        ResultSet rs = stmt.executeQuery(sql)
                        )
        {
            while (rs.next()){
                System.out.println(
                        rs.getInt("id")+"\t"+
                        rs.getString("nombre")+"\t"+
                        rs.getInt("hecho")+"\t"+
                        rs.getInt("prioridad")
                );
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void selectProyecto(){
        String sql = "SELECT id,nombre,favorito,usuarios,tareas FROM proyectos";
        try
                (
                        Connection conn = this.conectarse();
                        Statement stmt = conn.createStatement();
                        ResultSet rs = stmt.executeQuery(sql)
                        )
        {
            while (rs.next()){
                System.out.println(
                        rs.getInt("id")+"/t"+
                        rs.getString("nombre")+"/t"+
                        rs.getInt("favorito")+"/t"+
                        rs.getString("usuarios")+"/t"+
                        rs.getString("tareas")
                );
            }
        }
        catch (SQLException e){
            e.getStackTrace();
        }
    }

    public static void main(String[] args) throws SQLException{
        GestorBD gestorBD = new GestorBD();
        gestorBD.createNewTableProyecto();
        gestorBD.createNewTableSubtareas();
        gestorBD.createNewTableTareas();
        gestorBD.createNewTableUsuario();
    }

}
