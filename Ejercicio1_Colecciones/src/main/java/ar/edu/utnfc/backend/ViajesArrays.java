package ar.edu.utnfc.backend;

import java.util.ArrayList;
import java.util.List;


public class ViajesArrays {
    private List<Viaje> viajecitos = new ArrayList<>();
    // creo una lista de viajes que incluye todos los viajes individiales usando List y ArrayList<>()     

    public void agregarViajes(Viaje viaje) {
        viajecitos.add(viaje);
    }
    // añado los viajes en si ?

    public List<Viaje> getViajes() {
        return viajecitos;
    }// retorno el array viajes 
}
