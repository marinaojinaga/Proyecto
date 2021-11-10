package logicaDePrestacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class VentanaCrearTarea extends JFrame {

	private JPanel contentPane;
	private JTextField nombreTarea;
	private JTextField DescripciónTarea;
	private JTextField ddFechaLimite;
	private JTextField mmFechaLimite;
	private JTextField aaaaFechaLimite;
	private JTextField aaaaFechaRealizacion;
	private JTextField ddFechaRealizacion;
	private JTextField mmFechaRealizacion;
	private JTextField prioridadTarea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaCrearTarea frame = new VentanaCrearTarea();
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
	public VentanaCrearTarea() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 992, 625);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Crea una tarea");
		lblNewLabel.setFont(new Font("Bookman Old Style", Font.PLAIN, 25));
		lblNewLabel.setBounds(362, 11, 217, 46);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre");
		lblNewLabel_1.setFont(new Font("Bookman Old Style", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(20, 95, 171, 35);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Prioridad");
		lblNewLabel_1_1.setFont(new Font("Bookman Old Style", Font.PLAIN, 18));
		lblNewLabel_1_1.setBounds(20, 163, 92, 35);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Descripci\u00F3n");
		lblNewLabel_1_2.setFont(new Font("Bookman Old Style", Font.PLAIN, 18));
		lblNewLabel_1_2.setBounds(20, 239, 171, 35);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Fecha Limite");
		lblNewLabel_1_3.setFont(new Font("Bookman Old Style", Font.PLAIN, 18));
		lblNewLabel_1_3.setBounds(10, 313, 127, 35);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Fecha Realizaci\u00F3n");
		lblNewLabel_1_4.setFont(new Font("Bookman Old Style", Font.PLAIN, 18));
		lblNewLabel_1_4.setBounds(20, 385, 171, 35);
		contentPane.add(lblNewLabel_1_4);
		
		nombreTarea = new JTextField();
		nombreTarea.setFont(new Font("Bookman Old Style", Font.PLAIN, 18));
		nombreTarea.setBounds(95, 95, 355, 29);
		contentPane.add(nombreTarea);
		nombreTarea.setColumns(10);
		
		DescripciónTarea = new JTextField();
		DescripciónTarea.setFont(new Font("Bookman Old Style", Font.PLAIN, 18));
		DescripciónTarea.setColumns(10);
		DescripciónTarea.setBounds(129, 239, 817, 63);
		contentPane.add(DescripciónTarea);
		
		ddFechaLimite = new JTextField();
		ddFechaLimite.setFont(new Font("Bookman Old Style", Font.PLAIN, 18));
		ddFechaLimite.setColumns(10);
		ddFechaLimite.setBounds(139, 322, 59, 29);
		contentPane.add(ddFechaLimite);
		
		JLabel lblNewLabel_2 = new JLabel("dd/mm/aaaa");
		lblNewLabel_2.setFont(new Font("Bookman Old Style", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(20, 342, 109, 19);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("dd/mm/aaaa");
		lblNewLabel_2_1.setFont(new Font("Bookman Old Style", Font.PLAIN, 15));
		lblNewLabel_2_1.setBounds(47, 415, 109, 19);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_3 = new JLabel("/");
		lblNewLabel_3.setFont(new Font("Bookman Old Style", Font.PLAIN, 18));
		lblNewLabel_3.setBounds(208, 325, 24, 23);
		contentPane.add(lblNewLabel_3);
		
		mmFechaLimite = new JTextField();
		mmFechaLimite.setFont(new Font("Bookman Old Style", Font.PLAIN, 18));
		mmFechaLimite.setColumns(10);
		mmFechaLimite.setBounds(218, 322, 59, 29);
		contentPane.add(mmFechaLimite);
		
		JLabel lblNewLabel_3_1 = new JLabel("/");
		lblNewLabel_3_1.setFont(new Font("Bookman Old Style", Font.PLAIN, 18));
		lblNewLabel_3_1.setBounds(287, 325, 24, 23);
		contentPane.add(lblNewLabel_3_1);
		
		aaaaFechaLimite = new JTextField();
		aaaaFechaLimite.setFont(new Font("Bookman Old Style", Font.PLAIN, 18));
		aaaaFechaLimite.setColumns(10);
		aaaaFechaLimite.setBounds(310, 322, 86, 29);
		contentPane.add(aaaaFechaLimite);
		
		aaaaFechaRealizacion = new JTextField();
		aaaaFechaRealizacion.setFont(new Font("Bookman Old Style", Font.PLAIN, 18));
		aaaaFechaRealizacion.setColumns(10);
		aaaaFechaRealizacion.setBounds(364, 385, 86, 29);
		contentPane.add(aaaaFechaRealizacion);
		
		ddFechaRealizacion = new JTextField();
		ddFechaRealizacion.setFont(new Font("Bookman Old Style", Font.PLAIN, 18));
		ddFechaRealizacion.setColumns(10);
		ddFechaRealizacion.setBounds(193, 385, 59, 29);
		contentPane.add(ddFechaRealizacion);
		
		JLabel lblNewLabel_3_2 = new JLabel("/");
		lblNewLabel_3_2.setFont(new Font("Bookman Old Style", Font.PLAIN, 18));
		lblNewLabel_3_2.setBounds(262, 388, 24, 23);
		contentPane.add(lblNewLabel_3_2);
		
		mmFechaRealizacion = new JTextField();
		mmFechaRealizacion.setFont(new Font("Bookman Old Style", Font.PLAIN, 18));
		mmFechaRealizacion.setColumns(10);
		mmFechaRealizacion.setBounds(272, 385, 59, 29);
		contentPane.add(mmFechaRealizacion);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("/");
		lblNewLabel_3_1_1.setFont(new Font("Bookman Old Style", Font.PLAIN, 18));
		lblNewLabel_3_1_1.setBounds(341, 388, 24, 23);
		contentPane.add(lblNewLabel_3_1_1);
		
		prioridadTarea = new JTextField();
		prioridadTarea.setFont(new Font("Bookman Old Style", Font.PLAIN, 18));
		prioridadTarea.setColumns(10);
		prioridadTarea.setBounds(122, 166, 59, 29);
		contentPane.add(prioridadTarea);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Hecho");
		chckbxNewCheckBox.setHorizontalAlignment(SwingConstants.LEFT);
		chckbxNewCheckBox.setFont(new Font("Bookman Old Style", Font.PLAIN, 30));
		chckbxNewCheckBox.setBounds(683, 83, 127, 47);
		contentPane.add(chckbxNewCheckBox);
		
		JPanel panelSubtareas = new JPanel();
		panelSubtareas.setBounds(628, 322, 289, 237);
		contentPane.add(panelSubtareas);
		
		JButton btnCrearSubtarea = new JButton("Nueva Subtarea");
		btnCrearSubtarea.setFont(new Font("Bookman Old Style", Font.PLAIN, 13));
		btnCrearSubtarea.setBounds(628, 557, 143, 23);
		contentPane.add(btnCrearSubtarea);
		
		JButton btnConfirmarTarea = new JButton("Confirmar");
		btnConfirmarTarea.setFont(new Font("Bookman Old Style", Font.PLAIN, 20));
		btnConfirmarTarea.setBounds(20, 515, 196, 35);
		contentPane.add(btnConfirmarTarea);
	}
}
