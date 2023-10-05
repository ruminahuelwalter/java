package Logica;

public class Minibus extends VehiculoPersona {
    private int plaza = 15;

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

        return super.calcularAlquiler(cantidadDias) + (100 * (this.getPlaza() + cantidadDias)) + 120 * this.getPlaza();
    }
}
