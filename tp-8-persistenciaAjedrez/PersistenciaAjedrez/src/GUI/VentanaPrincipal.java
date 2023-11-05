package GUI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.*;

import AccesoDatos.PiezaDAO;
import Logica.*;

public class VentanaPrincipal extends JFrame implements ActionListener {

    private JButton botonAgregarPieza;
    private JButton botonAgregarSetPiezas;
    private JButton botonActualizarTabla;
    private JLabel labelAgregarPieza, labelSetPiezas, labelActualizar;
    private Tabla tabla;

    public VentanaPrincipal() {

        this.getContentPane().setBackground(new Color(174, 182, 191));
        this.setLayout(null);
        this.setBounds(0, 0, 1130, 800);
        this.setTitle("Ajedrez");
        this.setResizable(false);

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

        labelActualizar = new JLabel("Actualizar tabla");
        labelActualizar.setBounds(355, 660, 150, 30);
        this.add(labelActualizar);

        botonActualizarTabla = new JButton("Actualizar");
        botonActualizarTabla.setBounds(350, 690, 120, 30);
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
            subVentana.setVisible(true);
            subVentana.setResizable(true);
            subVentana.setLocationRelativeTo(null);

        }
        
        if (e.getSource() == botonAgregarSetPiezas) {
            
            VentanaInsetarSet ventanaInsetarSet = new VentanaInsetarSet();
            ventanaInsetarSet.setVisible(true);
            ventanaInsetarSet.setResizable(true);
            ventanaInsetarSet.setLocationRelativeTo(null);
       
        }
        
        if (e.getSource() == botonActualizarTabla) {
            iPiezaDAO iPiezaA = new PiezaDAO();
            List<PiezaBD> lista = iPiezaA.listar();
            tabla.actualizarTabla(lista);
        }
    }
    
    

}