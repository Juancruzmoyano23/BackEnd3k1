package main.java.ar.edu.utnfc.backend;
import java.sql.Date;
import java.time.Duration;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Viaje {

    private int id_viaje;          // identificador único del viaje
    private String linea;          // nombre de la línea de tren
    private String origen;         // estación de salida
    private String destino;        // estación de llegada
    private String horario_salida; // formato HH:mm
    private String horario_llegada;// formato HH:mm
    private int pasajeros;         // cantidad de pasajeros
    private int duracion;          // Duración en minutos

    // formateo las fechas a formato HH:MM
    private static final DateTimeFormatter tiempoFormateado = DateTimeFormatter.ofPattern("HH:mm");

    // Constructor vacío
    public Viaje() {
    }

    // Constructor con todos los parámetros
    public Viaje(int id_viaje, String linea, String origen, String destino,
                 String horario_salida, String horario_llegada,
                 int pasajeros) {
        this.id_viaje = id_viaje;
        this.linea = linea;
        this.origen = origen;
        this.destino = destino;
        this.horario_salida = horario_salida;
        this.horario_llegada = horario_llegada;
        this.pasajeros = pasajeros;
        this.duracion = calcularDuracion();
    }

    // Getters y Setters
    public int getId_viaje() { return id_viaje; }
    public void setId_viaje(int id_viaje) { this.id_viaje = id_viaje; }

    public String getLinea() { return linea; }
    public void setLinea(String linea) { this.linea = linea; }

    public String getOrigen() { return origen; }
    public void setOrigen(String origen) { this.origen = origen; }

    public String getDestino() { return destino; }
    public void setDestino(String destino) { this.destino = destino; }

    public String getHorario_salida() { return horario_salida; }
    public void setHorario_salida(String horario_salida) { this.horario_salida = horario_salida; }

    public String getHorario_llegada() { return horario_llegada; }
    public void setHorario_llegada(String horario_llegada) { this.horario_llegada = horario_llegada; }

    public int getPasajeros() { return pasajeros; }
    public void setPasajeros(int pasajeros) { this.pasajeros = pasajeros; }

    // Método para calcular la duración del viaje en minutos
    public int calcularDuracion(){
        return (int) Duration.between(
                java.time.LocalTime.parse(this.horario_salida, tiempoFormateado),
                java.time.LocalTime.parse(this.horario_llegada, tiempoFormateado)
        ).toMinutes();
    }

    // getter y setter de duracion
    public int getDuracion() { return duracion; }
    public void setDuracion(int duracion) { this.duracion = duracion; }


    // toString
    @Override
    public String toString() {
        return "Viaje{" +
                "id_viaje=" + id_viaje +
                ", linea='" + linea + '\'' +
                ", origen='" + origen + '\'' +
                ", destino='" + destino + '\'' +
                ", horario_salida='" + horario_salida + '\'' +
                ", horario_llegada='" + horario_llegada + '\'' +
                ", pasajeros=" + pasajeros +
                ", duracion=" + duracion +
                '}';
    }
}

