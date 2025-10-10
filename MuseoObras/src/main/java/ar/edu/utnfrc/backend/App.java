package ar.edu.utnfrc.backend;
import ar.edu.utnfrc.backend.entitis.ObraArtistica;
import ar.edu.utnfrc.backend.menu.Menu; // clase que implementa el menú CLI
import ar.edu.utnfrc.backend.repositories.contexto.DbInit; // utilidad para inicializar la BD/ esquema/ datos
import ar.edu.utnfrc.backend.service.AutorService; // servicio para lógica/CRUD de Directores
import ar.edu.utnfrc.backend.service.EstiloArtisticoService; // servicio para lógica/CRUD de Géneros
import ar.edu.utnfrc.backend.service.MuseoService;
import ar.edu.utnfrc.backend.service.ObraArstiticaService; // servicio para lógica sobre Películas
import java.io.File; // representación de archivo en el filesystem
import java.util.List;
import java.util.Scanner; // lectura desde System.in
public class App {
    public static void main(String[] args) throws Exception{
        DbInit.run(); // llama al método que se conecta y muestra los resultados
        AutorService autorService = new AutorService(); // instancia servicio de géneros (inicializa repositorio/caché)
        EstiloArtisticoService estiloArtisticoService = new EstiloArtisticoService(); //
        MuseoService museoService = new MuseoService();
        ObraArstiticaService obraArtisticaService = new ObraArstiticaService(autorService, estiloArtisticoService, museoService);// crea servicio de películas inyectando dependencias
        
        try (Scanner sc = new Scanner(System.in)) {
            // final DecimalFormat df2 = new DecimalFormat("#0.00");
            Menu menu = new Menu("Menu de Opciones de Obras Artísticas"); // crea el menú CLI con título

            // 1) Cargar CSV
            menu.addOpcion(1, "Cargar Obras Artísticas desde CSV", () -> {
                try {
                    File archivo = new File("C:\\Users\\juanc\\OneDrive\\Escritorio\\Proyectos Facultad\\BackEnd\\MuseoObras\\src\\main\\java\\ar\\edu\\utnfrc\\backend\\resources\\obras.csv"); // archivo CSV con datos de ejemplo
                    System.out.println("Leyendo: " + archivo.getAbsolutePath()); // informa la ruta absoluta que se va a leer
                    obraArtisticaService.bulkInsert(archivo); // delega en el servicio para procesar e insertar en bloque
                    System.out.println("✅ Obras artísticas cargadas correctamente."); // confirma carga exitosa
                } catch (Exception e) { // captura errores al procesar el CSV
                    System.err.println("Error al cargar las obras artísticas: " + e.getMessage()); // muestra mensaje de error
                }
            });

            // 2) Monto total a pagar
            menu.addOpcion(2, "Calcular Monto Total a Pagar", () -> { 
                double montoTotalDestruccionTotal = obraArtisticaService.calcularMontoTotalAPagarPorDestruccionTotal();
                System.out.println("El monto total a pagar es: $" + montoTotalDestruccionTotal);

                double montoTotalDestruccionParcial = obraArtisticaService.calcularMontoTotalAPagarPorDestruccionTotal();
                System.out.println("El monto total a pagar por destrucción parcial es: $" + montoTotalDestruccionParcial);

                double montoTotalAsegurado = obraArtisticaService.calcularMontoTotalAsegurado();
                System.out.println("El monto total asegurado es: $" + montoTotalAsegurado);

            });

            // 3) Generar reporte por estilo
            menu.addOpcion(3, "Generar reporte por estilo", () -> {
                try {
                    File archivoSalida = new File("C:\\Users\\juanc\\OneDrive\\Escritorio\\Proyectos Facultad\\BackEnd\\MuseoObras\\src\\main\\java\\ar\\edu\\utnfrc\\backend\\resources\\reporte_estilos.csv");
                    obraArtisticaService.exportarCantidadObrasAseguradasPorEstilo(archivoSalida);
                    System.out.println("✅ Reporte generado en: " + archivoSalida.getAbsolutePath());
                } catch (Exception e) {
                    System.err.println("Error al generar el reporte: " + e.getMessage());
                }
            });

            //4) Listar autores con más de N obras aseguradas
            menu.addOpcion(4, "Listar obras con seguro parcial y monto > promedio", () -> {
                try {
                    var lista = obraArtisticaService.getObrasSeguroParcialMayoresPromedio();
                    System.out.printf("|%40s|%6s|%12s|%10s|%20s|%20s|%n", "Nombre", "Año", "Monto Aseg.", "Seguro", "Autor", "Estilo");
                    for (ObraArtistica o : lista) {
                        double monto = o.getMontoAsegurado();
                        String seguro = Boolean.TRUE.equals(o.getSeguroTotal()) ? "Total" : "Parcial";
                        String autor = o.getAutor() != null ? o.getAutor().getNombre() : "";
                        String estilo = o.getEstiloArtistico() != null ? o.getEstiloArtistico().getNombre() : "";
                        System.out.printf("|%40s|%6s|%12.2f|%10s|%20s|%20s|%n",
                                o.getNombre(), o.getAnio(), monto, seguro, autor, estilo);
                    }
                } catch (Exception e) {
                    System.err.println("Error al obtener lista: " + e.getMessage());
                }
            });

            // 5)
            menu.addOpcion(5, "Listar obras por museo (mostrar autor y estilo)", () -> {
                System.out.print("Ingrese el nombre del museo: ");
                String museoNombre = sc.nextLine().trim();
                try {
                    List<ObraArtistica> obras = obraArtisticaService.getObrasByNombreMuseo(museoNombre);
                    if (obras == null || obras.isEmpty()) {
                        System.out.println("No se encontraron obras para el museo: " + museoNombre);
                        return;
                    }
                    System.out.printf("|%20s|%20s|%n",  "Autor", "Estilo");
                    for (ObraArtistica o : obras) {
                        String autor = o.getAutor() != null ? o.getAutor().getNombre() : "";
                        String estilo = o.getEstiloArtistico() != null ? o.getEstiloArtistico().getNombre() : "";
                        System.out.printf("|%20s|%20s|%n", autor, estilo);
                    }
                } catch (IllegalArgumentException e) {
                    System.err.println(e.getMessage());
                } catch (Exception e) {
                    System.err.println("Error al listar obras por museo: " + e.getMessage());
                }
            });

            menu.ejecutar();

        }
    }
}
