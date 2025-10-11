package ar.edu.utnfrc.backend.repositories;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import ar.edu.utnfrc.backend.entities.Publishers;

public class PublisherRepository extends Repository<Publishers, Integer> {

    public PublisherRepository() {
    super();
    }

    @Override
    public Publishers getById(Integer id){
        return this.entityManager.find(Publishers.class, id);
    }

    @Override
    public Set<Publishers> getAll() {
        return this.entityManager.createQuery("SELECT a FROM Publishers a", Publishers.class)
                .getResultList() 
                .stream() 
                .collect(Collectors.toSet());
    }

    @Override
    public Stream<Publishers> getAllStream() {
        return this.entityManager.createQuery("SELECT a FROM Publishers a", Publishers.class) 
                .getResultStream(); 
    }

}
