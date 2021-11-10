package logicaDePrestacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JButton;

public class VentanaProyectos extends JFrame {

	private JPanel contentPane;
	private JTextField nickUsuario;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaProyectos frame = new VentanaProyectos();
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
	public VentanaProyectos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 893, 583);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		nickUsuario = new JTextField();
		nickUsuario.setEditable(false);
		nickUsuario.setBounds(605, 11, 253, 47);
		contentPane.add(nickUsuario);
		nickUsuario.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Tus proyectos\r\n");
		lblNewLabel.setFont(new Font("Bookman Old Style", Font.PLAIN, 25));
		lblNewLabel.setBounds(41, 96, 184, 35);
		contentPane.add(lblNewLabel);
		
		JPanel panelProyectos = new JPanel();
		panelProyectos.setBounds(41, 170, 414, 279);
		contentPane.add(panelProyectos);
		
		JButton btnNuevoProyecto = new JButton("Nuevo proyecto\r\n");
		btnNuevoProyecto.setFont(new Font("Bookman Old Style", Font.PLAIN, 20));
		btnNuevoProyecto.setBounds(578, 170, 265, 47);
		contentPane.add(btnNuevoProyecto);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setFont(new Font("Bookman Old Style", Font.PLAIN, 20));
		btnSalir.setBounds(578, 402, 265, 47);
		contentPane.add(btnSalir);
		
		JButton btnBorrarproyecto = new JButton("Borrar proyecto");
		btnBorrarproyecto.setFont(new Font("Bookman Old Style", Font.PLAIN, 20));
		btnBorrarproyecto.setBounds(578, 241, 265, 47);
		contentPane.add(btnBorrarproyecto);
	}
}
