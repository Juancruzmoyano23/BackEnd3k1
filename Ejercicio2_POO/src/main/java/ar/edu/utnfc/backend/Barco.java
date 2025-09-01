package ar.edu.utnfc.backend;

public class Barco {
    private String matricula;
    private int muelle;
    private double capacidadCargaToneladas;
    private double costoAlquilerHora;
    private Capitan capitan;

    public Barco(String matricula, int muelle, double capacidadCargaToneladas, double costoAlquilerHora, Capitan capitan) {
        this.matricula = matricula;
        this.muelle = muelle;
        this.capacidadCargaToneladas = capacidadCargaToneladas;
        this.costoAlquilerHora = costoAlquilerHora;
        this.capitan = capitan;
    }

    public String getMatricula() { return matricula; }
    public int getMuelle() { return muelle; }
    public double getCapacidadCargaToneladas() { return capacidadCargaToneladas; }
    public double getCostoAlquilerHora() { return costoAlquilerHora; }
    public Capitan getCapitan() { return capitan; }

    @Override
    public String toString() {
        return "Barco{" +
                "matricula='" + matricula + '\'' +
                ", muelle=" + muelle +
                ", capacidadCargaToneladas=" + capacidadCargaToneladas +
                ", costoAlquilerHora=" + costoAlquilerHora +
                ", capitan=" + capitan +
                '}';
    }
}