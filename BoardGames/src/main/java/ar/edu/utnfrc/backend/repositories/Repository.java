package ar.edu.utnfrc.backend.repositories;

import java.util.Set;
import java.util.stream.Stream;
import jakarta.persistence.EntityManager;
import lombok.*;
import ar.edu.utnfrc.backend.repositories.context.DbContext;

public abstract class Repository<T, K> {

    protected EntityManager entityManager;

    public Repository() {
        entityManager = DbContext.getInstance().getEntityManager();
    }

    public void add(T entity) {
        var transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(entity);
        transaction.commit();

    }

    public void update(T entity) {
        var transaction = entityManager.getTransaction();
        transaction.begin(); 
        entityManager.merge(entity); 
        transaction.commit(); 
    }

    public T delete(K id) {
        var transaction = entityManager.getTransaction();
        transaction.begin();
        var nombreEntity = this.getById(id);
        entityManager.remove(nombreEntity);
        transaction.commit(); 
        return nombreEntity;
    }

    public abstract T getById(K id); 

    public abstract Set<T> getAll(); 

    public abstract Stream<T> getAllStream(); 

}
