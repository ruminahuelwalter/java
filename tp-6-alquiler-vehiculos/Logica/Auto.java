package Logica;

public class Auto extends VehiculoPersona {
    private final int plaza = 5;
    
    public int getPlaza() {
        return plaza;
    }

    @Override
    public double calcularAlquiler(int cantidadDias) {
        return super.calcularAlquiler(cantidadDias) + (100 * (this.getPlaza() + cantidadDias));
    }

}
