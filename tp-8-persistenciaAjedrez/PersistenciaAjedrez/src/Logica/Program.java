package Logica;

import java.util.ArrayList;
import java.util.List;

import AccesoDatos.PiezaDAO;
import GUI.Interfaz;

public class Program {
    
    public static void main(String[] args) {
        crearAjedrez();
        //mostrarPiezasBD();
        
        Interfaz interfaz = new Interfaz();
        interfaz.setTitle("Ajedrez");
        interfaz.setBounds(0,0,540,400);
        // 0,0 sin separacion en izquierda y derecha, pero si ancho y alto
        interfaz.setVisible(true);
        interfaz.setResizable(false); // el usuario no puede mod la dimension de la interfaz
        interfaz.setLocationRelativeTo(null); // al centro de la pantalla
        

    }

    public static void mostrarPiezasBD() {
        iPieza iPiezaA = new PiezaDAO();
        iPiezaA.mostrarPiezasBD();

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

    }


}
