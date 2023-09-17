package Logica;

import java.util.ArrayList;
import java.util.List;


public class Program {
    public static void main(String[] args) {
        //Pieza miPieza = new Peon();
        //System.out.println("La pieza creada es: " + miPieza.getClass().getSimpleName());
        //miPieza.setMovimiento("ladino");
        //miPieza.mover();

        //startJuego()
        //finJuego()
        //es el casillero el que conoce a la pieza?
        //* pieza deberia tener el atributo posicion HECHO */
        /* Voy a crear las piezas las cargo en un array, luego una vez creado el tablero
            cargo las piezas que estan en el array al array tablero.
         */
        // validar que una pieza se le asigna una posicion y en esa posicion no puede haber otra
        //debo asignar posiciones a las piezas, luego validar con las posiciones del tablero
        // Figura f = null
        // f = Cuadrado
        // f = Circulo
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

        //int[] posicion = {1,1};
        //pieza.getClass()
        for (Pieza pieza : piezasNegras) {
            if (pieza instanceof Alfil && bandera) {
                Alfil alfil = (Alfil) pieza;
                piezaA = alfil;
                bandera = false;
                System.out.println(alfil.getComportamiento());
                System.out.println(alfil.getMovimiento());
                System.out.println(alfil.getColor());
                //alfil.setFila(3);
                //alfil.setColumna(0);
                //System.out.println("Posicion del alfil: "+ alfil.getFila()+ "," + alfil.getColumna());
                System.out.println();
                //alfil.mover();
            }
        }
        for (Pieza pieza : piezasNegras){
            if(pieza.getClass().getSimpleName().equals("Peon")){
                System.out.println("Encontre un peon");
            }
        }

        //for(Pieza pieza : piezasNegras){
            //System.out.println( pieza.getClass().getSimpleName());
            //System.out.println( pieza.getColor());
            //System.out.println("Soy un " + pieza.getClass().getSimpleName() + " de color " + pieza.getColor() + " y mi posicion es " + pieza.getFila()+ "," + pieza.getColumna());
            //pieza.getClass().getSimpleName();
        //}

        piezaA.mover();
        System.out.print(piezaA);

        Tablero tablero = new Tablero();
        //int[] posicion = {1,1}; //prueba 
        //piezaA.setPosicion();

        //System.out.println(tablero.getCasilleros());
        tablero.getCasilleros();
        System.out.println(tablero.obtenerColor(1, 2));

        List<String> nombresCasilleros = nombresCasillas();

        for (String casilla : nombresCasilleros) {
            System.out.println("nombre casilla: " + casilla);
        }

        asignarPosicionB(piezasNegras, "negro");

    }//*fin main

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


    public static List<Pieza> cargarComportamientoMovimiento(List<Pieza> piezasAjedrez){
        
        for (Pieza pieza : piezasAjedrez) {
            if (pieza instanceof Alfil) {
                Alfil alfil = (Alfil) pieza;
                alfil.setComportamiento("sesgo");
                alfil.setMovimiento("oblicuo");
            }
            if (pieza instanceof Caballo){
                Caballo caballo = (Caballo) pieza;
                caballo.setComportamiento(null);
                caballo.setMovimiento("ligero");
            }
            if (pieza instanceof Peon) {
                Peon peon = (Peon) pieza;
                peon.setComportamiento("agresor");
                peon.setMovimiento("ladino");
            }
            if (pieza instanceof Reina) {
                Reina reina = (Reina) pieza;
                reina.setComportamiento("armada");
                reina.setMovimiento("encarnizada");
            }
            if (pieza instanceof Rey) {
                Rey rey = (Rey) pieza;
                rey.setComportamiento("postrero");
                rey.setMovimiento("tenue");
            }
        }
        return piezasAjedrez;
    }

