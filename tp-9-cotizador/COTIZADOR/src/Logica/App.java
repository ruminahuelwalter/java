package Logica;
import javax.swing.JFrame;
import GUI.*;

public class App {
    public static void main(String[] args) {

        VentanaBienvenida nueva = new VentanaBienvenida();
        nueva.setVisible(true);
        nueva.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);      
    }
}
