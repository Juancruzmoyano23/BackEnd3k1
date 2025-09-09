package ar.edu.utnfc.backend;

public class Aereo extends Viaje {
    private int millasAcumuladas;
    private String codAerolinea;

    public Aereo(String codigo, int nroReserva, double precio, int tipo, Cliente cliente, int millasAcumuladas, String codAerolinea) {
        super(codigo, nroReserva, precio, tipo, cliente);
        this.millasAcumuladas = millasAcumuladas;
        this.codAerolinea = codAerolinea;
    }

    public int getMillasAcumuladas() {
        return millasAcumuladas;
    }

    public void setMillasAcumuladas(int millasAcumuladas) {
        this.millasAcumuladas = millasAcumuladas;
    }

    public String getCodAerolinea() {
        return codAerolinea;
    }

    public void setCodAerolinea(String codAerolinea) {
        this.codAerolinea = codAerolinea;
    }
}
