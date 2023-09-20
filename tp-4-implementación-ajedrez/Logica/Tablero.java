package Logica;

class Tablero{

    private Casillero casilleros[][];

    public Tablero(Casillero casilleros[][]) {
        this.casilleros = casilleros;
    }

    public Tablero(){

    }
    
    public Casillero[][] getCasilleros() {
        return casilleros;
    }

    public void setCasilleros(Casillero casilleros[][]) {
        this.casilleros = casilleros;
    }

    public void generarTablero(int row, int column){
        casilleros = new Casillero[row][column];
        //*String[] colores = {"blanco", "negro"};
        //*String color;
    
        //*int ascii = 97; //a = 97
        //*String conversion;
        //*String nombrePosicion;
       
        //*int num = 8;
        for(int fila = 0; fila < row; fila++){
            for(int columna = 0; columna < column; columna++){
                //*color = colores[(fila+columna) % 2]; //*color es 0 o 1,asigna la posicion de blanco o negro
                //*conversion = Character.toString((ascii + columna));
                //*nombrePosicion = conversion+num;
                
                //casilleros[fila][columna] = new Casillero(color,nombrePosicion, null, fila, columna);
                casilleros[fila][columna] = new Casillero();
            }
           //* num--;
        } 
    }

    public void asignarColor(){

        String[] colores = {"blanco", "negro"};
        String color;
        
        for(int fila = 0; fila<8; fila++){
            for(int columna = 0; columna<8; columna++){
                color = colores[(fila+columna) % 2]; //*color es 0 o 1,asigna la posicion de blanco o negro
                //*this.casilleros[fila][columna].setColor(color); ;
                casilleros[fila][columna].setColor(color); ;
            }
        }
    }

    public void asignarNombrePosicion(){
     
        int ascii = 97; //a = 97
        String conversion;
        String nombrePosicion;
        int num = 8;

        for(int fila = 0; fila<8; fila++){
            for(int columna = 0; columna<8; columna++){
                conversion = Character.toString((ascii + columna));
                nombrePosicion = conversion+num;
                //this.casilleros[fila][columna].setNombrePosicion(nombrePosicion); ;
                casilleros[fila][columna].setNombrePosicion(nombrePosicion); ;
            }
            num--;
        }
    }

    public void mostrarPosiciones(){
        
        for(int fila = 0; fila<8; fila++){
            for(int columna = 0; columna<8; columna++){
                //Casillero casillero = casilleros[fila][columna]
                //*System.out.print(" " + this.casilleros[fila][columna].getNombrePosicion() + " ");
                System.out.print(" " + casilleros[fila][columna].getNombrePosicion() + " ");
            
            }
            System.out.println();        
        }
    }

     public void mostrarColores(){
        for(int fila = 0; fila<8; fila++){
            for(int columna = 0; columna<8; columna++){
                //*System.out.print(" " + this.casilleros[fila][columna].getColor() + " ");
                System.out.print(" " + casilleros[fila][columna].getColor() + " ");
            
            }
            System.out.println();        
        }
    }


    public void moverPieza(String origen, String destino){
        // Posición de casillero en formato 'a8' se transforma a posición en indice numerico. Según letra y número.
        int filaOrigen = obtenerFilaPosicion(origen);
        int columnaOrigen = obtenerColumnaPosicion(origen);
        System.out.println("Fila y columna de origen: " + filaOrigen + " " + columnaOrigen);
        int filaDestino = obtenerFilaPosicion(destino);
        int columnaDestino = obtenerColumnaPosicion(destino);
        System.out.println("Fila y columna de destino: " + filaDestino + " " + columnaDestino);
    
        Casillero casilleroOrigen = casilleros[filaOrigen][columnaOrigen]; // Casillero de origen.
        Casillero casilleroDestino = casilleros[filaDestino][columnaDestino]; // Casillero de destino.

        Pieza piezaAMover = casilleroOrigen.getPieza(); // Del casillero de origen se obtiene la pieza a mover.
        if (piezaAMover == null) {
            System.out.println("No hay una pieza en el casillero de origen.");
            return; // No hay pieza para mover. 
        }
        if (casilleroDestino.getPieza() != null) {
            System.out.println("El casillero de destino ya está ocupado.");
            return; // No se puede mover a un casillero ocupado. Falta lógica de juego.
        }
        casilleroDestino.setPieza(piezaAMover);
        System.out.println("La pieza " + piezaAMover.getClass().getSimpleName() + " se movió correctamente.");
    }


    public void colocarPieza(Pieza pieza, int fila, int columna){
        // Colocar la pieza dentro del tablero en su posición inicial.
        
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

    
    public int obtenerFilaPosicion(String nombrePosicion){

        char numero = nombrePosicion.charAt(1);
        //!System.out.println("letra: " + numero);
        int fila =  Character.getNumericValue(numero);
        fila = 8 - fila; // Restar fila a 8 dado que indice va de 0 a 7. 8-8= 0.
        System.out.println("Fila obtenida: " + fila );

        return fila;
    }
    
    
    public int obtenerColumnaPosicion(String nombrePosicion){

        char letra = nombrePosicion.charAt(0);
        //!System.out.println("letra: " + letra);
        int columna = letra;
        columna = columna - 97; // Restar 97, posicion de 'a' en ascii. a es indice 0.
        System.out.println("Columna obtenida: " + columna);

        return columna;
    }


    public void mostrarTablero() {

        for (int fila = 0; fila < casilleros.length; fila++) {
            for (int columna = 0; columna < casilleros[fila].length; columna++) {
                Casillero casillero = casilleros[fila][columna];
                Pieza pieza = casillero.getPieza(); // Método getPieza en la clase Casillero para obtener la pieza en ese casillero.
                if (pieza != null) {
                    System.out.println("En la fila " + fila + ", columna " + columna + " hay una pieza: " + pieza.getClass().getSimpleName());
                    System.out.println("De comportamiento: " + pieza.getComportamiento() + " y con movimiento " + pieza.getMovimiento());
                }
            }
        }
    }

//* Fin Tablero.
}

   