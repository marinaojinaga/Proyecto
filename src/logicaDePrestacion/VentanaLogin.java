package logicaDePrestacion;

import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import gestionBD.GestorBD;
import logicaDeDatos.Usuario;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaLogin extends JFrame{
    private JPanel contentPane;
    private JTextField email;
    private JTextField contrasenya;

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
        setBounds(100, 100, 921, 536);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("Inicio");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 49));
        lblNewLabel.setBounds(394, 11, 123, 44);
        contentPane.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Email");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
        lblNewLabel_1.setBounds(287, 139, 108, 36);
        contentPane.add(lblNewLabel_1);

        JLabel lblNewLabel_2 = new JLabel("Contrase\u00F1a");
        lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 25));
        lblNewLabel_2.setBounds(287, 202, 145, 36);
        contentPane.add(lblNewLabel_2);

        email = new JTextField();
        email.setBounds(442, 149, 239, 29);
        contentPane.add(email);
        email.setColumns(10);

        contrasenya = new JTextField();
        contrasenya.setColumns(10);
        contrasenya.setBounds(442, 209, 239, 29);
        contentPane.add(contrasenya);

        JButton Acceso = new JButton("Acceder");
        Acceso.addActionListener(e -> {
            if(email_contrasena()){
                GestorBD g = new GestorBD();
                Usuario u = g.getusuario(email.getText());
                VentanaProyectos vProyectos = new VentanaProyectos(u);
                vProyectos.setVisible(true);
                VentanaLogin.this.setVisible(false);
            }else{
                JOptionPane.showMessageDialog(VentanaLogin.this,"Email y/o contraseña incorrectos");
            }

        });
        Acceso.setFont(new Font("Tahoma", Font.PLAIN, 26));
        Acceso.setBounds(360, 340, 158, 44);
        contentPane.add(Acceso);

        JButton cUsuario = new JButton("Crear Usuario");
        cUsuario.addActionListener(e -> {
            VentanaCrearUsuario vCrearUsuario = new VentanaCrearUsuario();
            vCrearUsuario.setVisible(true);
            VentanaLogin.this.setVisible(false);
        });
        cUsuario.setFont(new Font("Tahoma", Font.PLAIN, 26));
        cUsuario.setBounds(360, 400, 200, 44);
        contentPane.add(cUsuario);
    }

    public boolean email_contrasena(){
        Boolean b = false;
        GestorBD g = new GestorBD();
        String contraB = g.getContrasena(email.getText());
        String contraP = contrasenya.getText();
        if(contraB.equals(contraP)){
            b = true;
        }
        return b;
    }
}
