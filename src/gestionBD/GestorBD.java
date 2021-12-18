package gestionBD;

import com.sun.org.apache.xpath.internal.operations.Bool;
import logicaDeDatos.*;
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
        conn = conectarse();
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
        conn = conectarse();

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
    public ArrayList<Tarea> selectTareas() throws SQLException{
        String sql = "SELECT id_tareas,nombre, hecho,prioridad,descripcion,id_proyectos FROM TAREAS";
        ArrayList<Tarea> s = new ArrayList<Tarea>();
        try
                (
                        Connection conn = this.conectarse();
                        Statement stmt = conn.createStatement();
                        ResultSet rs = stmt.executeQuery(sql)
                        )
        {
            while(rs.next()){
                        int id_tarea = rs.getInt("id_tareas");
                        String nombre = rs.getString("nombre");
                        boolean hecho = rs.getBoolean("hecho");
                        Prioridad prioridad = deStringAPrioridad(rs.getString("prioridad"));
                        String descripcion = rs.getString("descripcion");
                        int id_proyectos = rs.getInt("id_proyectos");
                        Tarea t = new Tarea(nombre,hecho,prioridad,descripcion,id_tarea,id_proyectos);
                        s.add(t);
            }
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return s;
    }

    public ArrayList<Usuario> selectUsuario() throws SQLException{
        String sql = "SELECT id_usuarios,nickUsuario,contrasena,nombre,mail FROM usuarios";
        ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
        try
                (
                        Connection conn = this.conectarse();
                        Statement stmt = conn.createStatement();
                        ResultSet rs = stmt.executeQuery(sql)
                )
        {
            while (rs.next())
            {

                int id = rs.getInt("id_usuarios");
                String nick = rs.getString("nickUsuario");
                String contra = rs.getString("contrasena");
                String nombre = rs.getString("nombre");
                String mail = rs.getString("mail");
                Usuario u = new Usuario(nick,contra,nombre,mail,id);
                usuarios.add(u);
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return usuarios;
    }

    public ArrayList<Subtarea> selectSubtareas(){
        String sql = "SELECT id_subtareas,nombre,prioridad,hecho,id_tarea FROM subtareas";
        ArrayList<Subtarea > s = new ArrayList<Subtarea>();
        try
                (
                        Connection conn = this.conectarse();
                        Statement stmt = conn.createStatement();
                        ResultSet rs = stmt.executeQuery(sql)
                        )
        {
            while (rs.next()){
                        int id_subtarea = rs.getInt("id_subtareas");
                        String nombre = rs.getString("nombre");
                        Boolean hecho = rs.getBoolean("hecho");
                        Prioridad prioridad = deStringAPrioridad(rs.getString("prioridad"));
                        int id_tarea = rs.getInt("id_tarea");
                        Subtarea subtarea = new Subtarea(nombre,hecho,prioridad,id_subtarea,id_tarea);
                        s.add(subtarea);
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return s;
    }

    public ArrayList<Proyecto> selectProyecto(){
        String sql = "SELECT id_proyectos,nombre,favorito,id_usuario FROM proyectos";
        ArrayList<Proyecto> s = new ArrayList<Proyecto>();
        try
                (
                        Connection conn = this.conectarse();
                        Statement stmt = conn.createStatement();
                        ResultSet rs = stmt.executeQuery(sql)
                        )
        {
            while (rs.next()){

                int id_proyecto = rs.getInt("id_proyectos");
                String nombre = rs.getString("nombre");
                boolean favorito = rs.getBoolean("favorito");
                int id_usuario = rs.getInt("id_usuario");
                Proyecto proyecto = new Proyecto(nombre,favorito,id_proyecto,id_usuario);
                s.add(proyecto);
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
        String sql = "SELECT ID_USUARIOS,nickUsuario,contrasena,nombre,mail FROM usuarios WHERE mail = ?";
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
                u.setId_usuario(rs.getInt("ID_USUARIOS"));
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

    public void eliminarUsuario(int id) {
        String sql = "DELETE FROM usuarios WHERE id_usuarios = ?";
        try (Connection conn = this.conectarse();
                PreparedStatement pstm = conn.prepareStatement(sql)) {
            pstm.setInt(1, id);
            pstm.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) throws SQLException{
        GestorBD gestorBD = new GestorBD();
        gestorBD.updateProyecto(true,5);
    }

    public Prioridad deStringAPrioridad(String a){
        Prioridad p = Prioridad.Baja;
        if(a.equals("Alta")){
            p = Prioridad.Alta;
        }else if(a.equals("Media")){
            p = Prioridad.Media;
        }else if(a.equals("Baja")){
            p = Prioridad.Baja;
        }
        return p;
    }

    //UPDATES
    public void updateProyecto(boolean favorito, int id_proyecto){
        String sql = "UPDATE PROYECTOS SET favorito = ? WHERE id_proyectos = ?";
        try
                (
                        Connection conn = this.conectarse();
                        PreparedStatement pstmt = conn.prepareStatement(sql);
                        )
        {
            pstmt.setBoolean(1,favorito);
            pstmt.setInt(2,id_proyecto);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void updateTareas(boolean hecho, Prioridad p, int id_tarea){
        String sql = "UPDATE TAREAS SET hecho = ?, prioridad = ? WHERE id_tareas = ?";
        try(
                Connection conn = this.conectarse();
                PreparedStatement pstmt = conn.prepareStatement(sql);
                )
        {
            pstmt.setBoolean(1,hecho);
            pstmt.setString(2,p.toString());
            pstmt.setInt(3,id_tarea);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void updateSubtareas(boolean hecho, Prioridad p, int id_subtarea){
        String sql = "UPDATE SUBTAREAS SET hecho = ?, prioridad = ? WHERE id_subtareas = ?";
        try(
                Connection conn = this.conectarse();
                PreparedStatement pstmt = conn.prepareStatement(sql);
        )
        {
            pstmt.setBoolean(1,hecho);
            pstmt.setString(2,p.toString());
            pstmt.setInt(3,id_subtarea);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

}
