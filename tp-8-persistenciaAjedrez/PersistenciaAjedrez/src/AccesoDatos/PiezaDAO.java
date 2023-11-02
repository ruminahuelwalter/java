package AccesoDatos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Logica.*;

public class PiezaDAO implements iPiezaDAO{
    
    // Objeto para ejecutar la consulta en la base de datos
    AccesoDatos accesoBD = null;
    Connection con = null;
    Statement sentencia = null;
    ResultSet rs = null;

    @Override
<<<<<<< HEAD
    public List<PiezaBD> mostrar() {
=======
    public List<PiezaBD> mostrarPiezasBD() {
>>>>>>> 1d27e070e6bef5bacf92bdd98b0a48c9cd964d8d

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
<<<<<<< HEAD
    public void insertar() {
        
=======
    public void insertarPiezasBD() {

        // En este bloque se ejecutan las sentencias necesarias para acceder a la BD y
        // obtener la informacion
        try {
            // Instancio un objeto de acceso a datos
            accesoBD = new AccesoDatos();

            // Obtener la conexion para poder generar la sentencia de consulta
            con = accesoBD.getConexion();
            sentencia = con.createStatement();
            String query = "insert into ";
            // Ejecuta la insercion y almacena el resultado en rs
            sentencia.executeUpdate(query);

            

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
>>>>>>> 1d27e070e6bef5bacf92bdd98b0a48c9cd964d8d
    }

    @Override
    public List<PiezaBD> listar() {

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
                "p.Posicion as Po, \n" + //
                "p.Fecha_Creacion\n" + //
                "from pieza p\n" + //
                "inner join color c on c.idColor = p.idColor\n" + //
                "inner join tipopieza tp on tp.idTipoPieza = p.idTipoPieza\n" + //
                "inner join tamanio tm on tm.idTamanio = p.idTamanio\n" + //
                "inner join material m on m.idMaterial = p.idMaterial";
        
<<<<<<< HEAD
        // En este bloque se ejecutan las sentencias necesarias para acceder a la BD y
        // obtener la informacion
=======
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
            "p.Fecha_Creacion as Fecha\n" + //
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
            pieza.setFechaNac(rs.getDate("Fecha"));
            //pieza.setIdPieza(idPieza);
            lista.add(pieza);
            
        }
    } catch (SQLException e) {
        System.err.println("Error al CARGAR DATOS");
    } finally {
>>>>>>> 1d27e070e6bef5bacf92bdd98b0a48c9cd964d8d
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
                pieza.setDescripcion(rs.getString("Descripcion"));
                pieza.setMovimiento(rs.getString("Movimiento"));
                pieza.setNombrePosicion(rs.getString("Po"));
                pieza.setComportamiento(rs.getString("Comportamiento"));
                pieza.setColor(rs.getString("Color"));
                pieza.setTamanio(rs.getString("Tamanio"));
                pieza.setMaterial(rs.getString("Material"));
                pieza.setFechaCreacion(rs.getTimestamp("Fecha_Creacion"));
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
    public void transaccion() {
     
    }

    @Override
    public List<PiezaBD> mostrarTipo() {
       
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
