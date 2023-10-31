package GUI;

import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import AccesoDatos.PiezaDAO;
import Logica.PiezaBD;
import Logica.iPieza;

public class Interfaz extends JFrame {
    
    private JTable tabla;
    private JScrollPane scrollPane;
    // se especifica el tamaño de la tabla
    DefaultTableModel modelo = new DefaultTableModel();

    public Interfaz() {

        setLayout(null);
        tabla = new JTable();
        tabla.setBounds(30,30,300,200);        
        add(tabla);

        scrollPane = new JScrollPane(tabla);
        scrollPane.setBounds(30,50,800,600);
        add(scrollPane);

        iPieza iPiezaA = new PiezaDAO();
        // List<PiezaBD> lista = iPiezaA.mostrarPiezasBD();
        List<PiezaBD> lista = iPiezaA.listarPiezasBD();
        
        modelo.setColumnIdentifiers(new Object[]{
            "idTipoPieza",
            "Pieza", 
            "Movimiento", 
            "Comportamiento" , 
            "Color", 
            "Tamaño", 
            "Material", 
            "Fecha de creación"
        });
        
        tabla.setModel(modelo);

        modelo.setRowCount(0);
        for (PiezaBD pieza : lista) {
            modelo.addRow(new Object[]{
                pieza.getIdPieza(),
                pieza.getTipoPieza(),
                pieza.getMovimiento(),
                pieza.getComportamiento(),
                pieza.getColor(),
                pieza.getTamanio(),
                pieza.getMaterial(),
                pieza.getFechaCreacion(),

            });

        }
    }

   

}
