package ar.edu.utnfrc.backend.service;

import java.util.HashMap;
import java.util.Map;
import ar.edu.utnfrc.backend.entitis.Autor;
import ar.edu.utnfrc.backend.repositories.AutorRepository;

public class AutorService {
   
    private final AutorRepository AR;
    private Map<String, Autor> autores;

    public AutorService(){
        this.AR = new AutorRepository();
        this.autores = new HashMap<>();
    }

    public Autor getOrCreateAutor(String nombreAutor) { // método que recupera un Autor existente o lo crea si no existe
        if (autores.containsKey(nombreAutor)) { // comprueba si la caché ya tiene el autor por nombre
            return autores.get(nombreAutor); // si existe en caché, devolverlo inmediatamente
        }
        Autor autor = new Autor(null, nombreAutor, null); // si no existe, crear una nueva instancia de Autor con el nombre
        autores.put(nombreAutor, autor); // almacenar la nueva instancia en la caché para usos posteriores
        AR.add(autor); // persistir la nueva entidad en la base de datos mediante el repositorio
        return autor; // devolver la entidad creada y persistida
    }

}
