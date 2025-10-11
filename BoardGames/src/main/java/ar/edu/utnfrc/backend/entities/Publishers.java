package ar.edu.utnfrc.backend.entities;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "PUBLISHERS")
public class Publishers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PUBLISHER")
    private Integer id;

    @Column(name = "NAME", length = 160, nullable = false)
    private String name;

    public Publishers(String name) {
        this.name = name;
    }
}