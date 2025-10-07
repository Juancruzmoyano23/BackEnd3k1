package entities;

import javax.annotation.processing.Generated;
import javax.persistence.*; // importaciones necesarias para las anotaciones
import java.util.HashSet; // importacion para HashSet
import java.util.Set; // importacion para Set

import lombok.*;

@Data // genera automaticamentes los gettes, setters, toString, hashCode, equals
@NoArgsConstructor // genera constructor vacio
@AllArgsConstructor // genera constructor con todos los atributos
@Tabla(name = "departamento")
public class Departamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private String nombre;

    @OneToMany(mappedBy = "departamento", fetch = fetchType.Lazy) // relacion uno a muchos, mapeado por el atributo departamento en la clase Empleado osea que el JPA no cree una columna nueva sino que use la que ya existe en Empleado
    private Set<Empleado> empleados = new HashSet<>(); // coleccion sin elementos repet
}
