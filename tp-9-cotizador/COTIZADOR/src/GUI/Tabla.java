package GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import AccesoDatos.*;
import Logica.*;

public class Tabla extends JPanel {
    
    private JTable tabla;
    private JScrollPane scrollPane;
    private DefaultTableModel tablaModelo;

    public Tabla() {

        tabla = new JTable(); 
        iVehiculoDAO iVehiculo = new VehiculoDAO();
        List<VehiculoBD> lista = iVehiculo.listar();
    
        this.setLayout(new BorderLayout());
        tablaModelo = new DefaultTableModel();

        Object encabezado[] = new Object[]{
            "idVehiculo",
            "Tipo",
            "Marca",
            "Modelo",
            "Año Fab",
            "Patente",
            "Color",
            "Transmisión",
            "Plazas",
            "C.Baul",
            "PMA" 
        };

        tablaModelo.setColumnIdentifiers(encabezado);
        
        tabla.setModel(tablaModelo);
        tabla.setDefaultEditor(Object.class, null);
        tablaModelo.setRowCount(0);

        for (VehiculoBD vehiculo : lista) {
            tablaModelo.addRow(new Object[]{
            
            vehiculo.getIdVehiculo(),
            vehiculo.getTipoVehiculo(),
            vehiculo.getMarca(),
            vehiculo.getModelo(),
            vehiculo.getAnioFabricacion(),
            vehiculo.getPatente(),
            vehiculo.getColor(),
            vehiculo.getTipoTransmision(),
            vehiculo.getCantPlazas(),
            vehiculo.getCapacidadBaul(),
            vehiculo.getPma()

            });

        } 
    
        tabla.setRowHeight(28);
        tabla.setShowHorizontalLines(false);
        tabla.setShowVerticalLines(false);
        tabla.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

        scrollPane = new JScrollPane(tabla);

        scrollPane.setPreferredSize((new Dimension(1000, 350)));
        //scrollPane.setMinimumSize(new Dimension(1000,300));
        //scrollPane.setMaximumSize(new Dimension(3000,600));
        
        this.add(scrollPane, BorderLayout.CENTER);
    }

    public void actualizarTabla(List<VehiculoBD> listaActualizada) {
        
        tablaModelo.setRowCount(0); // Limpia el contenido de la tabla

        for (VehiculoBD vehiculo : listaActualizada) {
            tablaModelo.addRow(new Object[]{
                vehiculo.getIdVehiculo(),
                vehiculo.getTipoVehiculo(),
                vehiculo.getMarca(),
                vehiculo.getModelo(),
                vehiculo.getAnioFabricacion(),
                vehiculo.getPatente(),
                vehiculo.getColor(),
                vehiculo.getTipoTransmision(),
                vehiculo.getCantPlazas(),
                vehiculo.getCapacidadBaul(),
                vehiculo.getPma()
            });
        }
    } 

    public String elementoSeleccionado() {
        int fila = this.tabla.getSelectedRow();
        String id = tabla.getValueAt(fila, 0).toString();
        return id;
    }

    public VehiculoBD vehiculoSeleccionado() {

        VehiculoBD vehiculo = new VehiculoBD();
        int fila = this.tabla.getSelectedRow();

        String id = tabla.getValueAt(fila, 0).toString();
        int idVehiculo = Integer.parseInt(id);
        vehiculo.setIdVehiculo(idVehiculo);
        
        String tipo = tabla.getValueAt(fila, 1).toString();
        vehiculo.setTipoVehiculo(tipo);

        String marca = tabla.getValueAt(fila, 2).toString();
        vehiculo.setMarca(marca);

        String modelo = tabla.getValueAt(fila, 3).toString();
        vehiculo.setModelo(modelo);
        
        String auxAnio = tabla.getValueAt(fila, 4).toString();
        int anio = Integer.parseInt(auxAnio);
        vehiculo.setAnioFabricacion(anio);

        String patente = tabla.getValueAt(fila, 5).toString();
        vehiculo.setPatente(patente);

        String color = tabla.getValueAt(fila, 6).toString();
        vehiculo.setColor(color);

        String tipoTransmision = tabla.getValueAt(fila, 7).toString();
        vehiculo.setTipoTransmision(tipoTransmision);
        
        String auxCantP = tabla.getValueAt(fila, 8).toString();
        int cantPlazas = Integer.parseInt(auxCantP);
        vehiculo.setCantPlazas(cantPlazas);

        String auxCapBaul = tabla.getValueAt(fila, 9).toString();
        int capBaul = Integer.parseInt(auxCapBaul);
        vehiculo.setCapacidadBaul(capBaul);

        String auxPma = tabla.getValueAt(fila, 10).toString();
        float pma = Float.parseFloat(auxPma);
        vehiculo.setPma(pma);

        return vehiculo;
    }

}
