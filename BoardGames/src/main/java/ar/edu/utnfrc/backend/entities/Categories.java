package ar.edu.utnfrc.backend.entities;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "CATEGORIES")
public class Categories {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CATEGORY")
    private Integer id;

    @Column(name = "NAME", length = 160)
    private String name;

    public Categories(String name) {
        this.name = name;
    }
}