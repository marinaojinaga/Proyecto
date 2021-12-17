package logicaDePrestacion;

import gestionBD.GestorBD;
import logicaDeDatos.Usuario;
import logicaNegocio.ExtraerBD;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

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

		JLabel lblNewLabel = new JLabel("Crear un nuevo usuario");
		lblNewLabel.setBounds(155, 11, 150, 14);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Nick usuario");
		lblNewLabel_1.setBounds(10, 68, 85, 14);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Contrase\u00F1a");
		lblNewLabel_2.setBounds(10, 93, 99, 14);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Nombre");
		lblNewLabel_3.setBounds(10, 121, 47, 14);
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Mail");
		lblNewLabel_4.setBounds(10, 146, 47, 14);
		contentPane.add(lblNewLabel_4);

		nickUsuario = new JTextField();
		nickUsuario.setBounds(119, 65, 294, 20);
		contentPane.add(nickUsuario);
		nickUsuario.setColumns(10);

		contrasena = new JTextField();
		contrasena.setColumns(10);
		contrasena.setBounds(119, 90, 294, 20);
		contentPane.add(contrasena);

		nombre = new JTextField();
		nombre.setColumns(10);
		nombre.setBounds(119, 118, 294, 20);
		contentPane.add(nombre);

		mail = new JTextField();
		mail.setColumns(10);
		mail.setBounds(119, 143, 294, 20);
		contentPane.add(mail);

		JButton btnNewButton = new JButton("Crear usuario");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Usuario usuario = new Usuario(nickUsuario.getText(),contrasena.getText(),nombre.getText(),mail.getText(),0);
				GestorBD g = new GestorBD();
				g.insertUsuarios(usuario);
				VentanaProyectos ventanaProyectos = new VentanaProyectos(usuario);
				ventanaProyectos.setVisible(true);
				VentanaCrearUsuario.this.setVisible(false);
			}
		});
		btnNewButton.setBounds(147, 232, 117, 23);
		contentPane.add(btnNewButton);
	}

	public int getUsuario(String mail) throws SQLException {
		ExtraerBD e = new ExtraerBD();
		int x = 0;
		ArrayList<Usuario> usuarios = e.extraerUsuarios();
		Usuario r = null;
		for(int i=0;i<usuarios.size();i++){
			if(usuarios.get(i).getMail().equals(mail)){
				x = usuarios.get(i).getId_usuario();
			}
		}
		return x;
	}

}
