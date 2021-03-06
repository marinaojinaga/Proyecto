package logicaDePrestacion;

import gestionBD.GestorBD;
import logicaDeDatos.Proyecto;
import logicaDeDatos.QuickSort;
import logicaDeDatos.Tarea;
import logicaDeDatos.Usuario;
import logicaNegocio.CalculadorHechoGenerico;

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
    public VentanaUnProyecto(Proyecto proyectoP, Usuario usuario) throws SQLException {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        nombreProyecto = new JTextField();
        nombreProyecto.setText(proyectoP.getNombre());
        nombreProyecto.setEditable(false);
        nombreProyecto.setBounds(10, 11, 172, 32);
        contentPane.add(nombreProyecto);
        nombreProyecto.setColumns(10);

        JCheckBox favorito = new JCheckBox("Favorito");
        favorito.setSelected(proyectoP.isFavorito());
        favorito.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                proyectoP.setFavorito(favorito.isSelected());
                GestorBD g = new GestorBD();
                g.updateProyecto(favorito.isSelected(),proyectoP.getId_proyecto());
            }
        });
        favorito.setBounds(270, 50, 97, 23);
        contentPane.add(favorito);

        GestorBD gestorBD = new GestorBD();
        DefaultListModel<Tarea> tareasUx = new DefaultListModel<Tarea>();
        ArrayList<Tarea> tareas = gestorBD.selectTareas();
        ArrayList<Tarea> tareasPorcentaje = new ArrayList<Tarea>();
        tareas.forEach(e->{
            if(e.getId_proyecto() == proyectoP.getId_proyecto()){
                tareasUx.addElement(e);
                tareasPorcentaje.add(e);
            }
        });

        JLabel lblNewLabel = new JLabel("Tareas completadas");
        lblNewLabel.setBounds(307, 127, 121, 14);
        contentPane.add(lblNewLabel);

        JTextField porcentaje = new JTextField();
        porcentaje.setEditable(false);
        CalculadorHechoGenerico<Tarea> calculadorHechoGenerico = new CalculadorHechoGenerico<Tarea>();
        String por =calculadorHechoGenerico.calcular(tareasPorcentaje);
        porcentaje.setText(por);
        porcentaje.setBounds(307, 152, 121, 20);
        contentPane.add(porcentaje);
        porcentaje.setColumns(10);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 79, 219, 148);
        contentPane.add(scrollPane);

        JList list = new JList();
        list.addListSelectionListener(e-> {
            Tarea t = (Tarea)list.getSelectedValue();
            VentanaVisionTarea ventanaVisionTarea = new VentanaVisionTarea(t,proyectoP,usuario);
            VentanaUnProyecto.this.setVisible(false);
            ventanaVisionTarea.setVisible(true);
        });
        scrollPane.setViewportView(list);
        list.setModel(tareasUx);

        JButton nuevaTarea = new JButton("Nueva tarea");
        nuevaTarea.addActionListener(e->{
            GestorBD g = new GestorBD();
            g.updateProyecto(favorito.isSelected(),proyectoP.getId_proyecto());
            VentanaCrearTarea ventanaCrearTarea = new VentanaCrearTarea(proyectoP,usuario);
            ventanaCrearTarea.setVisible(true);
            VentanaUnProyecto.this.setVisible(false);
        });
        nuevaTarea.setBounds(274, 204, 154, 23);
        contentPane.add(nuevaTarea);

        JButton atras = new JButton("Atras");
        atras.addActionListener(e-> {
            VentanaProyectos ventanaProyectos = new VentanaProyectos(usuario);
            ventanaProyectos.setVisible(true);
            VentanaUnProyecto.this.setVisible(false);
        });
        atras.setBounds(339, 11, 89, 23);
        contentPane.add(atras);

        JComboBox ordenar = new JComboBox();
        ordenar.addItem("......");
        ordenar.addItem("Orden alfab?tico");
        ordenar.addItem("Tareas no hechas arriba");
        ordenar.addItem("Ordenar por prioridad");
        ordenar.addActionListener(e-> {
            QuickSort quickSort = new QuickSort();
            DefaultListModel<Tarea> tareaOrdenada = new DefaultListModel<Tarea>();
            if(ordenar.getSelectedItem().equals("Orden alfab?tico")){
                quickSort.SortAlfabetico(tareasPorcentaje,0,tareasPorcentaje.size()-1);
            }else if (ordenar.getSelectedItem().equals("Tareas no hechas arriba")){
                quickSort.SortBooleanos(tareasPorcentaje,0,tareasPorcentaje.size()-1);
            }else if(ordenar.getSelectedItem().equals("Ordenar por prioridad")){
                quickSort.SortPrioridad(tareasPorcentaje,0,tareasPorcentaje.size()-1);
            }
            tareasPorcentaje.forEach(f->tareaOrdenada.addElement(f));
            list.setModel(tareaOrdenada);
        });
        ordenar.setBounds(10, 57, 219, 22);
        getContentPane().add(ordenar);
    }
}

