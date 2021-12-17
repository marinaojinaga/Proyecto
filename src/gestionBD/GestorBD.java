package gestionBD;

import logicaDeDatos.Proyecto;
import logicaDeDatos.Subtarea;
import logicaDeDatos.Tarea;
import logicaDeDatos.Usuario;
import logicaNegocio.GestorArrayLists;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;

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

    private void verNombre () throws SQLException {
        conectarse();
        DatabaseMetaData md = conn.getMetaData();
        ResultSet rs = md.getTables(null, null, "%", null);
        while (rs.next()) {
            System.out.println(rs.getString(3));
        }
        closeLink();
    }

    //CREATE TABLES
    private void createNewTableTareas() throws SQLException {
        conectarse();

        String sql = "CREATE TABLE IF NOT EXISTS TAREAS (\n"
                + "    ID_TAREAS INTEGER PRIMARY KEY,\n"
                + "    nombre TEXT NOT NULL,\n"
                + "    hecho INTEGER NOT NULL,\n"
                + "    prioridad TEXT NOT NULL,\n"
                + "    descripcion TEXT NOT NULL,\n"
                + "    ID_PROYECTOS INTEGER REFERENCES PROYECTOS(ID_PROYECTOS) ON DELETE CASCADE "
                + ");";

        ejecutarStatement(sql);
        closeLink();
    }

    private void createNewTableUsuario() throws SQLException {
        conectarse();

        String sql = "CREATE TABLE IF NOT EXISTS usuarios (\n"
                +" ID_USUARIOS INTEGER PRIMARY KEY, \n"
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
        String sql = "CREATE TABLE IF NOT EXISTS SUBTAREAS (\n"
                + "    ID_SUBTAREAS INTEGER PRIMARY KEY,\n"
                + "    nombre TEXT NOT NULL,\n"
                + "    prioridad TEXT NOT NULL,\n"
                + "    hecho INTEGER NOT NULL,\n"
                + "    ID_TAREA INTEGER REFERENCES TAREAS (ID_TAREAS) ON DELETE CASCADE"
                + ");";

        ejecutarStatement(sql);
        closeLink();
    }

    private void createNewTableProyecto() throws SQLException{
        conectarse();

        String sql = "CREATE TABLE IF NOT EXISTS PROYECTOS (\n"
                +" ID_PROYECTOS INTEGER PRIMARY KEY, \n"
                + "NOMBRE TEXT NOT NULL, \n"
                + "FAVORITO INTEGER NOT NULL, \n"
                + "ID_USUARIO INTEGER REFERENCES USUARIOS(ID) ON DELETE CASCADE"
                + ");";

        ejecutarStatement(sql);
        closeLink();
    }

    //BORRAR TABLAS
    private void deleteTareas() throws SQLException {
        conectarse();

        String sql = "DROP TABLE Tareas;";

        ejecutarStatement(sql);
        closeLink();
    }

    private void deleteSubtareas() throws SQLException {
        conectarse();

        String sql = "DROP TABLE SUBTAREAS;";

        ejecutarStatement(sql);
        closeLink();
    }

    private void deleteProyectos() throws SQLException {
        conectarse();

        String sql = "DROP TABLE PROYECTOS;";

        ejecutarStatement(sql);
        closeLink();
    }

    private void deleteUsuarios() throws SQLException {
        conectarse();

        String sql = "DROP TABLE USUARIOS;";

        ejecutarStatement(sql);
        closeLink();
    }

    //Inserts
    public void insertTarea(Tarea t)
    {
        conectarse();
        String sql = "INSERT INTO tareas(nombre,hecho,prioridad,descripcion,ID_PROYECTOS)"
                +"VALUES(?,?,?,?,?)";

        try
                (
                        PreparedStatement pstmt = conn.prepareStatement(sql)
                        )
        {
            GestorArrayLists g = new GestorArrayLists();

            pstmt.setString(1,t.getNombre());
            pstmt.setBoolean(2, t.isHecho());
            pstmt.setString(3,t.deEnumAString());
            pstmt.setString(4, t.getDescripcion());
            pstmt.setInt(5,t.getId_proyecto());
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
        String sql = "INSERT INTO subtareas(nombre,hecho,prioridad,id_tarea) VALUES (?,?,?,?)";
        try(
                PreparedStatement pstmt = conn.prepareStatement(sql);
                )
        {
            pstmt.setString(1,s.getNombre());
            pstmt.setBoolean(2,s.isHecho());
            pstmt.setString(3,s.deEnumAString());
            pstmt.setInt(4,s.getId_tarea());
            pstmt.executeUpdate();
            closeLink();
        }catch (SQLException e) {
            System.out.println("BadAss error executing insert. " + e.getMessage());
        }
    }

    public void insertProyecto(Proyecto p){
        conectarse();
        String sql = "INSERT INTO proyectos(nombre,favorito,id_usuario) VALUES (?,?,?)";
        try(
                PreparedStatement pstmt = conn.prepareStatement(sql);
                )
        {
            GestorArrayLists g = new GestorArrayLists();
            pstmt.setString(1,p.getNombre());
            pstmt.setBoolean(2,p.isFavorito());
            pstmt.setInt(3,p.getId_usuario());
            pstmt.executeUpdate();
            closeLink();
        }catch (SQLException e){
            System.out.println("BadAss error executing insert "+e.getMessage());
        }
    }

    //SELECTS
    public ArrayList<String> selectTareas() throws SQLException{
        String sql = "SELECT id_tarea,nombre, hecho,prioridad,descripcion,id_proyectos FROM TAREAS";
        ArrayList<String> s = new ArrayList<String>();
        try
                (
                        Connection conn = this.conectarse();
                        Statement stmt = conn.createStatement();
                        ResultSet rs = stmt.executeQuery(sql)
                        )
        {
            while(rs.next()){
                s.add(
                        rs.getInt("id_tarea")+ "\t"+
                        rs.getString("nombre")+ "\t"+
                        rs.getInt("hecho")+ "\t"+
                        rs.getString("prioridad")+ "\t"+
                        rs.getString("descripcion")+ "\t"+
                        rs.getInt("id_proyectos")+ "\t");
            }
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return s;
    }

    public ArrayList<String> selectUsuario() throws SQLException{
        String sql = "SELECT id_usuarios,nickUsuario,contrasena,nombre,mail FROM usuarios";
        ArrayList<String> r = new ArrayList<String>();
        try
                (
                        Connection conn = this.conectarse();
                        Statement stmt = conn.createStatement();
                        ResultSet rs = stmt.executeQuery(sql)
                )
        {
            while (rs.next())
            {
                r.add(
                                rs.getInt("id_usuarios") + "\t" +
                                rs.getString("nickUsuario") + "\t" +
                                rs.getString("contrasena") + "\t" +
                                rs.getString("nombre") + "\t" +
                                rs.getString("mail"));
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return r;
    }

    public ArrayList<String> selectSubtareas(){
        String sql = "SELECT id_subtareas,nombre,prioridad,hecho,id_tarea FROM subtareas";
        ArrayList<String > s = new ArrayList<String>();
        try
                (
                        Connection conn = this.conectarse();
                        Statement stmt = conn.createStatement();
                        ResultSet rs = stmt.executeQuery(sql)
                        )
        {
            while (rs.next()){
                s.add(
                        rs.getInt("id_subtareas")+"\t"+
                        rs.getString("nombre")+"\t"+
                        rs.getInt("hecho")+"\t"+
                        rs.getString("prioridad") +"\t"+
                        rs.getInt("id_tarea")
                );
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return s;
    }

    public ArrayList<String> selectProyecto(){
        String sql = "SELECT id_proyectos,nombre,favorito,id_usuario FROM proyectos";
        ArrayList<String> s = new ArrayList<String>();
        try
                (
                        Connection conn = this.conectarse();
                        Statement stmt = conn.createStatement();
                        ResultSet rs = stmt.executeQuery(sql)
                        )
        {
            while (rs.next()){
                s.add(
                        rs.getInt("id_proyectos")+"\t"+
                        rs.getString("nombre")+"\t"+
                        rs.getInt("favorito")+"\t"+
                        rs.getInt("id_usuario")
                );
            }
        }
        catch (SQLException e){
            e.getStackTrace();
        }
        return s;
    }

    public String getContrasena(String mail) {
        String sql = "SELECT contrasena FROM usuarios WHERE mail = ?";
        String s="";
        try
                (
                        Connection conn = this.conectarse();
                        PreparedStatement pstmt = conn.prepareStatement(sql);
                )
        {
            pstmt.setString(1,mail);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next())
            {
                s = rs.getString("contrasena");
            }
        }
        catch (SQLException e){
            e.printStackTrace();
            s = "";
        }
        return s;
    }

    public Usuario getusuario(String mail) {
        String sql = "SELECT id,nickUsuario,contrasena,nombre,mail FROM usuarios WHERE mail = ?";
        Usuario u = new Usuario("","","","",0);
        try
                (
                        Connection conn = this.conectarse();
                        PreparedStatement pstmt = conn.prepareStatement(sql);
                )
        {
            pstmt.setString(1,mail);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next())
            {
                u.setnickUsuario(rs.getString("nickUsuario"));
                u.setContrasenya(rs.getString("contrasena"));
                u.setNombre(rs.getString("nombre"));
                u.setMail(rs.getString("mail"));
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return u;
    }

    public int getIdUsuario(String mail) {
        String sql = "SELECT id FROM usuarios WHERE mail = ?";
        int i = 0;
        try
                (
                        Connection conn = this.conectarse();
                        PreparedStatement pstmt = conn.prepareStatement(sql);
                )
        {
            pstmt.setString(1,mail);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next())
            {
                i = rs.getInt("id");
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return i;
    }

    public static void main(String[] args) throws SQLException{
        GestorBD gestorBD = new GestorBD();
        Proyecto p1 = new Proyecto("Macro", true,1,1);
        Proyecto p2 = new Proyecto("Practicas",false,2,1);
        Proyecto p3 = new Proyecto("Inglés",false,3,1);
        Proyecto p4 = new Proyecto("Program",true,4,2);
        Proyecto p5 = new Proyecto("Clases",false,5,2);
        Proyecto p6 = new Proyecto("Frances",true,6,2);
        Proyecto p7 = new Proyecto("Mates",false,7,3);
        Proyecto p8 = new Proyecto("Lengua",true,8,3);
        Proyecto p9 = new Proyecto("Alemas",false,9,3);
        gestorBD.insertProyecto(p1);
        gestorBD.insertProyecto(p2);
        gestorBD.insertProyecto(p3);
        gestorBD.insertProyecto(p4);
        gestorBD.insertProyecto(p5);
        gestorBD.insertProyecto(p6);
        gestorBD.insertProyecto(p7);
        gestorBD.insertProyecto(p8);
        gestorBD.insertProyecto(p9);

    }

}
