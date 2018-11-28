package co.com.devco.devco.model;

public class Persona {

    private String nombre;
    private String apelido;
    private int edad;

    public Persona() {

    }

    public Persona(String nombre, String apelido, int edad) {
        this.nombre = nombre;
        this.apelido = apelido;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
}
