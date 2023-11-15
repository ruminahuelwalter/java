package Logica;

public class VehiculoBD extends Vehiculo {

    private int idVehiculo;
    private int idTipoVehiculo;
    private String tipoVehiculo;
    private String marca;
    private String modelo;
    private int anioFabricacion;
    private String color;
    private String tipoTransmision;
    private int cantPlazas;
    private int capacidadBaul;
    private float pma;

    public VehiculoBD() {

    }

    public VehiculoBD(String patente, int idVehiculo, int idTipoVehiculo, String tipoVehiculo, String marca,
            String modelo, int anioFabricacion, String color, String tipoTransmision, int cantPlazas, int capacidadBaul,
            float pma) {
        super(patente);
        this.idVehiculo = idVehiculo;
        this.idTipoVehiculo = idTipoVehiculo;
        this.tipoVehiculo = tipoVehiculo;
        this.marca = marca;
        this.modelo = modelo;
        this.anioFabricacion = anioFabricacion;
        this.color = color;
        this.tipoTransmision = tipoTransmision;
        this.cantPlazas = cantPlazas;
        this.capacidadBaul = capacidadBaul;
        this.pma = pma;
    }

    public VehiculoBD(int idVehiculo, int idTipoVehiculo, String tipoVehiculo, String marca, String modelo,
            int anioFabricacion, String color, String tipoTransmision, int cantPlazas, int capacidadBaul, float pma) {
        this.idVehiculo = idVehiculo;
        this.idTipoVehiculo = idTipoVehiculo;
        this.tipoVehiculo = tipoVehiculo;
        this.marca = marca;
        this.modelo = modelo;
        this.anioFabricacion = anioFabricacion;
        this.color = color;
        this.tipoTransmision = tipoTransmision;
        this.cantPlazas = cantPlazas;
        this.capacidadBaul = capacidadBaul;
        this.pma = pma;
    }

    public int getIdVehiculo() {
        return idVehiculo;
    }

    public void setIdVehiculo(int idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    public int getIdTipoVehiculo() {
        return idTipoVehiculo;
    }

    public void setIdTipoVehiculo(int idTipoVehiculo) {
        this.idTipoVehiculo = idTipoVehiculo;
    }

    public String getTipoVehiculo() {
        return tipoVehiculo;
    }

    public void setTipoVehiculo(String tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAnioFabricacion() {
        return anioFabricacion;
    }

    public void setAnioFabricacion(int anioFabricacion) {
        this.anioFabricacion = anioFabricacion;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTipoTransmision() {
        return tipoTransmision;
    }

    public void setTipoTransmision(String tipoTransmision) {
        this.tipoTransmision = tipoTransmision;
    }

    public int getCantPlazas() {
        return cantPlazas;
    }

    public void setCantPlazas(int cantPlazas) {
        this.cantPlazas = cantPlazas;
    }

    public int getCapacidadBaul() {
        return capacidadBaul;
    }

    public void setCapacidadBaul(int capacidadBaul) {
        this.capacidadBaul = capacidadBaul;
    }

    public float getPma() {
        return pma;
    }

    public void setPma(float pma) {
        this.pma = pma;
    }

    
    
}
