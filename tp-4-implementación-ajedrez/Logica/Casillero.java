package Logica;
public class Casillero {
    
    private String color;
    private int fila;
    private int columna;
    private String nombrePosicion;
    private Pieza pieza;

    public Casillero(String color, String nombrePosicion, Pieza pieza, int fila, int columna) {
        this.color = color;
        this.nombrePosicion = nombrePosicion;
        this.pieza = pieza;
        this.fila = fila;
        this.columna = columna;
    }

    public Casillero() {
        
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    public String getNombrePosicion() {
        return nombrePosicion;
    }

    public void setNombrePosicion(String nombrePosicion) {
        this.nombrePosicion = nombrePosicion;
    }

    
    public void setPieza(Pieza pieza) {
        this.pieza = pieza;
    }
    
    public Pieza getPieza() {
        return pieza;
    }


} 