    public static void asignarPosicionB(List<Pieza> piezasAjedrez, String color){

        int posicionInicial = 0;

        if (color.equals("negro")){
            for (Pieza pieza : piezasAjedrez) {

                if (pieza instanceof Torre) {
                    pieza.setPosicion(posicionInicial);
                    pieza.setPosicion(posicionInicial+7);//posicionInicial += 7;
                        //bandera = true;
                    }
                posicionInicial = 0;
                if (pieza instanceof Caballo) {
                    pieza.setPosicion(posicionInicial + 1);
                    pieza.setPosicion(posicionInicial + 5);
                }
                posicionInicial = 0;
                if (pieza instanceof Alfil) {
                    pieza.setPosicion(posicionInicial + 2);
                    posicionInicial += 3;
                } 
                posicionInicial = 0;
                if (pieza instanceof Rey) {
                    pieza.setPosicion(posicionInicial + 3);
                }
                posicionInicial = 0;
                if (pieza instanceof Reina) {
                    pieza.setPosicion(posicionInicial + 4);
                } 
                posicionInicial = 0;
                if (pieza instanceof Peon) {
                    pieza.setPosicion(posicionInicial + 8);
                    posicionInicial += 1;
                }

            }
            for (Pieza pieza : piezasAjedrez) {
                if (pieza instanceof Torre) {
                    System.out.println("torre.getPosicion(): " + pieza.getPosicion());
                }
                if (pieza instanceof Caballo) {
                    System.out.println("caballo.getPosicion(): " + pieza.getPosicion());
                }
                if (pieza instanceof Alfil) {
                    System.out.println("alfil.getPosicion(): " + pieza.getPosicion());
                }
                if (pieza instanceof Rey) {
                    System.out.println("rey.getPosicion(): " + pieza.getPosicion());
                }
                if (pieza instanceof Reina) {
                    System.out.println("reina.getPosicion(): " + pieza.getPosicion());
                }
                if (pieza instanceof Peon) {
                    System.out.println("peon.getPosicion(): " + pieza.getPosicion());
                }
            }

            
        }
    }

