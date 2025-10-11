package ar.edu.utnfrc.backend.repositories;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import ar.edu.utnfrc.backend.entities.BoardGames;

public class BoardGamesRepository extends Repository<BoardGames, Integer> {

    public BoardGamesRepository() {
    super();
    }

    @Override
    public BoardGames getById(Integer id){
        return this.entityManager.find(BoardGames.class, id); 
    }

    @Override
    public Set<BoardGames> getAll() {
        return this.entityManager.createQuery("SELECT a FROM BoardGames a", BoardGames.class)
                .getResultList()
                .stream() 
                .collect(Collectors.toSet());
    }

    @Override
    public Stream<BoardGames> getAllStream() {
        return this.entityManager.createQuery("SELECT a FROM BoardGames a", BoardGames.class) 
                .getResultStream();
    }
    
}

