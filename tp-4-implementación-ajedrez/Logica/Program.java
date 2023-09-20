package Logica;

import java.util.ArrayList;
import java.util.List;


public class Program {
    public static void main(String[] args) {
 

        //startJuego()
        //finJuego()
     
        List<Pieza> piezasBlancas = new ArrayList<>();
        List<Pieza> piezasNegras = new ArrayList<>();
        
        crearPiezasAjedrez(piezasBlancas);
        crearPiezasAjedrez(piezasNegras);

        pintarPiezas(piezasBlancas, "blanco");
        pintarPiezas(piezasNegras, "negro");

        cargarComportamientoMovimiento(piezasNegras);

        Tablero tablero = new Tablero();

        tablero.generarTablero(8,8);
        tablero.asignarColor();
        tablero.asignarNombrePosicion();
        tablero.mostrarColores();
        
        colocarPiezaTablero(piezasNegras, tablero);

        // Validar el ingreso de posiciones correctas, "w1" por ejemplo, no deberia aceptar.
        tablero.moverPieza("a8", "h1");

        tablero.mostrarPosiciones();

        //*tablero.mostrarTablero();

    }//*fin main


    public static void colocarPiezaTablero(List<Pieza> piezasAjedrez, Tablero tablero){
        //* SOLO ESTA FUNCIONANDO PARA LAS PIEZAS NEGRAS */
        int fila = 0;
        int columna = 0;
      
        for (int i= 0; i <16; i++){
            tablero.colocarPieza(piezasAjedrez.get(i), fila, columna);
            System.out.println("soy: " + piezasAjedrez.get(i).getClass().getSimpleName());
            
            if ((columna+1)%8 == 0){
                columna= -1;
                fila++;
            }

            columna++;
        }
    
    }


    public static List<Pieza> pintarPiezas(List<Pieza> piezas, String color){
        // Asignar color a las piezas de ajedrez.
        for (Pieza piezaAjedrez : piezas){
            piezaAjedrez.setColor(color);
        }
        return piezas;
    }


    public static void crearPiezasAjedrez(List<Pieza> piezas) {

        piezas.add(new Torre());
        piezas.add(new Caballo());
        piezas.add(new Alfil());
        piezas.add(new Rey());
        piezas.add(new Reina());
        piezas.add(new Alfil());
        piezas.add(new Caballo());
        piezas.add(new Torre());
        
        for (int i = 0; i < 8; i++) {
            piezas.add(new Peon());
        }
    }


    public static void cargarComportamientoMovimiento(List<Pieza> piezasAjedrez){
        
        for (Pieza pieza : piezasAjedrez) {
            if (pieza instanceof Alfil) {
                // Alfil alfil = (Alfil) pieza;
                pieza.setComportamiento("sesgo");
                pieza.setMovimiento("oblicuo");
            }
            if (pieza instanceof Caballo){
                pieza.setComportamiento("nulo"); // Falta comportamiento de caballo.
                pieza.setMovimiento("ligero");
            }
            if (pieza instanceof Peon) {
                pieza.setComportamiento("agresor");
                pieza.setMovimiento("ladino");
            }
            if (pieza instanceof Reina) {
                pieza.setComportamiento("armada");
                pieza.setMovimiento("encarnizada");
            }
            if (pieza instanceof Rey) {
                pieza.setComportamiento("postrero");
                pieza.setMovimiento("tenue");
            }

            if (pieza instanceof Torre) {
                pieza.setComportamiento("hómerica");
                pieza.setMovimiento("directa");
            }
        }
        return;
    }


}

