package Logica;

import javax.swing.JFrame;

import GUI.VentanaPrincipal;

public class Program {

    public static void main(String[] args) {

        ventanaPrincipal();
       
    }

    public static void ventanaPrincipal() {

        VentanaPrincipal principal = new VentanaPrincipal();
        // principal.setBounds(0,0,1200,700);
        
        principal.setVisible(true);
        principal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     
    }
}
