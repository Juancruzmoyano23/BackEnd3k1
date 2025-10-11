package ar.edu.utnfrc.backend;

import ar.edu.utnfrc.backend.entities.BoardGames;
import ar.edu.utnfrc.backend.menu.Menu;
import ar.edu.utnfrc.backend.repositories.context.DbInit;
import ar.edu.utnfrc.backend.services.BoardGameService;
import ar.edu.utnfrc.backend.services.CategoriesService;
import ar.edu.utnfrc.backend.services.DesignerService;
import ar.edu.utnfrc.backend.services.PublisherService;
import java.io.File;
import java.util.Scanner;


public class App {
    public static void main(String[] args) throws Exception{
            DbInit.run();
            CategoriesService categoriesService = new CategoriesService();
            DesignerService designerService = new DesignerService();
            PublisherService publisherService = new PublisherService();
            BoardGameService boardGameService = new BoardGameService(categoriesService, designerService, publisherService);

        try (Scanner sc = new Scanner(System.in)) {
            Menu menu = new Menu("Menu de Opciones:");

            // 1) Cargar CSV
            menu.addOpcion(1, "Cargar Juegos de mesa", () -> {
                try {
                    File archivo = new File("src/main/resources/BoardGames.csv");
                    System.out.println("Leyendo " + archivo.getAbsolutePath());
                    boardGameService.bulkInsert(archivo);
                    System.out.println("Juegos de mesa cargados correctamente !!");
                } catch (Exception e) {
                    System.err.println("Error al cargar los juegos de mesa... " + e.getMessage());
                }
            });

            menu.ejecutar();

            // 2) 
        }
    }
}
