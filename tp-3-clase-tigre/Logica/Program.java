package Logica;
import java.util.Scanner;

public class Program {
    
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        Tigre tigrePalermo = new Tigre("delicado", "fatal", "infinita", "sanguinario", "hermoso");
        String autor = "Jorge Luis Borges";
        //!cargarTigrePalermo(tigrePalermo);
        imprimirTexto(tigrePalermo, autor);
        
        Tigre tigre = new Tigre();
        System.out.println("Creando un nuevo tigre..");
        System.out.print("Ingrese el autor: ");
        autor = teclado.nextLine();
        cargarNuevoTigre(tigre);
        imprimirTexto(tigre, autor);
        
        teclado.close();
        //menu con opciones por favor seleccione el tigre que desee conocer
        // 1 tigre de palermo, 2 tigre personalizado, 3 abandonar el programa
    }
    
    
    
    /* static void cargarTigrePalermo(Tigre tigreBorges){
        
        tigreBorges.setComportamiento("delicado");
        tigreBorges.setPeligrosidad("fatal");
        tigreBorges.setVitalidad("infinita");
        tigreBorges.setInstinto("sanguinario");
        tigreBorges.setApariencia("hermoso");
        } */
        //Tigre t = tigreN()
        //pub sta tigreN(){
        //instancia
        //return tig
    /* static void mostrarMenu{

    } */

    static void cargarNuevoTigre(Tigre tigreNuevo){
        
        Scanner teclado = new Scanner(System.in);
        String comportamiento;
        

        System.out.println("Creando un nuevo tigre..");

        System.out.println("Ingrese comportamiento: ");
        System.out.println("{bruto, fino, sutil} ");
        comportamiento = teclado.nextLine();
        tigreNuevo.setComportamiento(comportamiento);

        System.out.println("Ingrese instinto: ");
        System.out.println("{sagaz, cruel, compasivo}");
        tigreNuevo.setInstinto(teclado.nextLine());
        
        System.out.println("Ingrese peligrosidad: ");
        System.out.println("{manso, inofensivo, cariñoso}");
        tigreNuevo.setPeligrosidad(teclado.nextLine());

        System.out.println("Ingrese vitalidad: ");
        System.out.println("{nula, inestable, escasa}");
        tigreNuevo.setVitalidad(teclado.nextLine());

        System.out.println("Ingrese apariencia: ");
        System.out.println("{feo, viejo, pulgoso}");
        tigreNuevo.setApariencia(teclado.nextLine());
        
        teclado.close();
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
