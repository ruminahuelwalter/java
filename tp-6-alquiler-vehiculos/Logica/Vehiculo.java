package Logica;
abstract class Vehiculo {
    private final double precioBase = 2000;
    private String patente;
    private int plaza;

    public Vehiculo(String patente, int precioBase, int cantidadDias, int plaza) {
        this.patente = patente;
        this.plaza = plaza;
    }

     public Vehiculo() {

    }

    public int getPlaza() {
        return this.plaza;
    }

    public void setPlaza(int plaza) {
        this.plaza = plaza;
    }

    public Vehiculo(String patente, int plaza) {
        this.patente = patente;
        this.plaza = plaza;
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
        double resultado;
        resultado = this.precioBase * cantidadDias;
        return resultado;
    }
}
