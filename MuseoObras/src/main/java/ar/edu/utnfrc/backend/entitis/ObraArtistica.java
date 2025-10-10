package ar.edu.utnfrc.backend.entitis;

import jakarta.persistence.*; // importo las anotaciones de JPA (Entity, Id, ManyToOne, JoinColumn, GeneratedValue, GenerationType)
import lombok.*; // importo las anotaciones de Lombok (Data, AllArgsConstructor, NoArgsConstructor, Builder, ToString)



@Data // genera los getters y setters, toString, equals y hashCode
@AllArgsConstructor // genera el constructor con todos los atributos
@NoArgsConstructor // genera el constructor sin parametros
@Builder // genera el patron builder
@Entity // indica que esta clase es una entidad de la base de datos
@Table(name = "OBRAARTISTICA") // indica el nombre de la tabla en la base de datos
public class ObraArtistica {

    @Id // indica la clave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) // indica que el valor se genera automaticamente, es autoincremental
    @Column(name = "ID")
    private Integer id;

    @Column(name = "NOMBRE", length = 255)
    private String nombre;

    @Column(name = "ANIO", length = 255)
    private String anio;

    @Column(name = "MONTOASEGURADO")
    private Double montoAsegurado;

    @Column(name = "SEGUROTOTAL")
    private Boolean seguroTotal;

    @ManyToOne // indica la relacion muchos a uno con la entidad Autor
    @JoinColumn(name = "AUTORID", nullable = false) // indica la columna que hace de clave foranea, no puede ser nula
    @ToString.Exclude // para evitar el ciclo infinito en el toString
    private Autor autor; 

    @ManyToOne // indica la relacion muchos a uno con la entidad Autor
    @JoinColumn(name = "MUSEOID", nullable = false) // indica la columna que hace de clave foranea, no puede ser nula
    @ToString.Exclude
    private Museo museo;

    @ManyToOne
    @JoinColumn(name = "ESTILOARTISTICOID", nullable = false)
    @ToString.Exclude
    private EstiloArtistico estiloArtistico;

}
