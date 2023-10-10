package Logica;

public class Furgoneta extends VehiculoCarga {
    private int plaza = 1;
    private double pma = 3.5;

    public double getPma() {
        return this.pma;
    }

    public int getPlaza() {
        return this.plaza;
    }

    public void setPlaza(int plaza) {
        setPlaza(plaza);
    }

    @Override
    public double calcularAlquiler(int cantidadDias) {
        return super.calcularAlquiler(cantidadDias) + 800 * this.getPma();
    }

}
