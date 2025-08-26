package ar.edu.utnfc.backend;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Capitan {
    private int id;
    private String nombre;
    private String apellido;
    private int antiguedad;
}
