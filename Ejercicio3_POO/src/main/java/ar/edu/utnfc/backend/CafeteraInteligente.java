package ar.edu.utnfc.backend;

public class CafeteraInteligente {
    private String marca;
    private String modelo;
    private int capacidadMaxima;
    private int contenidoActual;
    private boolean encendida;
    private int cafesServidos;
    private int temperatura;

    public CafeteraInteligente(String marca, String modelo, int capacidadMaxima) {
        this.marca = marca;
        this.modelo = modelo;
        this.capacidadMaxima = capacidadMaxima;
        this.contenidoActual = 0;
        this.encendida = false;
        this.cafesServidos = 0;
        this.temperatura = 20;
    }

    public void encender() {
        encendida = true;
        temperatura = 20;
        contenidoActual = 0;
    }

    public void apagar() {
        encendida = false;
        cafesServidos = 0;
    }

    public void cargarAgua(int ml) {
        if (encendida) {
            contenidoActual += ml;
            if (contenidoActual > capacidadMaxima) {
                contenidoActual = capacidadMaxima;
            }
        }
    }

    public void calentar() {
        if (encendida) {
            temperatura += 40;
            if (temperatura > 100) {
                temperatura = 100;
            }
        }
    }

    public boolean servirCafe() {
        if (encendida && contenidoActual >= 100 && temperatura >= 90) {
            contenidoActual -= 100;
            cafesServidos++;
            return true;
        }
        return false;
    }

    @Override 
    public String toString() {
        return "Cafetera " + marca + " " + modelo +
                " - Agua: " + contenidoActual + "ml, Temperatura: " + temperatura + "°C, Servidos: " +
                cafesServidos + ", Estado: " + (encendida ? "encendida" : "apagada");
    }

    // Getters y setters opcionales si los necesitas
}
