package GUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import AccesoDatos.CotizacionDAO;
import Logica.*;


public class VentanaDetalleCotizacion extends JFrame implements ActionListener, ItemListener{
    
    private JPanel panelTitulo, panelPrincipal, panelSur;
    private JLabel labelTitulo, labelTipo, labelMarca, labelModelo, labelAnio, labelPatente, labelColor, labelTipoTransmision, labelCantPlazas, labelCapacidadBaul, labelPMA;
    private JLabel labelVehiculoTipo, labelVehiculoMarca, labelVehiculoModelo, labelVehiculoAnio, labelVehiculoPatente, labelVehiculoColor, labelVehiculoTipoTransmision, labelVehiculoCantPlazas, labelVehiculoCapacidadBaul, labelVehiculoPMA;
    private JButton botonAceptar, botonCancelar;
    private GridBagConstraints gridBag;
    private VehiculoBD vehiculoBD;
    private int cantidadDias;

    public VentanaDetalleCotizacion(VehiculoBD vehiculo,int cantDias, Tabla tabla) {

        this.setBounds(0, 0, 800, 600);
        this.setLayout(new BorderLayout());
        this.setTitle("Detalle Vehiculo");
        this.setResizable(true);
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(new Color(30,136,229));

        this.vehiculoBD = vehiculo;
        this.cantidadDias = cantDias;
        
        panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new GridBagLayout());
        this.add(panelPrincipal, BorderLayout.CENTER);

        panelTitulo = new JPanel();
        panelTitulo.setBorder(new EmptyBorder(10, 0, 10, 0));
        this.add(panelTitulo, BorderLayout.NORTH);
        labelTitulo = new JLabel("<html><center>Detalle de vehiculo:</center></html>", JLabel.CENTER);
        labelTitulo.setFont(new Font("Hack Nerd Font", 1, 30));
        panelTitulo.add(labelTitulo);

        labelTipo = new JLabel("Tipo:");
        labelTipo.setFont(new Font("Hack nerd font", 1, 20));

        labelVehiculoTipo = new JLabel();
        labelVehiculoTipo.setFont(new Font("Hack nerd font", 1, 20));
        labelVehiculoTipo.setText(vehiculo.getTipoVehiculo());

        labelMarca = new JLabel("Marca:");
        labelMarca.setFont(new Font("Hack nerd font", 1, 20));
        labelVehiculoMarca = new JLabel();
        labelVehiculoMarca.setFont(new Font("Hack nerd font", 1, 20));
        labelVehiculoMarca.setText(vehiculo.getMarca());

        labelModelo = new JLabel("Modelo:");
        labelModelo.setFont(new Font("Hack nerd font", 1, 20));
        labelVehiculoModelo = new JLabel();
        labelVehiculoModelo.setFont(new Font("Hack nerd font", 1, 20));
        labelVehiculoModelo.setText(vehiculo.getModelo());

        labelAnio = new JLabel("Año de fabricacion:");
        labelAnio.setFont(new Font("Hack nerd font", 1, 20));
        String anio =  String.valueOf(vehiculo.getAnioFabricacion());
        labelVehiculoAnio = new JLabel();
        labelVehiculoAnio.setFont(new Font("Hack nerd font", 1, 20));
        labelVehiculoAnio.setText(anio);

        labelPatente = new JLabel("Patente:");
        labelPatente.setFont(new Font("Hack nerd font", 1, 20));
        labelVehiculoPatente = new JLabel();
        labelVehiculoPatente.setFont(new Font("Hack nerd font", 1, 20));
        labelVehiculoPatente.setText(vehiculo.getPatente());

        labelColor = new JLabel("Color:");
        labelColor.setFont(new Font("Hack nerd font", 1, 20));
        labelVehiculoColor = new JLabel();
        labelVehiculoColor.setFont(new Font("Hack nerd font", 1, 20));
        labelVehiculoColor.setText(vehiculo.getColor());

