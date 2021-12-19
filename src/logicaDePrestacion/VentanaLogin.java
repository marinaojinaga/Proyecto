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
        lblNewLabel_2.setBounds(10, 95, 80, 14);
        contentPane.add(lblNewLabel_2);

        GestorBD gestorBD = new GestorBD();
        JButton Acceder = new JButton("Acceder");
       Acceder.addActionListener(e-> {
           try {
               if(coincide(email.getText(),contrasena.getText())){
                   VentanaProyectos vProyectos = new VentanaProyectos(gestorBD.getusuario(email.getText()));
                   vProyectos.setVisible(true);
                   VentanaLogin.this.setVisible(false);
               }else{
                   JOptionPane.showMessageDialog(VentanaLogin.this, "Contraseña y/o mail invalidos");
               }
           } catch (SQLException ex) {
               ex.printStackTrace();
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

        JButton crearUsuario = new JButton("Crear Usuario");
        crearUsuario.addActionListener(e-> {
            VentanaCrearUsuario ventanaCrearUsuario = new VentanaCrearUsuario();
            ventanaCrearUsuario.setVisible(true);
            VentanaLogin.this.setVisible(false);
        });
        crearUsuario.setBounds(147, 161, 122, 23);
        contentPane.add(crearUsuario);
    }

    /**
     * Coinciden el email y la contraseña con alguno de un usuario
     */
    public boolean coincide(String email, String contrasena) throws SQLException {
        boolean respuesta = false;
        GestorBD g = new GestorBD();
        if (email.equals("")){
            respuesta = false;
        }else{
            Usuario u = g.getusuario(email);
            if(u.getContrasena().equals(contrasena)){
                respuesta = true;
            }
        }
        return respuesta;
    }
}
