package logicaDePrestacion;

import gestionBD.GestorBD;
import logicaDeDatos.Proyecto;
import logicaDeDatos.Tarea;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.ArrayList;

public class VentanaUnProyecto extends JFrame {

    private JPanel contentPane;
    private JTextField nombreProyecto;


    /**
     * Create the frame.
     */
    public VentanaUnProyecto(Proyecto proyecto) throws SQLException {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        nombreProyecto = new JTextField();
        nombreProyecto.setText(proyecto.getNombre());
        nombreProyecto.setEditable(false);
        nombreProyecto.setBounds(10, 11, 172, 32);
        contentPane.add(nombreProyecto);
        nombreProyecto.setColumns(10);

        JCheckBox favorito = new JCheckBox("Favorito");
        favorito.setSelected(proyecto.isFavorito());
        favorito.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                proyecto.setFavorito(favorito.isSelected());
            }
        });
        favorito.setBounds(270, 16, 97, 23);
        contentPane.add(favorito);

        GestorBD gestorBD = new GestorBD();
        DefaultListModel<Tarea> tareasUx = new DefaultListModel<Tarea>();
        ArrayList<Tarea> tareas = gestorBD.selectTareas();
        for(int i=0; i<tareas.size();i++){
            if(tareas.get(i).getId_proyecto() == proyecto.getId_proyecto()){
                tareasUx.addElement(tareas.get(i));
            }
        }
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 79, 219, 148);
        contentPane.add(scrollPane);

        JList list = new JList();
        list.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                Tarea t = (Tarea)list.getSelectedValue();
            }
        });
        scrollPane.setViewportView(list);
        list.setModel(tareasUx);

        JButton nuevaTarea = new JButton("Nueva tarea");
        nuevaTarea.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        nuevaTarea.setBounds(274, 204, 154, 23);
        contentPane.add(nuevaTarea);
    }
}

