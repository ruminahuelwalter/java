package Logica;

public class Camion extends VehiculoCarga {
    //pma 11.5
    
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
    public double calcularAlquiler(int cantidadDias) {
        return super.calcularAlquiler(cantidadDias) + 800*getPma() + 1600;
    }

}