    public static void asignarPosicion(List<Pieza> piezasAjedrez, String color){
        
        int posicionInicial = 0;
        if (color.equals("negro")){

            for (Pieza pieza : piezasAjedrez) {
                if (pieza instanceof Torre) {
                    //Torre torre = (Torre) pieza;
                    pieza.setPosicion(posicionInicial);
                    posicionInicial =+ 7;
                }
            }
            posicionInicial = 0;
            for (Pieza pieza : piezasAjedrez) {
                if (pieza instanceof Caballo) {
                    Caballo caballo = (Caballo) pieza;
                    caballo.setPosicion(posicionInicial + 1);
                    posicionInicial = posicionInicial + 5;
                }
            }
            posicionInicial = 0;
            for (Pieza pieza : piezasAjedrez) {
                if (pieza instanceof Alfil) {
                    Alfil alfil = (Alfil) pieza;
                    alfil.setPosicion(posicionInicial + 2);
                    posicionInicial = posicionInicial + 3;
                }
            }
            posicionInicial = 0;
            for (Pieza pieza : piezasAjedrez) {
                if (pieza instanceof Rey) {
                    Rey rey = (Rey) pieza;
                    rey.setPosicion(posicionInicial + 3);
                }
                if (pieza instanceof Reina) {
                    Reina reina = (Reina) pieza;
                    reina.setPosicion(posicionInicial + 4);
                }
            }
            posicionInicial = 0;
            for (Pieza pieza : piezasAjedrez) {
                if (pieza instanceof Peon) {
                    Peon peon = (Peon) pieza;
                    peon.setPosicion(posicionInicial + 8);
                    posicionInicial = posicionInicial + 1;
                }
            }
            
            /*
             * CHEQUO DE POSICIONES
             */
            for (Pieza pieza : piezasAjedrez) {
                if (pieza instanceof Torre) {
                    Torre torre = (Torre) pieza;
                    System.out.println("torre.getPosicion(): " + torre.getPosicion());
                }
                if (pieza instanceof Caballo) {
                    Caballo caballo = (Caballo) pieza;
                    System.out.println("caballo.getPosicion(): " + caballo.getPosicion());
                }
                if (pieza instanceof Alfil) {
                    Alfil alfil = (Alfil) pieza;
                    System.out.println("alfil.getPosicion(): " + alfil.getPosicion());
                }
                if (pieza instanceof Rey) {
                    Rey rey = (Rey) pieza;
                    System.out.println("rey.getPosicion(): " + rey.getPosicion());
                }
                if (pieza instanceof Reina) {
                    Reina reina = (Reina) pieza;
                    System.out.println("reina.getPosicion(): " + reina.getPosicion());
                }
                if (pieza instanceof Peon) {
                    Peon peon = (Peon) pieza;
                    System.out.println("peon.getPosicion(): " + peon.getPosicion());
                }
            }
        }


    }   

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
        
    }

   /*  public static List<Pieza> asignarPosicion(List<Pieza> piezas){
        
    } */

    /*
        public static List<Pieza> funcrearPiezasAjedrez() {
        List<Pieza> piezas = new ArrayList<>();

        for (int i = 0; i < 8; i++) {
            piezas.add(new Peon());
        }

        for (int i = 0; i < 2; i++) {
            piezas.add(new Alfil());
        }

        for (int i = 0; i < 2; i++) {
            piezas.add(new Caballo());
        }

        for (int i = 0; i < 2; i++) {
            piezas.add(new Torre());
        }
        piezas.add(new Reina());
        piezas.add(new Rey());

        return piezas;
    }

     
     */

   /*  //! BORRAR
    public Pieza[] crearPiezasBlancasVector(){
        Pieza[] piezasBlancas = new Pieza[16];

        for (int i = 0; i < 16; i++) {
            if (i < 8){
                piezasBlancas[i] = new Peon();
            }
            if (i>=8 && i<10){
                piezasBlancas[i] = new Alfil();
            }
            if (i>=10 && i<12){
                piezasBlancas[i] = new Caballo();
            }
            if (i>=12 && i<14){
                piezasBlancas[i] = new Torre();
            }
            if (i>=14 && i<15){
                piezasBlancas[i] = new Reina();
            }   
            if (i>=15 && i<16){
                piezasBlancas[i] = new Rey();
            }
        }

        for (int i = 0; i < 16; i++){
            piezasBlancas[i].setColor("blanco");
        }

        return piezasBlancas;
    }
 */
   
 /*    static void cargaPiezas(){
        //!BORRAR
        Pieza peon = new Peon();
        peon.setComportamiento("agresor");
        peon.setMovimiento("ladino");
    } */
        /* //! CODIGO 
        Piezas[] pieza = new Piezas[10];
        for(int i = 0; i<16;i++){
            if(i < 2){
                Pieza reina = new Reina();
                listaPiezas.add(reina);
                Pieza rey = new Rey();
                listaPiezas.add(rey);
            }
            if (i < 4){
                Pieza torre = new Torre();
                listaPiezas.add(torre);
                Pieza caballo = new Caballo();
                listaPiezas.add(caballo);
                Pieza alfil = new Alfil();
                listaPiezas.add(alfil);

            }
            Pieza peon = new Peon();
            peon.setComportamiento("agresor");
            peon.setColor("negro");
            listaPiezas.add(peon);
        } */



    //carga de tablero
    //carga de piezas
    //pieza que quiere mover
 
    /*    public String[] crearPiezas(){
        String[] piezas = new String[16];
        Pieza peon1 = new Peon();
        Pieza peon2 = new Peon();
        Pieza peon3 = new Peon();
        Pieza peon5 = new Peon();
        Pieza peon6 = new Peon();
        Pieza peon7 = new Peon();


        return piezas;

    } */
    /* public List<Pieza> cargarPiezas(List<Pieza> piezas){
            piezas.size();
            for(Pieza objeto : piezas){
               
            }
        return piezas;
    } */
    /* public List<Pieza> crearPiezas(){

        List<Pieza> listaPiezas = new ArrayList<Pieza>();
        for(int i = 0; i<16;i++){
            if(i < 2){
                Pieza reina = new Reina();
                listaPiezas.add(reina);
                Pieza rey = new Rey();
                listaPiezas.add(rey);
            }
            if (i < 4){
                Pieza torre = new Torre();
                listaPiezas.add(torre);
                Pieza caballo = new Caballo();
                listaPiezas.add(caballo);
                Pieza alfil = new Alfil();
                listaPiezas.add(alfil);

            }
            Pieza peon = new Peon();
            peon.setComportamiento("agresor");
            peon.setColor("negro");
            listaPiezas.add(peon);
        } */
        /* for (int i = 0; i < 4; i++){
            Pieza torre = new Torre();
            listaPiezas.add(torre);
            Pieza caballo = new Caballo();
            listaPiezas.add(caballo);
            Pieza alfil = new Alfil();
            listaPiezas.add(alfil);

        } */

       /*  for (int i = 0; i < 4; i++){
        } */
        /* for (int i = 0; i < 4; i++){
        } */
       /*  for (int i = 0; i < 2; i++){
            Pieza reina = new Reina();
            listaPiezas.add(reina);
        }

        for (int i = 0; i < 2; i++){
            Pieza rey = new Rey();
            listaPiezas.add(rey);
        } */
        
       /*  return listaPiezas;
       
    } */

    
}

