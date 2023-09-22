package Logica;

public class Alfil extends Pieza{

    @Override
    public void mover(){
        System.out.println("Soy un " + this.getClass().getSimpleName()  + " y me muevo " + this.getMovimiento());
    }
    
}
