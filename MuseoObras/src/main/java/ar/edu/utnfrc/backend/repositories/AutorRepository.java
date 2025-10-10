package ar.edu.utnfrc.backend.repositories;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import ar.edu.utnfrc.backend.entitis.Autor;

public class AutorRepository extends Repository<Autor, Integer> {

    public AutorRepository() {
    super();
    }

    @Override // implementacion del metodo abstracto getById de la clase
    public Autor getById(Integer id){
        return this.entityManager.find(Autor.class, id); // busca la entidad por su ID usanto el Entity Manager de mi padre con el find que recibe la clase y el id
    }

    @Override
    public Set<Autor> getAll() {
        return this.entityManager.createQuery("SELECT a FROM Autor a", Autor.class) // crea una consulta JPQL para obtener todas las entidades de tipo Autor
                .getResultList() // obtiene el resultado de la consulta como una lista
                .stream() // convierte la lista en un stream
                .collect(Collectors.toSet()); // recolecta los resultados en un Set
    }

    @Override
    public Stream<Autor> getAllStream() {
        return this.entityManager.createQuery("SELECT a FROM Autor a", Autor.class) // crea una consulta JPQL para obtener todas las entidades de tipo Autor
                .getResultStream(); // obtiene el resultado de la consulta como un stream
    }
    
}