        labelTipoTransmision = new JLabel("Tipo de transmision:");
        labelTipoTransmision.setFont(new Font("Hack nerd font", 1, 20));
        labelVehiculoTipoTransmision = new JLabel();
        labelVehiculoTipoTransmision.setFont(new Font("Hack nerd font", 1, 20));
        labelVehiculoTipoTransmision.setText(vehiculo.getTipoTransmision());
        
        labelCantPlazas = new JLabel("Cantidad de plazas:");
        labelCantPlazas.setFont(new Font("Hack nerd font", 1, 20));
        String cantPlazas =  String.valueOf(vehiculo.getCantPlazas());
        labelVehiculoCantPlazas = new JLabel();
        labelVehiculoCantPlazas.setFont(new Font("Hack nerd font", 1, 20));;
        labelVehiculoCantPlazas.setText(cantPlazas);        

        labelCapacidadBaul = new JLabel("Capacidad de baul:");
        labelCapacidadBaul.setFont(new Font("Hack nerd font", 1, 20));

        String capBaul =  String.valueOf(vehiculo.getCantPlazas());
        labelVehiculoCapacidadBaul = new JLabel();
        labelVehiculoCapacidadBaul.setFont(new Font("Hack nerd font", 1, 20));
        labelVehiculoCapacidadBaul.setText(capBaul);

        labelPMA = new JLabel("Peso maximo autorizado:");
        labelPMA.setFont(new Font("Hack nerd font", 1, 20));
        
        Double pmaAux = asiganarPMA(vehiculo);
        float pma = pmaAux.floatValue();
        vehiculo.setPma(pma);
        String pmaString = Float.toString(vehiculo.getPma());
        labelVehiculoPMA = new JLabel();
        labelVehiculoPMA.setFont(new Font("Hack nerd font", 1, 20));
        labelVehiculoPMA.setText(pmaString);  

        gridBag = new GridBagConstraints();
        gridBag.anchor = GridBagConstraints.EAST;
        gridBag.insets.right = 50;
        gridBag.insets.left = 0;
        //gridBag.insets.bottom = 10;
        gridBag.gridwidth = 1;
        gridBag.weightx = 1;
        gridBag.weighty = 1;

        gridBag.gridx = 0; //columna
        gridBag.gridy = 0;  //fila
        panelPrincipal.add(labelTipo, gridBag);

        gridBag.gridx = 1;
        gridBag.gridy = 0;
        gridBag.fill = GridBagConstraints.NONE;
        gridBag.anchor = GridBagConstraints.WEST;
        panelPrincipal.add(labelVehiculoTipo, gridBag);
        
        gridBag.gridx = 0;
        gridBag.gridy = 1;
        gridBag.fill = GridBagConstraints.NONE;
        gridBag.anchor = GridBagConstraints.EAST;
        panelPrincipal.add(labelMarca, gridBag);

        gridBag.gridx = 1;
        gridBag.gridy = 1;
        gridBag.fill = GridBagConstraints.NONE;
        gridBag.anchor = GridBagConstraints.WEST;
        panelPrincipal.add(labelVehiculoMarca, gridBag);


        gridBag.gridx = 0;
        gridBag.gridy = 2;
        gridBag.fill = GridBagConstraints.NONE;
        gridBag.anchor = GridBagConstraints.EAST;
        panelPrincipal.add(labelModelo, gridBag);

        gridBag.gridx = 1;
        gridBag.gridy = 2;
        gridBag.fill = GridBagConstraints.NONE;
        gridBag.anchor = GridBagConstraints.WEST;
        panelPrincipal.add(labelVehiculoModelo, gridBag);

        gridBag.gridx = 0;
        gridBag.gridy = 3;
        gridBag.fill = GridBagConstraints.NONE;
        gridBag.anchor = GridBagConstraints.EAST;
        panelPrincipal.add(labelAnio, gridBag);

        gridBag.gridx = 1;
        gridBag.gridy = 3;
        gridBag.fill = GridBagConstraints.NONE;
        gridBag.anchor = GridBagConstraints.WEST;
        panelPrincipal.add(labelVehiculoAnio, gridBag);


