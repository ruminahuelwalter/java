package Logica;

public class Auto extends VehiculoPersona {
    private int plaza = 5;
    
    public Auto() {
    }

    @Override
    public int getPlaza() {
        return this.plaza;
    }

    @Override
    public void setPlaza(int plaza) {
        super.setPlaza(this.plaza);
    }

    @Override
    public double calcularAlquiler(int cantidadDias) {
        //setPlaza(this.plaza);
        System.out.println("calc auto: " + getPlaza());
        //return super.calcularAlquiler(cantidadDias);
        return super.calcularAlquiler(cantidadDias) + (100 * (this.getPlaza() + cantidadDias));
    }

}
