package Logica;

public abstract class Pieza {

    private String movimiento;
    private String color;
    private String comportamiento;

    public Pieza() {
    }

    public Pieza(String movimiento, String color, String comportamiento) {
        this.movimiento = movimiento;
        this.color = color;
        this.comportamiento = comportamiento;

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

    public abstract void mover();

}
