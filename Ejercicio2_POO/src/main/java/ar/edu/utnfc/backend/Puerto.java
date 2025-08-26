package ar.edu.utnfc.backend;

import lombok.Data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Data
public class Puerto {
    private List<Barco> barcos = new ArrayList<>();

    // 2 - Cargar desde CSV
    public void cargarDesdeCSV(String rutaArchivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            br.readLine(); // saltar cabecera
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");

                Capitan capitan = new Capitan(
                        Integer.parseInt(datos[4]),
                        datos[5],
                        datos[6],
                        Integer.parseInt(datos[7])
                );

                Barco barco = new Barco(
                        datos[0],
                        Integer.parseInt(datos[1]),
                        Double.parseDouble(datos[2]),
                        Double.parseDouble(datos[3]),
                        capitan
                );

                barcos.add(barco);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 3 - Total recaudado
    public double calcularRecaudacionTotal() {
        int horasCarga = 15;
        return barcos.stream()
                .mapToDouble(b -> b.getCostoAlquilerHora() * horasCarga)
                .sum();
    }

    // 4 - Barcos con capitanes con más de 18 años
    public List<Barco> barcosCapitanesConExperiencia() {
        return barcos.stream()
                .filter(b -> b.getCapitan().getAntiguedad() > 18)
                .toList();
    }

    // 5 - Promedio de carga en muelles pares
    public double promedioCargaMuellesPares() {
        return barcos.stream()
                .filter(b -> b.getMuelle() % 2 == 0)
                .mapToDouble(Barco::getCapacidadCargaToneladas)
                .average()
                .orElse(0.0);
    }
}
