package GUI;

import javax.swing.*;
import AccesoDatos.PiezaDAO;
import Logica.PiezaBD;
import Logica.iPiezaDAO;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.util.List;

public class VentanaNuevaPieza extends JFrame implements ActionListener, ItemListener {

    private JLabel labelTitulo, labelTipo, labelColor, labelMaterial, labelTamanio, labelComportamiento,
            labelMovimiento, labelDescripcion, labelPosicion;
    private JButton botonAceptar, botonCancelar;
    private JComboBox<String> comboBoxTipo, comboBoxColor, comboBoxMaterial, comboBoxTamanio, comboBoxFila,
            comboBoxColumna;
    private JTextField textfieldComportamiento, textfieldMovimiento, textFieldDescripcion;
    private JCheckBox checkBoxComportamiento, checkBoxMovimiento, checkBoxDescripcion;
    private PiezaBD pieza;
    private int r,g,b;
    private Tabla tabla;

    public VentanaNuevaPieza(Tabla tabla) {

        this.tabla = tabla;

        r = 174;
        g = 182;
        b = 191;

        this.getContentPane().setBackground(new Color(174, 182, 191));
        this.setBounds(0, 0, 550, 550);
        this.setLayout(null);
        this.setTitle("Nueva Pieza");
        this.setResizable(false);

        labelTitulo = new JLabel("Seleccione e indique las caracteristicas de la pieza:");
        labelTitulo.setFont(new Font("Cascadia Mono", 1, 15));
        labelTitulo.setBounds(30, 10, 500, 40);
        this.add(labelTitulo);

        labelTipo = new JLabel("Tipo:");
        labelTipo.setBounds(30, 50, 100, 30);
        this.add(labelTipo);

        comboBoxTipo = new JComboBox<>();
        comboBoxTipo.setBounds(140, 50, 120, 30);
        comboBoxTipo.addItem("Alfil");
        comboBoxTipo.addItem("Caballo");
        comboBoxTipo.addItem("Peon");
        comboBoxTipo.addItem("Reina");
        comboBoxTipo.addItem("Rey");
        comboBoxTipo.addItem("Torre");
        this.add(comboBoxTipo);

        labelColor = new JLabel("Color:");
        labelColor.setBounds(30, 100, 100, 30);
        this.add(labelColor);

        comboBoxColor = new JComboBox<>();
        comboBoxColor.setBounds(140, 100, 120, 30);
        comboBoxColor.addItem("Blanco");
        comboBoxColor.addItem("Negro");
        this.add(comboBoxColor);

        labelMaterial = new JLabel("Material:");
        labelMaterial.setBounds(30, 150, 100, 30);
        this.add(labelMaterial);

        comboBoxMaterial = new JComboBox<>();
        comboBoxMaterial.setBounds(140, 150, 120, 30);
        comboBoxMaterial.addItem("Madera");
        comboBoxMaterial.addItem("Plastico");
        this.add(comboBoxMaterial);

        labelTamanio = new JLabel("Tamaño:");
        labelTamanio.setBounds(30, 200, 100, 30);
        this.add(labelTamanio);

        comboBoxTamanio = new JComboBox<>();
        comboBoxTamanio.setBounds(140, 200, 120, 30);
        comboBoxTamanio.addItem("Chico");
        comboBoxTamanio.addItem("Grande");
        this.add(comboBoxTamanio);

        labelPosicion = new JLabel("Posición:");
        labelPosicion.setBounds(30, 250, 100, 30);
        this.add(labelPosicion);

        comboBoxColumna = new JComboBox<>();
        comboBoxColumna.setBounds(140, 250, 50, 30);
 
        int ascii = 65; // A = 65 H =72
        String letra;
        for (int i = 0; i < 8; i++) {
            letra = Character.toString((ascii + i));
            comboBoxColumna.addItem(String.valueOf(letra));
        }
        this.add(comboBoxColumna);

        comboBoxFila = new JComboBox<>();
        comboBoxFila.setBounds(210, 250, 50, 30);
        for (int i = 0; i < 8; i++) {
            comboBoxFila.addItem(String.valueOf(i + 1));
        }
        this.add(comboBoxFila);

        labelComportamiento = new JLabel("Comportamiento:");
        labelComportamiento.setBounds(30, 300, 100, 30);
        this.add(labelComportamiento);

        textfieldComportamiento = new JTextField();
        textfieldComportamiento.setBounds(140, 300, 120, 30);
        this.add(textfieldComportamiento);

        checkBoxComportamiento = new JCheckBox();
        checkBoxComportamiento.setBounds(270, 300, 100, 30);
        checkBoxComportamiento.setBackground(new Color(r, g, b));
        checkBoxComportamiento.addItemListener(this);
        this.add(checkBoxComportamiento);

        labelMovimiento = new JLabel("Movimiento:");
        labelMovimiento.setBounds(30, 350, 100, 30);
        this.add(labelMovimiento);

        textfieldMovimiento = new JTextField();
        textfieldMovimiento.setBounds(140, 350, 120, 30);
        this.add(textfieldMovimiento);

        checkBoxMovimiento = new JCheckBox();
        checkBoxMovimiento.setBounds(270, 350, 100, 30);
        checkBoxMovimiento.setBackground(new Color(r, g, b));;
        checkBoxMovimiento.addItemListener(this);
        this.add(checkBoxMovimiento);

        labelDescripcion = new JLabel("Descripcion:");
        labelDescripcion.setBounds(30, 400, 100, 30);
        this.add(labelDescripcion);

        textFieldDescripcion = new JTextField();
        textFieldDescripcion.setBounds(140, 400, 120, 30);
        this.add(textFieldDescripcion);

        checkBoxDescripcion = new JCheckBox();
        checkBoxDescripcion.setBounds(270, 400, 100, 30);
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
        pieza = new PiezaBD();
        String movimiento, comportamiento, descripcion;

        if (checkBoxMovimiento.isSelected()) {
            movimiento = textfieldMovimiento.getText();
        } else
            movimiento = "";
        if (checkBoxComportamiento.isSelected()) {
            comportamiento = textfieldComportamiento.getText();
        } else
            comportamiento = "";
        if (checkBoxDescripcion.isSelected()) {
            descripcion = textFieldDescripcion.getText();
        } else
            descripcion = "";

        if (e.getSource() == botonAceptar) {

            pieza.setTipoPieza(comboBoxTipo.getSelectedItem().toString());
            pieza.setColor(comboBoxColor.getSelectedItem().toString());
            pieza.setMaterial(comboBoxMaterial.getSelectedItem().toString());
            pieza.setTamanio(comboBoxTamanio.getSelectedItem().toString());
            String posicion = (comboBoxColumna.getSelectedItem().toString()
                    + comboBoxFila.getSelectedItem().toString());
            pieza.setNombrePosicion(posicion);
            pieza.setComportamiento(comportamiento);
            pieza.setDescripcion(descripcion);
            pieza.setMovimiento(movimiento);

            iPiezaDAO iPiezaA = new PiezaDAO();
            iPiezaA.insertar(pieza);
            List<PiezaBD> lista = iPiezaA.listar();
            tabla.actualizarTabla(lista);

            this.dispose();
        }

        if (e.getSource() == botonCancelar) {
            this.dispose();
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {

        if (checkBoxComportamiento.isSelected() == true && checkBoxMovimiento.isSelected() == true
                && checkBoxDescripcion.isSelected() == true) { 
            botonAceptar.setEnabled(true); 

        } else {
            botonAceptar.setEnabled(false);
        }
    }
}
