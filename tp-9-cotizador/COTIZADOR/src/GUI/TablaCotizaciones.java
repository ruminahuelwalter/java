package GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import AccesoDatos.*;
import Logica.*;

public class TablaCotizaciones extends JPanel {
    
    private JTable tabla;
    private JScrollPane scrollPane;
    private DefaultTableModel tablaModelo;

    public TablaCotizaciones() {

        tabla = new JTable();
        
        iCotizacionDAO iCotizacion = new CotizacionDAO();
        List<Cotizacion> lista = iCotizacion.listar();
    
        //tabla.setSize(1121, 453);
        this.setLayout(new BorderLayout());
        tablaModelo = new DefaultTableModel();

        Object encabezado[] = new Object[]{
            "ID Cotizacion",
            "ID Vehiculo",
            "Marca",
            "Modelo",
            "Patente",
            "Plazas",
            "Año",
            "Color",
            "Transmisión",
            "Capacidad Baul",
            "PMA",
            "Tipo",
            "Dias Cotizados",
            "Precio",
            "Fecha"
        };

        tablaModelo.setColumnIdentifiers(encabezado);
        
        tabla.setModel(tablaModelo);
        tabla.setDefaultEditor(Object.class, null);
        tablaModelo.setRowCount(0);
        TableColumnModel anchoColumna = tabla.getColumnModel();

        anchoColumna.getColumn(0).setPreferredWidth(50);
        anchoColumna.getColumn(1).setPreferredWidth(50);
        anchoColumna.getColumn(10).setPreferredWidth(50);
        //anchoColumna.getColumn(2).setPreferredWidth(250);
        //anchoColumna.getColumn(4).setPreferredWidth(150);
        //anchoColumna.getColumn(5).setPreferredWidth(150);
        //anchoColumna.getColumn(9).setPreferredWidth(200);

        

        for (Cotizacion cotizacion : lista) {
            tablaModelo.addRow(new Object[]{
            
            cotizacion.getIdCotizacion(),
            cotizacion.getVehiculoBD().getIdVehiculo(),
            cotizacion.getVehiculoBD().getMarca(),
            cotizacion.getVehiculoBD().getModelo(),
            cotizacion.getVehiculoBD().getPatente(),
            cotizacion.getVehiculoBD().getCantPlazas(),
            cotizacion.getVehiculoBD().getAnioFabricacion(),
            cotizacion.getVehiculoBD().getColor(),
            cotizacion.getVehiculoBD().getTipoTransmision(),
            cotizacion.getVehiculoBD().getCapacidadBaul(),
            cotizacion.getVehiculoBD().getPma(),
            cotizacion.getVehiculoBD().getTipoVehiculo(),
            cotizacion.getDiasCotizados(),
            cotizacion.getPrecioCotizacion(),
            cotizacion.getFechaCotizacion()

            });

        } 
    
        //tabla.setAutoResizeMode(2);

        //tabla.setAutoResizeMode(1);
        tabla.setRowHeight(25);
        tabla.setShowHorizontalLines(false);
        tabla.setShowVerticalLines(false);

        //tabla.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

        scrollPane = new JScrollPane(tabla);

        scrollPane.setPreferredSize((new Dimension(1000, 370)));
        //scrollPane.setMinimumSize(new Dimension(1000,300));
        //scrollPane.setMaximumSize(new Dimension(3000,600));
        
        this.add(scrollPane, BorderLayout.CENTER);
    }


    public void actualizarTabla(List<Cotizacion> listaActualizada) {
        
        tablaModelo.setRowCount(0); // Limpia el contenido de la tabla

        for (Cotizacion cotizacion : listaActualizada) {
            tablaModelo.addRow(new Object[]{
                cotizacion.getIdCotizacion(),
                cotizacion.getVehiculoBD().getIdVehiculo(),
                cotizacion.getVehiculoBD().getMarca(),
                cotizacion.getVehiculoBD().getModelo(),
                cotizacion.getVehiculoBD().getCantPlazas(),
                cotizacion.getVehiculoBD().getAnioFabricacion(),
                cotizacion.getVehiculoBD().getColor(),
                cotizacion.getVehiculoBD().getTipoTransmision(),
                cotizacion.getVehiculoBD().getCapacidadBaul(),
                cotizacion.getVehiculoBD().getPma(),
                cotizacion.getVehiculoBD().getTipoVehiculo(),
                cotizacion.getDiasCotizados(),
                cotizacion.getPrecioCotizacion(),
                cotizacion.getFechaCotizacion()
            });
        }
    } 

    public String elementoSeleccionado() {
        int fila = this.tabla.getSelectedRow();
        String id = tabla.getValueAt(fila, 0).toString();
        return id;
    }


}
