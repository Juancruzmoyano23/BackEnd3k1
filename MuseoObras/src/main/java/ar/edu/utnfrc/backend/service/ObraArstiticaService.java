package ar.edu.utnfrc.backend.service;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import ar.edu.utnfrc.backend.entitis.Autor;
import ar.edu.utnfrc.backend.entitis.EstiloArtistico;
import ar.edu.utnfrc.backend.entitis.Museo;
import ar.edu.utnfrc.backend.entitis.ObraArtistica;
import ar.edu.utnfrc.backend.repositories.ObraArtisticaRepository;

public class ObraArstiticaService {

    private final ObraArtisticaRepository obraArtisticaRepository;
    private final AutorService autorService;
    private final MuseoService museoService;
    private final EstiloArtisticoService estiloArtisticoService;

    public ObraArstiticaService(AutorService autorService, EstiloArtisticoService estiloArtisticoService, MuseoService museoService) {
        this.obraArtisticaRepository = new ObraArtisticaRepository();
        this.autorService = autorService;
        this.museoService = museoService;
        this.estiloArtisticoService = estiloArtisticoService;
    }

public void bulkInsert(File fileToImport) throws IOException { // método público para insertar en bloque desde CSV; puede lanzar IOException
        // CSV: titulo;fechaCreacion;valorBase;autor;estiloArtistico;museo
        Files.lines(Paths.get(fileToImport.toURI())) // abre las líneas del archivo como Stream<String>
                .skip(1) // salta la primera línea (encabezado)
                .forEach(linea -> { // por cada línea del CSV
                    try {
                        ObraArtistica obra = procesarLinea(linea); // procesa la línea y construye una ObraArtistica
                        if (obra != null) { // si la línea fue válida y devolvió ObraArtistica
                            obraArtisticaRepository.add(obra); // persiste la ObraArtistica usando el repositorio
                        }
                    } catch (Exception ex) { // captura cualquier excepción en procesamiento de línea individual
                        ex.printStackTrace(); // imprime el stacktrace (logging rudimentario)
                        System.err.println("Error procesando línea: " + linea + " -> " + ex.getMessage());
                    }
                });
    }


    private ObraArtistica procesarLinea(String linea) {
        String[] tokens = linea.split(",");

        String nombreObra = tokens[0].trim(); // extrae y limpia nombre de la obra
        String anioCreacionStr = tokens[1].trim(); // extrae y limpia año de creación como String
        String nombreAutor = tokens[2].trim(); // extrae y limpia nombre del autor
        String nombreMuseo = tokens[3].trim(); // extrae y limpia nombre del museo
        String nombreEstiloArtistico = tokens[4].trim(); // extrae y limpia
        String montoAseguradoStr = tokens[5].trim(); // extrae y limpia monto asegurado como String
        String seguroTotalStr = tokens[6].trim(); // extrae y limpia si tiene seguro total como String

        Autor autor = autorService.getOrCreateAutor(nombreAutor); // obtiene o crea el autor
        Museo museo = museoService.getOrCreateMuseo(nombreMuseo); // obtiene o crea el museo
        EstiloArtistico estilo = estiloArtisticoService.getOrCreateEstiloArtistico(nombreEstiloArtistico); // obtiene o crea el estilo artístico
        ObraArtistica obraArtistica = new ObraArtistica(); // crea una nueva instancia de ObraArtistica

        obraArtistica.setNombre(nombreObra);
        obraArtistica.setAnio(anioCreacionStr);
        obraArtistica.setAutor(autor);
        obraArtistica.setMuseo(museo);
        obraArtistica.setEstiloArtistico(estilo);

         // Parse montoAseguradoStr to double (or appropriate type) and set using the correct setter
        try {
            double montoAsegurado = Double.parseDouble(montoAseguradoStr);
            obraArtistica.setMontoAsegurado(montoAsegurado); // Make sure ObraArtistica has setMontoAsegurado(double)
        } catch (NumberFormatException e) {
            // Handle invalid number format, e.g., set to 0 or log error
            obraArtistica.setMontoAsegurado(0.0);
        }
        obraArtistica.setSeguroTotal(seguroTotalStr.equals("1"));

        return obraArtistica;
    }

    // Método para calcular el monto total a pagar por destrucción total
    public double calcularMontoTotalAPagarPorDestruccionTotal() {
        return obraArtisticaRepository.getAll().stream()
                .filter(o -> Boolean.TRUE.equals(o.getSeguroTotal()))
                .mapToDouble(ObraArtistica::getMontoAsegurado)
                .sum();
    }

    public double calcularMontoTotalAPagarPorDestruccionParcial() {
        return obraArtisticaRepository.getAll().stream()
                .filter(o -> !Boolean.TRUE.equals(o.getSeguroTotal()))
                .mapToDouble(ObraArtistica::getMontoAsegurado)
                .sum();
    }

    public double calcularMontoTotalAsegurado() {
        return obraArtisticaRepository.getAll().stream()
                .mapToDouble(ObraArtistica::getMontoAsegurado)
                .sum();
    }


    // 3 Generar un informe que muestre la cantidad de obras aseguradas por estilo artístico.

    public Map<String, Long> getCantidadObrasAseguradasPorEstilo() {
        return obraArtisticaRepository.getAll().stream()
                .filter(o -> Boolean.TRUE.equals(o.getSeguroTotal()))
                .filter(o -> o.getEstiloArtistico() != null && o.getEstiloArtistico().getNombre() != null)
                .collect(Collectors.groupingBy(o -> o.getEstiloArtistico().getNombre(), Collectors.counting()));
    }

    // exporta un CSV (texto separado por comas) con encabezado "Estilo,Cantidad"
    public void exportarCantidadObrasAseguradasPorEstilo(File salida) throws IOException {
        Map<String, Long> mapa = getCantidadObrasAseguradasPorEstilo();
        List<String> lineas = new ArrayList<>();
        lineas.add("Estilo,Cantidad");
        mapa.forEach((estilo, cantidad) -> lineas.add(estilo + "," + cantidad));
        Files.write(salida.toPath(), lineas, StandardCharsets.UTF_8);
    }

    // 4) Listar las obras que tienen seguro parcial y cuyo monto asegurado es mayor al promedio de todas las obras, ordenadas por año de creación descendente.

        public List<ObraArtistica> getObrasSeguroParcialMayoresPromedio() {
        var todas = obraArtisticaRepository.getAll();
        double promedio = todas.stream()
                .mapToDouble(ObraArtistica::getMontoAsegurado)
                .average()
                .orElse(0.0);

        return todas.stream()
                .filter(o -> !Boolean.TRUE.equals(o.getSeguroTotal())) // seguro parcial (no total)
                .filter(o -> o.getMontoAsegurado() > promedio)
                .sorted(Comparator.comparing(ObraArtistica::getAnio).reversed())
                .collect(Collectors.toList());
    }

    // 5)

    public List<ObraArtistica> getObrasByNombreMuseo(String nombreMuseo) {
        return obraArtisticaRepository.getAll().stream()
                .filter(o -> o.getMuseo() != null && nombreMuseo.equalsIgnoreCase(o.getMuseo().getNombre()))
                .collect(Collectors.toList());
    }
}
