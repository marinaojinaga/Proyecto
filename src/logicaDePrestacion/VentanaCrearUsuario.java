package logicaDePrestacion;

import gestionBD.GestorBD;
import logicaDeDatos.Usuario;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaCrearUsuario extends JFrame {

    private JPanel contentPane;
    private JTextField nickUsuario;
    private JTextField contrasena;
    private JTextField nombre;
    private JTextField mail;

    /**
     * Create the frame.
     */
    public VentanaCrearUsuario() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("Crear usuario");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNewLabel.setBounds(148, 11, 156, 14);
        contentPane.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Nick Usuario");
        lblNewLabel_1.setBounds(10, 74, 111, 14);
        contentPane.add(lblNewLabel_1);

        JLabel lblNewLabel_2 = new JLabel("Contrase\u00F1a");
        lblNewLabel_2.setBounds(10, 118, 83, 14);
        contentPane.add(lblNewLabel_2);

        JLabel lblNewLabel_3 = new JLabel("Nombre");
        lblNewLabel_3.setBounds(10, 166, 83, 14);
        contentPane.add(lblNewLabel_3);

        JLabel lblNewLabel_4 = new JLabel("Mail");
        lblNewLabel_4.setBounds(10, 203, 47, 14);
        contentPane.add(lblNewLabel_4);

        nickUsuario = new JTextField();
        nickUsuario.setBounds(131, 71, 267, 20);
        contentPane.add(nickUsuario);
        nickUsuario.setColumns(10);

        contrasena = new JTextField();
        contrasena.setColumns(10);
        contrasena.setBounds(131, 115, 267, 20);
        contentPane.add(contrasena);

        nombre = new JTextField();
        nombre.setColumns(10);
        nombre.setBounds(131, 163, 267, 20);
        contentPane.add(nombre);

        mail = new JTextField();
        mail.setColumns(10);
        mail.setBounds(131, 200, 267, 20);
        contentPane.add(mail);

        JButton Aceptar = new JButton("Aceptar");
        Aceptar.addActionListener(e->{
            Usuario usuario = new Usuario(nickUsuario.getText(),contrasena.getText(),nombre.getText(),mail.getText(),0);
            GestorBD gestorBD = new GestorBD();
            gestorBD.insertUsuarios(usuario);
            VentanaLogin ventanaLogin = new VentanaLogin();
            ventanaLogin.setVisible(true);
            VentanaCrearUsuario.this.setVisible(false);
        });
        Aceptar.setBounds(309, 243, 89, 23);
        contentPane.add(Aceptar);
    }

}
