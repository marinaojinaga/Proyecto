package logicaDePrestacion;

import gestionBD.GestorBD;
import logicaDeDatos.*;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaVisionSubtarea extends JFrame {

    private JPanel contentPane;
    private JTextField nombre;
    private JTextField prioridad;

    /**
     * Create the frame.
     */
    public VentanaVisionSubtarea(Subtarea subtarea, Tarea tarea, Proyecto proyecto, Usuario usuario) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        nombre = new JTextField();
        nombre.setText(subtarea.getNombre());
        nombre.setEditable(false);
        nombre.setFont(new Font("Tahoma", Font.PLAIN, 18));
        nombre.setBounds(10, 11, 207, 37);
        contentPane.add(nombre);
        nombre.setColumns(10);

        JCheckBox hecho = new JCheckBox("Hecho");
        hecho.setSelected(subtarea.isHecho());
        hecho.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                subtarea.setHecho(hecho.isSelected());
                GestorBD g = new GestorBD();
                g.updateSubtareas(hecho.isSelected(), subtarea.getPrioridad(),subtarea.getId_subtarea());
            }
        });
        hecho.setBounds(10, 92, 97, 23);
        contentPane.add(hecho);


        JComboBox Prioridad = new JComboBox<logicaDeDatos.Prioridad>();
        logicaDeDatos.Prioridad[] p = new Prioridad[]{logicaDeDatos.Prioridad.Alta,logicaDeDatos.Prioridad.Media, logicaDeDatos.Prioridad.Baja};
        Prioridad.setModel(new DefaultComboBoxModel(p));
        Prioridad.setSelectedItem(subtarea.getPrioridad());
        Prioridad.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                subtarea.setPrioridad((logicaDeDatos.Prioridad) Prioridad.getSelectedItem());
                GestorBD gestorBD = new GestorBD();
                gestorBD.updateSubtareas(subtarea.isHecho(), (logicaDeDatos.Prioridad) Prioridad.getSelectedItem(),subtarea.getId_subtarea());
            }
        });
        Prioridad.setBounds(78, 158, 117, 20);
        contentPane.add(Prioridad);

        JLabel lblNewLabel = new JLabel("Prioridad");
        lblNewLabel.setBounds(10, 161, 79, 14);
        contentPane.add(lblNewLabel);

        JButton atras = new JButton("Atras");
        atras.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                VentanaVisionTarea ventanaVisionTarea = new VentanaVisionTarea(tarea,proyecto,usuario);
                ventanaVisionTarea.setVisible(true);
                VentanaVisionSubtarea.this.setVisible(false);
            }
        });
        atras.setBounds(339, 11, 89, 23);
        contentPane.add(atras);
    }
}
