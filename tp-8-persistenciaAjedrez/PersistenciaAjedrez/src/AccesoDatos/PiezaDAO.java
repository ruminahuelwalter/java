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

public class PiezaDAO implements iPiezaDAO {

    // Objeto para ejecutar la consulta en la base de datos
    AccesoDatos accesoBD = null;
    Connection con = null;
    Statement sentenciaStatement = null;
    ResultSet rs = null;
    PreparedStatement sentenciaPrepared = null;

    LocalDateTime fechaHoraActual = LocalDateTime.now();
    Map<String, Integer> piezaId = new HashMap<>();

    @Override
    public void insertar(PiezaBD pieza) {
        String query = "insert into pieza (Descripcion,idColor,idTipoPieza,idTamanio,idMaterial,Posicion,Comportamiento,Movimiento, Fecha_Creacion) values(?,?,?,?,?,?,?,?,?)";

        try {
            // Instancio un objeto de acceso a datos
            accesoBD = new AccesoDatos();
            // Obtener la conexion para poder generar la sentencia de insercion
            con = accesoBD.getConexion();
            sentenciaPrepared = con.prepareStatement(query);

            int idColor = 0, idMaterial = 0, idTamanio = 0;
            piezaId.put("Reina", 1);
            piezaId.put("Rey", 2);
            piezaId.put("Torre", 3);
            piezaId.put("Alfil", 4);
            piezaId.put("Caballo", 5);
            piezaId.put("Peon", 6);

            if (pieza.getColor().equals("blanco")) {
                idColor = 1;
            } else {
                idColor = 2;
            }

            if (pieza.getTamanio().equals("Chico")) {
                idTamanio = 1;
            } else {
                idTamanio = 2;
            }

            if (pieza.getMaterial().equals("Plastico")) {
                idMaterial = 1;
            } else {
                idMaterial = 2;
            }

            int idTipoPieza = piezaId.get(pieza.getTipoPieza());

            sentenciaPrepared.setString(1, pieza.getDescripcion());
            sentenciaPrepared.setInt(2, idColor);
            sentenciaPrepared.setInt(3, idTipoPieza);
            sentenciaPrepared.setInt(4, idTamanio);
            sentenciaPrepared.setInt(5, idMaterial);
            sentenciaPrepared.setString(6, pieza.getNombrePosicion());
            sentenciaPrepared.setString(7, pieza.getComportamiento());
            sentenciaPrepared.setString(8, pieza.getMovimiento());
            sentenciaPrepared.setTimestamp(9, java.sql.Timestamp.valueOf(fechaHoraActual));

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
                "inner join material m on m.idMaterial = p.idMaterial\n" + //
                "order by fecha_creacion desc";

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

                PiezaBD pieza = new PiezaBD();

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

                lista.add(pieza);
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

     String query = "delete from pieza where idPieza = ?";
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
    public void modificarElemento(PiezaBD pieza, String elemento) {
       
        String query = "update pieza set Descripcion = ?,idColor= ?, idTipoPieza = ?,idTamanio= ?,idMaterial= ?, Posicion = ?, Comportamiento= ?,Movimiento= ?, Fecha_Creacion= ? where idPieza = " + elemento;
        try {
            // Instancio un objeto de acceso a datos
            accesoBD = new AccesoDatos();
            // Obtener la conexion para poder generar la sentencia de insercion
            con = accesoBD.getConexion();
            sentenciaPrepared = con.prepareStatement(query);

            int idColor = 0, idMaterial = 0, idTamanio = 0;

            piezaId.put("Reina", 1);
            piezaId.put("Rey", 2);
            piezaId.put("Torre", 3);
            piezaId.put("Alfil", 4);
            piezaId.put("Caballo", 5);
            piezaId.put("Peon", 6);

            if (pieza.getColor().equals("blanco")) {
                idColor = 1;
            } else {
                idColor = 2;
            }

            if (pieza.getTamanio().equals("Chico")) {
                idTamanio = 1;
            } else {
                idTamanio = 2;
            }

            if (pieza.getMaterial().equals("Plastico")) {
                idMaterial = 1;
            } else {
                idMaterial = 2;
            }

            int idTipoPieza = piezaId.get(pieza.getTipoPieza());

            sentenciaPrepared.setString(1, pieza.getDescripcion());
            sentenciaPrepared.setInt(2, idColor);
            sentenciaPrepared.setInt(3, idTipoPieza);
            sentenciaPrepared.setInt(4, idTamanio);
            sentenciaPrepared.setInt(5, idMaterial);
            sentenciaPrepared.setString(6, pieza.getNombrePosicion());
            sentenciaPrepared.setString(7, pieza.getComportamiento());
            sentenciaPrepared.setString(8, pieza.getMovimiento());
            sentenciaPrepared.setTimestamp(9, java.sql.Timestamp.valueOf(fechaHoraActual));
            
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
