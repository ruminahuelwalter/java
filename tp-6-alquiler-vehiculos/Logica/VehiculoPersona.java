package Logica;

public class VehiculoPersona extends Vehiculo {

    @Override
    public int getPlaza() {
        return super.getPlaza();
    }

    @Override
    public void setPlaza(int plaza) {
        System.out.println("plaza en vp: " + plaza );
        super.setPlaza(plaza);
    }

    @Override
    public double calcularAlquiler(int cantidadDias) {
        System.out.println("this.plaza: " + getPlaza());
        //System.out.println("super: " + super.calcularAlquiler(cantidadDias) + (100 * (this.getPlaza() + cantidadDias)));
        //return super.calcularAlquiler(cantidadDias) + (100 * (this.getPlaza() + cantidadDias));
        return super.calcularAlquiler(cantidadDias);
        
    }

}
