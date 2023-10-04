package Logica;

abstract class Vehiculo {
    private String patente;
    private double precioBase = 2000;
    private int plaza;

    public Vehiculo(String patente, int precioBase, int cantidadDias, int plaza) {
        this.patente = patente;
        this.precioBase = precioBase;
        this.plaza = plaza;
    }

     public Vehiculo() {

    }

    public int getPlaza() {
        return plaza;
    }

    public void setPlaza(int plaza) {
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

    public void setPrecioBase(int precioBase) {
        this.precioBase = precioBase;
    }

    public double calcularAlquiler(int cantidadDias) {
        double resultado;
        resultado = this.precioBase * cantidadDias;
        return resultado;
    }

}
