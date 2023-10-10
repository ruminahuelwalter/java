package Logica;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Program {
    static Scanner tecladoNumerico = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.printf(" %60s", "- BIENVENIDO AL PROGRAMA COTIZADOR -\n");
        ejecutarMenuPrincipal();

    }

    public static void ejecutarMenuPrincipal() {
        boolean ejecucion = true;

        while (ejecucion) {
            try {
                mostrarMenuPrincipal();

                System.out.printf("\n Elija una opción: ");
                int opcion = tecladoNumerico.nextInt();

                switch (opcion) {
                    case 1:
                        ejecucion = ejecutarMenuVehiculoParaPersonas();

                        break;
                    case 2:
                        ejecucion = ejecutarMenuVehiculoDeCarga();

                        break;
                    case 3:
                        ejecucion = false;
                        break;
                    default:
                        System.out.println("\n¡Opción no válida!\n");
                        break;
                }
            } catch (Exception e) {
                System.out.println("¡Error! ¡Debe ingresar una opción válida!\n");
                tecladoNumerico.nextLine(); // Limpia el buffer
            }
        }
    }

    public static boolean ejecutarMenuVehiculoParaPersonas() {
        boolean subMenu = true;
        boolean menu = true;
        int cantidadDias;

        while (subMenu) {
            try {
                mostrarMenuVehiculoParaPersonas();
                System.out.printf("\n Elija una opción: ");
                int subOpcion = tecladoNumerico.nextInt();

                switch (subOpcion) {
                    case 1:
                        System.out.printf("\n Indique la cantidad de dias: ");
                        cantidadDias = tecladoNumerico.nextInt();
                        clearConsole();
                        ticket(cantidadDias, new Auto());

                        subMenu = cotizarOtroVehiculo();
                        menu = subMenu;
                        clearConsole();
                        break;
                    case 2:
                        System.out.printf("\n Indique la cantidad de dias: ");
                        cantidadDias = tecladoNumerico.nextInt();
                        clearConsole();
                        ticket(cantidadDias, new Minibus());

                        subMenu = cotizarOtroVehiculo();
                        menu = subMenu;
                        clearConsole();
                        break;
                    case 3:
                        subMenu = false;
                        break;
                    default:
                        System.out.println("\n¡Opción no válida!\n");
                        break;
                }
            } catch (Exception e) {
                System.out.println("¡Error! ¡Debe ingresar una opción válida!\n");
                tecladoNumerico.nextLine(); // Limpia el buffer
            }
        }
        return menu;
    }

    public static boolean ejecutarMenuVehiculoDeCarga() {
        boolean subMenu = true;
        boolean menu = true;
        int cantidadDias;

        while (subMenu) {
            try {
                mostrarMenuVehiculoDeCarga();
                System.out.printf("\n Elija una opción: ");
                int subOpcion = tecladoNumerico.nextInt();

                switch (subOpcion) {
                    case 1:
                        System.out.printf("\n Indique la cantidad de dias: ");
                        cantidadDias = tecladoNumerico.nextInt();
                        clearConsole();
                        ticket(cantidadDias, new Furgoneta());

                        subMenu = cotizarOtroVehiculo();
                        menu = subMenu;

                        clearConsole();

                        break;
                    case 2:
                        System.out.printf("\n Indique la cantidad de dias: ");
                        cantidadDias = tecladoNumerico.nextInt();
                        clearConsole();
                        ticket(cantidadDias, new Camion());

                        subMenu = cotizarOtroVehiculo();
                        menu = subMenu;

                        clearConsole();

                        break;
                    case 3:
                        subMenu = false;
                        break;
                    default:
                        System.out.println("\n¡Opción no válida!\n");
                        break;
                }

            } catch (Exception e) {
                System.out.println("¡Error! ¡Debe ingresar una opción válida!\n");
                tecladoNumerico.nextLine(); // Limpia el buffer
            }
        }
        return menu;
    }

    private static void mostrarMenuPrincipal() {
        clearConsole();
        System.out.printf(" %60s", "- BIENVENIDO AL PROGRAMA COTIZADOR -\n");
        System.out.println("");
        System.out.printf(" %30s", "MENÚ PRINCIPAL \n");
        System.out.println("");
        System.out.println(" 1 - Vehiculos para personas");
        System.out.println(" 2 - Vehiculos de carga");
        System.out.println(" 3 - Salir");
    }

    private static void mostrarMenuVehiculoParaPersonas() {
        clearConsole();
        System.out.println("");
        System.out.printf(" %40s", "MENÚ VEHICULO PARA PERSONAS\n");
        System.out.println();
        System.out.println(" 1 - Auto");
        System.out.println(" 2 - Minibus");
        System.out.println(" 3 - Volver");
    }

    private static void mostrarMenuVehiculoDeCarga() {
        clearConsole();
        System.out.println("");
        System.out.printf(" %40s", "MENÚ VEHICULO DE CARGA\n");
        System.out.println();
        System.out.println(" 1 - Furgoneta");
        System.out.println(" 2 - Camión");
        System.out.println(" 3 - Volver");
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
        System.out.printf("Ingrese '1' para cotizar otro vehiculo, '0' para salir: ");
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
                System.out.printf("Debe ingresar '0' o '1': ");
                opcion = tecladoNumerico.nextInt();
            }
        } while (bandera);
        return respuesta;
    }

    public static void ticket(int cantidadDias, Vehiculo vehiculo) {

        barra();
        System.out.printf(" %30s", "TICKET\n");
        System.out.println("\n");
        ImprimirFechaHora();

        System.out.format("%5s %41s", "Vehiculo:", vehiculo.getClass().getSimpleName() + "\n");
        System.out.format("%5s %42s", "Patente:", generarPatente() + "\n");
        String chasis = vehiculo.toString();
        System.out.format("%5s %37s", "N° de Chasis:", chasis.toLowerCase() + "\n");

        if (vehiculo instanceof Auto) {
            Auto auto = (Auto) vehiculo;
            System.out.format("%5s %43s", "Plazas:", auto.getPlaza() + "\n");
            System.out.format("%5s %33s", "Cantidad de dias:", cantidadDias + "\n");

            System.out.println("   __________________________________________________________   \n");
            System.out.format("%5s %30s", "Precio base por dia:",
                    Math.round(vehiculo.getPrecioBase() * cantidadDias) + "\n");
            System.out.format("%5s %16s", "Adicional de $100 por plaza y dia:",
                    Math.round(100 * (auto.getPlaza() + cantidadDias)) + "\n");
        }

        if (vehiculo instanceof Minibus) {
            Minibus minibus = (Minibus) vehiculo;
            System.out.format("%5s %43s", "Plazas:", minibus.getPlaza() + "\n");
            System.out.format("%5s %33s", "Cantidad de dias:", cantidadDias + "\n");

            System.out.println("   __________________________________________________________   \n");
            System.out.format("%5s %30s", "Precio base por dia:",
                    Math.round(vehiculo.getPrecioBase() * cantidadDias) + "\n");
            System.out.format("%5s %16s", "Adicional de $100 por plaza y dia:",
                    100 * (minibus.getPlaza() + cantidadDias) + "\n");
            System.out.format("%5s %22s", "Adicional de $120 por plaza:",
                    Math.round(120 * minibus.getPlaza()) + "\n");
        }

        if (vehiculo instanceof Furgoneta) {
            Furgoneta furgoneta = (Furgoneta) vehiculo;
            System.out.format("%5s %43s", "Plazas:", furgoneta.getPlaza() + "\n");
            System.out.format("%5s %33s", "Cantidad de dias:", cantidadDias + "\n");

            System.out.println("   __________________________________________________________   \n");
            System.out.format("%5s %30s", "Precio base por dia:",
                    Math.round(vehiculo.getPrecioBase() * cantidadDias) + "\n");
            System.out.format("%5s %31s", "Capacidad de carga:", furgoneta.getPma() + " tn" + "\n");
            System.out.format("%5s %24s", "Adicional de $800 por pma:",
                    Math.round(furgoneta.getPma() * 800) + "\n");
        }

        if (vehiculo instanceof Camion) {
            Camion camion = (Camion) vehiculo;
            System.out.format("%5s %43s", "Plazas:", camion.getPlaza() + "\n");
            System.out.format("%5s %33s", "Cantidad de dias:", cantidadDias + "\n");

            System.out.println("   __________________________________________________________   \n");
            System.out.format("%5s %30s", "Precio base por dia:",
                    Math.round(vehiculo.getPrecioBase() * cantidadDias) + "\n");
            System.out.format("%5s %31s", "Capacidad de carga:", camion.getPma() + " tn" + "\n");
            System.out.format("%5s %24s", "Adicional de $800 por pma:",
                    Math.round(camion.getPma() * 800) + "\n");
            System.out.format("%5s %39s", "Cargo fijo:", "1600" + "\n");
        }
        System.out.format("%5s %44s", "\nTotal:", Math.round(vehiculo.calcularAlquiler(cantidadDias)) + "\n");
        barra();
    }

    private static String generarPatente() {
        int numeroPatente = (int) (Math.random() * 999 + 100);
        String patente = "AB " + numeroPatente + " CD";

        return patente;
    }

    public static void ImprimirFechaHora() {

        LocalDateTime fechaHoraActual = LocalDateTime.now();

        // Crea un formato para la fecha y la hora.
        DateTimeFormatter formatoD = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        DateTimeFormatter formatoH = DateTimeFormatter.ofPattern("HH:mm:ss");

        // Convierte la fecha y la hora en una cadena formateada.
        String fechaFormateada = fechaHoraActual.format(formatoD);
        String horaFormateada = fechaHoraActual.format(formatoH);

        // Imprime la fecha y hora formateada
        System.out.format("%5s %44s", "Fecha:", fechaFormateada + "\n");
        System.out.format("%5s %46s", "Hora:", horaFormateada + "\n\n");

    }

    public static void barra() {
        String barra = "________________________________________________________________\n";
        System.out.println(barra);
    }

    public static void clearConsole() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            System.out.print("\033[H\033[2J");
            System.out.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
