package logicaDePrestacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaVisionTarea extends JFrame {

    private JPanel contentPane;
    private JTextField nombre;
    private JTextField Prioridad;
    private JTextField textField;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    VentanaVisionTarea frame = new VentanaVisionTarea();
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
    public VentanaVisionTarea() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        nombre = new JTextField();
        nombre.setEditable(false);
        nombre.setFont(new Font("Tahoma", Font.PLAIN, 15));
        nombre.setBounds(10, 11, 182, 33);
        contentPane.add(nombre);
        nombre.setColumns(10);

        JCheckBox hecho = new JCheckBox("Hecho");
        hecho.setBounds(253, 18, 97, 23);
        contentPane.add(hecho);

        JLabel lblNewLabel = new JLabel("Prioridad");
        lblNewLabel.setBounds(10, 75, 78, 14);
        contentPane.add(lblNewLabel);

        Prioridad = new JTextField();
        Prioridad.setEditable(false);
        Prioridad.setBounds(97, 72, 120, 20);
        contentPane.add(Prioridad);
        Prioridad.setColumns(10);

        JLabel lblNewLabel_1 = new JLabel("Descripci\u00F3n");
        lblNewLabel_1.setBounds(10, 125, 78, 14);
        contentPane.add(lblNewLabel_1);

        textField = new JTextField();
        textField.setEditable(false);
        textField.setBounds(97, 122, 120, 133);
        contentPane.add(textField);
        textField.setColumns(10);

        JLabel lblNewLabel_2 = new JLabel("Subtareas");
        lblNewLabel_2.setBounds(310, 59, 90, 14);
        contentPane.add(lblNewLabel_2);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(253, 75, 175, 147);
        contentPane.add(scrollPane);

        JButton nuevaSubtarea = new JButton("Nueva subtarea");
        nuevaSubtarea.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        nuevaSubtarea.setBounds(290, 232, 138, 23);
        contentPane.add(nuevaSubtarea);
    }
}