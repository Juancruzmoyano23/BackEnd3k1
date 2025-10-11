package ar.edu.utnfrc.backend.entities;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "BOARD_GAMES")
public class BoardGames {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_GAME")
    private Integer id;

    @Column(name = "NAME", length = 200, nullable = false)
    private String name;

    @Column(name = "YEAR_PUBLISHED")
    private Integer yearPublished;

    @Column(name = "MIN_AGE")
    private Integer minAge;

    @Column(name = "AVERAGE_RATING")
    private Double averageRating;

    @Column(name = "USERS_RATING")
    private Integer usersRating;

    @Column(name = "MIN_PLAYERS")
    private Integer minPlayers;

    @Column(name = "MAX_PLAYERS")
    private Integer maxPlayers;

    @ManyToOne(fetch = FetchType.EAGER, optional = false, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "ID_DESIGNER")
    private Designers designer;

    @ManyToOne(fetch = FetchType.EAGER, optional = false, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "ID_PUBLISHER")
    private Publishers publisher;

    @ManyToOne(fetch = FetchType.EAGER, optional = false, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "ID_CATEGORY")
    private Categories category;

    public BoardGames(String name) {
        this.name = name;
    }


    public boolean supportsPlayerCount(int players){
        if (players < this.minPlayers || players > this.maxPlayers) {
            return false;
        }
        return true;
    }
 
    public boolean isSuitableForAges(int[] ages){
        if (this.minAge == null) {
            return true;
        }
        for (int age : ages) {
            if (age < this.minAge) {
                return false;
            }
        }
        return true;
    }
}
