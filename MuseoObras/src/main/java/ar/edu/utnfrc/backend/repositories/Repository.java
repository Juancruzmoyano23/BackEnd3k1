package ar.edu.utnfrc.backend.repositories;

import java.util.Set;
import java.util.stream.Stream;

import ar.edu.utnfrc.backend.repositories.contexto.DbContext;
import jakarta.persistence.EntityManager;
import lombok.*;

public abstract class Repository<T, K> { // clase abstracta de la cual van a heredar los repositorios concretos, repositorios hijos

    protected EntityManager entityManager;

    public Repository () {
        entityManager = DbContext.getInstance().getEntityManager(); // en el entity manager meto la instancia y el Entity Manager del DBconext
    }

    public void add(T entity) {
        entityManager.getTransaction().begin(); // Inicia la transacción
        entityManager.persist(entity); // Guarda la entidad en la base de datos
        entityManager.getTransaction().commit(); // Confirma la transacción
    }

    public void update(T entity) {
        entityManager.getTransaction().begin(); // Inicia la transacción
        entityManager.merge(entity); // Actualiza la entidad en la base de datos
        entityManager.getTransaction().commit(); // Confirma la transacción
    }

    public T delete(K id) {
        entityManager.getTransaction().begin(); // Inicia la transacción
        var entity = this.getById(id); // Busca la entidad por su ID
        entityManager.remove(entity); // Elimina la entidad de la base de datos
        entityManager.getTransaction().commit(); // Confirma la transacción
        return entity;
    }

    public abstract T getById(K id); // metodo abstracto que va a ser implementado en los repositorios hijos

    public abstract Set<T> getAll(); // metodo abstracto que va a ser implementado en los repositorios hijos

    public abstract Stream<T> getAllStream(); // metodo abstracto que va a ser implementado en los repositorios hijos

    public boolean existeByNombreOrDescripcion(String valor){
        return false;
    }
}
