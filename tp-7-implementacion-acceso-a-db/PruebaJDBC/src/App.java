
public class App {
	public static void main(String[] args) throws Exception {
		
		mostrarPiezasConInterface();
		
	}

	public static void mostrarPiezasConInterface(){
		
		iAjedrez iAjedrez = new Ajedrez();
		iAjedrez.mostrarPiezasBD();
	}

	
}
