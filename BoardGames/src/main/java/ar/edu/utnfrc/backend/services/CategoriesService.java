package ar.edu.utnfrc.backend.services;

import java.util.HashMap;
import java.util.Map;

import ar.edu.utnfrc.backend.entities.Categories;
import ar.edu.utnfrc.backend.repositories.CategoryRepository;


public class CategoriesService {

    private final CategoryRepository CR;
    private final Map<String, Categories> categorias;

    public CategoriesService() {
        CR = new CategoryRepository();
        categorias = new HashMap<>();
    }

    public Categories getOrCreateCategoria(String nombreCategoria) {
        if (categorias.containsKey(nombreCategoria)) {
            return categorias.get(nombreCategoria);
        }
        Categories categoria = new Categories("categoria" + nombreCategoria);
        categorias.put(nombreCategoria, categoria);
        CR.add(categoria);
        return categoria;
    }
}
