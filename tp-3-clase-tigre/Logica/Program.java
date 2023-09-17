package Logica;
import java.util.Scanner;

public class Program {
    static Scanner teclado = new Scanner(System.in);
    public static void main(String[] args) {
    
        String autor;
        int opcionMenu;

        mostrarMenu();
        opcionMenu = teclado.nextInt();
        teclado.nextLine();
        
        switch (opcionMenu) {
            case 1:
                Tigre tigrePalermo = new Tigre("delicado", "fatal", "infinita", "sanguinario", "hermoso");
                imprimirTexto(tigrePalermo, "Jorge Luis Borges");
                break;

            case 2:
                autor = cargarAutor();
                Tigre tigrePersonalizado = crearTigre(cargarAtributosTigre());
                imprimirTexto(tigrePersonalizado, autor);
                break;

            case 3:
                System.out.println(" Finalizando programa...");
                break;

            default:
                System.out.println(" ¡Opción no válida!");
                break;
        }
    }
        
    static void mostrarMenu(){

        System.out.println("---------------------------------------------------------");
        System.out.println(" BIENVENIDO AL PROGRAMA \n");
        System.out.println(" Por favor seleccione el tigre que desea conocer: \n");
        System.out.println(" 1 - Tigre de Palermo.");
        System.out.println(" 2 - Tigre Personalizado.");
        System.out.println(" 3 - Finalizar programa.\n");
        System.out.print(" Elija una opción: ");
    }

    static String cargarAutor(){

        String autor;
        boolean bandera = true;

        do{

            System.out.print("\n Ingrese el autor: ");
            autor = teclado.nextLine();
            bandera = confirmar("autor");

        } while (bandera);

        return autor;
    }

    static boolean confirmar(String valor){

        String opcion;
        boolean bandera = true;

        System.out.print("\n¿Desea confirmar " + valor + "? [S/N]: ");
        opcion = teclado.nextLine();

        if (opcion.equalsIgnoreCase("s")){
            bandera = false;
        }

        return bandera;
    }

    static String[] cargarAtributosTigre(){
      
        boolean bandera = true;
        String[] valorAtributos = new String[5];

        String[] atributos = {
            "Comportamiento",
            "Peligrosidad",
            "Vitalidad",
            "Instinto",
            "Apariencia",
        };

        String[] ejemplos = {
            "bruto, fino, sutil",
            "manso, inofensivo, cariñoso",
            "nula, inestable, escasa",
            "sagaz, cruel, compasivo",
            "feo, viejo, pulgoso",
        };

        do {
            System.out.println("----------------------------------------------------------------------------------\n");
            System.out.println("-- CREANDO UN NUEVO TIGRE --");
            
            for (int i = 0; i < atributos.length ; i++){
                System.out.println("\nIngrese " + atributos[i].toLowerCase());
                System.out.print("Ejemplos: " + ejemplos[i] + ": ");
                valorAtributos[i] = teclado.nextLine();
            }

            System.out.println("----------------------------------------------------------------------------------\n");
            System.out.println("Los atributos elegidos son: \n");
            for(int i = 0; i<atributos.length ; i++){
                System.out.println("- " + atributos[i] +": "+ valorAtributos[i]);
                
            }
            bandera = confirmar("atributos");

        } while (bandera);

        return valorAtributos;
    }
    
    static Tigre crearTigre(String[] atributos){

        Tigre tigrePersonalizado = new Tigre();
        tigrePersonalizado.setComportamiento(atributos[0]);
        tigrePersonalizado.setPeligrosidad(atributos[1]);
        tigrePersonalizado.setVitalidad(atributos[2]);
        tigrePersonalizado.setInstinto(atributos[3]);
        tigrePersonalizado.setApariencia(atributos[4]);

        return tigrePersonalizado;
    }

    static void imprimirTexto(Tigre tigre, String autor){

        String negrita = "\033[0;1m";
        String finNegrita = "\u001B[0m";
        
        System.out.println("----------------------------------------------------------------------------------\n");
        System.out.println("Texto literario: El tigre ("+autor+")"+"\n\n"
        +"Iba y venia " + negrita + tigre.getComportamiento() + finNegrita 
        + " y " + negrita + tigre.getPeligrosidad() + finNegrita + ", " + "cargado de " + negrita + tigre.getVitalidad() + finNegrita
        + " energia" + ", del otro lado de los"  + "\n" + "firmes barrotes y todos lo mirábamos. " 
        + "Era el tigre de esa mañana, en" + "\n" + "Palermo, y el tigre del Oriente y el tigre"
        + " de Blake y de Hugo y Shere Khan, y" + "\n" + "los tigres que fueron "
        + "y que serán y asimismo el tigre arquetipo, ya que el" + "\n"
        + "individuo, en su caso, es toda la especie. Pensamos que era " + negrita + tigre.getInstinto() + finNegrita
        + " y " +"\n" + negrita + tigre.getApariencia() + finNegrita + ". Norah, una niña, dijo: Esta hecho para el amor."
        + "\n" + "\n" + autor + "\n" + "El oro de los tigres" + "\n");
        System.out.println("----------------------------------------------------------------------------------");
    }
}
