package ar.edu.utnfc.backend;

public class Maritimo extends Viaje {
    private int cantidadContenedores;
    private double costoPorKilo;
    private double pesoTransportado;

    public Maritimo(String codigo, int nroReserva, double precio, int tipo, Cliente cliente, int cantidadContenedores, double costoPorKilo, double pesoTransportado) {
        super(codigo, nroReserva, precio, tipo, cliente);
        this.cantidadContenedores = cantidadContenedores;
        this.costoPorKilo = costoPorKilo;
        this.pesoTransportado = pesoTransportado;
    }

    public int getCantidadContenedores() {
        return cantidadContenedores;
    }

    public void setCantidadContenedores(int cantidadContenedores) {
        this.cantidadContenedores = cantidadContenedores;
    }

    public double getCostoPorKilo() {
        return costoPorKilo;
    }

    public void setCostoPorKilo(double costoPorKilo) {
        this.costoPorKilo = costoPorKilo;
    }

    public double getPesoTransportado() {
        return pesoTransportado;
    }

    public void setPesoTransportado(double pesoTransportado) {
        this.pesoTransportado = pesoTransportado;
    }

    // Método para calcular el costo total del viaje marítimo
    public double calcularCostoTotal() {
        return costoPorKilo * pesoTransportado;
    }
}
