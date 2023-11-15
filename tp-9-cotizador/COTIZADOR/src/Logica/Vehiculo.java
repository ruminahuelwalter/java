package Logica;

public abstract class Vehiculo {
    private final double precioBase = 2000;
    private String patente;

    public Vehiculo(String patente) {
        this.patente = patente;
    }

    public Vehiculo() {

    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public double calcularAlquiler(int cantidadDias) {
        double resultado = this.precioBase * cantidadDias;
        return resultado;
    }
}
