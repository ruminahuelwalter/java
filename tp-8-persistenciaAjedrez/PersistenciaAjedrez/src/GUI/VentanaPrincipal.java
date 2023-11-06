package GUI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.*;
import AccesoDatos.PiezaDAO;
import Logica.*;

public class VentanaPrincipal extends JFrame implements ActionListener {
    
    private JButton botonAgregarPieza,botonAgregarSetPiezas, botonActualizarTabla, botonEliminar;
    private JLabel labelAgregarPieza, labelSetPiezas, labelActualizar, labelEliminar;
    private Tabla tabla;

    public VentanaPrincipal() {

        this.getContentPane().setBackground(new Color(174, 182, 191));
        this.setLayout(null);
        this.setBounds(0, 0, 1130, 800);
        this.setTitle("Ajedrez");
        this.setResizable(false);
        this.setLocationRelativeTo(null);


        labelAgregarPieza = new JLabel("Agregar Nueva Pieza");
        labelAgregarPieza.setBounds(50, 660, 130, 30);
        this.add(labelAgregarPieza);
        botonAgregarPieza = new JButton("Agregar");
        botonAgregarPieza.setBounds(50, 690, 120, 30);
        botonAgregarPieza.setVisible(true);
        this.add(botonAgregarPieza);
        botonAgregarPieza.addActionListener(this);

        labelSetPiezas = new JLabel("Agregar Set de piezas");
        labelSetPiezas.setBounds(200, 660, 150, 30);
        this.add(labelSetPiezas);

        botonAgregarSetPiezas = new JButton("Agregar");
        botonAgregarSetPiezas.setBounds(200, 690, 120, 30);
        botonAgregarSetPiezas.setVisible(true);
        this.add(botonAgregarSetPiezas);
        botonAgregarSetPiezas.addActionListener(this);

        labelEliminar = new JLabel("Borrado Fisico");
        labelEliminar.setBounds(370, 660, 150, 30);
        this.add(labelEliminar);
        
        botonEliminar = new JButton("Eliminar");
        botonEliminar.setBounds(350, 690, 120, 30);
        botonEliminar.setVisible(true);
        this.add(botonEliminar);
        botonEliminar.addActionListener(this);

        labelActualizar = new JLabel("Actualizar tabla");
        labelActualizar.setBounds(520, 660, 150, 30);
        this.add(labelActualizar);

        botonActualizarTabla = new JButton("Actualizar");
        botonActualizarTabla.setBounds(500, 690, 120, 30);
        botonActualizarTabla.setVisible(true);
        this.add(botonActualizarTabla);
        botonActualizarTabla.addActionListener(this);


        tabla = new Tabla();
        tabla.setLayout(null);
        tabla.setBounds(50, 50, 1000, 600);
        tabla.setVisible(true);
        this.add(tabla);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == botonAgregarPieza) {
      
            VentanaNuevaPieza subVentana = new VentanaNuevaPieza();
            configVentana(subVentana);
        }
        
        if (e.getSource() == botonAgregarSetPiezas) {
            
            VentanaInsertarSet ventanaInsetarSet = new VentanaInsertarSet();
            configVentana(ventanaInsetarSet);
        }
        
        if (e.getSource() == botonActualizarTabla) {
            iPiezaDAO iPiezaA = new PiezaDAO();
            List<PiezaBD> lista = iPiezaA.listar();
            tabla.actualizarTabla(lista);
        }

        if (e.getSource() == botonEliminar) {
            
            int n = JOptionPane.showOptionDialog(null, "          ¿Esta seguro?", "Confirmar", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,new Object[]{"SI","NO"},null);
            if (n==0){
                String id = tabla.eliminarElemento();
                iPiezaDAO iPiezaA = new PiezaDAO();
                iPiezaA.eliminarElemento(id);
            }
            
        }
    }
    
    public void configVentana(JFrame ventana) {
        ventana.setVisible(true);
        ventana.setResizable(false);
        ventana.setLocationRelativeTo(null);

        
    }

}