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

/*Cuando cierro o VentanaCrearSubtareas o VentanaCrearTarea sse cierran ambas, y quiero qe pase eso con vCrearTarea
pero no al revés
 */

public class VentanaCrearSubtareas extends JFrame {

    private JPanel contentPane;
    private JTextField nombre;

    /**
     * Create the frame.
     */
    public VentanaCrearSubtareas(Tarea t, Proyecto proyecto, Usuario usuario) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel_1 = new JLabel("Subtarea");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 26));
        lblNewLabel_1.setBounds(135, 11, 156, 39);
        contentPane.add(lblNewLabel_1);

        nombre = new JTextField();
        nombre.setBounds(127, 95, 96, 20);
        contentPane.add(nombre);
        nombre.setColumns(10);

        JLabel lblNewLabel = new JLabel("Nombre");
        lblNewLabel.setBounds(10, 92, 107, 27);
        contentPane.add(lblNewLabel);

        JCheckBox chckbxNewCheckBox = new JCheckBox("Hecho");
        chckbxNewCheckBox.setBounds(51, 148, 97, 23);
        contentPane.add(chckbxNewCheckBox);

        JComboBox prioridadSubtarea = new JComboBox();
        Prioridad[] p = new Prioridad[]{Prioridad.Alta,Prioridad.Media,Prioridad.Baja};
        prioridadSubtarea.setModel(new DefaultComboBoxModel(p));
        prioridadSubtarea.setBounds(127, 196, 115, 22);
        contentPane.add(prioridadSubtarea);

        JLabel lblNewLabel_2 = new JLabel("Prioridad");
        lblNewLabel_2.setBounds(10, 196, 107, 18);
        contentPane.add(lblNewLabel_2);

        JButton confirmar = new JButton("Confirmar");
        confirmar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                GestorBD gestorBD = new GestorBD();
                Subtarea subtarea = new Subtarea(nombre.getText(),chckbxNewCheckBox.isSelected(),(Prioridad) prioridadSubtarea.getSelectedItem(),0,t.getId_tarea());
                gestorBD.insertSubtareas(subtarea);
                VentanaVisionTarea ventanaVisionTarea = new VentanaVisionTarea(t,proyecto,usuario);
                ventanaVisionTarea.setVisible(true);
                VentanaCrearSubtareas.this.setVisible(false);
            }
        });
        confirmar.setBounds(303, 148, 125, 23);
        contentPane.add(confirmar);
    }
}