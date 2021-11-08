package logicaDePrestacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;

public class VentanaTareas extends JFrame {

	private JPanel contentPane;
	private JTextField nombreProyecto;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaTareas frame = new VentanaTareas();
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
	public VentanaTareas() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 883, 609);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		nombreProyecto = new JTextField();
		nombreProyecto.setEditable(false);
		nombreProyecto.setBounds(10, 52, 278, 48);
		contentPane.add(nombreProyecto);
		nombreProyecto.setColumns(10);
		
		JPanel panelTareas = new JPanel();
		panelTareas.setBounds(10, 163, 298, 351);
		contentPane.add(panelTareas);
		
		JButton btnNuevaTarea = new JButton("Nueva tarea");
		btnNuevaTarea.setFont(new Font("Bookman Old Style", Font.PLAIN, 25));
		btnNuevaTarea.setBounds(536, 163, 242, 48);
		contentPane.add(btnNuevaTarea);
		
		JButton btnBorrarTarea = new JButton("Borrar tarea\r\n");
		btnBorrarTarea.setFont(new Font("Bookman Old Style", Font.PLAIN, 25));
		btnBorrarTarea.setBounds(536, 242, 242, 48);
		contentPane.add(btnBorrarTarea);
		
		JButton btnModificarTarea = new JButton("Modificar tarea\r\n");
		btnModificarTarea.setFont(new Font("Bookman Old Style", Font.PLAIN, 25));
		btnModificarTarea.setBounds(536, 329, 242, 48);
		contentPane.add(btnModificarTarea);
	}

}
