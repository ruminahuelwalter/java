package Logica;

public class PiezaBD extends Pieza{

    private int idPieza;
    private String tipoPieza;
    private String descripcion;

    public PiezaBD() {

    }
    
    public PiezaBD(String movimiento, String color, String comportamiento, String nombrePosicion, int fila, int columna,
            int idPieza, String tipoPieza, String descripcion) {
        super(movimiento, color, comportamiento, nombrePosicion);
        this.idPieza = idPieza;
        this.tipoPieza = tipoPieza;
        this.descripcion = descripcion;
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
    
    @Override
    public void mover() {
        
    }
}
