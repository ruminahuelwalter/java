package Logica;

import java.util.Scanner;

public class Program {
    static Scanner tecladoNumerico = new Scanner(System.in);

    public static void main(String[] args) {
        menu();
    }
   
    public static void menu(){
        barra();
        System.out.printf(" %60s", "- BIENVENIDO AL PROGRAMA COTIZADOR -\n");
        barra();
        boolean subMenu = true;
        boolean ejecucion = true;
        int opcion;
        int subOpcion;
        int cantidadDias;

        while (ejecucion) {
            try {
                System.out.println();
                System.out.printf(" %30s", "MENÚ PRINCIPAL \n");
                barra();
                System.out.println(" 1 - Vehiculo persona");
                System.out.println(" 2 - Vehiculo de carga");
                System.out.println(" 3 - Salir");
                System.out.print("\n Elija una opción: ");
                
                opcion = tecladoNumerico.nextInt();

                switch (opcion) {

                    case 1:
                        //subMenu = true;
                        while (subMenu) {
                            try {
                                System.out.println("");
                                barra();
                                System.out.printf(" %40s", "SUBMENÚ VEHICULO PARA PERSONAS\n");
                                barra();
                                System.out.println(" 1 - Auto");
                                System.out.println(" 2 - Minubus");
                                System.out.println(" 3 - Volver");
                            
                                System.out.print("\nElija una opción: ");
                                subOpcion = tecladoNumerico.nextInt();

                                switch (subOpcion) {
                                        case 1:
                                            //System.out.println();
                                            System.out.print("\nIndique la cantidad de dias: ");
                                            cantidadDias = tecladoNumerico.nextInt();

                                            if(validarCantidadDias(cantidadDias)){
                                                Auto auto = new Auto();
                                                ticket(cantidadDias, auto);

                                            }
                                            else{
                                                System.out.println("Ingreso un número de dias no válido.");
                                            }

                                            System.out.println("¿Desea cotizar otro vehiculo?");
                                            System.out.println("Ingrese '1' para cotizar otro vehiculo, '0' para salir.");
                                            int respuesta = tecladoNumerico.nextInt();
                                            if (respuesta == 0){
                                                subMenu= false;
                                                ejecucion = false;
                                            }
                                            
                                            //ejecucion = false;

                                        break;
                                    
                                        case 2:
                                            System.out.println("Indique la cantidad de dias.");
                                            cantidadDias = tecladoNumerico.nextInt();

                                            if(validarCantidadDias(cantidadDias)){
                                                Minibus minibus = new Minibus();
                                                ticket(cantidadDias, minibus);

                                            }
                                            else{
                                                System.out.println("Ingreso un número de dias no válido.");
                                            }
                                        
                                        case 3:
                                            subMenu = false;
                                        
                                        break;
                                }
                            }
                            catch (Exception e) {
                                System.out.println("¡Error! ¡Debe ingresar una opción válida!");
                            }

                        }
                
                    case 2:
                        //subMenu = true;
                        while (subMenu) {
                            try {
                                System.out.println("");
                                System.out.printf(" %20s", "SUBMENÚ VEHICULO PARA CARGA");
                                System.out.println("\n");
                                System.out.println(" 1 - Furgoneta");
                                System.out.println(" 2 - Camión");
                                System.out.println(" 3 - Volver");
                            
                                System.out.print("Elija una opción: ");
                                subOpcion = tecladoNumerico.nextInt();

                                switch (subOpcion) {
                                        case 1:
                                            System.out.println("Indique la cantidad de dias.");
                                            cantidadDias = tecladoNumerico.nextInt();

                                            if(validarCantidadDias(cantidadDias)){
                                                
                                                Furgoneta furgoneta = new Furgoneta();
                                                ticket(cantidadDias, furgoneta);

                                            }
                                            else{
                                                System.out.println("Ingreso un número de dias no válido.");
                                            }

                                        break;
                                    
                                        case 2:
                                            System.out.println("Indique la cantidad de dias.");
                                            cantidadDias = tecladoNumerico.nextInt();

                                            if(validarCantidadDias(cantidadDias)){
                                                Camion camion = new Camion();
                                                ticket(cantidadDias, camion);

                                            }
                                            else{
                                                System.out.println("Ingreso un número de dias no válido.");
                                            }
                                        
                                        case 3:
                                            subMenu = false;
                                        
                                        break;
                                }
                            }
                            catch (Exception e) {
                                System.out.println("¡Error! ¡Debe ingresar una opción válida!");
                            }

                        }
                    break;

                    case 3:
                        ejecucion = false;
                    break;

                    default:
                        System.out.println("\n¡Opción no válida!\n");
                    break;
                }
            }
            catch (Exception e) {
                System.out.println("¡Error! ¡Debe ingresar una opción válida!");
            }   
        }
    }

    public static boolean validarCantidadDias(int dias) {
        if (dias > 0) {
            return true;
        } else {
            return false;
        }
    }

    public static void ticket(int cantidadDias, Vehiculo vehiculo) {

        // Pruebas. Deberia funcionar sin casteo.
        if (vehiculo instanceof Auto) {
            //Auto auto = (Auto) vehiculo;
            barra();
            vehiculo.setPrecioBase(2000);
            vehiculo.setPlaza(5);
            System.out.printf(" %30s", "TICKET\n");
            System.out.printf(" %5s", "Cantidad de dias: " + cantidadDias + "\n");
            System.out.printf(" %5s", "Plazas: " + vehiculo.getPlaza() + "\n");
            System.out.printf(" %5s", "Precio base por dia: " + vehiculo.getPrecioBase() + "\n");
            System.out.printf(" %5s", "TOTAL: " + vehiculo.calculoAlquiler(cantidadDias) + "\n");
            barra();
        }

        if (vehiculo instanceof Minibus) {
            Minibus minibus = (Minibus) vehiculo;
            minibus.setPlaza(18);
            System.out.printf(" %30s", "TICKET\n");
            System.out.printf(" %5s", "Cantidad de dias: " + cantidadDias);
            System.out.printf(" %5s", "Plazas: " + minibus.getPlaza());
            System.out.printf(" %5s", "Precio base: " + minibus.getPrecioBase());
            System.out.printf(" %5s", "TOTAL: " + minibus.calculoAlquiler(cantidadDias));
        }

        if (vehiculo instanceof Furgoneta) {
            Furgoneta furgoneta = (Furgoneta) vehiculo;
            System.out.printf(" %30s", "TICKET");
            System.out.printf(" %5s", "Cantidad de dias: " + cantidadDias);
            System.out.printf(" %5s", "Plazas: " + furgoneta.getPlaza()+ "\n");
            System.out.printf(" %5s", "TOTAL: " + furgoneta.calculoAlquiler(cantidadDias)+ "\n");
        }

        if (vehiculo instanceof Camion) {
            Camion camion = (Camion) vehiculo;
            System.out.printf(" %30s", "TICKET\n");
            System.out.printf(" %5s", "Cantidad de dias: " + cantidadDias + "\n");
            System.out.printf(" %5s", "Plazas: " + camion.getPlaza());
            System.out.printf(" %5s", "TOTAL: " + camion.calculoAlquiler(cantidadDias));
        }

    }

    public static void barra() {
        String barra = "_____________________________________________________________________________________________\n";
        System.out.println(barra);
    }

}
