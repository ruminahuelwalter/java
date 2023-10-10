package Logica;

public class Auto extends VehiculoPersona {
    private final int plaza = 5;
    
    public Auto() {
    }

    public int getPlaza() {
        return this.plaza;
    }

    public void setPlaza(int plaza) {
        setPlaza(this.plaza);
    }

    @Override
    public double calcularAlquiler(int cantidadDias) {
        return super.calcularAlquiler(cantidadDias) + (100 * (this.getPlaza() + cantidadDias));
    }

}
