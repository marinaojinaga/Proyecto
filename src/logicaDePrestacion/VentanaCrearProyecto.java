package logicaDePrestacion;

import gestionBD.GestorBD;
import logicaDeDatos.Proyecto;
import logicaDeDatos.Usuario;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaCrearProyecto extends JFrame {

    private JPanel contentPane;
    private JTextField nombre;

    /**
     * Create the frame.
     */
    public VentanaCrearProyecto(Usuario usuario) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("Crea un nuevo proyecto");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel.setBounds(105, 11, 249, 21);
        contentPane.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Nombre");
        lblNewLabel_1.setBounds(10, 84, 88, 14);
        contentPane.add(lblNewLabel_1);

        nombre = new JTextField();
        nombre.setBounds(76, 81, 330, 20);
        contentPane.add(nombre);
        nombre.setColumns(10);

        JCheckBox favorito = new JCheckBox("Favorito");
        favorito.setBounds(176, 126, 88, 23);
        contentPane.add(favorito);

        JButton Aceptar = new JButton("Aceptar");
        Aceptar.addActionListener(e -> {
                Proyecto proyecto = new Proyecto(nombre.getText(),favorito.isSelected(),0,usuario.getId_usuario());
                GestorBD g = new GestorBD();
                g.insertProyecto(proyecto);
                VentanaProyectos ventanaProyectos = new VentanaProyectos(usuario);
                ventanaProyectos.setVisible(true);
                VentanaCrearProyecto.this.setVisible(false);
        });
        Aceptar.setBounds(176, 218, 89, 23);
        contentPane.add(Aceptar);
    }
}
