package ar.edu.utnfc.backend;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Puerto {
    private List<Barco> barcos = new ArrayList<>();

    public List<Barco> getBarcos() {
        return barcos;
    }

    // 2 - Cargar desde CSV
    public void cargarDesdeCSV(String rutaArchivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            br.readLine(); // Saltear encabezado
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                String matricula = datos[0];
                int muelle = Integer.parseInt(datos[1]);
                double capacidadCargaToneladas = Double.parseDouble(datos[2]);
                double costoAlquilerHora = Double.parseDouble(datos[3]);
                String idCapitan = datos[4];
                String nombreCapitan = datos[5];
                String apellidoCapitan = datos[6];
                int antiguedadCapitan = Integer.parseInt(datos[7]);

                Capitan capitan = new Capitan(idCapitan, nombreCapitan, apellidoCapitan, antiguedadCapitan);
                Barco barco = new Barco(matricula, muelle, capacidadCargaToneladas, costoAlquilerHora, capitan);
                barcos.add(barco);
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
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
        List<Barco> resultado = new ArrayList<>();
        for (Barco b : barcos) {
            if (b.getCapitan().getAntiguedad() > 18) {
                resultado.add(b);
            }
        }
        return resultado;
    }

    // 5 - Promedio de carga en muelles pares
    public double promedioCargaMuellesPares() {
        double suma = 0;
        int cantidad = 0;
        for (Barco b : barcos) {
            if (b.getMuelle() % 2 == 0) {
                suma += b.getCapacidadCargaToneladas();
                cantidad++;
            }
        }
        return cantidad == 0 ? 0 : suma / cantidad;
    }
}