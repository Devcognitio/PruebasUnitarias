package co.com.devco.devco.model;

public class Control {

    private String identificador;
    private String descripcion;

    public Control(String identificador, String descripcion) {
        this.identificador = identificador;
        this.descripcion = descripcion;
    }


    public String getIdentificador(){
       return this.identificador;
    }

    public String getDescripcion(){
        return this.descripcion;
    }

    public void setIdentificador(String identificador){
        this.identificador = identificador;
    }

    public void setDescripcion(String descripcion){
        this.descripcion = descripcion;
    }

}
