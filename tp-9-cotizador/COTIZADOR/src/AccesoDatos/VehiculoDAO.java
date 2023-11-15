package AccesoDatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import Logica.*;

public class VehiculoDAO implements iVehiculoDAO {

    // Objeto para ejecutar la consulta en la base de datos
    AccesoDatos accesoBD = null;
    Connection con = null;
    Statement sentenciaStatement = null;
    ResultSet rs = null;
    PreparedStatement sentenciaPrepared = null;

    LocalDateTime fechaHoraActual = LocalDateTime.now();
    Map<String, Integer> vehiculoId = new HashMap<>();
    Map<String, Integer> idTipoVehiculo = new HashMap<>();

    @Override

    public void insertar(VehiculoBD vehiculo) {
        String query = "insert into vehiculo (idtipo_vehiculo, Marca, Modelo, AnioFabricacion, Patente, Color, TipoTransmision, CantPlazas, CapacidadBaul,PMA) values(?,?,?,?,?,?,?,?,?,?)";
           //idTipoVehiculo = new HashMap<>();
        try {
            // Instancio un objeto de acceso a datos
            accesoBD = new AccesoDatos();
            // Obtener la conexion para poder generar la sentencia de insercion
            con = accesoBD.getConexion();
            sentenciaPrepared = con.prepareStatement(query);

         
            idTipoVehiculo.put("Auto", 1);
            idTipoVehiculo.put("Minibus", 2);
            idTipoVehiculo.put("Furgoneta", 3);
            idTipoVehiculo.put("Camion", 4);
       

            int TipoVehiculo = idTipoVehiculo.get(vehiculo.getTipoVehiculo());

            sentenciaPrepared.setInt(1, TipoVehiculo);
            sentenciaPrepared.setString(2, vehiculo.getMarca());
            sentenciaPrepared.setString(3, vehiculo.getModelo());
            sentenciaPrepared.setInt(4, vehiculo.getAnioFabricacion());
            sentenciaPrepared.setString(5, vehiculo.getPatente());
            sentenciaPrepared.setString(6,vehiculo.getColor() );
            sentenciaPrepared.setString(7, vehiculo.getTipoTransmision());
            sentenciaPrepared.setInt(8, vehiculo.getCantPlazas());
            sentenciaPrepared.setInt(9, vehiculo.getCapacidadBaul());
            sentenciaPrepared.setFloat(10, vehiculo.getPma());

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
    public List<VehiculoBD> listar() {

        List<VehiculoBD> lista = new ArrayList<>();
        String query = "select idVehiculo, descripcion as Tipo,\n" + //
        "Marca, Modelo, AnioFabricacion as anio, Patente, Color,\n" + //
        "TipoTransmision, CantPlazas, CapacidadBaul, PMA from vehiculo\n" + //
        "inner join tipo_vehiculo on vehiculo.idtipo_vehiculo = tipo_vehiculo.idtipo_vehiculo";

        // En este bloque se ejecutan las sentencias necesarias para acceder a la BD y
        // obtener la informacion
        try {
            // Instancio un objeto de acceso a datos
            accesoBD = new AccesoDatos();
            // Obtener la conexion para poder generar la sentencia de consulta
            con = accesoBD.getConexion();
            sentenciaStatement = con.createStatement();
            // Ejecuta la consulta y almacena el resultado en rs
            rs = sentenciaStatement.executeQuery(query);
            // Procesa el resultSet y muestra la informacion obtenida desde la BD
            while (rs.next()) {
                VehiculoBD vehiculo = new VehiculoBD();
                
                vehiculo.setIdVehiculo(rs.getInt("idVehiculo"));
                vehiculo.setTipoVehiculo(rs.getString("Tipo"));
                vehiculo.setMarca(rs.getString("Marca"));
                vehiculo.setModelo(rs.getString("Modelo"));
                vehiculo.setAnioFabricacion(rs.getInt("anio"));
                vehiculo.setPatente(rs.getString("Patente"));
                vehiculo.setColor(rs.getString("Color"));
                vehiculo.setTipoTransmision(rs.getString("TipoTransmision"));
                vehiculo.setCantPlazas(rs.getInt("CantPlazas"));
                vehiculo.setCapacidadBaul(rs.getInt("CapacidadBaul"));
                vehiculo.setPma(rs.getFloat("PMA"));

                lista.add(vehiculo);
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

    @Override
    public void eliminarElemento(String elemento) {

     String query = "delete from vehiculo where idVehiculo = ?";
     System.out.println(elemento);
        try {
            // Instancio un objeto de acceso a datos
            accesoBD = new AccesoDatos();
            // Obtener la conexion para poder generar la sentencia de insercion
            con = accesoBD.getConexion();
            sentenciaPrepared = con.prepareStatement(query);
            sentenciaPrepared.setString(1, elemento);

            sentenciaPrepared.executeUpdate();
     
        } catch (SQLException e) {
            System.err.println("Error al ELIMINAR DATOS");
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
    public void modificarElemento(VehiculoBD vehiculo, String elemento) {
       
        String query = "update vehiculo set idtipo_vehiculo = ?, Marca= ?, Modelo = ?, AnioFabricacion = ?, Patente = ?, Color= ?, TipoTransmision = ?, CantPlazas = ?, CapacidadBaul = ?,PMA = ? where idVehiculo = ?";
        try {
            // Instancio un objeto de acceso a datos
            accesoBD = new AccesoDatos();
            // Obtener la conexion para poder generar la sentencia de insercion
            con = accesoBD.getConexion();
            sentenciaPrepared = con.prepareStatement(query);
            sentenciaPrepared.setString(11, elemento);

         
            idTipoVehiculo.put("Auto", 1);
            idTipoVehiculo.put("Minibus", 2);
            idTipoVehiculo.put("Furgoneta", 3);
            idTipoVehiculo.put("Camion", 4);
       

            int TipoVehiculo = idTipoVehiculo.get(vehiculo.getTipoVehiculo());

            sentenciaPrepared.setInt(1, TipoVehiculo);
            sentenciaPrepared.setString(2, vehiculo.getMarca());
            sentenciaPrepared.setString(3, vehiculo.getModelo());
            sentenciaPrepared.setInt(4, vehiculo.getAnioFabricacion());
            sentenciaPrepared.setString(5, vehiculo.getPatente());
            sentenciaPrepared.setString(6,vehiculo.getColor() );
            sentenciaPrepared.setString(7, vehiculo.getTipoTransmision());
            sentenciaPrepared.setInt(8, vehiculo.getCantPlazas());
            sentenciaPrepared.setInt(9, vehiculo.getCapacidadBaul());
            sentenciaPrepared.setFloat(10, vehiculo.getPma());

            sentenciaPrepared.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Error al MODIFICAR DATO");
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

}
