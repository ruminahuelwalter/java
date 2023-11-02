package Logica;

import java.util.Date;

public class PiezaBD extends Pieza{

    private int idPieza;
    private String tipoPieza;
    private String descripcion;
    private String material;
    private String tamanio;
    private Date fechaCreacion;

    public PiezaBD() {

    }
    
    public PiezaBD(String movimiento, String color, String comportamiento, String nombrePosicion, int idPieza,
            String tipoPieza, String descripcion, String material, String tamanio, Date fechaCreacion) {
        super(movimiento, color, comportamiento, nombrePosicion);
        this.idPieza = idPieza;
        this.tipoPieza = tipoPieza;
        this.descripcion = descripcion;
        this.material = material;
        this.tamanio = tamanio;
        this.fechaCreacion = fechaCreacion;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getTamanio() {
        return tamanio;
    }

    public void setTamanio(String tamanio) {
        this.tamanio = tamanio;
    }

    public int getIdPieza() {
        return idPieza;
    }

    public void setIdPieza(int idPieza) {
        this.idPieza = idPieza;
    }
    
    public String getTipoPieza() {
        return tipoPieza;
    }
    
    public void setTipoPieza(String tipoPieza) {
        this.tipoPieza = tipoPieza;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    @Override
    public void mover() {
        
    }
}
