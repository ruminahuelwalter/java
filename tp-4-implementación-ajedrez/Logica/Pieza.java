package Logica;

public abstract class Pieza {

    private String movimiento;
    private String color;
    private String comportamiento;
    private String nombrePosicion;

    public Pieza(String movimiento, String color, String comportamiento, String nombrePosicion, int fila, int columna) {
        this.movimiento = movimiento;
        this.color = color;
        this.comportamiento = comportamiento;
        this.nombrePosicion = nombrePosicion;

    }

    public Pieza(){
        
    }

    public String getMovimiento() {
        return movimiento;
    }

    public void setMovimiento(String movimiento) {
        this.movimiento = movimiento;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getComportamiento() {
        return comportamiento;
    }

    public void setComportamiento(String comportamiento) {
        this.comportamiento = comportamiento;
    }
    
    public String getNombrePosicion() {
        return nombrePosicion;
    }

    public void setNombrePosicion(String nombrePosicion) {
        this.nombrePosicion = nombrePosicion;
    }

    public abstract void mover();

}