        gridBag.gridx = 0;
        gridBag.gridy = 4;
        gridBag.fill = GridBagConstraints.NONE;
        gridBag.anchor = GridBagConstraints.EAST;
        panelPrincipal.add(labelPatente, gridBag);

        gridBag.gridx = 1;
        gridBag.gridy = 4;
        gridBag.fill = GridBagConstraints.NONE;
        gridBag.anchor = GridBagConstraints.WEST;
        panelPrincipal.add(labelVehiculoPatente, gridBag);

        gridBag.gridx = 0;
        gridBag.gridy = 5;
        gridBag.fill = GridBagConstraints.NONE;
        gridBag.anchor = GridBagConstraints.EAST;
        panelPrincipal.add(labelColor, gridBag);

        gridBag.gridx = 1;
        gridBag.gridy = 5;
        gridBag.fill = GridBagConstraints.NONE;
        gridBag.anchor = GridBagConstraints.WEST;
        panelPrincipal.add(labelVehiculoColor, gridBag);
        
        gridBag.gridx = 0;
        gridBag.gridy = 6;
        gridBag.fill = GridBagConstraints.NONE;
        gridBag.anchor = GridBagConstraints.EAST;
        panelPrincipal.add(labelTipoTransmision, gridBag);

        gridBag.gridx = 1;
        gridBag.gridy = 6;
        gridBag.fill = GridBagConstraints.NONE;
        gridBag.anchor = GridBagConstraints.WEST;
        panelPrincipal.add(labelVehiculoTipoTransmision, gridBag);

        gridBag.gridx = 0;
        gridBag.gridy = 7;
        gridBag.fill = GridBagConstraints.NONE;
        gridBag.anchor = GridBagConstraints.EAST;
        panelPrincipal.add(labelCantPlazas, gridBag);

        gridBag.gridx = 1;
        gridBag.gridy = 7;
        gridBag.fill = GridBagConstraints.NONE;
        gridBag.anchor = GridBagConstraints.WEST;
        panelPrincipal.add(labelVehiculoCantPlazas, gridBag);
        
        gridBag.gridx = 0;
        gridBag.gridy = 8;
        gridBag.fill = GridBagConstraints.NONE;
        gridBag.anchor = GridBagConstraints.EAST;
        panelPrincipal.add(labelCapacidadBaul, gridBag);

        gridBag.gridx = 1;
        gridBag.gridy = 8;
        gridBag.fill = GridBagConstraints.NONE;
        gridBag.anchor = GridBagConstraints.WEST;
        panelPrincipal.add(labelVehiculoCapacidadBaul, gridBag);
        
        gridBag.gridx = 0;
        gridBag.gridy = 9;
        gridBag.fill = GridBagConstraints.NONE;
        gridBag.anchor = GridBagConstraints.EAST;
        panelPrincipal.add(labelPMA, gridBag);

        gridBag.gridx = 1;
        gridBag.gridy = 9;
        gridBag.fill = GridBagConstraints.NONE;
        gridBag.anchor = GridBagConstraints.WEST;
        panelPrincipal.add(labelVehiculoPMA, gridBag);



        JLabel labelCantidadDias = new JLabel("Cantidad de dias:");
        labelCantidadDias.setFont(new Font("Hack nerd font", 1, 20));
    
        String cantidDias= String.valueOf(cantDias);
        JLabel labelCantDias = new JLabel();
        labelCantDias.setFont(new Font("Hack nerd font", 1, 20));
        labelCantDias.setText(cantidDias);

        JLabel labelPrecio = new JLabel("Precio:");
        labelPrecio.setFont(new Font("Hack nerd font", 1, 20));
        
        Double cotizacion = calculoCotizacion(vehiculo, cantDias);

        String cotiz = Double.toString(cotizacion);
        JLabel labelCotizacion = new JLabel();
        labelCotizacion.setFont(new Font("Hack nerd font", 1, 20));
        labelCotizacion.setText(cotiz);

