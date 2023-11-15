package Logica;

import java.util.List;

public interface iVehiculoDAO{

    public abstract void insertar(VehiculoBD vehiculo);
    public abstract void eliminarElemento(String elemento);
    public abstract void modificarElemento(VehiculoBD vehiculo,String elemento);
    public abstract List<VehiculoBD> listar();
}
