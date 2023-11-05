package Logica;

import GUI.VentanaPrincipal;

public class Program {

    public static void main(String[] args) {

        ventanaPrincipal();
       
    }

    public static void ventanaPrincipal() {

        VentanaPrincipal principal = new VentanaPrincipal();
        // principal.setBounds(0,0,1200,700);
        principal.setResizable(true);
        principal.setVisible(true);
        principal.setLocationRelativeTo(null);

    }
}
