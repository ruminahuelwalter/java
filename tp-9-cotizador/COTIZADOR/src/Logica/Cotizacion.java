package Logica;

import java.util.Date;

public class Cotizacion {
    
    private int idCotizacion;
    private VehiculoBD vehiculoBD;
    private int diasCotizados;
    private double precioCotizacion;
    private Date fechaCotizacion;

    public Cotizacion(){

    }

    public Cotizacion(int idCotizacion, VehiculoBD vehiculoBD, int diasCotizados, double precioCotizacion, Date fechaCotizacion) {
        this.idCotizacion = idCotizacion;
        this.vehiculoBD = vehiculoBD;
        this.diasCotizados = diasCotizados;
        this.precioCotizacion = precioCotizacion;
        this.fechaCotizacion = fechaCotizacion;
    }

    public int getIdCotizacion() {
        return idCotizacion;
    }

    public void setIdCotizacion(int idCotizacion) {
        this.idCotizacion = idCotizacion;
    }

    public int getDiasCotizados() {
        return diasCotizados;
    }

    public void setDiasCotizados(int diasCotizados) {
        this.diasCotizados = diasCotizados;
    }

    public double getPrecioCotizacion() {
        return precioCotizacion;
    }

    public void setPrecioCotizacion(double precioCotizacion) {
        this.precioCotizacion = precioCotizacion;
    }

    public Date getFechaCotizacion() {
        return fechaCotizacion;
    }

    public void setFechaCotizacion(Date fechaCotizacion) {
        this.fechaCotizacion = fechaCotizacion;
    }

    public VehiculoBD getVehiculoBD() {
        return vehiculoBD;
    }

    public void setVehiculoBD(VehiculoBD vehiculoBD) {
        this.vehiculoBD = vehiculoBD;
    }

}
