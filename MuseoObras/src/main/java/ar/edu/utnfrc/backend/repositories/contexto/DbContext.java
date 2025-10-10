package ar.edu.utnfrc.backend.repositories.contexto;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import jakarta.persistence.EntityManagerFactory;

public class DbContext { // clase singleton que maneja la conexion con la base de datos y el entity manager

    private final EntityManager entityManager; // el entity manager es el que maneja las operaciones con la base de datos

    public static DbContext instance = null; // instancia unica de la clase

    public DbContext(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("museo"); // creo el entity manager factory con el nombre de la unidad de persistencia definida en persistence.xml
        entityManager = emf.createEntityManager(); // creo el entity manager a partir del factory
    }

    public static DbContext getInstance(){ // metodo para obtener la instancia unica de la clase
        if(instance == null){
            instance = new DbContext();
        }
        return instance;
    }

    public EntityManager getEntityManager() { // metodo para obtener el entity manager
        return entityManager;
    }
    
}