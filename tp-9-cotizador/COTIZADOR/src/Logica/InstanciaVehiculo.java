package Logica;

public class InstanciaVehiculo {
    //public enum VehiculoCotizado{Auto, Minibus, Furgoneta, Camion};

    public Vehiculo crear(String tipo) {
        Vehiculo vehiculo;
        switch (tipo) {
            case "auto":
                vehiculo = new Auto();
                break;
            case "minibus":
                vehiculo = new Minibus();
                break;
            case "furgoneta":
                vehiculo = new Furgoneta();
                break;
            case "camion":
                vehiculo = new Camion();
            default:
                vehiculo = null;
                break;
        }
        return vehiculo;
    }

}
