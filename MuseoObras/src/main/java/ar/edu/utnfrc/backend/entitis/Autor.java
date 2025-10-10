package ar.edu.utnfrc.backend.entitis;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "AUTOR")
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "NOMBRE")
    private String nombre;

    @OneToMany(mappedBy = "autor", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @ToString.Exclude
    @Builder.Default // para inicializar el atributo en el patron builder
    private Set<ObraArtistica> obras = new HashSet<>();
    
}
