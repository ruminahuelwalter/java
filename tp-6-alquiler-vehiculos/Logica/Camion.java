package Logica;

public class Camion extends VehiculoCarga {
    private final int plaza = 1;
    private final double pma = 11.5;

    public double getPma() {
        
        return this.pma;
    }

    public int getPlaza() {
        return this.plaza;
    }
    
    @Override
    public void setPma(double pma) {
      
        super.setPma(pma);
    }


    @Override
    public void setPlaza(int plaza) {
        super.setPlaza(plaza);
    }

    @Override
    public double calcularAlquiler(int cantidadDias) {
        setPma(this.pma);
        return super.calcularAlquiler(cantidadDias)  + 800*this.getPma()+ 1600;
    }

}
