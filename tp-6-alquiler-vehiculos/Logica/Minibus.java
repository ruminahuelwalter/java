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
    public double calculoAlquiler(int cantidadDias) {
        
        return super.calculoAlquiler(cantidadDias) + (100 * getPlaza() * cantidadDias) +  120*getPlaza();
    }
}
