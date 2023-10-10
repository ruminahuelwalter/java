package Logica;

public class Minibus extends VehiculoPersona {
    private final int plaza = 15;

    public int getPlaza() {
        return this.plaza;
    }

    public void setPlaza(int plaza) {
        setPlaza(this.plaza);
    }

    @Override
    public double calcularAlquiler(int cantidadDias) {

        return super.calcularAlquiler(cantidadDias) + (100 * (this.getPlaza() + cantidadDias)) + 120 * this.getPlaza();
    }
}
