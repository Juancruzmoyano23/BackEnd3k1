package ar.edu.utnfc.backend;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)

public class Terrestre extends Viaje {
    private int provinciasVisitadas;
    private int cantidadPasajeros;


    private Terrestre(String codigo, int nroReserva,double precio, int tipo, Cliente cliente, int provinciasVisitadas, int cantidadPasajeros){
        super(codigo, nroReserva, precio, tipo, cliente);
        this.provinciasVisitadas = provinciasVisitadas;
        this.cantidadPasajeros = cantidadPasajeros;
    }
}
