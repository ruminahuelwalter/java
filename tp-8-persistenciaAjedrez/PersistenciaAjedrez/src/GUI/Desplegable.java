package GUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Desplegable extends JFrame implements ActionListener {
    // el comboBox no va a tener el evento, el boton lo va a tener por eso ActionListener y no ItemListener
    
    private JLabel label1, label2, label3;
    private JComboBox<String> comboBox1, comboBox2, comboBox3;
    private JButton boton1;

    public Desplegable (Tabla ventana) {
        setLayout(null);
        label1 = new JLabel("Rojo:");
        label1.setBounds(10,10,100,10);
        add(label1);

        ventana.add(label1);

        comboBox1 = new JComboBox<>();
        comboBox1.setBounds(120,10,50,30);
        for(int i = 0; i<256; i++){
            // el valor de i lo convierte a String
            comboBox1.addItem(String.valueOf(i));
        }
        add(comboBox1);

        label2 = new JLabel("Verde");
        label2.setBounds(10,50,100,10);
        add(label2);
        comboBox2 = new JComboBox<>();
        comboBox2.setBounds(120,50,50,30);
        for(int i = 0; i<256; i++){
            // el valor de i lo convierte a String
            comboBox2.addItem(String.valueOf(i));
        }
        add(comboBox2);

        label3 = new JLabel("Azul");
        label3.setBounds(10,90,100,10);
        add(label3);
        
        comboBox3 = new JComboBox<>();
        comboBox3.setBounds(120,90,50,30);
        for(int i = 0; i<256; i++){
            // el valor de i lo convierte a String
            comboBox3.addItem(String.valueOf(i));
        }
        add(comboBox3);

        boton1 = new JButton();
        boton1.setBounds(10,130,100,30);
        add(boton1);
        boton1.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == boton1){
            String cad1 = comboBox1.getSelectedItem().toString();
            String cad2 = comboBox2.getSelectedItem().toString();
            String cad3 = comboBox3.getSelectedItem().toString();

            int rojo = Integer.parseInt(cad1);
            int verde = Integer.parseInt(cad2);
            int azul = Integer.parseInt(cad3);
            
            Color color1 = new Color(rojo,verde,azul);
            boton1.setBackground(color1);
        }
    }
}
