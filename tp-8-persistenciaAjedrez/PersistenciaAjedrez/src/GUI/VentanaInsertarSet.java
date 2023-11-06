package GUI;

import javax.swing.*;
import AccesoDatos.PiezaDAO;
import Logica.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.util.List;

public class VentanaInsertarSet extends JFrame implements ActionListener, ItemListener {
    
    private JLabel labelTitulo, labelMaterial, labelTamanio, labelDescripcion;
    private JButton botonAceptar, botonCancelar;
    private JComboBox<String> comboBoxMaterial, comboBoxTamanio;
    private JTextField textFieldDescripcion;
    private JCheckBox checkBoxDescripcion;
    private Tabla tabla;
    private int r,g,b;

    public VentanaInsertarSet(Tabla tabla) {
        this.tabla = tabla;
        r = 174;
        g = 182;
        b = 191;

        this.getContentPane().setBackground(new Color(174, 182, 191));
        this.setLayout(null);
        this.setBounds(0, 0, 500, 550);
        this.setTitle("Nuevo set de piezas");
        this.setResizable(false);

        labelTitulo = new JLabel("<html>Seleccione e indique las caracteristicas del<br> set de piezas:</hmtl>");
        labelTitulo.setFont(new Font("Cascadia Mono", 1, 15));
        labelTitulo.setBounds(30, 10, 500, 40);
        this.add(labelTitulo);

        labelMaterial = new JLabel("Material:");
        labelMaterial.setBounds(30, 60, 100, 30);
        this.add(labelMaterial);

        comboBoxMaterial = new JComboBox<>();
        comboBoxMaterial.setBounds(140, 60, 120, 30);
        comboBoxMaterial.addItem("Madera");
        comboBoxMaterial.addItem("Plastico");
        this.add(comboBoxMaterial);

        labelTamanio = new JLabel("Tamaño:");
        labelTamanio.setBounds(30, 120, 100, 30);
        this.add(labelTamanio);

        comboBoxTamanio = new JComboBox<>();
        comboBoxTamanio.setBounds(140, 120, 120, 30);
        comboBoxTamanio.addItem("Chico");
        comboBoxTamanio.addItem("Grande");
        this.add(comboBoxTamanio);

        labelDescripcion = new JLabel("Descripción:");
        labelDescripcion.setBounds(30, 180, 100, 30);
        this.add(labelDescripcion);

        textFieldDescripcion = new JTextField();
        textFieldDescripcion.setBounds(140, 180, 120, 30);
        this.add(textFieldDescripcion);

        checkBoxDescripcion = new JCheckBox();
        checkBoxDescripcion.setBounds(270, 180, 100, 30);
        checkBoxDescripcion.setBackground(new Color(r, g, b));
        checkBoxDescripcion.addItemListener(this);
        this.add(checkBoxDescripcion);

        botonAceptar = new JButton("Aceptar");
        botonAceptar.setBounds(30, 450, 100, 30);
        this.add(botonAceptar);
        botonAceptar.setEnabled(false);
        botonAceptar.addActionListener(this);

        botonCancelar = new JButton("Cancelar");
        botonCancelar.setBounds(160, 450, 100, 30);
        this.add(botonCancelar);
        botonCancelar.addActionListener(this);

    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String descripcion;
        if (checkBoxDescripcion.isSelected()) {
            descripcion = textFieldDescripcion.getText();
        } else
            descripcion = "";

        if (e.getSource() == botonAceptar) {

            Ajedrez ajedrez = new Ajedrez();
            List<PiezaBD> lista = ajedrez.piezaAPiezaDB();
            for (PiezaBD piezaBD : lista) {
                piezaBD.setMaterial(comboBoxMaterial.getSelectedItem().toString());
                piezaBD.setTamanio(comboBoxTamanio.getSelectedItem().toString());
                piezaBD.setDescripcion(descripcion);
            }
            
            iPiezaDAO iPiezaA = new PiezaDAO();

            for (PiezaBD piezaBD : lista) {
                iPiezaA.insertar(piezaBD);
            }

            List<PiezaBD> listaActualizada = iPiezaA.listar();
            tabla.actualizarTabla(listaActualizada);
        
            this.dispose();
        }

        if (e.getSource() == botonCancelar) {
            this.dispose();
        }
    }
    @Override
    public void itemStateChanged(ItemEvent e) {
        if (checkBoxDescripcion.isSelected() == true) {
            botonAceptar.setEnabled(true);

        } else botonAceptar.setEnabled(false);
    }

}
