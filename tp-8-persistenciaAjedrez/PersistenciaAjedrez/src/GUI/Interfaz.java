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
        tabla.setBounds(20,20,200,100);        
        add(tabla);

        scrollPane = new JScrollPane(tabla);
        scrollPane.setBounds(10,50,400,300);
        add(scrollPane);

        iPieza iPiezaA = new PiezaDAO();
        List<PiezaBD> lista = iPiezaA.mostrarPiezasBD();
        
        modelo.setColumnIdentifiers(new Object[]{"idTipoPieza", "Pieza"});
        tabla.setModel(modelo);

        modelo.setRowCount(0);
        for (PiezaBD pieza : lista) {
            modelo.addRow(new Object[]{
                pieza.getIdPieza(),
                pieza.getTipoPieza()
            });

        }
    }

   

}
