package Logica;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
//import java.util.HashMap;
import java.util.List;
//import java.util.Map;


public class Ajedrez {

    
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

 
    public static void ImprimirFechaHora() {

        LocalDateTime fechaHoraActual = LocalDateTime.now();

        // Crea un formato para la fecha y la hora.
        DateTimeFormatter formatoD = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        DateTimeFormatter formatoH = DateTimeFormatter.ofPattern("HH:mm:ss");

        // Convierte la fecha y la hora en una cadena formateada.
        String fechaFormateada = fechaHoraActual.format(formatoD);
        String horaFormateada = fechaHoraActual.format(formatoH);

        // Imprime la fecha y hora formateada
        System.out.format("%5s %44s", "Fecha:", fechaFormateada + "\n");
        System.out.format("%5s %46s", "Hora:", horaFormateada + "\n\n");

    }

}
