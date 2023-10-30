package AccesoDatos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
//import java.util.ArrayList;
import java.util.List;

import Logica.*;


public class PiezaDAO implements iPieza{
    
    // Objeto para ejecutar la consulta en la base de datos
    AccesoDatos accesoBD = null;
    Connection con = null;
    Statement sentencia = null;
    ResultSet rs = null;

    @Override
   
    public List<PiezaBD> mostrarPiezasBD() {

        List<PiezaBD> lista = new ArrayList<>();

        // Se crea la consulta usando lenguaje SQL Estandar y almacenando en la variable
        // query
        String query = "select * from tipopieza";
        
        // En este bloque se ejecutan las sentencias necesarias para acceder a la BD y
        // obtener la informacion
        try {
            // Instancio un objeto de acceso a datos
            accesoBD = new AccesoDatos();

            // Obtener la conexion para poder generar la sentencia de consulta
            con = accesoBD.getConexion();
            sentencia = con.createStatement();

            // Ejecuta la consulta y almacena el resultado en rs
            rs = sentencia.executeQuery(query);

            // Procesa el resultSet y muestra la informacion obtenida desde la BD
            while (rs.next()) {
                PiezaBD pieza = new PiezaBD();
                
                int idPieza = rs.getInt("idTipoPieza");
                
                //System.out.println("Pieza Nro: " + String.valueOf(idPieza)
                //        + " tipo " + rs.getString("Descripciondepieza"));
                
                String tipoPieza = rs.getString("Descripciondepieza");
                pieza.setIdPieza(idPieza);
                pieza.setTipoPieza(tipoPieza);

                lista.add(pieza);
                
            }

        } catch (SQLException e) {
            System.err.println("Error al CARGAR DATOS");
        } finally {
            try {
                // Cierra el ResultSet
                if (rs != null)
                    rs.close();
                // Cierra la sentencia
                if (sentencia != null)
                    sentencia.close();
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
    public void insertarPiezasBD() {
        
    }

    @Override
    public List<PiezaBD> listarPiezasBD() {
        return null;
     
    }

    @Override
    public void transaccionBD() {
     
    }

    @Override
    public List<PiezaBD> mostrarTipoPiezasBD() {
       
        List<PiezaBD> lista = new ArrayList<>();

        // Se crea la consulta usando lenguaje SQL Estandar y almacenando en la variable
        // query
        String query = "select * from tipopieza";
        
        // En este bloque se ejecutan las sentencias necesarias para acceder a la BD y
        // obtener la informacion
        try {
            // Instancio un objeto de acceso a datos
            accesoBD = new AccesoDatos();

            // Obtener la conexion para poder generar la sentencia de consulta
            con = accesoBD.getConexion();
            sentencia = con.createStatement();

            // Ejecuta la consulta y almacena el resultado en rs
            rs = sentencia.executeQuery(query);

            // Procesa el resultSet y muestra la informacion obtenida desde la BD
            while (rs.next()) {
                PiezaBD pieza = new PiezaBD();
                
                int idPieza = rs.getInt("idTipoPieza");
                
                //System.out.println("Pieza Nro: " + String.valueOf(idPieza)
                //        + " tipo " + rs.getString("Descripciondepieza"));
                
                String tipoPieza = rs.getString("Descripciondepieza");
                pieza.setIdPieza(idPieza);
                pieza.setTipoPieza(tipoPieza);

                lista.add(pieza);
                
            }

        } catch (SQLException e) {
            System.err.println("Error al CARGAR DATOS");
        } finally {
            try {
                // Cierra el ResultSet
                if (rs != null)
                    rs.close();
                // Cierra la sentencia
                if (sentencia != null)
                    sentencia.close();
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
