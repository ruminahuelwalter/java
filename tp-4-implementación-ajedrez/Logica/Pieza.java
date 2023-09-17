package Logica;

//import java.util.List;

public abstract class Pieza {

    private String movimiento;
    private String color;
    private String comportamiento;
    private int posicion;
    //private int fila;
    //private int columna;
    //private int[] posicion; //un vector con fila y posicion
    //private int posicion [] = {fila, columna};
   

    public Pieza(){
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
    
    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }
    
    public abstract void mover();

   /*  public posicionesPieza(){
        //String[] nombresCasillas = {"a8","b8"};
        List<String> nombresCasillas;
        String valor;
        int ascii = 96;
        int k = 8;
        for(int i = 0; i<64; i++){
            String convertedChar = Character.toString(ascii + 1);
                nombresCasillas.add(convertedChar+k);
                k++;
                if (i%8 == 0){ 
                    k = 0;
                    ascii=96;
                } 
        }
        nombresCasillas.
            
    } */

    
    
}

/*     public int getFila() {
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
    } */

    /* public posicion(){
        
    } */






