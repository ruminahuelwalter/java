package Logica;

import java.util.ArrayList;
import java.util.List;


public class Program {
    public static void main(String[] args) {
 

        //startJuego()
        //finJuego()
        //es el casillero el que conoce a la pieza?
        //* pieza deberia tener el atributo posicion HECHO */
        /* Voy a crear las piezas las cargo en un array, luego una vez creado el tablero
            cargo las piezas que estan en el array al array tablero.
         */
        // validar que una pieza se le asigna una posicion y en esa posicion no puede haber otra
        //debo asignar posiciones a las piezas, luego validar con las posiciones del tablero
        
        Pieza piezaA = null;
        boolean bandera = true;
        //List<Pieza> piezasBlancas = crearPiezasAjedrez(); //podria ser un metodo
        List<Pieza> piezasBlancas = new ArrayList<>();
        List<Pieza> piezasNegras = new ArrayList<>();
        
        crearPiezasAjedrez(piezasBlancas);
        crearPiezasAjedrez(piezasNegras);

        pintarPiezas(piezasBlancas, "blanco");
        pintarPiezas(piezasNegras, "negro");

        //List<Pieza> piezasNegras = crearPiezasAjedrez();
        cargarComportamientoMovimiento(piezasNegras);

 
        /* for (Pieza pieza : piezasNegras) {
            if (pieza instanceof Alfil && bandera) {
                //Alfil alfil = (Alfil) pieza;
                piezaA = pieza;
                bandera = false;
                System.out.println(pieza.getComportamiento());
                System.out.println(pieza.getMovimiento());
                System.out.println(pieza.getColor());
                System.out.println(pieza.getPosicion());
                //alfil.setFila(3);
                //alfil.setColumna(0);
                //System.out.println("Posicion del alfil: "+ alfil.getFila()+ "," + alfil.getColumna());
                System.out.println();
                //alfil.mover();
            }
        } */
/* esto funciona 
        for (Pieza pieza : piezasNegras){
            if(pieza.getClass().getSimpleName().equals("Peon")){
                System.out.println("Encontre un peon");
            }
        }

        for(Pieza pieza : piezasNegras){
            System.out.println( pieza.getClass().getSimpleName());
            System.out.println( pieza.getColor());
            System.out.println("Soy un " + pieza.getClass().getSimpleName() + " de color " + pieza.getColor());
            
        } */

       /*  piezaA.mover();
        System.out.println("pieza fuera de forEach" + piezaA.getClass().getSimpleName());
         */
        Tablero tablero = new Tablero();
        

        //System.out.println(tablero.getCasilleros().hashCode());
        //tablero.mostrarPosicionesTablero();
        tablero.mostrarColoresTablero();
        //tablero.mostrarEstadoTablero();
        //! Quede viendo como puedo setear desde program el estado del casillero
        /* for (Pieza piezaAjedrez : piezasNegras){
            tablero.colocarPieza(piezaAjedrez, 0, 0);
        } */
        /* for (Pieza piezaAjedrez : piezasNegras){
            System.out.println("posicion: " + piezaAjedrez.getPosicion().getFila() + piezaAjedrez.getPosicion().getColumna());
            
        }

        for (Pieza piezaAjedrez : piezasNegras){
            System.out.println("posicion: " + piezaAjedrez.getPosicion().getNombre());
            
        } */
        
        colocarPiezaTablero(piezasNegras, tablero);
        //System.out.println("hash casillero" + tablero.getCasilleros().hashCode());
        tablero.mostrarPosicionesTablero();
        /* System.out.println("Posicion de [0]: " + piezasNegras.get(15).getPosicion().getNombre()); */
       /*  System.out.println("hash casillero pieza" + piezasNegras.get(0).getPosicion().hashCode()); */
       
        tablero.moverPieza(piezasNegras.get(1), "d1");
        
        System.out.println("PIEZAS EN EL TABLERO");
        //tablero.mostrarPiezasTablero();
    

        /*quede en como relaciono las piezas con el tablero, ahora las piezas estan dentro de casillero
         * como muestro las piezas dentro del casillero. HECHO
         * quiero cargar las piezas al tablero y mostrarlas HECHO
         */

        //*tablero.mostrarTablero();

        /* Casillero casillero = new Casillero();

        System.out.println("casillero.getPieza: " + casillero.getPieza());
         */



        
        Casillero casilleros[][] = tablero.getCasilleros(); //obtengo los casilleros del tablero que tiene piezas cargadas
        Casillero casillero = casilleros[0][0]; //casillero de origen - fila columna
        Casillero casillero2 = casilleros[4][3]; //casillero de destino
        Pieza piezaC = casillero.getPieza();
        Pieza piezaD = casillero2.getPieza();
        System.out.println("piezaC: " + piezaC);
        System.out.println("piezaD: " + piezaD);

       
        Casillero casilleroOrigen = new Casillero(null, null, piezaC, 1, 2);
        Casillero casilleroDestino = new Casillero(null, null, null, 0, 3);

        tablero.moverPieza2(casillero, casillero2);
        tablero.mostrarTablero();

    }//*fin main

