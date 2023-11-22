package Logica;

import java.util.List;

public interface iCotizacionDAO {
    
 
    public abstract void insertar(Cotizacion cotizacion);
    public abstract void eliminarElemento(String elemento);
    public abstract void modificarElemento(Cotizacion cotizacion,String elemento);
    public abstract List<Cotizacion> listar();
}
