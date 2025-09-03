package ar.edu.utnfc.backend;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)

public class Maritimo extends Viaje {
    private int cantidadContenedores;
    private double costoPorKilo;
    private double pesoTransportado;

    private Maritimo(String codigo, int nroReserva,double precio, int tipo, Cliente cliente, int cantidadContenedores, double costoPorKilo, double pesoTransportado){
        super(codigo, nroReserva, precio, tipo, cliente);
        this.cantidadContenedores = cantidadContenedores;
        this.costoPorKilo = costoPorKilo;
        this.pesoTransportado = pesoTransportado;
    }
}
