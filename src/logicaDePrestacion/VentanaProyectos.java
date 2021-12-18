package logicaDePrestacion;

import com.sun.org.apache.xerces.internal.dom.DeferredAttrImpl;
import gestionBD.GestorBD;
import logicaDeDatos.Proyecto;
import logicaDeDatos.Usuario;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

public class VentanaProyectos extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GestorBD g = new GestorBD();
					VentanaProyectos frame = new VentanaProyectos(g.getusuario("marina@test.com"));
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
	public VentanaProyectos(Usuario usuariox) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		GestorBD gestorBD = new GestorBD();
		DefaultListModel<Proyecto> proyectosUsuario = new DefaultListModel<Proyecto>();
		ArrayList<Proyecto> proyectos = gestorBD.selectProyecto();
		for(int i=0;i<proyectos.size();i++){
			if(proyectos.get(i).getId_usuario()==usuariox.getId_usuario()) {
				proyectosUsuario.addElement(proyectos.get(i));
			}
		}
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(26, 63, 165, 175);
		contentPane.add(scrollPane);

		JList list = new JList();
		list.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				Proyecto p = (Proyecto)list.getSelectedValue();
				try {
					VentanaUnProyecto v1Proyecto = new VentanaUnProyecto(p);
					v1Proyecto.setVisible(true);
					VentanaProyectos.this.setVisible(false);
				} catch (SQLException ex) {
					ex.printStackTrace();
				}

			}
		});
		scrollPane.setViewportView(list);
		list.setModel(proyectosUsuario);

		JLabel lblNewLabel = new JLabel("Tus proyectos");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(26, 11, 165, 28);
		contentPane.add(lblNewLabel);

		JButton btnNewButton = new JButton("Nuevo proyecto");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Usuario x = usuariox;
				VentanaCrearProyecto ventanaCrearProyecto = new VentanaCrearProyecto(x);
				ventanaCrearProyecto.setVisible(true);
				VentanaProyectos.this.setVisible(false);
			}
		});
		btnNewButton.setBounds(259, 89, 127, 23);
		contentPane.add(btnNewButton);

	}
}
