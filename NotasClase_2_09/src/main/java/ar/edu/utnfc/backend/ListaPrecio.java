package ar.edu.utnfc.backend;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ListaPrecio {
    private int codigo;
    private String desc;
    private double precioUnitario;
    private double doc;
}
