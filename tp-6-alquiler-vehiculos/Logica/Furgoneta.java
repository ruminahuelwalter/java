package Logica;

public class Furgoneta extends VehiculoCarga {
    private int plaza = 3;
    private double pma = 3.5;
    
    
    public double getPma() {
        return this.pma;
    }
    
    @Override
    public int getPlaza() {
        return this.plaza;
    }

    @Override
    public void setPlaza(int plaza) {
        super.setPlaza(plaza);
    }

    @Override
    public double calcularAlquiler(int cantidadDias) {
        setPma(this.pma);
        return super.calcularAlquiler(cantidadDias);
    }

}
