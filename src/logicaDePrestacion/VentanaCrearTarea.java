
package logicaDePrestacion;

import gestionBD.GestorBD;
import logicaDeDatos.Prioridad;
import logicaDeDatos.Proyecto;
import logicaDeDatos.Tarea;
import logicaDeDatos.Usuario;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;

public class VentanaCrearTarea extends JFrame {

        private JPanel contentPane;
        private JTextField nombre;
        private JTextField descripcion;


        /**
         * Create the frame.
         */
        public VentanaCrearTarea(Proyecto proyecto, Usuario usuario) {
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setBounds(100, 100, 450, 300);
            contentPane = new JPanel();
            contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
            setContentPane(contentPane);
            contentPane.setLayout(null);

            JLabel lblNewLabel = new JLabel("Crea una tarea");
            lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
            lblNewLabel.setBounds(151, 11, 170, 14);
            contentPane.add(lblNewLabel);

            JLabel lblNewLabel_1 = new JLabel("Nombre");
            lblNewLabel_1.setBounds(10, 62, 47, 14);
            contentPane.add(lblNewLabel_1);

            JCheckBox hecho = new JCheckBox("Hecho");
            hecho.setBounds(10, 87, 97, 23);
            contentPane.add(hecho);

            JComboBox Prioridad = new JComboBox<Prioridad>();
            Prioridad[] p = new Prioridad[]{logicaDeDatos.Prioridad.Alta,logicaDeDatos.Prioridad.Media, logicaDeDatos.Prioridad.Baja};
            Prioridad.setModel(new DefaultComboBoxModel(p));
            Prioridad.setBounds(137, 125, 148, 22);
            contentPane.add(Prioridad);

            JLabel lblNewLabel_2 = new JLabel("Prioridad");
            lblNewLabel_2.setBounds(10, 129, 79, 14);
            contentPane.add(lblNewLabel_2);

            JLabel lblNewLabel_3 = new JLabel("Descripcion");
            lblNewLabel_3.setBounds(10, 167, 113, 14);
            contentPane.add(lblNewLabel_3);

            nombre = new JTextField();
            nombre.setBounds(137, 59, 245, 20);
            contentPane.add(nombre);
            nombre.setColumns(10);

            descripcion = new JTextField();
            descripcion.setBounds(137, 164, 245, 20);
            contentPane.add(descripcion);
            descripcion.setColumns(10);


            JButton Aceptar = new JButton("Aceptar");
            Aceptar.addActionListener(e-> {
                    Tarea t = new Tarea(nombre.getText(),hecho.isSelected(), (logicaDeDatos.Prioridad) Prioridad.getSelectedItem(),descripcion.getText(),0,proyecto.getId_proyecto());
                    GestorBD g = new GestorBD();
                    g.insertTarea(t);
                    try {
                        VentanaUnProyecto ventanaUnProyecto = new VentanaUnProyecto(proyecto,usuario);
                        ventanaUnProyecto.setVisible(true);
                        VentanaCrearTarea.this.setVisible(false);
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }

            });
            Aceptar.setBounds(151, 232, 89, 23);
            contentPane.add(Aceptar);
        }

}
