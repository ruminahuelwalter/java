package Logica;

public class Minibus extends VehiculoPersona {
    private final int plaza = 15;

    public int getPlaza() {
        return plaza;
    }

    @Override
    public double calcularAlquiler(int cantidadDias) {

        return super.calcularAlquiler(cantidadDias) + (100 * (this.getPlaza() + cantidadDias)) + 120 * this.getPlaza();
    }
}
