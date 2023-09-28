package Logica;

public class Casillero {

    private String color;
    private String nombrePosicion;
    private boolean ocupado;

    public Casillero(String color, String nombrePosicion, boolean ocupado, int fila, int columna) {
        this.color = color;
        this.nombrePosicion = nombrePosicion;
        this.ocupado = ocupado;
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

    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }
    
    public boolean isOcupado() {
        return ocupado;
    }

}
