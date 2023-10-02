package Logica;

public class Camion extends VehiculoCarga {
    

    @Override
    public double getPma() {
    
        return super.getPma();
    }

    @Override
    public void setPma(double pma) {
      
        super.setPma(pma);
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
    public double calculoAlquiler(int cantidadDias) {
        return super.calculoAlquiler(cantidadDias) + 1600;
    }

}
