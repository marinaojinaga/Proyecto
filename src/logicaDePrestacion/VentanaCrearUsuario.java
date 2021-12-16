package logicaDePrestacion;

import gestionBD.GestorBD;
import logicaDeDatos.Usuario;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Font;

public class VentanaCrearUsuario extends JFrame {

	private JPanel contentPane;
	private JTextField nickUsuario;
	private JTextField contrasena;
	private JTextField nombreUsuario;
	private JTextField mailUsuario;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaCrearUsuario frame = new VentanaCrearUsuario();
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
	public VentanaCrearUsuario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 721, 502);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nick de usuario");
		lblNewLabel.setFont(new Font("Bookman Old Style", Font.PLAIN, 25));
		lblNewLabel.setBounds(33, 103, 230, 45);
		contentPane.add(lblNewLabel);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setFont(new Font("Bookman Old Style", Font.PLAIN, 25));
		lblContrasea.setBounds(33, 159, 230, 45);
		contentPane.add(lblContrasea);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Bookman Old Style", Font.PLAIN, 25));
		lblNombre.setBounds(33, 228, 230, 45);
		contentPane.add(lblNombre);
		
		JLabel lblMail = new JLabel("Mail");
		lblMail.setFont(new Font("Bookman Old Style", Font.PLAIN, 25));
		lblMail.setBounds(33, 298, 230, 45);
		contentPane.add(lblMail);
		
		nickUsuario = new JTextField();
		nickUsuario.setBounds(273, 103, 413, 37);
		contentPane.add(nickUsuario);
		nickUsuario.setColumns(10);
		
		contrasena = new JTextField();
		contrasena.setColumns(10);
		contrasena.setBounds(273, 167, 413, 37);
		contentPane.add(contrasena);
		
		nombreUsuario = new JTextField();
		nombreUsuario.setColumns(10);
		nombreUsuario.setBounds(273, 228, 413, 37);
		contentPane.add(nombreUsuario);
		
		mailUsuario = new JTextField();
		mailUsuario.setColumns(10);
		mailUsuario.setBounds(273, 298, 413, 37);
		contentPane.add(mailUsuario);
		
		JButton CrearUsuario = new JButton("Crear usuario");
		/*CrearUsuario.addActionListener(e -> {
			Usuario u = new Usuario(nickUsuario.getText(),contrasena.getText(),nombreUsuario.getText(),mailUsuario.getText());
			GestorBD g = new GestorBD();
			g.insertUsuarios(u);
			VentanaProyectos vProyectos = new VentanaProyectos(u);
			vProyectos.setVisible(true);
			VentanaCrearUsuario.this.setVisible(false);
		});*/
		CrearUsuario.setFont(new Font("Bookman Old Style", Font.PLAIN, 16));
		CrearUsuario.setBounds(248, 365, 166, 45);
		contentPane.add(CrearUsuario);
		
		JLabel lblNewLabel_1 = new JLabel("Crea un usuario nuevo");
		lblNewLabel_1.setFont(new Font("Bookman Old Style", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(237, 11, 257, 61);
		contentPane.add(lblNewLabel_1);
	}
}
