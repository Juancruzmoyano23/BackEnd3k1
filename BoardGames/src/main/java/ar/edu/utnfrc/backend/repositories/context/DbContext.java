package ar.edu.utnfrc.backend.repositories.context;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence; 
import jakarta.persistence.EntityManagerFactory;

public class DbContext { 

    private final EntityManager entityManager; 

    public static DbContext instance = null;

    public DbContext(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("BoardGames"); 
        entityManager = emf.createEntityManager();
    }

    public static DbContext getInstance(){ 
        if(instance == null){
            instance = new DbContext();
        }
        return instance;
    }

    public EntityManager getEntityManager() { 
        return entityManager;
    }
    
}