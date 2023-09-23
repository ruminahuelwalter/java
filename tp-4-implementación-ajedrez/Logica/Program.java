package Logica;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Program {
    static Scanner teclado = new Scanner(System.in);
    static Scanner tecladoNumerico = new Scanner(System.in);
    public static void main(String[] args) {

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
    
        menu(tablero, piezasNegras, piezasBlancas);
    

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
                    columna= -1; // Para que al sumar 1 en la linea 55 (columna++) sea 0 y no 1.
                    fila++;
                }
                columna++;
            }
        }
        // Si las piezas son blancas se cargan aquí.
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
                
                pieza.setComportamiento("sesgo");
                pieza.setMovimiento("oblicuo");
            }
            if (pieza instanceof Caballo){
                pieza.setComportamiento("nulo");
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

    public static void menu(Tablero tablero, List<Pieza> piezasNegras, List<Pieza> piezasBlancas){
        System.out.println();
        System.out.printf( " %80s", "- BIENVENIDO AL PROGRAMA AJEDREZ -\n");
        System.out.printf( " %96s", "- Basado en el texto literario: El Hacedor de Jorge Luis Borges -\n");
        
        int opcion;
        int subOpcion;
        boolean volverSubMenu;
        boolean ejecucion = true;
        
        while (ejecucion) {
            System.out.println("\n");
            System.out.printf( " %30s", "MENÚ PRINCIPAL ");
            System.out.println("\n");
            System.out.println(" 1 - Conocer el tablero");
            System.out.println(" 2 - Conocer las piezas");
            System.out.println(" 3 - Conocer el tablero con las piezas");
            System.out.println(" 4 - Jugar (beta)");
            System.out.println(" 5 - Salir");
            System.out.println();
            System.out.print(" Elija una opción: ");

            opcion = tecladoNumerico.nextInt();

            switch (opcion) {

                case 1:
                volverSubMenu = true;
                    while (volverSubMenu) {
                        System.out.println("");
                        System.out.printf( " %30s", "SUBMENÚ TABLERO");
                        System.out.println("\n");
                        System.out.println(" 1 - Conocer el color de los casilleros");
                        System.out.println(" 2 - Conocer la posición de los casilleros");
                        System.out.println(" 3 - Volver");
                        System.out.println();
                        System.out.print("Elija una opción: ");
                        subOpcion = tecladoNumerico.nextInt();

                        switch (subOpcion) {
                            case 1:
                                System.out.println();
                                System.out.printf("%15s %s%n", " ", "Tablero de ajedrez con el color de sus casilleros");
                                barra();
                                tablero.mostrarColor();
                                barra();
                                break;
                            case 2:
                                System.out.println();
                                System.out.printf("%15s %s%n", " ", "Tablero de ajedrez con el nombre de sus casilleros");
                                barra();
                                tablero.mostrarNombrePosicion();
                                barra();
                                break;
                            case 3:
                                volverSubMenu = false;    
                                break;
                            default:
                                System.out.println("¡Opción no válida!");
                                break;
                        }
                    }
                break;

                case 2:
                    volverSubMenu = true;

                    while (volverSubMenu) {
                        System.out.println("");
                        System.out.printf( " %30s","SUBMENÚ PIEZAS \n\n");
                        System.out.println(" 1 - Conocer las piezas negras");
                        System.out.println(" 2 - Conocer las piezas blancas");
                        System.out.println(" 3 - Volver");
                        System.out.println();
                        System.out.print("Elija una opción: ");
                        subOpcion = tecladoNumerico.nextInt();

                        switch (subOpcion) {
                            case 1:
                            barra();
                            System.out.printf( " %30s"," PIEZAS NEGRAS \n");
                            barra();
                                for(Pieza pieza: piezasNegras){
                                    pieza.mover();
                                    System.out.println("Mi comportamiento es " + pieza.getComportamiento() + " y mi color es " + pieza.getColor());
                                    System.out.println();
                                }
                            barra();
                            
                                break;

                            case 2:
                                
                                barra();
                                System.out.printf( " %30s"," PIEZAS BLANCAS \n");
                                barra();
                                for(Pieza pieza: piezasBlancas){
                                    pieza.mover();
                                    System.out.println("Mi comportamiento es " + pieza.getComportamiento() + " y mi color es " + pieza.getColor());
                                    System.out.println();
                                }
                                barra();
                            
                                break;
                            case 3:
                                volverSubMenu = false;
                                break;
                            default:
                                System.out.println("¡Opción no válida!");
                                break;
                        }
                    }
                break;

                case 3:
                    System.out.println();
                    System.out.printf("%25s %s%n", " ", "Tablero de ajedrez con las piezas");
                    barra();
                    tablero.mostrarPieza();
                    barra();
                    break;

                case 4:

                    String posicionOrigen;
                    String posicionDestino;
                    System.out.println("\n¡Que comience el juego!\n");
                    System.out.printf("%25s %s%n", " ", "Tablero de ajedrez con las piezas");
                    barra();
                    tablero.mostrarPieza();
                    barra();
                    System.out.print("Para mover una pieza ingrese '1' o para salir ingrese '0' : ");
                    opcion = tecladoNumerico.nextInt();
        
                    while (opcion == 1) {

                        System.out.println("Indique el movimiento de la pieza en formato 'a7' (por ejemplo, origen: 'a7' destino: 'c5').");
                        //System.out.println("\nIndique el casillero de origen y destino de la pieza a mover.");
                        //System.out.println("Ejemplo: a7, c5  \n");
                        System.out.print("Posicion de origen: ");
                        posicionOrigen = teclado.nextLine();

                        System.out.print("Posicion de destino: ");
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
                    break;
                case 5:
                    ejecucion = false;
                    break;
                default:
                    System.out.println("\n¡Opción no válida!\n");
                    break;
            }
        }


    }

    public static void  barra(){
        String barra = "_____________________________________________________________________________________________\n";
        System.out.println(barra);
    }
}

