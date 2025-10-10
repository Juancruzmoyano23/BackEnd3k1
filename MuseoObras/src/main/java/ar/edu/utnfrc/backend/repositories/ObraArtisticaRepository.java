package ar.edu.utnfrc.backend.repositories;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import ar.edu.utnfrc.backend.entitis.ObraArtistica;

public class ObraArtisticaRepository extends Repository<ObraArtistica, Integer> {
    
    public ObraArtisticaRepository() {
    super();
    }

    @Override
    public ObraArtistica getById(Integer id) {
        return this.entityManager.find(ObraArtistica.class, id);
    }

    public Set<ObraArtistica> getAll() {
        return this.entityManager.createQuery("SELECT a FROM ObraArtistica a", ObraArtistica.class) // crea una consulta JPQL para obtener todas las entidades de tipo ObraArtistica
                .getResultList() // obtiene el resultado de la consulta como una lista
                .stream() // convierte la lista en un stream
                .collect(Collectors.toSet()); // recolecta los resultados en un Set
    }

    public Stream<ObraArtistica> getAllStream() {
        return this.entityManager.createQuery("SELECT a FROM ObraArtistica a", ObraArtistica.class) // crea una consulta JPQL para obtener todas las entidades de tipo ObraArtistica
                .getResultStream(); // obtiene el resultado de la consulta como un stream
    }

    //     @Override
    // public boolean existeByNombreOrDescripcion(String valor) {
    //     return this.entityManager.createNamedQuery("ObraArtistica.GetByNombre", ObraArtistica.class)
    //             .setParameter("nombre", valor)
    //             .getResultStream()
    //             .findAny()
    //             .isPresent();
    // }

}
