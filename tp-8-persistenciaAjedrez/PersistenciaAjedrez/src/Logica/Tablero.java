package Logica;

public class Tablero {

    private Casillero casilleros[][];

    public Tablero(Casillero casilleros[][]) {
        this.casilleros = casilleros;
    }

    public Tablero() {

    }

    public Casillero[][] getCasilleros() {
        return casilleros;
    }

    public void setCasilleros(Casillero casilleros[][]) {
        this.casilleros = casilleros;
    }

    public void generarTablero() {
        // Crear tablero vacio.
        this.casilleros = new Casillero[8][8];
        for (int fila = 0; fila < 8; fila++) {
            for (int columna = 0; columna < 8; columna++) {
                this.casilleros[fila][columna] = new Casillero();
            }
        }
    }

    public void asignarColor() {

        String[] colores = { "blanco", "negro" };
        String color;

        for (int fila = 0; fila < 8; fila++) {
            for (int columna = 0; columna < 8; columna++) {
                color = colores[(fila + columna) % 2]; // Color es 0 o 1,asigna la posicion de blanco o negro.
                this.casilleros[fila][columna].setColor(color);
            }
        }
    }

    public void mostrarColor() {

        System.out.println(" ");
        for (int fila = 0; fila < 8; fila++) {
            for (int columna = 0; columna < 8; columna++) {
                System.out.printf(" %9s", " " + this.casilleros[fila][columna].getColor() + " ");

            }
            System.out.println("\n");
            System.out.println(" ");
        }
    }

    public void asignarNombrePosicion() {

        int ascii = 97; // a = 97
        String letra;
        String nombrePosicion;
        int numero = 8; // El número en posición 'a8' esta invertido con respecto al indice de fila '0'.

        for (int fila = 0; fila < 8; fila++) {
            for (int columna = 0; columna < 8; columna++) {
                letra = Character.toString((ascii + columna)); // Convierte el número al carácter correspondiente.
                nombrePosicion = letra + numero;
                this.casilleros[fila][columna].setNombrePosicion(nombrePosicion);

            }
            numero--;
        }
    }

    public void mostrarNombrePosicion() {
        System.out.println(" ");

        for (int fila = 0; fila < 8; fila++) {
            for (int columna = 0; columna < 8; columna++) {
                System.out.printf("%8s", " " + this.casilleros[fila][columna].getNombrePosicion() + " ");
            }
            System.out.println(" \n");
        }
    }

}