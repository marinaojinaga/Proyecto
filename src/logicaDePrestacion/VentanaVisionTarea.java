package logicaDePrestacion;

import gestionBD.GestorBD;
import logicaDeDatos.Subtarea;
import logicaDeDatos.Tarea;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class VentanaVisionTarea extends JFrame {

    private JPanel contentPane;
    private JTextField nombre;
    private JTextField Prioridad;
    private JTextField descripcion;

    /**
     * Create the frame.
     */
    public VentanaVisionTarea(Tarea tarea) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        nombre = new JTextField();
        nombre.setText(tarea.getNombre());
        nombre.setEditable(false);
        nombre.setFont(new Font("Tahoma", Font.PLAIN, 15));
        nombre.setBounds(10, 11, 182, 33);
        contentPane.add(nombre);
        nombre.setColumns(10);

        JCheckBox hecho = new JCheckBox("Hecho");
        hecho.setSelected(tarea.isHecho());
        hecho.setBounds(253, 18, 97, 23);
        contentPane.add(hecho);

        JLabel lblNewLabel = new JLabel("Prioridad");
        lblNewLabel.setBounds(10, 75, 78, 14);
        contentPane.add(lblNewLabel);

        Prioridad = new JTextField();
        Prioridad.setText(tarea.getPrioridad().toString());
        Prioridad.setEditable(false);
        Prioridad.setBounds(97, 72, 120, 20);
        contentPane.add(Prioridad);
        Prioridad.setColumns(10);

        JLabel lblNewLabel_1 = new JLabel("Descripci\u00F3n");
        lblNewLabel_1.setBounds(10, 125, 78, 14);
        contentPane.add(lblNewLabel_1);

        descripcion = new JTextField();
        descripcion.setText(tarea.getDescripcion());
        descripcion.setEditable(false);
        descripcion.setBounds(97, 122, 120, 133);
        contentPane.add(descripcion);
        descripcion.setColumns(10);

        JLabel lblNewLabel_2 = new JLabel("Subtareas");
        lblNewLabel_2.setBounds(310, 59, 90, 14);
        contentPane.add(lblNewLabel_2);

        GestorBD gestorBD = new GestorBD();
        DefaultListModel<Subtarea> subtareas = new DefaultListModel<Subtarea>();
        ArrayList<Subtarea> sub = gestorBD.selectSubtareas();
        for(int i=0;i<sub.size();i++){
            if(sub.get(i).getId_tarea()==tarea.getId_tarea()){
                subtareas.addElement(sub.get(i));
            }
        }
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(253, 75, 175, 147);
        contentPane.add(scrollPane);

        JList list = new JList();
        list.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                Subtarea subtarea = (Subtarea)list.getSelectedValue();
                VentanaVisionSubtarea ventanaVisionSubtarea = new VentanaVisionSubtarea(subtarea);
                ventanaVisionSubtarea.setVisible(true);
                VentanaVisionTarea.this.setVisible(false);
            }
        });
        scrollPane.setViewportView(list);
        list.setModel(subtareas);

        JButton nuevaSubtarea = new JButton("Nueva subtarea");
        nuevaSubtarea.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                VentanaCrearSubtareas ventanaCrearSubtareas = new VentanaCrearSubtareas(tarea);
                ventanaCrearSubtareas.setVisible(true);
                VentanaVisionTarea.this.setVisible(false);
            }
        });
        nuevaSubtarea.setBounds(290, 232, 138, 23);
        contentPane.add(nuevaSubtarea);

    }
}