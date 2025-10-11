package ar.edu.utnfrc.backend.services;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import ar.edu.utnfrc.backend.entities.BoardGames;
import ar.edu.utnfrc.backend.entities.Categories;
import ar.edu.utnfrc.backend.entities.Designers;
import ar.edu.utnfrc.backend.entities.Publishers;
import ar.edu.utnfrc.backend.repositories.BoardGamesRepository;

public class BoardGameService {

    private final BoardGamesRepository BR;
    private final Map<String, BoardGames> boardGames;
    private final CategoriesService categoriesService;
    private final DesignerService designersService;
    private final PublisherService publishersService;

    public BoardGameService(CategoriesService categoriesService, DesignerService designersService, PublisherService publishersService) {
        BR = new BoardGamesRepository();
        boardGames = new HashMap<>();
        this.categoriesService = categoriesService;
        this.designersService = designersService;
        this.publishersService = publishersService;
        
    }

    public void bulkInsert(File fileToImport) throws IOException { 
        Files.lines(Paths.get(fileToImport.toURI()))
                .skip(1) 
                .forEach(linea -> {
                    try {
                        BoardGames juegoBoardGames = procesarLinea(linea);
                        if (juegoBoardGames != null) { 
                            BR.add(juegoBoardGames);
                        }
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        System.err.println("Error procesando línea: " + linea + " -> " + ex.getMessage());
                    }
                });
    }


    private BoardGames procesarLinea(String linea) {
        String[] tokens = linea.split(",");
        // ID_GAME,NAME,YEAR_PUBLISHED,MIN_AGE,AVERAGE_RATING,USERS_RATING,MIN_PLAYERS,MAX_PLAYERS,ID_DESIGNER,ID_PUBLISHER,ID_CATEGORY

        String idJuego = tokens[0].trim();
        String nombreJuego = tokens[1].trim();
        String anioPublicacionStr = tokens[2].trim();
        String edadMinimaStr = tokens[3].trim();
        String ratingPromedioStr = tokens[4].trim();
        String ratingUsuariosStr = tokens[5].trim();
        String minJugadoresStr = tokens[6].trim();
        String maxJugadoresStr = tokens[7].trim(); 
        String idDiseñadorStr = tokens[8].trim();
        String idEditorStr = tokens[9].trim();
        String idCategoriaStr = tokens[10].trim();


        Categories categoria = categoriesService.getOrCreateCategoria(idCategoriaStr);
        Designers designers = designersService.getOrCreateDesigner(idDiseñadorStr);
        Publishers publishers = publishersService.getOrCreatePublisher(idEditorStr); 

        BoardGames boardGames = new BoardGames();
        boardGames.setName(nombreJuego);
        boardGames.setYearPublished(Integer.parseInt(anioPublicacionStr));
        boardGames.setMinAge(Integer.parseInt(edadMinimaStr));
        boardGames.setAverageRating(Double.parseDouble(ratingPromedioStr));
        boardGames.setUsersRating(Integer.parseInt(ratingUsuariosStr));
        boardGames.setMinPlayers(Integer.parseInt(minJugadoresStr));
        boardGames.setMaxPlayers(Integer.parseInt(maxJugadoresStr));
        boardGames.setDesigner(designers);
        boardGames.setPublisher(publishers);
        boardGames.setCategory(categoria);


        return boardGames;
    }
}