package AccesoDatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import Logica.Cotizacion;
import Logica.VehiculoBD;
import Logica.iCotizacionDAO;

public class CotizacionDAO implements iCotizacionDAO {

    AccesoDatos accesoBD = null;
    Connection con = null;
    Statement sentenciaStatement = null;
    ResultSet rs = null;
    PreparedStatement sentenciaPrepared = null;

    LocalDateTime fechaHoraActual = LocalDateTime.now();


    @Override
    public void insertar(Cotizacion cotizacion) {

        String query = "insert into cotizacion (idVehiculo,cantidadDias,precioCotizacion,fecha_Creacion) values(?,?,?,?)";
    
        try {
            // Instancio un objeto de acceso a datos
            accesoBD = new AccesoDatos();
            // Obtener la conexion para poder generar la sentencia de insercion
            con = accesoBD.getConexion();
            sentenciaPrepared = con.prepareStatement(query);
      
            sentenciaPrepared.setInt(1, cotizacion.getVehiculoBD().getIdVehiculo());
            sentenciaPrepared.setInt(2, cotizacion.getDiasCotizados());
            sentenciaPrepared.setDouble(3, cotizacion.getPrecioCotizacion());
            sentenciaPrepared.setTimestamp(4, java.sql.Timestamp.valueOf(fechaHoraActual));

            sentenciaPrepared.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Error al INSERTAR DATOS");
        } finally {
            try {

                // Cierra la sentencia
                if (sentenciaPrepared != null)
                    sentenciaPrepared.close();
                // Cierra la conexion
                if (con != null)
                    con.close();
            } catch (SQLException e) {
                System.err.println("Error al cerrar conexion");
            }
        }
    }

    @Override
    public void eliminarElemento(String elemento) {
      
    }

    @Override
    public void modificarElemento(Cotizacion cotizacion, String elemento) {
        
    }

    @Override
    public List<Cotizacion> listar() {
        
        List<Cotizacion> lista = new ArrayList<>();
        String query = "select  cotizacion.idCotizacion as idCotizacion, vehiculo.idVehiculo as idVehiculo, vehiculo.Marca as\n" + //
                " Marca, vehiculo.Modelo as Modelo, vehiculo.Patente as\n" + //
                " Patente, vehiculo.CantPlazas as Plaza,AnioFabricacion as\n" + //
                " Anio, vehiculo.Color as Color, vehiculo.TipoTransmision as Transmision,\n" + //
                " vehiculo.CapacidadBaul as Baul, vehiculo.PMA as PMA, tipo_vehiculo.descripcion as\n" + //
                " Vehiculo, cotizacion.cantidadDias as Dias, cotizacion.precioCotizacion as\n" + //
                " Precio, cotizacion.fecha_Creacion as\n" + //
                " Fecha from cotizacion inner join vehiculo on cotizacion.idVehiculo = vehiculo.idVehiculo \n" + //
                " inner join tipo_vehiculo on vehiculo.idtipo_vehiculo = tipo_vehiculo.idtipo_vehiculo order by cotizacion.fecha_Creacion DESC;";
        try {

            accesoBD = new AccesoDatos();
            con = accesoBD.getConexion();
            sentenciaStatement = con.createStatement();
            rs = sentenciaStatement.executeQuery(query);
            while (rs.next()) {

                Cotizacion cotizacion = new Cotizacion();
                VehiculoBD vehiculoBD = new VehiculoBD();
                cotizacion.setVehiculoBD(vehiculoBD);

                cotizacion.setIdCotizacion(rs.getInt("idCotizacion"));
                cotizacion.getVehiculoBD().setIdVehiculo(rs.getInt("idVehiculo"));
                cotizacion.getVehiculoBD().setMarca(rs.getString("Marca"));
                cotizacion.getVehiculoBD().setModelo(rs.getString("Modelo"));
                cotizacion.getVehiculoBD().setPatente(rs.getString("Patente"));
                cotizacion.getVehiculoBD().setCantPlazas(rs.getInt("Plaza"));
                cotizacion.getVehiculoBD().setAnioFabricacion(rs.getInt("Anio"));
                cotizacion.getVehiculoBD().setColor(rs.getString("Color"));
                cotizacion.getVehiculoBD().setTipoTransmision(rs.getString("Transmision"));
                cotizacion.getVehiculoBD().setCapacidadBaul(rs.getInt("Baul"));
                cotizacion.getVehiculoBD().setPma(rs.getFloat("PMA"));
                cotizacion.getVehiculoBD().setTipoVehiculo(rs.getString("Vehiculo"));
                cotizacion.setDiasCotizados(rs.getInt("Dias"));
                cotizacion.setPrecioCotizacion(rs.getDouble("Precio"));
                cotizacion.setFechaCotizacion(rs.getTimestamp("Fecha"));


                lista.add(cotizacion);
            }
        } catch (SQLException e) {
            System.err.println("Error al CARGAR DATO(S)");
        } finally {
            try {
                // Cierra el ResultSet
                if (rs != null)
                    rs.close();
                // Cierra la sentencia
                if (sentenciaStatement != null)
                    sentenciaStatement.close();
                // Cierra la conexion
                if (con != null)
                    con.close();
            } catch (SQLException e) {
                System.err.println("Error al cerrar conexion");
            }
        }

        return lista;
    }
    
}
