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

    public void generarTablero(){
        // Crear tablero vacio.
        int row = 8 ;
        int column = 8;
        casilleros = new Casillero[row][column];
        for(int fila = 0; fila < row; fila++){
            for(int columna = 0; columna < column; columna++){
                casilleros[fila][columna] = new Casillero();
            }
        }
    }

    public void asignarColor(){

        String[] colores = {"blanco", "negro"};
        String color;
        
        for(int fila = 0; fila<8; fila++){
            for(int columna = 0; columna<8; columna++){
                color = colores[(fila+columna) % 2]; //* Color es 0 o 1,asigna la posicion de blanco o negro.
                casilleros[fila][columna].setColor(color);
            }
        }
    }

    public void asignarNombrePosicion(){
        
        int ascii = 97; //a = 97
        String letra;
        String nombrePosicion;
        int numero = 8; // El número en posición 'a8' esta invertido con respecto al indice de fila '0 0'.

        for(int fila = 0; fila<8; fila++){
            for(int columna = 0; columna<8; columna++){
                letra = Character.toString((ascii + columna)); // Convierte el número al carácter correspondiente.
                nombrePosicion = letra+numero;
                casilleros[fila][columna].setNombrePosicion(nombrePosicion); ;
            }
            numero--;
        }
    }

    public void mostrarNombrePosicion(){
      
        for(int fila = 0; fila<8; fila++){
            for(int columna = 0; columna<8; columna++){
                System.out.printf("%8s"," " + casilleros[fila][columna].getNombrePosicion() + " ");
            }
            System.out.println(" \n");
        }
    
        System.out.println("");
    }

     public void mostrarColor(){
 
        for(int fila = 0; fila<8; fila++){
            for(int columna = 0; columna<8; columna++){
                System.out.printf(" %9s", " " + casilleros[fila][columna].getColor() + " ");
            
            }
            System.out.println("\n");
            System.out.println(" ");
        }
 
        System.out.println(" ");
    }

       public void mostrarPieza(){
   
        System.out.println();
        for(int fila = 0; fila<8; fila++){
            for(int columna = 0; columna<8; columna++){
                if (casilleros[fila][columna].getPieza() != null){
                    
                    System.out.printf("%10s", " "+ casilleros[fila][columna].getPieza().getClass().getSimpleName() );
                }
                else System.out.printf("%10s", " "); // Si es null se imprime un espacio para que no se desplacen las demás piezas
            }
            System.out.println("\n");
            System.out.println(" ");
        }
    
        System.out.println(" ");
    }


    public void moverPieza(String origen, String destino){
        // Posición de casillero en formato 'a8' se transforma a posición en indice numerico. Según letra y número.
        int filaOrigen = obtenerFilaPosicion(origen);
        int columnaOrigen = obtenerColumnaPosicion(origen);
        //! Check
        System.out.println("Origen:  Fila: " + filaOrigen + " Columna: " + columnaOrigen);

        int filaDestino = obtenerFilaPosicion(destino);
        int columnaDestino = obtenerColumnaPosicion(destino);
        //! Check
        System.out.println("Destino:  Fila: " + filaDestino + " Columna: " + columnaDestino);
    
        Casillero casilleroOrigen = casilleros[filaOrigen][columnaOrigen]; // Casillero de origen.
        Casillero casilleroDestino = casilleros[filaDestino][columnaDestino]; // Casillero de destino.

        Pieza piezaAMover = casilleroOrigen.getPieza(); // Del casillero de origen se obtiene la pieza a mover.
        if (piezaAMover == null) {
            System.out.println("No hay una pieza en el casillero de origen.");
            return; // No hay pieza para mover. 
        }
        if (casilleroDestino.getPieza() != null) {
            System.out.println("El casillero de destino ya está ocupado.");
            return; // No se puede mover a un casillero ocupado. Falta incorporar lógica de juego.
        }
        casilleroDestino.setPieza(piezaAMover);
        casilleroOrigen.setPieza(null); // Quitar pieza de casillero de origen.
        System.out.println("La pieza " + piezaAMover.getClass().getSimpleName() + " se movió correctamente.");
    }

    public void colocarPieza(Pieza pieza, int fila, int columna){
        // Colocar la pieza dentro del tablero en su posición inicial.
        if (fila>= 0 && fila < casilleros.length && columna>=0 && columna < casilleros.length){ // casilleros[0].length
            Casillero casillero = casilleros[fila][columna];
            casillero.setPieza(pieza);
        }
    }
    
    public int obtenerFilaPosicion(String nombrePosicion){

        char numero = nombrePosicion.charAt(1); // 'a8' Obtiene el número 8, para luego retornar su indice correspondiente.
        int fila =  Character.getNumericValue(numero);
        fila = 8 - fila; // Restar fila a 8 dado que indice va de 0 a 7. 8-8= 0.
  
        return fila;
    }
    
    public int obtenerColumnaPosicion(String nombrePosicion){

        char letra = nombrePosicion.charAt(0); // 'a8' Obtiene la letra a, para luego retornar su indice correspondiente.
        int columna = letra;
        columna = columna - 97; // Restar 97, que es la posicion de 'a' en ascii. a es indice 0.

        return columna;
    }


    public void mostrarTablero() {

        for (int fila = 0; fila < casilleros.length; fila++) {
            for (int columna = 0; columna < casilleros[fila].length; columna++) {
                Casillero casillero = casilleros[fila][columna];
                Pieza pieza = casillero.getPieza();
                if (pieza != null) {
                    System.out.println("En la fila " + (fila+1) + ", columna " + (columna+1) + " hay una pieza: " + pieza.getClass().getSimpleName());
                    System.out.println("De comportamiento: " + pieza.getComportamiento() + " y con movimiento " + pieza.getMovimiento());
                }
            }
        }
    }

    


}

   