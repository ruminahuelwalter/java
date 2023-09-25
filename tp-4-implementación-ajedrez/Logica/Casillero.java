package Logica;

public class Casillero {

    private String color;
    private String nombrePosicion;
    private Pieza pieza;

    public Casillero(String color, String nombrePosicion, Pieza pieza, int fila, int columna) {
        this.color = color;
        this.nombrePosicion = nombrePosicion;
        this.pieza = pieza;
    }

    public Casillero() {

    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
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
