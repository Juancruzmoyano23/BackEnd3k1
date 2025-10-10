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
@Table(name = "MUSEO")
public class Museo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;
    
    @Column(name = "NOMBRE")
    private String nombre;

    @OneToMany(mappedBy = "museo", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @ToString.Exclude
    @Builder.Default
    private Set<ObraArtistica> obras = new HashSet<>();
}
