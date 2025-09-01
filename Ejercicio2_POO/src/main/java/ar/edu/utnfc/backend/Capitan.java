package ar.edu.utnfc.backend;

public class Capitan {
    private String id;
    private String nombre;
    private String apellido;
    private int antiguedad;

    public Capitan(String id, String nombre, String apellido, int antiguedad) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.antiguedad = antiguedad;
    }

    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public String getApellido() { return apellido; }
    public int getAntiguedad() { return antiguedad; }

    @Override
    public String toString() {
        return "Capitan{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", antiguedad=" + antiguedad +
                '}';
    }
}