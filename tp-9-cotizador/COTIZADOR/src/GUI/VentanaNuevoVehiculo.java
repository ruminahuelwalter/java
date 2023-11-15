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
import Logica.iVehiculoDAO;

public class VentanaNuevoVehiculo extends JFrame implements ActionListener, ItemListener{
    
    private JPanel panelTitulo, panelPrincipal, panelSur, panelDerecho;
    private JLabel labelTitulo, labelTipo, labelMarca, labelModelo, labelAnio, labelPatente, labelColor, labelTipoTransmision, labelCantPlazas, labelCapacidadBaul, labelPMA;
    private JTextField textFieldMarca, textFieldModelo, textFieldAnio, textFieldPatente, textFieldColor,  textFieldCantPlazas, textFieldCapacidadBaul, textFieldPMA;
    private JComboBox<String> comboBoxTipo, comboBoxTransmision;
    private JButton botonAgregar, botonCancelar;
    private JCheckBox checkBoxMarca, checkBoxModelo, checkBoxAnio, checkBoxPatente, checkBoxColor, checkBoxCantPlazas, checkBoxCapacidadBaul, checkBoxPMA;
    private GridBagConstraints gridBag;
    private Tabla tabla;

    public VentanaNuevoVehiculo(Tabla tabla) {
        //this.setBounds(0, 0, 550, 550);
        this.setBounds(0, 0, 800, 600);
        this.setLayout(new BorderLayout());
        this.setTitle("Nuevo Vehiculo");
        this.setResizable(true);
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(new Color(30,136,229));

        this.tabla = tabla;

        panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new GridBagLayout());
        this.add(panelPrincipal, BorderLayout.CENTER);

        panelDerecho = new JPanel();
        panelDerecho.setLayout(new GridBagLayout());
        panelDerecho.setBackground(Color.GRAY);
        panelDerecho.setBorder(new EmptyBorder(0, 60, 60, 20));
        this.add(panelDerecho, BorderLayout.EAST);


        panelTitulo = new JPanel();
        panelTitulo.setBorder(new EmptyBorder(10, 0, 10, 0));
        this.add(panelTitulo, BorderLayout.NORTH);
        labelTitulo = new JLabel("<html><center>Seleccione e indique las<br> caracteristicas del auto:</center></html>", JLabel.CENTER);
        labelTitulo.setFont(new Font("Hack Nerd Font", 1, 30));
        panelTitulo.add(labelTitulo);

        labelTipo = new JLabel("Tipo:");
        labelTipo.setFont(new Font("Hack nerd font", 1, 20));
        String lista[] = {"Auto", "Minibus", "Furgoneta", "Camion"};
        comboBoxTipo = new JComboBox<>(lista);
        comboBoxTipo.setPreferredSize(new Dimension(210, 30));

        labelMarca = new JLabel("Marca:");
        labelMarca.setFont(new Font("Hack nerd font", 1, 20));
        textFieldMarca = new JTextField(20);
        checkBoxMarca = new JCheckBox();
        checkBoxMarca.addItemListener(this);

        labelModelo = new JLabel("Modelo:");
        labelModelo.setFont(new Font("Hack nerd font", 1, 20));
        textFieldModelo = new JTextField(20);
        checkBoxModelo = new JCheckBox();
        checkBoxModelo.addItemListener(this);


        labelAnio = new JLabel("Año de fabricacion:");
        labelAnio.setFont(new Font("Hack nerd font", 1, 20));
        textFieldAnio = new JTextField(20);
        checkBoxAnio = new JCheckBox();
        checkBoxAnio.addItemListener(this);

        labelPatente = new JLabel("Patente:");
        labelPatente.setFont(new Font("Hack nerd font", 1, 20));
        textFieldPatente = new JTextField(20);
        checkBoxPatente = new JCheckBox();
        checkBoxPatente.addItemListener(this);


        labelColor = new JLabel("Color:");
        labelColor.setFont(new Font("Hack nerd font", 1, 20));
        textFieldColor = new JTextField(20);
        checkBoxColor = new JCheckBox();
        checkBoxColor.addItemListener(this);


