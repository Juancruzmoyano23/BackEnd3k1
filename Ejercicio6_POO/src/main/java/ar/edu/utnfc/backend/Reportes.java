package main.java.ar.edu.utnfc.backend;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Reportes {

    // 1) Total pasajeros por línea
    public static Map<String, Integer> pasajerosPorLinea(List<Viaje> viajes) {
        return viajes.stream()
                .collect(Collectors.groupingBy(
                        Viaje::getLinea,
                        Collectors.summingInt(Viaje::getPasajeros)
                ));
    }

    // 2) Promedio duración (min) por línea
    public static Map<String, Double> promedioDuracionPorLinea(List<Viaje> viajes) {
        return viajes.stream()
                .collect(Collectors.groupingBy(
                        Viaje::getLinea,
                        Collectors.averagingInt(Viaje::getDuracion)
                ));
    }

    // 3) Viaje con más pasajeros (devuelve UN viaje)
    public static Optional<Viaje> viajeConMasPasajeros(List<Viaje> viajes) {
        return viajes.stream()
                .max(Comparator.comparingInt(Viaje::getPasajeros));
    }

    // 4) Viaje más largo (duración)
    public static Optional<Viaje> viajeMasLargo(List<Viaje> viajes) {
        return viajes.stream()
                .max(Comparator.comparingInt(Viaje::getDuracion));
    }
}
