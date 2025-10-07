package main.java.ar.edu.utnfrc.backend;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

import ar.edu.utnfrc.backend.menu.ApplicationContext;
import ar.edu.utnfrc.backend.services.EmpleadoService;

public class Acciones {
    public void importarCsv(ApplicationContext context) {
        var pathToImport = (URL) context.get("path");

        try (var paths = Files.walk(Paths.get(pathToImport.toURI()))) {
            var csvFiles = paths
                    .filter(Files::isRegularFile)
                    .filter(path -> path.toString().endsWith(".csv"))
                    .map(path -> path.toFile())
                    .toList();

            csvFiles.stream()
                    .filter(f -> f.getName()
                            .contains("empleados"))
                    .findFirst()
                    .ifPresentOrElse(f -> {
                        var service = context.getService(EmpleadoService.class);
                        try {
                            service.bulkInsert(f);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    },
                            () -> new IllegalArgumentException("Archivo inexistente"));
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
    }

    
}
