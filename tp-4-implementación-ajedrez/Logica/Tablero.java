package Logica;

import java.util.ArrayList;
import java.util.List;

public class Tablero{
    //private List<Casillero>  casilleros; //lista de Casilleros
    private List<Casillero> casilleros = new ArrayList<>();


    public Tablero(){
        //this.casilleros = new ArrayList<>();
        String[] colores = {"blanco", "negro"};
        String color;
        
         for(int fila = 0; fila<8; fila++){
            for(int columna = 0; columna<8; columna++){
                //int modulo = (fila+columna) % 2;
                //System.out.println("operacion: " + operacion);
                color = colores[(fila+columna) % 2]; //*color es 0 o 1,asigna la posicion de blanco o negro
                System.out.println("color:"+ color + "f: "+fila +"c: "+ columna);

                casilleros.add(new Casillero(color));
                //this.casilleros.add(new Casillero(color));
            }
        } 
    }

    public Tablero(List<Casillero> casilleros) {
        this.casilleros = casilleros;
    }

    public List<Casillero> getCasilleros() {
        return casilleros;
    }

    public void setCasilleros(List<Casillero> casilleros) {
        this.casilleros = casilleros;
    }

    public String obtenerColor(int fila, int columna){
        int posicion = fila*8 + columna;
        if (posicion >=0 && posicion < casilleros.size()){
            return casilleros.get(posicion).getColor();
        }
        else return null;
        
    }
}