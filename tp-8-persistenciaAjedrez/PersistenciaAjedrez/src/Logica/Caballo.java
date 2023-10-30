package Logica;

public class Caballo extends Pieza {

    @Override
    public void mover() {
        System.out.println("Soy un " + this.getClass().getSimpleName() + " y me muevo " + this.getMovimiento());
    }

}
