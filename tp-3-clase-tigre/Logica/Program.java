package Logica;
import java.util.Scanner;

public class Program {
    static Scanner teclado = new Scanner(System.in);
    public static void main(String[] args) {
    
        Tigre tigrePalermo = new Tigre("delicado", "fatal", "infinita", "sanguinario", "hermoso");
        Tigre tigrePersonalizado; // es lo mismo que tigrePersonalizado = null
        //no apuntan ni contienen ningun tigre
        String atributos[];
        String autor;
        int opcionMenu;

        mostrarMenu();
        opcionMenu = teclado.nextInt();
        teclado.nextLine();
        
        switch (opcionMenu) {
            case 1:
                imprimirTexto(tigrePalermo, "Jorge Luis Borges");
                break;

            case 2:
                autor = cargarAutor();
                atributos = cargarAtributosTigre(); 
                tigrePersonalizado = crearTigre(atributos);
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

            System.out.println("\n Ingrese el autor: ");
            autor = teclado.nextLine();
            bandera = confirmar("autor");

        } while (bandera);

        return autor;
    }

    static boolean confirmar(String valor){

        String opcion;
        boolean bandera = true;

        System.out.println("\nDesea confirmar " + valor + " [S/N]");
        opcion = teclado.nextLine();

        if (opcion.equalsIgnoreCase("s")){
            bandera = false;
        }

        return bandera;
    }

    static String[] cargarAtributosTigre(){
      
        String valorAtributos[] = new String[5];
        String atributos[] = new String[5];

        boolean bandera = true;

        atributos[0] = "Comportamiento";
        atributos[1] = "Peligrosidad";
        atributos[2] = "Vitalidad";
        atributos[3] = "Instinto";
        atributos[4] = "Apariencia";

        do {
            System.out.println("----------------------------------------------------------------------------------\n");
            System.out.println("-- CREANDO UN NUEVO TIGRE --");
            System.out.println("Ingrese comportamiento: ");
            System.out.println("{bruto, fino, sutil} ");
            valorAtributos[0] = teclado.nextLine();

            System.out.println("\nIngrese peligrosidad: ");
            System.out.println("{manso, inofensivo, cariñoso}");
            valorAtributos[1] = teclado.nextLine();

            System.out.println("\nIngrese vitalidad: ");
            System.out.println("{nula, inestable, escasa}");
            valorAtributos[2] = teclado.nextLine();

            System.out.println("\nIngrese instinto: ");
            System.out.println("{sagaz, cruel, compasivo}");
            valorAtributos[3] = teclado.nextLine();

            System.out.println("\nIngrese apariencia: ");
            System.out.println("{feo, viejo, pulgoso}");
            valorAtributos[4] = teclado.nextLine();
            
            System.out.println("----------------------------------------------------------------------------------\n");
            System.out.println("Los atributos elegidos son: \n");
            for(int i = 0; i<5 ; i++){
                System.out.println("- " + atributos[i] +": "+ valorAtributos[i]+
                "\n");
                
            }
            bandera = confirmar("atributos");

        } while (bandera);

        return valorAtributos;
    }
    
    static Tigre crearTigre(String atributos[]){

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
