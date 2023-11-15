package GUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import javax.swing.border.EmptyBorder;

public class VentanaHistorial extends JFrame implements ActionListener{
    private JLabel labelCerrar;
    private JButton botonCerrar;
    private GridBagConstraints gridBag;
    private TablaCotizaciones tabla;

    public VentanaHistorial() {

        this.setBounds(0, 0, 1130, 700);
        this.setLayout(new BorderLayout());
        this.setTitle("Lista de Vehiculos");
        this.setResizable(true);
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(new Color(30,136,229));

        JPanel panelTitulo = new JPanel();
        panelTitulo.setBackground(new Color(144,202,249));
        JLabel labelTitulo = new JLabel("<html><center> Historial de cotizaciones </center><br></html>",
                JLabel.CENTER);
        labelTitulo.setFont(new Font("Hack nerd font", 1, 40));
        labelTitulo.setBorder(new EmptyBorder(30, 30, 0, 30));
        labelTitulo.setVisible(true);
        panelTitulo.add(labelTitulo);
        this.add(panelTitulo, BorderLayout.NORTH);

        JPanel panelTabla = new JPanel();
        panelTabla.setBackground(new Color(30,136,229));
 
        tabla = new TablaCotizaciones();
        panelTabla.add(tabla);
        this.add(panelTabla, BorderLayout.CENTER);
             
        JPanel panelSur = new JPanel();
        panelSur.setLayout(new BorderLayout());
        panelSur.setBackground(new Color(30,136,229));
        panelSur.setBorder(new EmptyBorder(0, 0, 10, 0));
        this.add(panelSur, BorderLayout.SOUTH);
        
        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new GridBagLayout());
        
        panelBotones.setBackground(new Color(144,202,249));
        panelBotones.setBorder(new EmptyBorder(10, 10, 60, 10));
        panelSur.add(panelBotones);


        labelCerrar = new JLabel("<html><center>Cerrar</center></html>");
        labelCerrar.setFont(new Font("Hack nerd font", 1, 20));
        labelCerrar.setVisible(true);
        
        
        botonCerrar = new JButton("Cerrar");
        botonCerrar.setVisible(true);
        botonCerrar.setFont(new Font("Hack nerd font", 1, 20));
        botonCerrar.setPreferredSize(new Dimension(140, 40));
        botonCerrar.addActionListener(this);
        //botonCerrar.setForeground(new Color(40,53,147));

        gridBag = new GridBagConstraints();
        gridBag.insets.right = 40;
        gridBag.insets.left = 40;
        gridBag.insets.bottom = 10;

        gridBag.gridx = 2;
        gridBag.gridy = 1;
        panelBotones.add(botonCerrar, gridBag);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == botonCerrar) {
            this.dispose();
        } 

    }
    
}
