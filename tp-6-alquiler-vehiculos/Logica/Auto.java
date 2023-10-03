package Logica;

public class Auto extends VehiculoPersona {
    // private int plaza = 5;
    
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

        return super.calcularAlquiler(cantidadDias) + (100 * (this.getPlaza() + cantidadDias));
    }

}
