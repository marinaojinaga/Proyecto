package logicaDePrestacion;

import gestionBD.GestorBD;
import logicaDeDatos.MergeSort;
import logicaDeDatos.Proyecto;
import logicaDeDatos.Usuario;


import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.sql.SQLException;
import java.util.ArrayList;

public class VentanaProyectos extends JFrame {

	private JPanel contentPane;
	private JList list;

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
		ArrayList<Proyecto> proyectosAOrdenar = new ArrayList<Proyecto>();
		proyectos.forEach(e->{
			if(e.getId_usuario()==usuariox.getId_usuario()) {
				proyectosUsuario.addElement(e);
				proyectosAOrdenar.add(e);
			}
		});
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(26, 63, 165, 175);
		contentPane.add(scrollPane);

		list = new JList();
		list.addListSelectionListener(e-> {
			Proyecto p = (Proyecto)list.getSelectedValue();
			try {
				VentanaUnProyecto v1Proyecto = new VentanaUnProyecto(p,usuariox);
				v1Proyecto.setVisible(true);
				VentanaProyectos.this.setVisible(false);
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		});
		scrollPane.setViewportView(list);
		list.setModel(proyectosUsuario);

		JLabel lblNewLabel = new JLabel("Tus proyectos");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(26, 11, 165, 28);
		contentPane.add(lblNewLabel);

		JButton btnNewButton = new JButton("Nuevo proyecto");
		btnNewButton.addActionListener(e-> {
			Usuario x = usuariox;
			VentanaCrearProyecto ventanaCrearProyecto = new VentanaCrearProyecto(x);
			ventanaCrearProyecto.setVisible(true);
			VentanaProyectos.this.setVisible(false);
		});
		btnNewButton.setBounds(259, 89, 127, 23);
		contentPane.add(btnNewButton);

		JComboBox ordenar = new JComboBox();
		ordenar.addItem("......");
		ordenar.addItem("Orden alfabético");
		ordenar.addItem("Favoritos arriba");
		ordenar.addActionListener(e->{
			MergeSort<Proyecto> mergeSort = new MergeSort<Proyecto>();
			DefaultListModel<Proyecto> ProyectosOrdenados = new DefaultListModel<>();
			ArrayList<Proyecto> proyectosOrdenados;
			proyectosOrdenados = new ArrayList<Proyecto>();
			if(ordenar.getSelectedItem().equals("Orden alfabético")){
					proyectosOrdenados = mergeSort.mergeSortAlfabetico(proyectosAOrdenar);
			}else if (ordenar.getSelectedItem().equals("Favoritos arriba")){
				proyectosOrdenados = mergeSort.mergeSortBoolean(proyectosAOrdenar);
			}
			proyectosOrdenados.forEach(f->ProyectosOrdenados.addElement(f));
			list.setModel(ProyectosOrdenados);
		});
		ordenar.setBounds(26, 41, 165, 22);
		getContentPane().add(ordenar);

	}
}