        labelTipoTransmision = new JLabel("Tipo de transmision:");
        labelTipoTransmision.setFont(new Font("Hack nerd font", 1, 20));
        String transmision[] = {"Manual", "Automatico"};
        comboBoxTransmision = new JComboBox<>(transmision);
        comboBoxTransmision.setPreferredSize(new Dimension(210, 30));

        
        labelCantPlazas = new JLabel("Cantidad de plazas:");
        labelCantPlazas.setFont(new Font("Hack nerd font", 1, 20));
        textFieldCantPlazas = new JTextField(20);
        checkBoxCantPlazas = new JCheckBox();
        checkBoxCantPlazas.addItemListener(this);

        labelCapacidadBaul = new JLabel("Capacidad de baul:");
        labelCapacidadBaul.setFont(new Font("Hack nerd font", 1, 20));
        textFieldCapacidadBaul = new JTextField(20);
        checkBoxCapacidadBaul = new JCheckBox();
        checkBoxCapacidadBaul.addItemListener(this);

        labelPMA = new JLabel("Peso maximo autorizado:");
        labelPMA.setFont(new Font("Hack nerd font", 1, 20));
        textFieldPMA = new JTextField(20);
        checkBoxPMA = new JCheckBox();
        checkBoxPMA.addItemListener(this);
        
        gridBag = new GridBagConstraints();
        gridBag.anchor = GridBagConstraints.EAST;
        gridBag.insets.right = 0;
        gridBag.insets.left = 0;
        //gridBag.insets.bottom = 10;
        gridBag.gridwidth = 1;
        gridBag.weightx = 1;
        gridBag.weighty = 1;


        gridBag.gridx = 0; //columna
        gridBag.gridy = 0;  //fila
        panelPrincipal.add(labelTipo, gridBag);

        gridBag.gridx = 1;
        gridBag.gridy = 0; 
        panelPrincipal.add(comboBoxTipo, gridBag);
        
        gridBag.gridx = 0;
        gridBag.gridy = 1;
        panelPrincipal.add(labelMarca, gridBag);

        gridBag.gridx = 1;
        gridBag.gridy = 1;
        panelPrincipal.add(textFieldMarca, gridBag);

        gridBag.gridx = 2;
        gridBag.gridy = 1; 
        panelPrincipal.add(checkBoxMarca, gridBag);

        gridBag.gridx = 0;
        gridBag.gridy = 2;
        panelPrincipal.add(labelModelo, gridBag);

        gridBag.gridx = 1;
        gridBag.gridy = 2;
        panelPrincipal.add(textFieldModelo, gridBag);

        gridBag.gridx = 2;
        gridBag.gridy = 2; 
        panelPrincipal.add(checkBoxModelo, gridBag);
    

        gridBag.gridx = 0;
        gridBag.gridy = 3;
        panelPrincipal.add(labelAnio, gridBag);

        gridBag.gridx = 1;
        gridBag.gridy = 3;
        panelPrincipal.add(textFieldAnio, gridBag);

        gridBag.gridx = 2;
        gridBag.gridy = 3; 
        panelPrincipal.add(checkBoxAnio, gridBag);

        gridBag.gridx = 0;
        gridBag.gridy = 4;
        panelPrincipal.add(labelPatente, gridBag);

        gridBag.gridx = 1;
        gridBag.gridy = 4;
        panelPrincipal.add(textFieldPatente, gridBag);

        gridBag.gridx = 2;
        gridBag.gridy = 4; 
        panelPrincipal.add(checkBoxPatente, gridBag);
        
        gridBag.gridx = 0;
        gridBag.gridy = 5;
        panelPrincipal.add(labelColor, gridBag);

        gridBag.gridx = 1;
        gridBag.gridy = 5;
        panelPrincipal.add(textFieldColor, gridBag);

        gridBag.gridx = 2;
        gridBag.gridy = 5; 
        panelPrincipal.add(checkBoxColor, gridBag);
        
        gridBag.gridx = 0;
        gridBag.gridy = 6;
        panelPrincipal.add(labelTipoTransmision, gridBag);

        gridBag.gridx = 1;
        gridBag.gridy = 6;
        panelPrincipal.add(comboBoxTransmision, gridBag);

        gridBag.gridx = 0;
        gridBag.gridy = 7;
        panelPrincipal.add(labelCantPlazas, gridBag);

        gridBag.gridx = 1;
        gridBag.gridy = 7;
        panelPrincipal.add(textFieldCantPlazas, gridBag);

        gridBag.gridx = 2;
        gridBag.gridy = 7; 
        panelPrincipal.add(checkBoxCantPlazas, gridBag);
        
