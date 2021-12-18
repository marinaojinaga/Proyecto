package logicaDePrestacion;

import logicaDeDatos.Subtarea;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JCheckBox;
import javax.swing.JLabel;

public class VentanaVisionSubtarea extends JFrame {

    private JPanel contentPane;
    private JTextField nombre;
    private JTextField prioridad;

    /**
     * Create the frame.
     */
    public VentanaVisionSubtarea(Subtarea subtarea) {
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
        hecho.setBounds(10, 92, 97, 23);
        contentPane.add(hecho);

        prioridad = new JTextField();
        prioridad.setText(subtarea.getPrioridad().toString());
        prioridad.setEditable(false);
        prioridad.setBounds(78, 158, 117, 20);
        contentPane.add(prioridad);
        prioridad.setColumns(10);

        JLabel lblNewLabel = new JLabel("Prioridad");
        lblNewLabel.setBounds(10, 161, 79, 14);
        contentPane.add(lblNewLabel);
    }
}
