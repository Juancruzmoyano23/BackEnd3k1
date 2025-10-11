package ar.edu.utnfrc.backend.repositories.context;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.stream.Collectors;

public final class DbInit {
    private static final String URL = "jdbc:h2:mem:boardgames;DB_CLOSE_DELAY=-1";
    private static final String USER = "sa";
    private static final String PASS = "";

    private DbInit() {
    }

    public static void run() throws SQLException, IOException {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASS)) {
            try (var is = DbInit.class.getClassLoader().getResourceAsStream("sql/ddl_board_games.sql")) {
                if (is == null) {
                    throw new IOException("No se encontró el archivo...");
                }

                String sql = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8))
                        .lines()
                        .collect(Collectors.joining("\n"));

                try (Statement st = conn.createStatement()) {
                    st.execute(sql);
                }

                System.out.println("La Base de datos se inicializó correctamente, bien ahí.");
            }
        }
    }
}