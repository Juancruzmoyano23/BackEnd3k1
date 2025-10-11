package ar.edu.utnfrc.backend.repositories;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import ar.edu.utnfrc.backend.entities.Designers;

public class DesignerRepository extends Repository<Designers, Integer> {

    public DesignerRepository() {
    super();
    }

    @Override
    public Designers getById(Integer id){
        return this.entityManager.find(Designers.class, id);
    }

    @Override
    public Set<Designers> getAll() {
        return this.entityManager.createQuery("SELECT a FROM Designers a", Designers.class) 
                .getResultList() 
                .stream() 
                .collect(Collectors.toSet());
    }

    @Override
    public Stream<Designers> getAllStream() {
        return this.entityManager.createQuery("SELECT a FROM Designers a", Designers.class)
                .getResultStream();
    }

}