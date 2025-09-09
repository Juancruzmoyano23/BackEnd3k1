package ar.edu.utnfc.backend;

public class Terrestre extends Viaje {
    private int provinciasVisitadas;
    private int cantidadPasajeros;

    public Terrestre(String codigo, int nroReserva, double precio, int tipo, Cliente cliente, int provinciasVisitadas, int cantidadPasajeros) {
        super(codigo, nroReserva, precio, tipo, cliente);
        this.provinciasVisitadas = provinciasVisitadas;
        this.cantidadPasajeros = cantidadPasajeros;
    }

    public int getProvinciasVisitadas() {
        return provinciasVisitadas;
    }

    public void setProvinciasVisitadas(int provinciasVisitadas) {
        this.provinciasVisitadas = provinciasVisitadas;
    }

    public int getCantidadPasajeros() {
        return cantidadPasajeros;
    }

    public void setCantidadPasajeros(int cantidadPasajeros) {
        this.cantidadPasajeros = cantidadPasajeros;
    }
}
