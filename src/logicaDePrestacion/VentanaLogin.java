package logicaDePrestacion;

import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import gestionBD.GestorBD;
import logicaDeDatos.Usuario;
import logicaNegocio.ExtraerBD;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Array;
import java.sql.SQLException;
import java.util.ArrayList;

public class VentanaLogin extends JFrame{
    private JPanel contentPane;
    private JTextField email;
    private JTextField contrasena;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    VentanaLogin frame = new VentanaLogin();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public VentanaLogin() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("Email");
        lblNewLabel.setBounds(10, 52, 83, 19);
        contentPane.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Inicio sesion");
        lblNewLabel_1.setBounds(179, 11, 71, 14);
        contentPane.add(lblNewLabel_1);

        JLabel lblNewLabel_2 = new JLabel("Contrase\u00F1a");
        lblNewLabel_2.setBounds(10, 95, 98, 14);
        contentPane.add(lblNewLabel_2);

        JButton crearUsuario = new JButton("Crear usuario");
        crearUsuario.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                VentanaCrearUsuario ventanaCrearUsuario = new VentanaCrearUsuario();
                ventanaCrearUsuario.setVisible(true);
                VentanaLogin.this.setVisible(false);
            }
        });
        crearUsuario.setBounds(147, 232, 122, 23);
        contentPane.add(crearUsuario);

        JButton Acceder = new JButton("Acceder");
        Acceder.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    if(coincide(email.getText(),contrasena.getText())){
                        VentanaProyectos vProyectos = new VentanaProyectos(getUsuario(email.getText()));
                        vProyectos.setVisible(true);
                        VentanaLogin.this.setVisible(false);
                    }else{
                        JOptionPane.showMessageDialog(VentanaLogin.this, "Email y/o contraseña invalidos");
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        Acceder.setBounds(147, 198, 122, 23);
        contentPane.add(Acceder);

        email = new JTextField();
        email.setBounds(79, 51, 325, 20);
        contentPane.add(email);
        email.setColumns(10);

        contrasena = new JTextField();
        contrasena.setBounds(79, 92, 325, 20);
        contentPane.add(contrasena);
        contrasena.setColumns(10);
    }

    /**
     * Coinciden el email y la contraseña con alguno de un usuario
     */
    public boolean coincide(String email, String contrasena) throws SQLException {
        boolean respuesta = false;
        ExtraerBD e = new ExtraerBD();
        ArrayList<Usuario> usuarios = e.extraerUsuarios();
        for(int i=0;i<usuarios.size();i++){
            if(usuarios.get(i).getMail().equals(email)){
                if(usuarios.get(i).getContrasena().equals(contrasena)){
                    respuesta = true;
                }
                break;
            }
        }
        return respuesta;
    }

    public Usuario getUsuario(String mail) throws SQLException{
        ExtraerBD e = new ExtraerBD();
        ArrayList<Usuario> usuarios = e.extraerUsuarios();
        Usuario r = null;
        for(int i=0;i<usuarios.size();i++){
            if(usuarios.get(i).getMail().equals(mail)){
                r = usuarios.get(i);
            }
        }
        return r;
    }
}
