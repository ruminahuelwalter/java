package Logica;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Program {
    static Scanner teclado = new Scanner(System.in);
    static Scanner tecladoNumerico = new Scanner(System.in);
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
        cargarComportamientoMovimiento(piezasBlancas);


        Tablero tablero = new Tablero();

        tablero.generarTablero();
        tablero.asignarColor();
        tablero.asignarNombrePosicion();

        colocarPiezaTablero(piezasNegras, tablero);
        colocarPiezaTablero(piezasBlancas, tablero);

        System.out.println();
        System.out.printf("%15s %s%n", " ", "Tablero de ajedrez con el color de sus casilleros");
        barra();
        tablero.mostrarColor();
        barra();


        System.out.println();
        System.out.printf("%15s %s%n", " ", "Tablero de ajedrez con el nombre de sus casilleros");
        barra();
        tablero.mostrarNombrePosicion();
        barra();

        //tablero.mostrarTablero();

        System.out.println();
        System.out.printf("%25s %s%n", " ", "Tablero de ajedrez sus piezas");
        barra();
        tablero.mostrarPieza();
        barra();

        System.out.println("Presentación de piezas blancas y negras.");

        tablero.mostrarTablero();

        // Inicio de movimiento de piezas.
        String posicionOrigen;
        String posicionDestino;
        int opcion;

        
        System.out.print("Ingrese 1 si desea mover una pieza, 0 para salir: ");
        opcion = tecladoNumerico.nextInt();
        
   
        while (opcion == 1) {
            
            System.out.println("Indique el casillero de origen y destino de la pieza a mover.");
            System.out.println("Ejemplo: a7, c5  ");
            
            System.out.println("Indique el nombre del casillero posicion de origen");
            posicionOrigen = teclado.nextLine();

            System.out.println("Indique el nombre del casillero posicion de destino");
            posicionDestino = teclado.nextLine();

            barra();

            if (validarPosicion(posicionOrigen) && validarPosicion(posicionDestino)){
                tablero.moverPieza(posicionOrigen, posicionDestino);
            }
            else System.out.println("Ingresó una posición no válida.");

            barra();
            tablero.mostrarPieza();
            barra();

            System.out.print("Ingrese 1 si desea mover una pieza, 0 para salir: ");
            opcion = tecladoNumerico.nextInt();
        }


    }

   
    public static void colocarPiezaTablero(List<Pieza> piezasAjedrez, Tablero tablero){

        int fila = 0;
        int columna = 0;

        Pieza pieza = piezasAjedrez.get(0);

        if (pieza.getColor().equals("negro")){ 
            // Si las piezas son negras se cargan aqui.
            for (int i= 0; i < piezasAjedrez.size(); i++){
                tablero.colocarPieza(piezasAjedrez.get(i), fila, columna);
                
                if ((columna+1)%8 == 0){
                    columna= -1; // Para que al sumar 1 en la linea 69 (columna++) sea 0 y no 1.
                    fila++;
                }
                columna++;
            }
        }

        else{
            fila = 7;
            columna = 7;
            for (int i = 0; i < piezasAjedrez.size(); i++){
                tablero.colocarPieza(piezasAjedrez.get(i), fila , columna);
          
                if (columna == 0){
                    columna= 8; // Al restar en columnna-- es 7 en el próximo ciclo.
                    fila--;
                }

                columna--;
            }
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
        // Piezas creadas y agregadas a la lista en un orden determinado para facilitar la carga en el tablero.
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

    public static boolean validarPosicion(String posicion){
        // Verificar si la posicion ingresada es válida dentro del tablero.
        List<String> posicionesValidas = posiciones();
        if(posicionesValidas.contains(posicion)){ // True or False.
            return true;
        }
        else 
            return false;
    }

    public static List <String> posiciones(){
        // Lista de posiciones posibles dentro del tablero.
        List<String> posiciones = new ArrayList<>();
        int ascii = 97;
        String letra;
        String nombrePosicion;
        int numero = 8;

        for(int fila = 0; fila<8; fila++){
            for(int columna = 0; columna<8; columna++){
                letra = Character.toString((ascii + columna)); 
                nombrePosicion = letra+numero;
                posiciones.add(nombrePosicion);
            }
            numero--;
        }
        return posiciones;
    }
    
    public static void  barra(){
        String barra = "_____________________________________________________________________________________________\n";
        System.out.println(barra);
    }
}

