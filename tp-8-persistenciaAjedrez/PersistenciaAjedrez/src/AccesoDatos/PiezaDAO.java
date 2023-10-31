package AccesoDatos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
        
    List<PiezaBD> lista = new ArrayList<>();
    // Se crea la consulta usando lenguaje SQL Estandar y almacenando en la variable
    // query
    String query = "select \n" + //
            "p.idPieza,\n" + //
            "tp.Descripciondepieza as TipoPieza, \n" + //
            "p.Descripcion,\n" + //
            "p.Movimiento as Movimiento,\n" + //
            "p.Comportamiento as Comportamiento, \n" + //
            "c.Descripcion as Color, \n" + //
            "tm.Descripcion as Tamanio,\n" + //
            "m.Descripcion as Material,\n" + //
            "p.Fecha_Creacion\n" + //
            "from pieza p\n" + //
            "inner join color c on c.idColor = p.idColor\n" + //
            "inner join tipopieza tp on tp.idTipoPieza = p.idTipoPieza\n" + //
            "inner join tamanio tm on tm.idTamanio = p.idTamanio\n" + //
            "inner join material m on m.idMaterial = p.idMaterial";
    
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
            
            //int idPieza = rs.getInt("idTipoPieza");
            
            //System.out.println("Pieza Nro: " + String.valueOf(idPieza)
            //        + " tipo " + rs.getString("Descripciondepieza"));
            
            // String tipoPieza = rs.getString("TipoPieza");
            //pieza.setMovimiento(rs.getString("Movimiento"));
            //pieza.setComportamiento(rs.getString("Comportamiento"));
            
            pieza.setIdPieza(rs.getInt("idPieza"));
            pieza.setTipoPieza(rs.getString("TipoPieza"));
            pieza.setMovimiento(rs.getString("Movimiento"));
            pieza.setComportamiento(rs.getString("Comportamiento"));
            pieza.setColor(rs.getString("Color"));
            pieza.setTamanio(rs.getString("Tamanio"));
            pieza.setMaterial(rs.getString("Material"));
            //pieza.setIdPieza(idPieza);
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
