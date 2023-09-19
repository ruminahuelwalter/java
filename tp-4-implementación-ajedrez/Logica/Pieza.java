package Logica;

//import java.util.List;

public abstract class Pieza {

    private String movimiento;
    private String color;
    private String comportamiento;
    //private Casillero posicion;


    public Pieza(){
    }

    public Pieza(String movimiento, String color, String comportamiento) {
        this.movimiento = movimiento;
        this.color = color;
        this.comportamiento = comportamiento;
        //this.posicion = posicion;
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
    
   /*  public Casillero getPosicion() {
        return posicion;
    }

    public void setPosicion(Casillero posicion) {
        this.posicion = posicion;
    } */
    
    public abstract void mover();

    
}




