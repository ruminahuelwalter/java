package Logica;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Program {
    static Scanner tecladoNumerico = new Scanner(System.in);

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        barra();
        System.out.printf(" %60s", "- BIENVENIDO AL PROGRAMA COTIZADOR -\n");
      
        boolean subMenu = true;
        boolean ejecucion = true;
        int opcion;
        int subOpcion;
        int cantidadDias;

        while (ejecucion) {
            try {
                
                barra();
                System.out.printf(" %30s", "MENÚ PRINCIPAL \n");
                barra();
                System.out.println(" 1 - Vehiculo persona");
                System.out.println(" 2 - Vehiculo de carga");
                System.out.println(" 3 - Salir");
                System.out.print("\n Elija una opción: ");

                opcion = tecladoNumerico.nextInt();
                subMenu = true;
                clearConsole();
                switch (opcion) {

                    case 1:
                        
                        while (subMenu) {
                            try {
                                clearConsole();
                                barra();
                                System.out.printf(" %40s", "MENÚ VEHICULO PARA PERSONAS\n");
                                barra();
                                System.out.println(" 1 - Auto");
                                System.out.println(" 2 - Minubus");
                                System.out.println(" 3 - Volver");

                                System.out.print("\nElija una opción: ");
                                subOpcion = tecladoNumerico.nextInt();

                                switch (subOpcion) {
                                    case 1:
                                        // System.out.println();
                                        System.out.print("\nIndique la cantidad de dias: ");
                                        cantidadDias = tecladoNumerico.nextInt();
                                        if (validarCantidadDias(cantidadDias)) {
                                            Auto auto = new Auto();
                                            clearConsole();
                                            ticket(cantidadDias, auto);
                                        } else {
                                            System.out.println("Ingreso un número de dias no válido.");
                                        }

                                        if (cotizarOtroVehiculo()) {
                                            subMenu = true;  
                                        }
                                        else{
                                            subMenu = false;
                                            ejecucion = false;
                                        }
                                        break;

                                    case 2:
                                        System.out.print("\nIndique la cantidad de dias: ");
                                        cantidadDias = tecladoNumerico.nextInt();
                                        if (validarCantidadDias(cantidadDias)) {
                                            Minibus minibus = new Minibus();
                                            clearConsole();
                                            ticket(cantidadDias, minibus);
                                        } else {
                                            System.out.println("Ingreso un número de dias no válido.");
                                        }
                                        if (cotizarOtroVehiculo()) {
                                            subMenu = true;
                                            
                                        }
                                        else{
                                            subMenu = false;
                                            ejecucion = false;
                                        }
                                        break;
                                    case 3:
                                        subMenu = false;
                                        clearConsole();
                                        break;
                                    default:
                                        System.out.println("\n¡Opción no válida!\n");
                                        break;
                                }
                            } catch (Exception e) {
                                System.out.println("¡Error! ¡Debe ingresar una opción válida!");
                                tecladoNumerico.nextLine(); // Limpia el bufer
                            }

                        }
                    case 2:
                        while (subMenu) {
                            try {
                                clearConsole();
                                barra();
                                System.out.printf(" %20s", "MENÚ VEHICULO DE CARGA\n");
                                barra();
                                System.out.println(" 1 - Furgoneta");
                                System.out.println(" 2 - Camión");
                                System.out.println(" 3 - Volver");

                                System.out.print("\nElija una opción: ");
                                subOpcion = tecladoNumerico.nextInt();

                                switch (subOpcion) {
                                    case 1:
                                        System.out.print("\nIndique la cantidad de dias: ");
                                        cantidadDias = tecladoNumerico.nextInt();

                                        if (validarCantidadDias(cantidadDias)) {

                                            Furgoneta furgoneta = new Furgoneta();
                                            clearConsole();
                                            ticket(cantidadDias, furgoneta);

                                        } else {
                                            System.out.println("Ingreso un número de dias no válido.");
                                        }

                                        if (cotizarOtroVehiculo()) {
                                            subMenu = true;
                                            
                                        }
                                        else{
                                            subMenu = false;
                                            ejecucion = false;
                                        }
                                        break;

                                    case 2:
                                        System.out.print("\nIndique la cantidad de dias: ");
                                        cantidadDias = tecladoNumerico.nextInt();

                                        if (validarCantidadDias(cantidadDias)) {
                                            Camion camion = new Camion();
                                            clearConsole();
                                            ticket(cantidadDias, camion);

                                        } else {
                                            System.out.println("Ingreso un número de dias no válido.");
                                        }

                                        if (cotizarOtroVehiculo()) {
                                            subMenu = true;
                                            
                                        }
                                        else{
                                            subMenu = false;
                                            ejecucion = false;
                                        }

                                    case 3:
                                        subMenu = false;
                                        clearConsole();
                                        break;
                                    default:
                                        System.out.println("\n¡Opción no válida!\n");
                                        break;
                                }
                            } catch (Exception e) {
                                System.out.println("¡Error! ¡Debe ingresar una opción válida!");
                                tecladoNumerico.nextLine(); // Limpia el bufer
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
            } catch (Exception e) {
                System.out.println("¡Error! ¡Debe ingresar una opción válida!");
                tecladoNumerico.nextLine(); // Limpia el bufer
                
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

    public static boolean cotizarOtroVehiculo() {
        boolean respuesta = true;
        System.out.println("¿Desea cotizar otro vehiculo?");
        System.out.print("Ingrese '1' para cotizar otro vehiculo, '0' para salir: ");
        int opcion = tecladoNumerico.nextInt();
        boolean bandera = true;
        
        do {
            if (opcion == 0) {
                respuesta = false;
                bandera = false;
            } else if (opcion == 1) {
                respuesta = true;
                bandera = false;
            } else {
                System.out.print("Debe ingresar '0' o '1': ");
                opcion = tecladoNumerico.nextInt();
            }
        } while (bandera);
        return respuesta;
    }

    public static void ticket(int cantidadDias, Vehiculo vehiculo) {

       
        //vehiculo.setPrecioBase(2000);
        /* if (vehiculo instanceof Auto) {
            vehiculo.setPlaza(5);
        }
        if (vehiculo instanceof Minibus) {
            vehiculo.setPlaza(15);
        }
        if (vehiculo instanceof Furgoneta) {
            vehiculo.setPlaza(3);
        }
        if (vehiculo instanceof Camion) {
            vehiculo.setPlaza(3);
        } */
        
        barra();
        System.out.printf(" %30s", "TICKET\n");
        System.out.println("\n");
        ImprimirFechaHora();
        System.out.printf(" %5s", "Vehiculo: " + vehiculo.getClass().getSimpleName() + "\n");
        System.out.printf(" %5s", "Cantidad de dias: " + cantidadDias + "\n");
        System.out.printf(" %5s", "Plazas: " + vehiculo.getPlaza() + "\n");
        System.out.printf(" %5s", "Precio base por dia: " + vehiculo.getPrecioBase() + "\n");
        System.out.printf(" %5s", "Impuestos: " + (vehiculo.calcularAlquiler(cantidadDias) - vehiculo.getPrecioBase()) + "\n");
        System.out.println();
        System.out.printf(" %5s", "TOTAL: " + vehiculo.calcularAlquiler(cantidadDias) + "\n");
        barra();
    }


    public static void clearConsole() {
        try {
            ProcessBuilder builder = new ProcessBuilder("cmd", "/c", "cls");
            builder.inheritIO().start().waitFor();

        } 
        catch (Exception e) {
        }
    }

    public static void ImprimirFechaHora() {
   
        // Fecha y hora actual.
        LocalDateTime fechaHoraActual = LocalDateTime.now();

        // Crea un formato para la fecha y hora.
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy   HH:mm:ss");

        // Convierte la fecha y hora en una cadena formateada.
        String fechaHoraFormateada = fechaHoraActual.format(formato);

        // Imprime la fecha y hora formateada
        System.out.printf(" %5s", "Fecha y Hora: " + fechaHoraFormateada +"\n\n");
    
    }

    public static void barra() {
        String barra = "_____________________________________________________________________________________________\n";
        System.out.println(barra);
    }

}
