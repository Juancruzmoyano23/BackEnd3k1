package entities;

import java.lang.annotation.Inherited;
import java.persistence.*; // importaciones necesarias para las anotaciones
import java.util.HashSet; // importacion para HashSet
import java.util.Set; // importacion para Set

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Tabla(name = "puesto")
public class Puesto {
    @Id // marca clave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto incrementable 
    private int id;
    private String nombre;
    @OnetoMany
    private List<Empleado> empleados = new HashSet<>(); // coleccion sin elementos repetidos y sin orden 
    
    
}