        gridBag.gridx = 0;
        gridBag.gridy = 8;
        panelPrincipal.add(labelCapacidadBaul, gridBag);

        gridBag.gridx = 1;
        gridBag.gridy = 8;
        panelPrincipal.add(textFieldCapacidadBaul, gridBag);

        gridBag.gridx = 2;
        gridBag.gridy = 8; 
        panelPrincipal.add(checkBoxCapacidadBaul, gridBag);
        
        gridBag.gridx = 0;
        gridBag.gridy = 9;
        //panelPrincipal.add(labelPMA, gridBag);

        gridBag.gridx = 1;
        gridBag.gridy = 9;
        //panelPrincipal.add(textFieldPMA, gridBag);

        gridBag.gridx = 2;
        gridBag.gridy = 9; 
        //panelPrincipal.add(checkBoxPMA, gridBag);
        

        panelSur = new JPanel();
        panelSur.setBorder(new EmptyBorder(20, 0, 20, 0));
        this.add(panelSur, BorderLayout.SOUTH);

        botonAgregar = new JButton("Agregar");
        botonAgregar.setVisible(true);
        botonAgregar.setFont(new Font("Hack nerd font", 1, 20));
        botonAgregar.setPreferredSize(new Dimension(200, 40));
        panelSur.add(botonAgregar);
        botonAgregar.setEnabled(false);
        botonAgregar.addActionListener(this);


        botonCancelar = new JButton("Cancelar");
        botonCancelar.setVisible(true);
        botonCancelar.setFont(new Font("Hack nerd font", 1, 20));
        botonCancelar.setPreferredSize(new Dimension(200, 40));
        panelSur.add(botonCancelar);
        botonCancelar.addActionListener(this);
    }

    @Override
    public void itemStateChanged(ItemEvent e) {

        if (checkBoxMarca.isSelected() && checkBoxModelo.isSelected() && checkBoxAnio.isSelected() && checkBoxPatente.isSelected() && checkBoxColor.isSelected() && checkBoxCantPlazas.isSelected() && checkBoxCapacidadBaul.isSelected()) { 
            botonAgregar.setEnabled(true); 

        } else {
            botonAgregar.setEnabled(false);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String marca = "", modelo= "", patente = "", color = "";
        int anio=0, cantPlazas=0, capacidadBaul= 0;
        float pma=0;
        if (checkBoxMarca.isSelected()) {
            marca = textFieldMarca.getText();
        }
        if (checkBoxModelo.isSelected()) {
            modelo = textFieldModelo.getText();
        }
        if (checkBoxAnio.isSelected()) {
            anio = Integer.parseInt(textFieldAnio.getText());
        }
        if (checkBoxPatente.isSelected()) {
            patente = textFieldPatente.getText();
        }
        if (checkBoxColor.isSelected()) {
            color = textFieldColor.getText();
        }
        if (checkBoxCantPlazas.isSelected()) {
            cantPlazas = Integer.parseInt(textFieldCantPlazas.getText());
        }
        if (checkBoxCapacidadBaul.isSelected()) {
            capacidadBaul = Integer.parseInt(textFieldCapacidadBaul.getText());
        }
        if (checkBoxPMA.isSelected()) {
            pma = Float.parseFloat(textFieldPMA.getText());
        }

        if (e.getSource() == botonAgregar) {

            VehiculoBD vehiculo = new VehiculoBD();
            vehiculo.setTipoVehiculo(comboBoxTipo.getSelectedItem().toString());
            vehiculo.setMarca(marca);
            vehiculo.setModelo(modelo);
            vehiculo.setAnioFabricacion(anio);
            vehiculo.setPatente(patente);
            vehiculo.setColor(color);
            vehiculo.setTipoTransmision(comboBoxTransmision.getSelectedItem().toString());
            vehiculo.setCantPlazas(cantPlazas);
            vehiculo.setCapacidadBaul(capacidadBaul);
            vehiculo.setPma(pma);
            
            iVehiculoDAO iVehiculo = new VehiculoDAO();
            iVehiculo.insertar(vehiculo);
            //Actualizar tabla
            List<VehiculoBD> lista = iVehiculo.listar();
            tabla.actualizarTabla(lista);
            this.dispose();
        }

        if (e.getSource() == botonCancelar) {
            this.dispose();
        }
    }

    
}
