package GUI;

import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import AccesoDatos.*;
import Logica.*;

public class Tabla extends JPanel {
    
    private JTable tabla;
    private JScrollPane scrollPane;
    private DefaultTableModel tablaModelo;

    public Tabla() {
        
        this.setBounds(0,0,1000,600);
        this.setVisible(true);
        this.setLayout(null);

        tabla = new JTable();
        
        iPiezaDAO iPiezaA = new PiezaDAO();
        List<PiezaBD> lista = iPiezaA.listar();
        tablaModelo = new DefaultTableModel();

        tablaModelo.setColumnIdentifiers(new Object[]{

            "idTipoPieza",
            "Pieza",
            "Descripcion",
            "Posicion",
            "Movimiento",
            "Comportamiento",
            "Color",
            "Tamaño",
            "Material",
            "Fecha de creación"
            
        });
        
        tabla.setModel(tablaModelo);
        // boolean isCellEditable(int row, int column)
        tablaModelo.setRowCount(0);
        TableColumnModel anchoColumna = tabla.getColumnModel();
        anchoColumna.getColumn(0).setPreferredWidth(100);
        //anchoColumna.getColumn(1).setPreferredWidth(100);
        anchoColumna.getColumn(2).setPreferredWidth(250);
        //anchoColumna.getColumn(3).setPreferredWidth(100);
        anchoColumna.getColumn(4).setPreferredWidth(150);
        anchoColumna.getColumn(5).setPreferredWidth(180);
        //anchoColumna.getColumn(6).setPreferredWidth(100);
        //anchoColumna.getColumn(7).setPreferredWidth(100);
        //anchoColumna.getColumn(8).setPreferredWidth(100);
        anchoColumna.getColumn(9).setPreferredWidth(200);
        for (PiezaBD pieza : lista) {
            tablaModelo.addRow(new Object[]{

                pieza.getIdPieza(),
                pieza.getTipoPieza(),
                pieza.getDescripcion(),
                pieza.getNombrePosicion(),
                pieza.getMovimiento(),
                pieza.getComportamiento(),
                pieza.getColor(),
                pieza.getTamanio(),
                pieza.getMaterial(),
                pieza.getFechaCreacion()

            });

        }
        
        scrollPane = new JScrollPane(tabla);
        scrollPane.setBounds(0,0,1000,600);
        this.add(scrollPane);
    }

    public void actualizarTabla(List<PiezaBD> listaActualizada) {
        
        tablaModelo.setRowCount(0); // Limpia el contenido de la tabla

        for (PiezaBD pieza : listaActualizada) {
            tablaModelo.addRow(new Object[]{
                pieza.getIdPieza(),
                pieza.getTipoPieza(),
                pieza.getDescripcion(),
                pieza.getNombrePosicion(),
                pieza.getMovimiento(),
                pieza.getComportamiento(),
                pieza.getColor(),
                pieza.getTamanio(),
                pieza.getMaterial(),
                pieza.getFechaCreacion()
            });
        }
    }
}
