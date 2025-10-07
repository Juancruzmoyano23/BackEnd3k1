package entities;

import jakarta.persistence.*; // importaciones necesarias para las anotaciones
import java.time.LocalDate; // importacion para LocalDate
import lombok.*;


@Entity
@Tabla(name = "empleado")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nombre;

    private String edad;

    @Columna(name = "fecha_ingreso")
    private LocalDate fechaIngreso; // formato dd/MM/yyyy

    @Columna(name = "empleado_fijo")
    private double empleadoFijo; // true si es empleado fijo, false si es contratado

    @ManyToOne(fetch = FechType.EAGER) // muchos empleados pueden tener un mismo departamento
    @JoinColumn(name = "departamento_id") // columna que hace de llave foranea en la tabla empleado
    private Departamento departamento;

    @ManyToOne(fetch = FectType.EAGER) // muchos empleados pueden tener un mismo puesto
    @JoinColumn(name = "puesto_id") // columna que hace de llave foranea en la tabla empleado
    private Puesto puesto;

    public double calcularSalario(){
        return empleadoFijo ? salario * 1.08 : salario; // si es empleado fijo, se le suma un 8% al salario
    }
}