    public static void colocarPiezaTablero(List<Pieza> piezasAjedrez, Tablero tablero){
        //* SOLO ESTA FUNCIONANDO PARA LAS PIEZAS NEGRAS */
        int fila = 0;
        int columna = 0;
      
        for (int i= 0; i <16; i++){
            tablero.colocarPieza(piezasAjedrez.get(i), fila, columna);
            System.out.println("soy: " + piezasAjedrez.get(i).getClass().getSimpleName());
            
            if ((columna+1)%8 == 0){
                columna= -1;
                fila++;
            }

            columna++;
        }
    
        /* for (Pieza pieza : piezasAjedrez){
            System.out.println("Pieza: " + pieza.getClass().getSimpleName() +"\n" + " Fila:" + pieza.getPosicion().getFila());
            System.out.println("columna:" + pieza.getPosicion().getColumna() + " posicion: " + pieza.getPosicion().getNombre());

        } */
    }

    public static List<Pieza> pintarPiezas(List<Pieza> piezas, String color){
        //Recibe el arraylist con las piezas y las pinta xd
        for (Pieza piezaAjedrez : piezas){
            piezaAjedrez.setColor(color);
        }
        return piezas;
    }

    public static void crearPiezasAjedrez(List<Pieza> piezas) {

        piezas.add(new Torre());
        piezas.add(new Caballo());
        piezas.add(new Alfil());
        piezas.add(new Rey());
        piezas.add(new Reina());
        piezas.add(new Alfil());
        piezas.add(new Caballo());
        piezas.add(new Torre());
        
        for (int i = 0; i < 8; i++) {
            piezas.add(new Peon());
        }
    }


    public static void cargarComportamientoMovimiento(List<Pieza> piezasAjedrez){
        
        for (Pieza pieza : piezasAjedrez) {
            if (pieza instanceof Alfil) {
                //Alfil alfil = (Alfil) pieza;
                pieza.setComportamiento("sesgo");
                pieza.setMovimiento("oblicuo");
            }
            if (pieza instanceof Caballo){
                pieza.setComportamiento("nulo");
                pieza.setMovimiento("ligero");
            }
            if (pieza instanceof Peon) {
                pieza.setComportamiento("agresor");
                pieza.setMovimiento("ladino");
            }
            if (pieza instanceof Reina) {
                pieza.setComportamiento("armada");
                pieza.setMovimiento("encarnizada");
            }
            if (pieza instanceof Rey) {
                pieza.setComportamiento("postrero");
                pieza.setMovimiento("tenue");
            }

            if (pieza instanceof Torre) {
                pieza.setComportamiento("hómerica");
                pieza.setMovimiento("directa");
            }
        }
        return;
    }

/* 
    //cuando cargue el tablero cargo el nombre de las casillas
    public static List<String> nombresCasillas(){
        //String[] nombresCasillas = {"a8","b8"};
        List<String> nombresCasillas = new ArrayList<>();
        //String valor;
        int ascii = 97;
        int j = 8;
        String convertedChar;
        for(int i = 0; i<64; i++){
            convertedChar = Character.toString(ascii); //+i
            nombresCasillas.add(convertedChar+j);
            ascii++;
            if ((i+1)%8 == 0){ 
                //System.out.println("mod: "+ (i+1)%8);
                ascii = 97;
                j--;
            }
            System.out.println("conver: " + convertedChar); 
        }
        return nombresCasillas;

    }

    public static void cargarTablero(){
        
    } */


}

