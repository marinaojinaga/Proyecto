package logicaDePrestacion;

import gestionBD.GestorBD;
import logicaDeDatos.*;
import logicaNegocio.CalculadorHechoGenerico;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.ArrayList;

public class VentanaVisionTarea extends JFrame {

    private JPanel contentPane;
    private JTextField nombre;
    private JTextField Prioridad;
    private JTextField descripcion;

    /**
     * Create the frame.
     */
    public VentanaVisionTarea(Tarea tarea, Proyecto proyecto, Usuario usuario) {
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
        hecho.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tarea.setHecho(hecho.isSelected());
                GestorBD g = new GestorBD();
                g.updateTareas(hecho.isSelected(), tarea.getPrioridad(),tarea.getId_tarea());
            }
        });
        hecho.setBounds(253, 18, 75, 23);
        contentPane.add(hecho);

        JLabel lblNewLabel = new JLabel("Prioridad");
        lblNewLabel.setBounds(10, 75, 78, 14);
        contentPane.add(lblNewLabel);


        JComboBox Prioridad = new JComboBox<logicaDeDatos.Prioridad>();
        Prioridad[] p = new Prioridad[]{logicaDeDatos.Prioridad.Alta,logicaDeDatos.Prioridad.Media, logicaDeDatos.Prioridad.Baja};
        Prioridad.setModel(new DefaultComboBoxModel(p));
        Prioridad.setSelectedItem(tarea.getPrioridad());
        Prioridad.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tarea.setPrioridad((logicaDeDatos.Prioridad) Prioridad.getSelectedItem());
                GestorBD gestorBD = new GestorBD();
                gestorBD.updateTareas(tarea.isHecho(), (logicaDeDatos.Prioridad) Prioridad.getSelectedItem(),tarea.getId_tarea());
            }
        });
        Prioridad.setBounds(97, 72, 120, 20);
        contentPane.add(Prioridad);

        JLabel lblNewLabel_1 = new JLabel("Descripci\u00F3n");
        lblNewLabel_1.setBounds(10, 125, 78, 14);
        contentPane.add(lblNewLabel_1);

        JTextPane descripcion = new JTextPane();
        descripcion.setText(tarea.getDescripcion());
        descripcion.setEditable(false);
        descripcion.setBounds(81, 125, 149, 72);
        contentPane.add(descripcion);

        JLabel lblNewLabel_2 = new JLabel("Subtareas");
        lblNewLabel_2.setBounds(310, 59, 90, 14);
        contentPane.add(lblNewLabel_2);

        GestorBD gestorBD = new GestorBD();
        DefaultListModel<Subtarea> subtareas = new DefaultListModel<Subtarea>();
        ArrayList<Subtarea> sub = gestorBD.selectSubtareas();
        ArrayList<Subtarea> subtareasPorcentaje = new ArrayList<Subtarea>();
        for(int i=0;i<sub.size();i++){
            if(sub.get(i).getId_tarea()==tarea.getId_tarea()){
                subtareas.addElement(sub.get(i));
                subtareasPorcentaje.add(sub.get(i));
            }
        }
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(253, 75, 175, 122);
        contentPane.add(scrollPane);

        JList list = new JList();
        list.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                Subtarea subtarea = (Subtarea)list.getSelectedValue();
                VentanaVisionSubtarea ventanaVisionSubtarea = new VentanaVisionSubtarea(subtarea,tarea,proyecto,usuario);
                ventanaVisionSubtarea.setVisible(true);
                VentanaVisionTarea.this.setVisible(false);
            }
        });
        scrollPane.setViewportView(list);
        list.setModel(subtareas);

        JComboBox ordenar = new JComboBox();
        ordenar.addItem("......");
        ordenar.addItem("Orden alfabético");
        ordenar.addItem("Tareas no hechas arriba");
        ordenar.addItem("Ordenar por prioridad");
        ordenar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                QuickSort quickSort = new QuickSort();
                DefaultListModel<Subtarea> subtareaOrdenada = new DefaultListModel<>();
                if(ordenar.getSelectedItem().equals("Orden alfabético")){
                    quickSort.QuickSortAlfabetico(subtareasPorcentaje,0,subtareasPorcentaje.size()-1);
                }else if (ordenar.getSelectedItem().equals("Tareas no hechas arriba")){
                    quickSort.QuickSortBooleanos(subtareasPorcentaje,0,subtareasPorcentaje.size()-1);
                }else if(ordenar.getSelectedItem().equals("Ordenar por prioridad")){
                    quickSort.QuickSortPrioridad(subtareasPorcentaje,0,subtareasPorcentaje.size()-1);
                }
                for(int i=0;i<subtareasPorcentaje.size();i++){
                    subtareaOrdenada.addElement(subtareasPorcentaje.get(i));
                }
                list.setModel(subtareaOrdenada);
            }
        });
        ordenar.setBounds(253, 197, 175, 22);
        getContentPane().add(ordenar);


        JButton nuevaSubtarea = new JButton("Nueva subtarea");
        nuevaSubtarea.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                VentanaCrearSubtareas ventanaCrearSubtareas = new VentanaCrearSubtareas(tarea,proyecto,usuario);
                ventanaCrearSubtareas.setVisible(true);
                VentanaVisionTarea.this.setVisible(false);
            }
        });
        nuevaSubtarea.setBounds(290, 232, 138, 23);
        contentPane.add(nuevaSubtarea);

        JLabel lblNewLabel_3 = new JLabel("Subtareas completadas");
        lblNewLabel_3.setBounds(10, 236, 140, 14);
        contentPane.add(lblNewLabel_3);

        JTextField porcentaje = new JTextField();
        CalculadorHechoGenerico<Subtarea> CalculadorHechoGenerico = new CalculadorHechoGenerico<Subtarea>();
        String s = CalculadorHechoGenerico.calcular(subtareasPorcentaje);
        porcentaje.setText(s);
        porcentaje.setEditable(false);
        porcentaje.setBounds(150, 233, 96, 20);
        contentPane.add(porcentaje);
        porcentaje.setColumns(10);

        JButton atras = new JButton("Atras");
        atras.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    VentanaUnProyecto ventanaUnProyecto = new VentanaUnProyecto(proyecto,usuario);
                    ventanaUnProyecto.setVisible(true);
                    VentanaVisionTarea.this.setVisible(false);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }

            }
        });
        atras.setBounds(339, 11, 89, 23);
        contentPane.add(atras);
    }
}