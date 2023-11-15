package GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class VentanaBienvenida extends JFrame implements ActionListener {
    
    private JPanel panelCentral, panelBotones, panelNorte, panelIzquierdo, panelDerecho, panelSur;
    private JLabel labelTitulo, labelVerVehiculos, labelVerCotizaciones, labelNuevaCotizacion;
    private JButton botonVerVehiculos, botonNuevaCotizacion, botonVerCotizaciones;

    public VentanaBienvenida() {

        this.getContentPane().setBackground(new Color(84, 110, 122));
        this.setLayout(new BorderLayout());
        this.setBounds(0, 0, 1130, 700);
        this.setTitle("Cotizador");
        this.setResizable(true);
        this.setLocationRelativeTo(null);

        panelNorte = new JPanel();
        panelNorte.setBackground(new Color(30,136,229));
        panelNorte.setBorder(new EmptyBorder(20, 10, 0, 10));
        panelNorte.setVisible(true);
        this.add(panelNorte, BorderLayout.NORTH);

        panelDerecho = new JPanel();
        panelDerecho.setBackground(new Color(30,136,229));
        panelDerecho.setVisible(true);
        panelDerecho.setBorder(new EmptyBorder(10, 10, 10, 10));
        this.add(panelDerecho, BorderLayout.EAST);

        panelIzquierdo = new JPanel();
        panelIzquierdo.setBackground(new Color(30,136,229));
        panelIzquierdo.setVisible(true);
        panelIzquierdo.setBorder(new EmptyBorder(10, 10, 10, 10));
        this.add(panelIzquierdo, BorderLayout.WEST);

        panelCentral = new JPanel();
        panelCentral.setBackground(new Color(144,202,249));

        labelTitulo = new JLabel("<html><center><br>Bienvenido al programa<br> cotizador de alquiler<br> de vehiculos</center><br></html>",
                JLabel.CENTER);
        labelTitulo.setFont(new Font("Hack nerd font", 1, 70));
        labelTitulo.setVisible(true);
        panelCentral.add(labelTitulo);
        this.add(panelCentral, BorderLayout.CENTER);

        panelSur = new JPanel();
        panelSur.setLayout(new BorderLayout());
        panelSur.setBackground(new Color(30,136,229));
        panelSur.setBorder(new EmptyBorder(30, 30, 30, 30));
        this.add(panelSur, BorderLayout.SOUTH);

        panelBotones = new JPanel();
        panelBotones.setLayout(new GridBagLayout());

        panelBotones.setBackground(new Color(144,202,249));
        panelBotones.setBorder(new EmptyBorder(60, 20, 60, 20));
        panelSur.add(panelBotones, BorderLayout.CENTER);

        GridBagConstraints gridBag = new GridBagConstraints();
        gridBag.insets.right = 40;
        gridBag.insets.left = 40;
        gridBag.insets.bottom = 10;
        gridBag.gridx = 0;
        gridBag.gridy = 0;
        gridBag.fill = GridBagConstraints.BOTH;

        labelVerVehiculos = new JLabel("<html><center>Ver Vehiculos<br> Disponibles</center></html>");
        labelVerVehiculos.setFont(new Font("Hack nerd font", 1, 20));
        labelVerVehiculos.setVisible(true);
        panelBotones.add(labelVerVehiculos, gridBag);

        gridBag.gridx = 0;
        gridBag.gridy = 1;

        botonVerVehiculos = new JButton("Ver");
        botonVerVehiculos.setVisible(true);
        botonVerVehiculos.setFont(new Font("Hack nerd font", 1, 20));
        botonVerVehiculos.setPreferredSize(new Dimension(100, 40));
        panelBotones.add(botonVerVehiculos, gridBag);
        botonVerVehiculos.addActionListener(this);

        gridBag.gridx = 1;
        gridBag.gridy = 0;

        labelNuevaCotizacion = new JLabel("<html><center>Cotizar vehiculo</center></html>");
        labelNuevaCotizacion.setFont(new Font("Hack nerd font", 1, 20));
        labelNuevaCotizacion.setVisible(true);
        panelBotones.add(labelNuevaCotizacion, gridBag);

        gridBag.gridx = 1;
        gridBag.gridy = 1;

        botonNuevaCotizacion = new JButton("Cotizar");
        botonNuevaCotizacion.setVisible(true);
        botonNuevaCotizacion.setFont(new Font("Hack nerd font", 1, 20));
        botonNuevaCotizacion.setPreferredSize(new Dimension(130, 30));
        panelBotones.add(botonNuevaCotizacion, gridBag);
        botonNuevaCotizacion.addActionListener(this);

        gridBag.gridx = 3;
        gridBag.gridy = 0;

        labelVerCotizaciones = new JLabel("<html><center>Ver historial<br> de cotizaciones</center></html>");
        labelVerCotizaciones.setVisible(true);
        labelVerCotizaciones.setFont(new Font("Hack nerd font", 1, 20));
        panelBotones.add(labelVerCotizaciones, gridBag);

        gridBag.gridx = 3;
        gridBag.gridy = 1;

        botonVerCotizaciones = new JButton("Ver");
        botonVerCotizaciones.setVisible(true);
        botonVerCotizaciones.setPreferredSize(new Dimension(100, 30));
        botonVerCotizaciones.setFont(new Font("Hack nerd font", 1, 20));
        panelBotones.add(botonVerCotizaciones, gridBag);
        botonVerCotizaciones.addActionListener(this);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == botonVerVehiculos) {
            VentanaVerVehiculos ventana = new VentanaVerVehiculos();
            ventana.setVisible(true);
            //ventana.pack();
            //ventana.repaint(); 
        }
        if (e.getSource() == botonNuevaCotizacion){
            VentanaNuevaCotizacion ventanaC = new VentanaNuevaCotizacion();
            ventanaC.setVisible(true);
            //ventanaC.pack();
        }
        if (e.getSource() == botonVerCotizaciones){
            VentanaHistorial ventanaVer = new VentanaHistorial();
            ventanaVer.setVisible(true);
            //ventanaVer.pack();
        }
    }

}
