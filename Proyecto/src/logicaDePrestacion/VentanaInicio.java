package logicaDePrestacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logicaNegocio.GestionUsuario;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaInicio extends JFrame {

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
					VentanaInicio frame = new VentanaInicio();
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
	public VentanaInicio() {
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
		
		JButton btnAcceso = new JButton("Acceder");
		
		btnAcceso.setFont(new Font("Tahoma", Font.PLAIN, 26));
		btnAcceso.setBounds(360, 340, 158, 44);
		contentPane.add(btnAcceso);
	}
}
