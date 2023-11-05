package Logica;

import java.util.List;

public interface iPiezaDAO{
    
    public abstract List<PiezaBD> mostrar();
    public abstract List<PiezaBD> mostrarTipo();
    public abstract void insertar(PiezaBD pieza);
    //public abstract void insertarLista(List<Pieza> piezas);
    public abstract List<PiezaBD> listar();
    public abstract void transaccion();

    // actualizar
    // eliminar

    // Por cada query va a haber un metodo

}
