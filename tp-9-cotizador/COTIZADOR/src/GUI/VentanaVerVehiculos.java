package GUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.util.List;
import AccesoDatos.VehiculoDAO;
import Logica.VehiculoBD;


public class VentanaVerVehiculos extends JFrame implements ActionListener{
    private JLabel labelAgregarVehiculo, labelEliminarVehiculo, labelCerrar;
    private JButton botonAgregarVehiculo, botonEliminarVehiculo, botonCerrar;
    private GridBagConstraints gridBag;
    private Tabla tabla;

    public VentanaVerVehiculos() {

        this.setBounds(0, 0, 1130, 700);
        this.setLayout(new BorderLayout());
        this.setTitle("Lista de Vehiculos");
        this.setResizable(true);
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(new Color(30,136,229));

        JPanel panelTitulo = new JPanel();
        panelTitulo.setBackground(new Color(144,202,249));
        JLabel labelTitulo = new JLabel("<html><center> Vehiculos disponibles para alquilar </center><br></html>",
                JLabel.CENTER);
        labelTitulo.setFont(new Font("Hack nerd font", 1, 40));
        labelTitulo.setBorder(new EmptyBorder(30, 30, 0, 30));
        labelTitulo.setVisible(true);
        panelTitulo.add(labelTitulo);
        this.add(panelTitulo, BorderLayout.NORTH);

        JPanel panelTabla = new JPanel();
        panelTabla.setBackground(new Color(30,136,229));
        this.tabla = new Tabla();
        
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
        

        labelAgregarVehiculo = new JLabel("<html><center>Agregar nuevo<br>vehiculo</center></html>");
        labelAgregarVehiculo.setFont(new Font("Hack nerd font", 1, 20));
        labelAgregarVehiculo.setVisible(true);
        

        botonAgregarVehiculo = new JButton("Agregar");
        botonAgregarVehiculo.setVisible(true);
        botonAgregarVehiculo.setFont(new Font("Hack nerd font", 1, 20));
        botonAgregarVehiculo.setPreferredSize(new Dimension(140, 40));
        botonAgregarVehiculo.addActionListener(this);

        labelEliminarVehiculo = new JLabel("<html><center>Eliminar vehiculo</center></html>");
        labelEliminarVehiculo.setFont(new Font("Hack nerd font", 1, 20));
        labelEliminarVehiculo.setVisible(true);
            
        botonEliminarVehiculo = new JButton("Eliminar");
        botonEliminarVehiculo.setVisible(true);
        botonEliminarVehiculo.setFont(new Font("Hack nerd font", 1, 20));
        botonEliminarVehiculo.setPreferredSize(new Dimension(140, 40));
        botonEliminarVehiculo.addActionListener(this);


        labelCerrar = new JLabel("<html><center>Cerrar</center></html>");
        labelCerrar.setFont(new Font("Hack nerd font", 1, 20));
        labelCerrar.setVisible(true);
        
        botonCerrar = new JButton("Cerrar");
        botonCerrar.setVisible(true);
        botonCerrar.setFont(new Font("Hack nerd font", 1, 20));
        botonCerrar.setPreferredSize(new Dimension(140, 40));
        botonCerrar.addActionListener(this);


        gridBag = new GridBagConstraints();
        gridBag.insets.right = 40;
        gridBag.insets.left = 40;
        gridBag.insets.bottom = 10;

        gridBag.gridx = 0;
        gridBag.gridy = 0;
        //gridBag.fill = GridBagConstraints.BOTH;
        panelBotones.add(labelAgregarVehiculo, gridBag);

        gridBag.gridx = 0;
        gridBag.gridy = 1;
        panelBotones.add(botonAgregarVehiculo, gridBag);

        gridBag.gridx = 1;
        gridBag.gridy = 0;
        panelBotones.add(labelEliminarVehiculo, gridBag);

        gridBag.gridx = 1;
        gridBag.gridy = 1;
        panelBotones.add(botonEliminarVehiculo, gridBag);

        gridBag.gridx = 2;
        gridBag.gridy = 0;
        panelBotones.add(labelCerrar, gridBag);

        gridBag.gridx = 2;
        gridBag.gridy = 1;
        panelBotones.add(botonCerrar, gridBag);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == botonAgregarVehiculo) {
            VentanaNuevoVehiculo ventana = new VentanaNuevoVehiculo(tabla);
            ventana.setVisible(true);
        }

        if (e.getSource() == botonCerrar) {
            this.dispose();
        } 

        if (e.getSource() == botonEliminarVehiculo) {
            
            try {
                int n = JOptionPane.showOptionDialog(null, "          ¿Esta seguro?", "Confirmar", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,new Object[]{"SI","NO"},null);
                if (n==0){
                    
                    VehiculoDAO iVehiculoDAO = new VehiculoDAO();
                    iVehiculoDAO.eliminarElemento(tabla.elementoSeleccionado());
                    
                    List<VehiculoBD> lista = iVehiculoDAO.listar();
                    tabla.actualizarTabla(lista);
                }
                
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Seleccione un elemento");
            }
           
        }

    }
    
}
