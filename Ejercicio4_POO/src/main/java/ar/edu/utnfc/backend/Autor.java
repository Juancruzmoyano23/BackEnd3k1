package ar.edu.utnfc.backend;

public class Autor {
    private String id;
    private String nombre;
    private String apellido;
    private int aniosCarrera;

    public Autor(String id, String nombre, String apellido, int aniosCarrera) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.aniosCarrera = aniosCarrera;
    }

    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public String getApellido() { return apellido; }
    public int getAniosCarrera() { return aniosCarrera; }

    @Override
    public String toString() {
        return nombre + " " + apellido + " (" + aniosCarrera + " años)";
    }
}
