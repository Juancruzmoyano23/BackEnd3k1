package Ejercicio5_POO_ClientesApp.src.main.java.ar.edu.utnfc.backend;

public class Cliente {
    private String nombre;
    private int dni;
    private short edad;
    private String ocupacion;
    private int cantidadPosteos;
    private float horasEnPlataforma;
    private boolean verificado;

    // constructor
    public Cliente(String nombre, int dni, short edad, String ocupacion, int cantidadPosteos, float horasEnPlataforma, boolean verificado) {
        this.nombre = nombre;
        this.dni = dni;
        this.edad = edad;
        this.ocupacion = ocupacion;
        this.cantidadPosteos = cantidadPosteos;
        this.horasEnPlataforma = horasEnPlataforma;
        this.verificado = verificado;
    }

    // getters and setters 

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getDni() {
        return dni;
    }
    public void setDni(int dni) {
        this.dni = dni;
    }
    public short getEdad() {
        return edad;
    }
    public void setEdad(short edad) {
        this.edad = edad;
    }
    public String getOcupacion() {
        return ocupacion;
    }
    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }
    public int getCantidadPosteos() {
        return cantidadPosteos;
    }
    public void setCantidadPosteos(int cantidadPosteos) {
        this.cantidadPosteos = cantidadPosteos;
    }
    public float getHorasEnPlataforma() {
        return horasEnPlataforma;
    }
    public void setHorasEnPlataforma(float horasEnPlataforma) {
        this.horasEnPlataforma = horasEnPlataforma;
    }

    public boolean isVerificado() {
        return verificado;
    }

    public void setVerificado(boolean verificado) {
        this.verificado = verificado;
    }

    // metodo para calcular la puntuacion del cliente
    public double calcularPuntuacion() {
        double base = (edad > 25) ? (horasEnPlataforma * 2) : (horasEnPlataforma * 3);
        if (verificado) {
            base += 20;
        }
        return base;
    }


    // metodo toString
    @Override
    public String toString() {
        return "Cliente [nombre=" + nombre + ", dni=" + dni + ", edad=" + edad + ", ocupacion=" + ocupacion
                + ", cantidadPosteos=" + cantidadPosteos + ", horasEnPlataforma=" + horasEnPlataforma
                + ", verificado=" + verificado + "]";
    }

}