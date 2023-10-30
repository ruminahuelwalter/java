package Logica;

public class Reina extends Pieza{

    @Override
    public void mover(){
        System.out.println("Soy una " + this.getClass().getSimpleName() + " y me muevo " + this.getMovimiento());
    }
    
}
