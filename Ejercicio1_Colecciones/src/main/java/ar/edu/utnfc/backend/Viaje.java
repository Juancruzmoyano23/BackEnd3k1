package ar.edu.utnfc.backend;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Viaje {
    private String codigo;
    private int nroReserva;
    private double precio;
    private int tipo;
    private Cliente cliente;
}
