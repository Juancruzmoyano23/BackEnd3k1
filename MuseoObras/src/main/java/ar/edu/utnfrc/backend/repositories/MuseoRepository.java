package ar.edu.utnfrc.backend.repositories;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import ar.edu.utnfrc.backend.entitis.Museo;

public class MuseoRepository extends Repository<Museo, Integer> {

    public MuseoRepository() {
    super();
    }

    @Override // implementacion del metodo abstracto getById de la clase
    public Museo getById(Integer id){
        return this.entityManager.find(Museo.class, id); // busca la entidad por su ID usanto el Entity Manager de mi padre con el find que recibe la clase y el id
    }

    @Override
    public Set<Museo> getAll() {
        return this.entityManager.createQuery("SELECT a FROM Museo a", Museo.class)
                .getResultList()
                .stream()
                .collect(Collectors.toSet());
    }

    public Stream<Museo> getAllStream() {
        return this.entityManager.createQuery("SELECT a FROM Museo a", Museo.class) // crea una consulta JPQL para obtener todas las entidades de tipo Museo
                .getResultStream(); // obtiene el resultado de la consulta como un stream
    }

    // public boolean existeByNombreOrDescripcion(String valor){
    //     return this.entityManager.createNamedQuery("Museo.GetByNombre", Museo.class)
    //                                .setParameter("Nombre", valor)
    //                                .getResultStream()
    //                                .findFirst()
    //                                .isPresent();
    // }
    
}
