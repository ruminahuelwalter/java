package Logica;

import java.util.List;

public interface iPieza{
    
    public abstract List<PiezaBD> mostrarPiezasBD();
    public abstract List<PiezaBD> mostrarTipoPiezasBD();
    public abstract void insertarPiezasBD();
    public abstract List<PiezaBD> listarPiezasBD();
    public abstract void transaccionBD();

    // actualizar
    // eliminar

    // Por cada query va a haber un metodo

}
