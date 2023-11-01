package Logica;

import java.util.ArrayList;
import java.util.List;
import AccesoDatos.PiezaDAO;
import GUI.Ventana;

public class Program {
    
    public static void main(String[] args) {

        crearAjedrez();
        mostrarPiezasBD();
        
        Ventana ventana = new Ventana();
        ventana.ventanaBasica();
        /* Ventana ventana = new Ventana();
        ventana.setTitle("Ajedrez");

        ventana.setBounds(0,0,900,700);
        // 0,0 sin separacion en izquierda y derecha, pero si ancho y alto
        ventana.setVisible(true);
        ventana.setResizable(true); // el usuario no puede mod la dimension de la interfaz
        ventana.setLocationRelativeTo(null); // al centro de la pantalla   */
        crearAjedrez();
        
    
    }

    public static void mostrarPiezasBD() {
        iPiezaDAO iPiezaA = new PiezaDAO();
        iPiezaA.listar();
    }

    public static void crearAjedrez(){

        List<Pieza> piezasBlancas = new ArrayList<>();
        List<Pieza> piezasNegras = new ArrayList<>();

        Ajedrez.crearPiezasAjedrez(piezasBlancas);
        Ajedrez.crearPiezasAjedrez(piezasNegras);

        Ajedrez.pintarPiezas(piezasBlancas, "blanco");
        Ajedrez.pintarPiezas(piezasNegras, "negro");

        Ajedrez.cargarComportamientoMovimiento(piezasNegras);
        Ajedrez.cargarComportamientoMovimiento(piezasBlancas);

        Tablero tablero = new Tablero();
        tablero.generarTablero();
        tablero.asignarColor();
        tablero.asignarNombrePosicion();

        Ajedrez.colocarPiezaTablero(piezasNegras, tablero);
        Ajedrez.colocarPiezaTablero(piezasBlancas, tablero);

        for (Pieza pieza : piezasBlancas) {
            System.out.println(pieza.getMovimiento());
        }
    }
}
