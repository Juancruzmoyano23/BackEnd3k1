package ar.edu.utnfc.backend;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)

public class Aereo extends Viaje {
    private int millasAcumuladas;
    private String codAerolinea;

    private Aereo(String codigo, int nroReserva,double precio, int tipo, Cliente cliente, int millasAcumuladas, String codAerolinea){
        super(codigo, nroReserva, precio, tipo, cliente);
        this.millasAcumuladas = millasAcumuladas;
        this.codAerolinea = codAerolinea;
    }

}
