package ar.edu.utnfrc.backend.repositories;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import ar.edu.utnfrc.backend.entitis.EstiloArtistico;

public class EstiloArtisticoRepository extends Repository<EstiloArtistico, Integer>{

    public EstiloArtisticoRepository() {
    super();
    }

    @Override // implementacion del metodo abstracto getById de la clase
    public EstiloArtistico getById(Integer id){
        return this.entityManager.find(EstiloArtistico.class, id); // busca la entidad por su ID usanto el Entity Manager de mi padre con el find que recibe la clase y el id
    }

    public Set<EstiloArtistico> getAll() {
        return this.entityManager.createQuery("SELECT e FROM EstiloArtistico e", EstiloArtistico.class) // crea una consulta JPQL para obtener todas las entidades de tipo EstiloArtistico
                .getResultList() // obtiene el resultado de la consulta como una lista
                .stream() // convierte la lista en un stream
                .collect(Collectors.toSet()); // recolecta los resultados en un Set
    }

    @Override
    public Stream<EstiloArtistico> getAllStream() {
        return this.entityManager.createQuery("SELECT a FROM EstiloArtistico a", EstiloArtistico.class)
                .getResultStream();
    }
    
}
