package Logica;

public class VehiculoCarga extends Vehiculo {
    private double pma;
    
    @Override
    public int getPlaza() {
        return super.getPlaza();
    }

    @Override
    public void setPlaza(int plaza) {
        super.setPlaza(plaza);
    }

    public double getPma() {
        return this.pma;
    }

    public void setPma(double pma) {
        this.pma = pma;
    }

    @Override
    public double calcularAlquiler(int cantidadDias) {
        return super.calcularAlquiler(cantidadDias);
    }

}
