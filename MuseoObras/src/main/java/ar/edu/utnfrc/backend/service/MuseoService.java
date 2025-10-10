package ar.edu.utnfrc.backend.service;

import java.util.HashMap;
import java.util.Map;

import ar.edu.utnfrc.backend.entitis.Museo;
import ar.edu.utnfrc.backend.repositories.MuseoRepository;

public class MuseoService {

    private final MuseoRepository MR;
    private final Map<String, Museo> museos;

    public MuseoService() {
        MR = new MuseoRepository();
        museos = new HashMap<>();
    }

    public Museo getOrCreateMuseo(String descripcion) {
        return this.museos.computeIfAbsent(descripcion, desc -> {
            Museo museo = new Museo();
            museo.setNombre(desc);
            MR.add(museo);
            return museo;
        });
    }

    // public boolean existe(String museo) {
    //     return MR.existeByNombreOrDescripcion(museo);
    // }
}

