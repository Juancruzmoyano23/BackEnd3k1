package ar.edu.utnfrc.backend.repositories;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import ar.edu.utnfrc.backend.entities.Categories;

public class CategoryRepository extends Repository<Categories, Integer> {

    public CategoryRepository() {
    super();
    }

    @Override 
    public Categories getById(Integer id){
        return this.entityManager.find(Categories.class, id);
    }

    @Override
    public Set<Categories> getAll() {
        return this.entityManager.createQuery("SELECT a FROM Categories a", Categories.class)
                .getResultList()
                .stream()
                .collect(Collectors.toSet());
    }

    @Override
    public Stream<Categories> getAllStream() {
        return this.entityManager.createQuery("SELECT a FROM Categories a", Categories.class) // crea una consulta JPQL para obtener todas las entidades de tipo Categories
                .getResultStream(); // obtiene el resultado de la consulta como un stream
    }
    
}
