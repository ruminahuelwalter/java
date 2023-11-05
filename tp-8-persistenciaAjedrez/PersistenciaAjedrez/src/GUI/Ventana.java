package GUI;

import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import AccesoDatos.*;
import Logica.*;

// BORRAR
public class Ventana extends JFrame {
    
    private JTable tabla;
    private JScrollPane scrollPane;
    // se especifica el tamaño de la tabla
    DefaultTableModel tablaModelo = new DefaultTableModel();

    public Ventana() {

        setLayout(null);
        tabla = new JTable();
        tabla.setBounds(30,30,300,200);
        add(tabla);
        
        scrollPane = new JScrollPane(tabla);
        scrollPane.setBounds(30,50,800,600);
        add(scrollPane);
        
        iPiezaDAO iPiezaA = new PiezaDAO();
        
        List<PiezaBD> lista = iPiezaA.listar();
        
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
    }

    public void ventanaBasica() {
        Ventana ventana = new Ventana();
        ventana.setTitle("Ajedrez");

        ventana.setBounds(0,0,900,700);
        // 0,0 sin separacion en izquierda y derecha, pero si ancho y alto
        ventana.setVisible(true);
        ventana.setResizable(true); // el usuario no puede mod la dimension de la interfaz
        ventana.setLocationRelativeTo(null); // al centro de la pantalla  
    }

    
}
