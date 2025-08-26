package ar.edu.utnfc.backend;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Barco {
    private String matricula;
    private int muelle;
    private double capacidadCargaToneladas;
    private double costoAlquilerHora;
    private Capitan capitan;
}
