package ar.edu.utnfrc.backend.entities;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "DESIGNERS")
public class Designers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_DESIGNER")
    private Integer id;

    @Column(name = "NAME", length = 160, nullable = false)
    private String name;

    public Designers(String name) {
        this.name = name;
    }
}
