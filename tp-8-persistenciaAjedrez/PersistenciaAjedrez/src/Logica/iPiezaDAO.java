package Logica;

import java.util.List;

public interface iPiezaDAO{
    

    public abstract void insertar(PiezaBD pieza);
    public abstract void eliminarElemento(String elemento);
    public abstract void modificarElemento(PiezaBD pieza,String elemento);
    public abstract List<PiezaBD> listar();

}
