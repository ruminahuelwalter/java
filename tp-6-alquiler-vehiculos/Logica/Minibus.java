package Logica;

public class Minibus extends VehiculoPersona {
   

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
        
        return super.calcularAlquiler(cantidadDias) + (100 * getPlaza() * cantidadDias) +  120*getPlaza();
    }
}
