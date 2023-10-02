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
        return pma;
    }

    public void setPma(double pma) {
        this.pma = pma;
    }

    @Override
    public double calculoAlquiler(int cantidadDias) {

        return super.calculoAlquiler(cantidadDias) + 800*this.pma;
    }

}