        gridBag.gridx = 0;
        gridBag.gridy = 10;
        gridBag.fill = GridBagConstraints.NONE;
        gridBag.anchor = GridBagConstraints.EAST;
        panelPrincipal.add(labelCantidadDias, gridBag);

        gridBag.gridx = 1;
        gridBag.gridy = 10;
        gridBag.fill = GridBagConstraints.NONE;
        gridBag.anchor = GridBagConstraints.WEST;
        panelPrincipal.add(labelCantDias, gridBag);

        gridBag.gridx = 0;
        gridBag.gridy = 11;
        gridBag.fill = GridBagConstraints.NONE;
        gridBag.anchor = GridBagConstraints.EAST;
        panelPrincipal.add(labelPrecio, gridBag);

        gridBag.gridx = 1;
        gridBag.gridy = 11;
        gridBag.fill = GridBagConstraints.NONE;
        gridBag.anchor = GridBagConstraints.WEST;
        panelPrincipal.add(labelCotizacion, gridBag);

        
        panelSur = new JPanel();
        panelSur.setBorder(new EmptyBorder(20, 0, 20, 0));
        this.add(panelSur, BorderLayout.SOUTH);

        botonAceptar = new JButton("Aceptar");
        botonAceptar.setVisible(true);
        botonAceptar.setFont(new Font("Hack nerd font", 1, 20));
        botonAceptar.setPreferredSize(new Dimension(200, 40));
        panelSur.add(botonAceptar);
        botonAceptar.addActionListener(this);

        botonCancelar = new JButton("Cancelar");
        botonCancelar.setVisible(true);
        botonCancelar.setFont(new Font("Hack nerd font", 1, 20));
        botonCancelar.setPreferredSize(new Dimension(200, 40));
        panelSur.add(botonCancelar);
        botonCancelar.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == botonAceptar) {
            // se instancia un objeto cotizador
            // y se agrega la cotizacion a la base de datos
            CotizacionDAO iCotizacionDAO = new CotizacionDAO();
            Cotizacion cotizacion = new Cotizacion();

            cotizacion.setVehiculoBD(vehiculoBD);
            cotizacion.setDiasCotizados(cantidadDias);
            cotizacion.setPrecioCotizacion(calculoCotizacion(vehiculoBD, cantidadDias));
            iCotizacionDAO.insertar(cotizacion);

            this.dispose();
        }

        if (e.getSource() == botonCancelar) {
            this.dispose();
        }
    }


    @Override
    public void itemStateChanged(ItemEvent e) {
   
    }

    public Double asiganarPMA(VehiculoBD vehiculoBD){
        String tipo = vehiculoBD.getTipoVehiculo().toLowerCase();
   
        Double pma;

        switch (tipo) {
            case "auto":
                pma = (double) 0;
                break;
            case "minibus":
                pma = (double) 0;
                break;
            case "furgoneta":
                Furgoneta furgoneta = new Furgoneta();
                pma = furgoneta.getPma();
                break;
            case "camion":
                Camion camion = new Camion();
                pma = camion.getPma();
                break;
            default:
                pma =(double) 0;
                break;
        }
        return pma;

    }

    public Double calculoCotizacion(VehiculoBD vehiculoBD, int cantDias) {

        String tipo = vehiculoBD.getTipoVehiculo().toLowerCase();
   
        Vehiculo vehiculo;
        Double resultado;

        switch (tipo) {
            case "auto":
                vehiculo = new Auto();
                resultado = vehiculo.calcularAlquiler(cantDias);
                break;
            case "minibus":
                vehiculo = new Minibus();
                resultado = vehiculo.calcularAlquiler(cantDias);
                break;
            case "furgoneta":
                vehiculo = new Furgoneta();
                resultado = vehiculo.calcularAlquiler(cantDias);
                break;
            case "camion":
                vehiculo = new Camion();
                resultado = vehiculo.calcularAlquiler(cantDias);
                break;
            default:
                vehiculo = null;
                resultado =(double) 0;
                break;
        }
        return resultado;
    }
}