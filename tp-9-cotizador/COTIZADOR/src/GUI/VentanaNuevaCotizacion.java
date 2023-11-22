package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import java.awt.event.*;
import java.util.List;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import AccesoDatos.VehiculoDAO;
import Logica.VehiculoBD;

public class VentanaNuevaCotizacion extends JFrame implements ActionListener, ItemListener, KeyListener{

    private JLabel labelCotizar, labelCerrar;
    private JButton botonCotizar, botonCerrar;
    private JCheckBox checkBoxCantidadDias;
    private JTextField textFieldCantidadDias;
    private GridBagConstraints gridBag;
    private Tabla tabla;
    private JPanel panelTabla;

    public VentanaNuevaCotizacion() {
      
        this.setBounds(0, 0, 1130, 700);
        this.setLayout(new BorderLayout());
        this.setTitle("Cotizar Vehiculo");
        this.setResizable(true);
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(new Color(30,136,229));

        JPanel panelTitulo = new JPanel();
        panelTitulo.setBackground(new Color(144,202,249));
        JLabel labelTitulo = new JLabel("<html><center> Seleccione un vehiculo para cotizar </center><br></html>",
                JLabel.CENTER);
        labelTitulo.setFont(new Font("Hack nerd font", 1, 40));
        labelTitulo.setBorder(new EmptyBorder(30, 30, 0, 30));
        labelTitulo.setVisible(true);
        panelTitulo.add(labelTitulo);
        this.add(panelTitulo, BorderLayout.NORTH);


        panelTabla = new JPanel();
        panelTabla.setBackground(new Color(30,136,229));
 

        tabla = new Tabla();
        
        panelTabla.add(tabla, BorderLayout.CENTER);
        this.add(panelTabla, BorderLayout.CENTER);
          
        
        JPanel panelSur = new JPanel();
        panelSur.setLayout(new BorderLayout());
        panelSur.setBackground(new Color(30,136,229));
        panelSur.setBorder(new EmptyBorder(0, 0, 10, 0));

        this.add(panelSur, BorderLayout.SOUTH);
        
        JPanel panelCantidadDias = new JPanel();
        panelCantidadDias.setLayout(new GridBagLayout());
        panelCantidadDias.setBackground(new Color(144,202,249));
        panelCantidadDias.setBorder(new EmptyBorder(5, 10, 0, 10));
   
        panelSur.add(panelCantidadDias, BorderLayout.NORTH);  

        JLabel labelCantidadDias = new JLabel("<html><center>Ingrese la cantidad de dias: </center></html>");
        labelCantidadDias.setFont(new Font("Hack nerd font", 1, 17));
        labelCantidadDias.setVisible(true);

        textFieldCantidadDias = new JTextField(5);
        textFieldCantidadDias.addKeyListener(this);
        textFieldCantidadDias.setBorder(new EmptyBorder(5, 5, 5, 5));
        
        checkBoxCantidadDias = new JCheckBox();
        checkBoxCantidadDias.addItemListener(this);

        GridBagConstraints gridBag0 = new GridBagConstraints();
        gridBag0.insets.right = 0;
        gridBag0.insets.left = 20;
        gridBag0.insets.bottom = 5;
        gridBag0.anchor = GridBagConstraints.EAST;

        gridBag0.gridx = 0;
        gridBag0.gridy = 0;
        gridBag0.fill = GridBagConstraints.NONE;
        gridBag0.anchor = GridBagConstraints.EAST;
        panelCantidadDias.add(labelCantidadDias, gridBag0);

        gridBag0.gridx = 1;
        gridBag0.gridy = 0;
        gridBag0.fill = GridBagConstraints.NONE;
        gridBag0.anchor = GridBagConstraints.EAST;
        panelCantidadDias.add(textFieldCantidadDias, gridBag0);

        gridBag0.gridx = 2;
        gridBag0.gridy = 0;
        gridBag0.fill = GridBagConstraints.NONE;
        gridBag0.anchor = GridBagConstraints.EAST;
        panelCantidadDias.add(checkBoxCantidadDias, gridBag0);
        
        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new GridBagLayout());
        
        panelBotones.setBackground(new Color(144,202,249));
        panelBotones.setBorder(new EmptyBorder(10, 10, 10, 10));
        panelSur.add(panelBotones, BorderLayout.SOUTH);  
    
        labelCotizar = new JLabel("<html><center>Cotizar<br> vehiculo</center></html>");
        labelCotizar.setFont(new Font("Hack nerd font", 1, 15));
        labelCotizar.setVisible(true);
       
        botonCotizar = new JButton("Cotizar");
        botonCotizar.setVisible(true);
        botonCotizar.setFont(new Font("Hack nerd font", 1, 15));
        botonCotizar.setPreferredSize(new Dimension(120, 30));
        botonCotizar.addActionListener(this);
        botonCotizar.setEnabled(false);
        
        labelCerrar = new JLabel("<html><center>Cerrar</center></html>");
        labelCerrar.setFont(new Font("Hack nerd font", 1, 15));
        labelCerrar.setVisible(true);
            
        botonCerrar = new JButton("Cerrar");
        botonCerrar.setVisible(true);
        botonCerrar.setFont(new Font("Hack nerd font", 1, 15));
        botonCerrar.setPreferredSize(new Dimension(120, 30));
        botonCerrar.addActionListener(this);
        
        gridBag = new GridBagConstraints();
        gridBag.insets.right = 40;
        gridBag.insets.left = 40;
        gridBag.insets.bottom = 10;
         
        gridBag.gridx = 0;
        gridBag.gridy = 1;
        gridBag.fill = GridBagConstraints.NONE;
        panelBotones.add(botonCotizar, gridBag);

        gridBag.gridx = 1;
        gridBag.gridy = 1;
        gridBag.fill = GridBagConstraints.NONE;
        panelBotones.add(botonCerrar, gridBag);
  
       
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cantidadDias = textFieldCantidadDias .getText();
     
        if (e.getSource() == botonCotizar) {
            try {
  
                int cantDias = Integer.parseInt(cantidadDias);
         
                VehiculoBD vehiculo = new VehiculoBD();
                vehiculo = tabla.vehiculoSeleccionado();
                
                VentanaDetalleCotizacion ventanaCotizar = new VentanaDetalleCotizacion(vehiculo,cantDias,tabla);
                ventanaCotizar.setVisible(true);

                VehiculoDAO iVehiculo = new VehiculoDAO();
                List<VehiculoBD> lista = iVehiculo.listar();
                tabla.actualizarTabla(lista);
                
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Seleccione un elemento", "Atención!", JOptionPane.WARNING_MESSAGE);
            }
        }

        if (e.getSource() == botonCerrar) {
            this.dispose();
        }

    }


    @Override
    public void itemStateChanged(ItemEvent e) {
        if (checkBoxCantidadDias.isSelected()){
            botonCotizar.setEnabled(true); 

        } else {
            botonCotizar.setEnabled(false);
            }

    }

    private void textFieldCantidadDiasTecla (java.awt.event.KeyEvent event){
        int tecla = event.getKeyChar();
        boolean numero = tecla >= 48 && tecla <=57;
        if (!numero){
            event.consume(); // No acepta ascii diferente del rango de arriba
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
       textFieldCantidadDiasTecla(e);
    }

    @Override
    public void keyPressed(KeyEvent e) {
       
    }

    @Override
    public void keyReleased(KeyEvent e) {
        textFieldCantidadDiasTecla(e);
    }
    
}
