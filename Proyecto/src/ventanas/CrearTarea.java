package ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;

public class CrearTarea extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CrearTarea frame = new CrearTarea();
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
	public CrearTarea() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\hp\\Desktop\\5\u00BA cuatri\\Program\\Fotos\\tick-icon-For-Your-Project-Graphics-9371644-1-1-580x387.jpg"));
		setBackground(SystemColor.menu);
		setFont(new Font("Bodoni MT", Font.PLAIN, 12));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.menu);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Crea una tarea");
		lblNewLabel.setFont(new Font("Lucida Console", Font.PLAIN, 11));
		lblNewLabel.setBounds(160, 11, 98, 28);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(26, 74, 47, 14);
		contentPane.add(lblNewLabel_1);
	}

}
