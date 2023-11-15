package Logica;

public class Camion extends VehiculoCarga {
    private final int plaza = 1;
    private final double pma = 11.5;

    public double getPma() {
        return pma;
    }

    public int getPlaza() {
        return plaza;
    }

    @Override
    public double calcularAlquiler(int cantidadDias) {
        return super.calcularAlquiler(cantidadDias) + 800 * this.getPma() + 1600;
    }

}
