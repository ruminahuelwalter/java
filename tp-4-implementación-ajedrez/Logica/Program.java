package Logica;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

        List<Pieza> piezasAjedrez = listaPiezas(piezasNegras, piezasBlancas);

        menu(tablero, piezasAjedrez, piezasNegras, piezasBlancas);
      
    }

    public static void crearPiezasAjedrez(List<Pieza> piezas) {
        // Piezas creadas y agregadas a la lista en un orden determinado para facilitar
        // la carga en el tablero.
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

    public static List<Pieza> pintarPiezas(List<Pieza> piezas, String color) {
        // Asignar color a las piezas de ajedrez.
        for (Pieza piezaAjedrez : piezas) {
            piezaAjedrez.setColor(color);
        }
        return piezas;
    }

    public static void cargarComportamientoMovimiento(List<Pieza> piezasAjedrez) {

        for (Pieza pieza : piezasAjedrez) {
            if (pieza instanceof Alfil) {
                pieza.setComportamiento("sesgo");
                pieza.setMovimiento("oblicuo");
            }
            if (pieza instanceof Caballo) {
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

    public static boolean validarPosicion(String posicion) {
        // Verificar si la posicion ingresada es válida dentro del tablero.
        List<String> posicionesValidas = posiciones();
        if (posicionesValidas.contains(posicion)) { // Devuelve True or False.
            return true;
        } else
            return false;
    }

    public static List<String> posiciones() {
        // Lista de posiciones posibles dentro del tablero.
        List<String> posiciones = new ArrayList<>();
        int ascii = 97;
        String letra;
        String nombrePosicion;
        int numero = 8;

        for (int fila = 0; fila < 8; fila++) {
            for (int columna = 0; columna < 8; columna++) {
                letra = Character.toString((ascii + columna));
                nombrePosicion = letra + numero;
                posiciones.add(nombrePosicion);
            }
            numero--;
        }
        return posiciones;
    }

    public static void colocarPiezaTablero(List<Pieza> piezasAjedrez, Tablero tablero) {

        int fila = 0;
        int columna = 0;

        Pieza pieza = piezasAjedrez.get(0);

        if (pieza.getColor().equals("negro")) {
            // Si las piezas son negras se cargan aqui.
            for (int i = 0; i < piezasAjedrez.size(); i++) {
                colocarPieza(tablero, piezasAjedrez.get(i), fila, columna);

                if ((columna + 1) % 8 == 0) {
                    columna = -1; // Para que al sumar 1 en la linea 55 (columna++) sea 0 y no 1.
                    fila++;
                }
                columna++;
            }
        }

        // Si las piezas son blancas se cargan aquí.
        else if (pieza.getColor().equals("blanco")) {
            fila = 7;
            columna = 7;
            for (int i = 0; i < piezasAjedrez.size(); i++) {
                colocarPieza(tablero, piezasAjedrez.get(i), fila, columna);
                if (columna == 0) {
                    columna = 8; // Al restar en columnna-- es 7 en el próximo ciclo.
                    fila--;
                }
                columna--;
            }
        }
    }

    public static void colocarPieza(Tablero tablero, Pieza pieza, int fila, int columna) {
        // Colocar la pieza dentro del tablero en su posición inicial.
        Casillero casilleros[][] = tablero.getCasilleros();

        if (fila >= 0 && fila < casilleros.length && columna >= 0 && columna < casilleros.length) {
            pieza.setNombrePosicion(casilleros[fila][columna].getNombrePosicion());
            casilleros[fila][columna].setOcupado(true); // Se asigna valor ocupado.
        }
    }

    public static List<Pieza> listaPiezas(List<Pieza> piezasNegras, List<Pieza> piezasBlancas) {
        List<Pieza> piezasAjedrez = new ArrayList<>();

        for (Pieza pieza : piezasNegras) {
            piezasAjedrez.add(pieza);
        }

        for (Pieza pieza : piezasBlancas) {
            piezasAjedrez.add(pieza);
        }

        return piezasAjedrez;
    }

    public static void mostrarPieza(Tablero tablero, List<Pieza> piezasAjedrez) {

        Casillero casilleros[][] = tablero.getCasilleros();

        String negrita = "\033[0;1m";
        String blanco = "\u001B[37m";
        String negro = "\033[30m";
        String finAscii = "\u001B[0m";

        System.out.println();

        String[] letras = { "a", "b", "c", "d", "e", "f", "g", "h" };

        for (String letra : letras) {
            System.out.printf("%11s", letra);
        }
        
        // Se almacena el par pieza - posición para luego obtener
        // la posición con la pieza, en linea 223.
        Map<String, Pieza> posicionPiezas = new HashMap<>();

        for (Pieza pieza : piezasAjedrez) {
            String posicion = pieza.getNombrePosicion();
            if (posicion != null) {
                posicionPiezas.put(posicion, pieza);
            }
        }

        System.out.println("");
        System.out.println("\n");

        for (int fila = 0; fila < 8; fila++) {
            System.out.print((8 - fila) + " ");
            for (int columna = 0; columna < 8; columna++) {

                if (casilleros[fila][columna].isOcupado()) { // Si esta ocupado hay una pieza.
                    // Se busca quien esta ocupando la posición.
                    String posicion = casilleros[fila][columna].getNombrePosicion();
                    Pieza pieza = posicionPiezas.get(posicion);
                    if (pieza != null) {
                    // Si coincide la posición de la pieza con la posición del casillero, se "imprime" la pieza en la posición del casillero.
                        if (pieza.getNombrePosicion().equals(posicion) && pieza.getColor().equals("negro")) {
                            String piezaNegra = negrita + negro + pieza.getClass().getSimpleName() + finAscii;
                            System.out.printf("%26s", " " + piezaNegra);
                        }
                        if (pieza.getNombrePosicion().equals(posicion) && pieza.getColor().equals("blanco")) {
                            String piezaBlanca = negrita + blanco + pieza.getClass().getSimpleName() + finAscii;
                            System.out.printf("%26s", " " + piezaBlanca);
                        }
                    } else {
           
                        System.out.printf("%11s", " "); // Se agrega espacio donde no hay piezas.
                    }
                  
                } else {
                    System.out.printf("%11s", " "); // Se agrega espacio donde no hay piezas.
                 }
            }
            System.out.println("\n");
            System.out.println(" ");
        }
    }

    public static void moverPieza(Tablero tablero, List<Pieza> piezasAjedrez, String origen, String destino) {

        Casillero casilleros[][] = tablero.getCasilleros();
        String negrita = "\033[0;1m";
        String finAscii = "\u001B[0m";

        int filaOrigen = obtenerFilaPosicion(origen);
        int columnaOrigen = obtenerColumnaPosicion(origen);

        int filaDestino = obtenerFilaPosicion(destino);
        int columnaDestino = obtenerColumnaPosicion(destino);

        Map<String, Pieza> posicionPiezas = new HashMap<>();

        for (Pieza pieza : piezasAjedrez) {
            String posicion = pieza.getNombrePosicion();
            if (posicion != null) {
                posicionPiezas.put(posicion, pieza);
            }
        }

        // Con clave origen se obtiene valor: pieza.
        // Cual es la pieza que esta en el casillero de origen.
        Pieza piezaEnOrigen = posicionPiezas.get(origen);

        // Cual es la pieza que esta en el casillero de destino.
        Pieza piezaEnDestino = posicionPiezas.get(destino);

        if(piezaEnOrigen != null){
        
            if (piezaEnOrigen.getNombrePosicion() != null) {
                String nuevaPosicion;
                if (casilleros[filaDestino][columnaDestino].isOcupado() == true) {
                    // El casillero 'contiene una pieza'
                    if (piezaEnOrigen.getColor().equals(piezaEnDestino.getColor())) {
                        // ¿Son del mismo color? No se puede realizar el movimiento.
                        System.out.println("No puede realizar este movimiento las piezas son del mismo color");
                    }

                    else {

                        System.out.println("\n" + negrita
                                + "¡La pieza " + piezaEnDestino.getClass().getSimpleName() + " de color "
                                + piezaEnDestino.getColor() + " ha sido comida por la pieza "
                                + piezaEnOrigen.getClass().getSimpleName() + " de color "
                                + piezaEnOrigen.getColor() + "!" + finAscii);
                        casilleros[filaOrigen][columnaOrigen].setOcupado(false);
                        casilleros[filaDestino][columnaDestino].setOcupado(true);

                        nuevaPosicion = casilleros[filaDestino][columnaDestino].getNombrePosicion();

                        piezaEnOrigen.setNombrePosicion(nuevaPosicion); // Pieza en nueva posicion.
                        piezaEnDestino.setNombrePosicion(null); // Pieza eliminada.
                    }

                } else {
                    
                    // Casillero de destino sin piezas.
                    // Se deja libre el casillero de origen.
                    casilleros[filaOrigen][columnaOrigen].setOcupado(false);
                    casilleros[filaDestino][columnaDestino].setOcupado(true);
                    nuevaPosicion = casilleros[filaDestino][columnaDestino].getNombrePosicion();
                    piezaEnOrigen.setNombrePosicion(nuevaPosicion);
                    System.out.println("\n" + negrita + "La pieza " + piezaEnOrigen.getClass().getSimpleName() + " se movió correctamente." + finAscii);

                }
            }
        }
    }

    public static int obtenerFilaPosicion(String nombrePosicion) {

        // 'a8' Obtiene el número 8, para luego retornar su indicecorrespondiente.
        char numero = nombrePosicion.charAt(1); 
        int fila = Character.getNumericValue(numero);
        fila = 8 - fila; // Restar fila a 8 dado que indice va de 0 a 7. 8-8= 0.

        return fila;
    }

    public static int obtenerColumnaPosicion(String nombrePosicion) {

        char letra = nombrePosicion.charAt(0); 
        // 'a8' Obtiene la letra a, para luego retornar su indice correspondiente.
        int columna = letra;
        columna = columna - 97; // Restar 97, que es la posicion de 'a' en ascii. a es indice 0.

        return columna;
    }

    public static void menu(Tablero tablero, List<Pieza> piezasAjedrez, List<Pieza> piezasNegras,
            List<Pieza> piezasBlancas) {

        System.out.println();
        System.out.printf(" %80s", "- BIENVENIDO AL PROGRAMA AJEDREZ -\n");
        System.out.printf(" %96s", "- Basado en el texto literario: El Hacedor de Jorge Luis Borges -\n");

        int opcion;
        int subOpcion;
        boolean subMenu;
        boolean ejecucion = true;

        while (ejecucion) {

            try {

                System.out.println("\n");
                System.out.printf(" %30s", "MENÚ PRINCIPAL ");
                System.out.println("\n");
                System.out.println(" 1 - Mostrar el tablero");
                System.out.println(" 2 - Mostrar las piezas");
                System.out.println(" 3 - Mostrar el tablero con piezas");
                System.out.println(" 4 - Jugar (beta)");
                System.out.println(" 5 - Salir");
                System.out.println();

                System.out.print(" Elija una opción: ");
                opcion = tecladoNumerico.nextInt();

                switch (opcion) {

                    case 1:
                        subMenu = true;
                        while (subMenu) {
                            try {
                                System.out.println("");
                                System.out.printf(" %30s", "SUBMENÚ TABLERO");
                                System.out.println("\n");
                                System.out.println(" 1 - Mostrar el color de los casilleros");
                                System.out.println(" 2 - Mostrar la posición de los casilleros");
                                System.out.println(" 3 - Volver");
                                System.out.println();

                                System.out.print("Elija una opción: ");
                                subOpcion = tecladoNumerico.nextInt();

                                switch (subOpcion) {
                                    case 1:
                                        System.out.println();
                                        System.out.printf("%15s %s%n", " ",
                                                "Tablero con el color de sus casilleros");
                                        barra();
                                        tablero.mostrarColor();
                                        barra();
                                        break;
                                    case 2:
                                        System.out.println();
                                        System.out.printf("%15s %s%n", " ",
                                                "Tablero con el nombre de sus casilleros");
                                        barra();
                                        tablero.mostrarNombrePosicion();
                                        barra();
                                        break;
                                    case 3:
                                        subMenu = false;
                                        break;
                                    default:
                                        System.out.println("¡Opción no válida!");
                                        break;
                                }

                            } catch (Exception e) {
                                System.out.println("¡Error! ¡Debe ingresar una opción válida!");
                                tecladoNumerico.nextLine(); // Limpia el bufer
                            }

                        }
                        break;

                    case 2:
                        subMenu = true;

                        while (subMenu) {
                            try {

                                System.out.println("");
                                System.out.printf(" %30s", "SUBMENÚ PIEZAS \n\n");
                                System.out.println(" 1 - Mostrar las piezas negras");
                                System.out.println(" 2 - Mostrar las piezas blancas");
                                System.out.println(" 3 - Volver");
                                System.out.println();
                                System.out.print("Elija una opción: ");
                                subOpcion = tecladoNumerico.nextInt();

                                switch (subOpcion) {
                                    case 1:
                                        barra();
                                        System.out.printf(" %30s", " PIEZAS NEGRAS \n");
                                        barra();
                                        for (Pieza pieza : piezasNegras) {
                                            pieza.mover();
                                            System.out.println("Mi comportamiento es " + pieza.getComportamiento()
                                                    + " y mi color es " + pieza.getColor());
                                            System.out.println();
                                        }
                                        barra();

                                        break;

                                    case 2:

                                        barra();
                                        System.out.printf(" %30s", " PIEZAS BLANCAS \n");
                                        barra();
                                        for (Pieza pieza : piezasBlancas) {
                                            pieza.mover();
                                            System.out.println("Mi comportamiento es " + pieza.getComportamiento()
                                                    + " y mi color es " + pieza.getColor());
                                            System.out.println();
                                        }
                                        barra();

                                        break;
                                    case 3:
                                        subMenu = false;
                                        break;
                                    default:
                                        System.out.println("¡Opción no válida!");
                                        break;
                                }
                            } catch (Exception e) {
                                System.out.println("¡Error! ¡Debe ingresar una opción válida!\n");
                                tecladoNumerico.nextLine(); // Limpia el bufer
                            }
                        }
                        break;

                    case 3:
                        System.out.println();
                        barra();
                        System.out.printf("%25s %s%n", " ", "Tablero de ajedrez con las piezas");
                        barra();
                        mostrarPieza(tablero, piezasAjedrez);
                        barra();
                        break;

                    case 4:
                        subMenu = true;
                        System.out.println("\n¡Que comience el juego!\n");
                        while (subMenu) {

                            try {
                                String posicionOrigen;
                                String posicionDestino;
                                barra();
                                System.out.printf("%25s %s%n", " ", "Tablero de ajedrez con las piezas");
                                barra();
                                mostrarPieza(tablero, piezasAjedrez);
                                barra();

                                System.out.print("Para mover una pieza ingrese '1' o para salir ingrese '0' : ");
                                subOpcion = tecladoNumerico.nextInt();

                                if (subOpcion == 1) {
                                    System.out.println("\nIndique el movimiento de la pieza en formato 'a7' (por ejemplo, origen: 'a7' destino: 'c5').");
                                    System.out.print("Posicion de origen: ");
                                    posicionOrigen = teclado.nextLine();
                                    posicionOrigen = posicionOrigen.toLowerCase();

                                    System.out.print("Posicion de destino: ");
                                    posicionDestino = teclado.nextLine();
                                    posicionDestino = posicionDestino.toLowerCase();

                                    if (validarPosicion(posicionOrigen) && validarPosicion(posicionDestino)) {
                                        moverPieza(tablero, piezasAjedrez, posicionOrigen, posicionDestino);
                                    } else
                                        System.out.println("Ingresó una posición no válida.");
                                } else if (subOpcion == 0) {
                                    subMenu = false;
                                } else {
                                    System.out.println("¡Opción no válida!");
                                }

                            } catch (Exception e) {
                                System.out.println("\n¡Error! ¡Debe ingresar una opción válida!\n");
                                tecladoNumerico.nextLine(); // Limpia el bufer
                            }
                        }
                        break;
                    case 5:
                        ejecucion = false;
                        break;
                    default:
                        System.out.println("\n¡Opción no válida!\n");
                        break;
                }

            } catch (Exception e) {
                System.out.println("\n¡Error! ¡Debe ingresar una opción válida!\n");
                tecladoNumerico.nextLine(); // Limpia el bufer
            }
        }

    }

    public static void barra() {
        String barra = "_____________________________________________________________________________________________\n";
        System.out.println(barra);
    }
}
