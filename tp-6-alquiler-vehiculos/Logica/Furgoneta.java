package Logica;

public class Furgoneta extends VehiculoCarga {
    private double pma = 3.5;
    // pma 3.5
    
    public double getPma() {
        return getPma();
    }
    

    @Override
    public int getPlaza() {
        return super.getPlaza();
    }

    @Override
    public void setPlaza(int plaza) {
        super.setPlaza(plaza);
    }

    @Override
    public double calcularAlquiler(int cantidadDias) {

        return super.calcularAlquiler(cantidadDias) + 800*this.getPma();
    }

}
