package Logica;

abstract class Vehiculo {
    private String patente;
    private int precioBase;
    private int cantidadDias;
    private int plaza;

    public Vehiculo(String patente, int precioBase, int cantidadDias, int plaza) {
        this.patente = patente;
        this.precioBase = precioBase;
        this.cantidadDias = cantidadDias;
        this.plaza = plaza;
    }

     public Vehiculo() {

    }

    public int getCantidadDias() {
        return cantidadDias;
    }

    public void setCantidadDias(int cantidadDias) {
        this.cantidadDias = cantidadDias;
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

    public int getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(int precioBase) {
        this.precioBase = precioBase;
    }

    public double calculoAlquiler(int cantidadDias) {
        double resultado;
        resultado = this.precioBase * this.cantidadDias;
        return resultado;
    }

}
