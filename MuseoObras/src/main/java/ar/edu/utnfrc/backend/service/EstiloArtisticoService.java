package ar.edu.utnfrc.backend.service;

import java.util.HashMap;
import java.util.Map;
import ar.edu.utnfrc.backend.entitis.EstiloArtistico;
import ar.edu.utnfrc.backend.repositories.EstiloArtisticoRepository;

public class EstiloArtisticoService {

    private final EstiloArtisticoRepository ER;
    private final Map<String, EstiloArtistico> estilos;

    public EstiloArtisticoService(){
        ER = new EstiloArtisticoRepository();
        estilos = new HashMap<>();
    }

    public EstiloArtistico getOrCreateEstiloArtistico(String descripcion) {
        return this.estilos.computeIfAbsent(descripcion, des -> {
            EstiloArtistico estilo = new EstiloArtistico();
            estilo.setNombre(des);
            ER.add(estilo);
            return estilo;
        });
    }

    public Object getOrCreateMuseo(String nombreEstilo) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getOrCreateMuseo'");
    }

    // public Map<String, Integer> getCantidadObrasPorEstilo(){
    //     Map<String, Integer> resultado;
    //     var estilos = this.ER.getAllStream();
    //     resultado = estilos.collect(Collectors.groupingBy(EstiloArtistico::getNombre, Collectors.summingInt(e -> e.getObras().size())));
    //     return resultado;
    // }

    
}
