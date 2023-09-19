package Logica;

//import java.util.ArrayList;
//import java.util.List;

public class Tablero{
    //private List<Casillero>  casilleros; //lista de Casilleros
    //private List<Casillero> casilleros = new ArrayList<>();
    private Casillero casilleros[][];

    public Tablero(Casillero casilleros[][]) {
        this.casilleros = casilleros;
    }


    public Tablero(){
       
        this.casilleros = new Casillero[8][8];
        String[] colores = {"blanco", "negro"};
        String color;
    
        int ascii = 97; //a = 97
        String conversion;
        String nombrePosicion;
       
        int num = 8;
         for(int fila = 0; fila<8; fila++){
            for(int columna = 0; columna<8; columna++){
                color = colores[(fila+columna) % 2]; //*color es 0 o 1,asigna la posicion de blanco o negro
                conversion = Character.toString((ascii + columna));
                nombrePosicion = conversion+num;
                
                casilleros[fila][columna] = new Casillero(color,nombrePosicion, null, fila, columna);
            }
            num--;
        } 
    }

    public Casillero[][] getCasilleros() {
        
        return casilleros;
    }


    public void setCasilleros(Casillero casilleros[][]) {
        this.casilleros = casilleros;
    }


    public void mostrarPosicionesTablero(){
        for(int fila = 0; fila<8; fila++){
            for(int columna = 0; columna<8; columna++){
                System.out.print(" " + this.casilleros[fila][columna].getNombrePosicion() + " ");
            
            }
            System.out.println();        
        }

    } 

     public void mostrarColoresTablero(){
        for(int fila = 0; fila<8; fila++){
            for(int columna = 0; columna<8; columna++){
                System.out.print(" " + this.casilleros[fila][columna].getColor() + " ");
            
            }
            System.out.println();        
        }
    }


    public void moverPieza2(Casillero casilleroOrigen, Casillero casilleroDestino) {
        // Verificar si hay una pieza en el casillero de origen
        Pieza piezaAMover = casilleroOrigen.getPieza();
        if (piezaAMover == null) {
            System.out.println("No hay una pieza en el casillero de origen.");
            return; // No hay pieza para mover.
        }

        // Verificar si el casillero de destino está vacío
        if (casilleroDestino.getPieza() != null) {
            System.out.println("El casillero de destino ya está ocupado.");
            return; // No se puede mover a un casillero ocupado.
        }

        // Mover la pieza al casillero de destino
        casilleroOrigen.setPieza(null); // Quitar la pieza del casillero de origen
        casilleroDestino.setPieza(piezaAMover); // Colocar la pieza en el casillero de destino

        // Actualizar la posición de la pieza
        //*piezaAMover.setCasillero(casilleroDestino);
    }




   /*  public void mostrarPiezasTablero(){
        int contador = 0;
        for(int fila = 0; fila < casilleros.length; fila++){
            for(int columna = 0; columna< casilleros.length ; columna++){
                if (this.casilleros[fila][columna].getPieza() != null){
                    contador++;

                }
                
            }
        }
        contador = contador/8;
        System.out.println("contador: " + contador);

        for(int fila = 0; fila < contador; fila++){
            for(int columna = 0; columna< 8 ; columna++){
                System.out.print(this.casilleros[fila][columna].getPieza().getClass().getSimpleName()+ " ");
                
                System.out.print("color:"+this.casilleros[fila][columna].getColor()+ " ");
            }
               
            System.out.println("");
        }
    } */


    public void colocarPieza(Pieza pieza, int fila, int columna){
        /*
         * Colocar la pieza dentro del casillero
         */
        //int ascii = 97;
        if (fila>= 0 && fila < casilleros.length && columna>=0 && columna < casilleros.length){ // casilleros[0].length
            
            Casillero casillero = casilleros[fila][columna];
            casillero.setPieza(pieza);
            //*this.casilleros[fila][columna].setPieza(pieza);
            //pieza.setPosicion(casilleros);
            /* String letra = Character.toString((ascii + columna));
            String nombrePosicion = letra+(8 - fila);
            //casillero.setNombre(nombrePosicion);
            this.casilleros[fila][columna].setNombrePosicion(nombrePosicion); */
        }
    }

    public void moverPieza(Pieza pieza, String nombrePosicion){

        //convierto un string del nombre de la posicion en una letra y un numero que van a ser
        // la nueva fila y la columna de la pieza

      /*   Casillero casilleroOrigen = casilleros;
        System.out.println("Casillero origen:" + casilleroOrigen;
 */
        char letra = nombrePosicion.charAt(0);
        System.out.println("letra: " + letra);
        int columna = letra;
        System.out.println("le deberia ser numero" + columna);

        char numero = nombrePosicion.charAt(1);
        System.out.println("letra: " + numero);
        int fila =  Character.getNumericValue(numero);
        System.out.println("le deberia ser numero" + fila );

        //this.casilleros[][]
        
    }

    public int obtenerFilaPosicion(String nombrePosicion){
        char numero = nombrePosicion.charAt(1);
        System.out.println("letra: " + numero);
        int fila =  Character.getNumericValue(numero);
        System.out.println("le deberia ser numero" + fila );

        return fila;
    }
    
    
    public int obtenerColumnaPosicion(String nombrePosicion){
        char letra = nombrePosicion.charAt(0);
        System.out.println("letra: " + letra);
        int columna = letra;
        System.out.println("le deberia ser numero" + columna);

        return columna;
    }


    public void mostrarTablero() {
        for (int fila = 0; fila < casilleros.length; fila++) {
            for (int columna = 0; columna < casilleros[fila].length; columna++) {
                Casillero casillero = casilleros[fila][columna];
                Pieza pieza = casillero.getPieza(); // método getPieza en la clase Casillero para obtener la pieza en ese casillero
                if (pieza != null) {
                    System.out.println("En la fila " + fila + ", columna " + columna + " hay una pieza: " + pieza.getClass().getSimpleName());
                    System.out.println(pieza.getComportamiento());
                }
            }
        }
    }

//*fin Tablero*/
}

   