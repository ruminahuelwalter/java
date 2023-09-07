package Logica;

public class Tigre {
    //! ATRIBUTOS
    private String comportamiento;
    private String peligrosidad;
    private String vitalidad;
    private String instinto;
    private String apariencia;

    //* CONSTRUCTOR POR DEFECTO 
    public Tigre(){
    }

    //* CONSTRUCTOR CON ARGUMENTOS
    public Tigre(String comportamiento, String peligrosidad, String vitalidad, String instinto, String aparienecia){
        this.comportamiento = comportamiento;
        this.peligrosidad = peligrosidad;
        this.vitalidad = vitalidad;
        this.instinto = instinto;
        this.apariencia = aparienecia;
    }

    //? GETTERS Y SETTERS
    public String getComportamiento() {
        return comportamiento;
    }

    public void setComportamiento(String comportamiento) {
        this.comportamiento = comportamiento;
    }

    public String getPeligrosidad() {
        return peligrosidad;
    }
    
    public void setPeligrosidad(String peligrosidad) {
        this.peligrosidad = peligrosidad;
    }
    
    public String getVitalidad() {
        return vitalidad;
    }
    
    public void setVitalidad(String vitalidad) {
        this.vitalidad = vitalidad;
    }
    
    public String getInstinto() {
        return instinto;
    }

    public void setInstinto(String instinto) {
        this.instinto = instinto;
    }

    public String getApariencia() {
        return apariencia;
    }

    public void setApariencia(String apariencia) {
        this.apariencia = apariencia;
    }

}
