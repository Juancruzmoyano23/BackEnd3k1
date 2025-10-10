package ar.edu.utnfrc.backend.repositories.contexto; // declara el paquete donde se encuentra la clase

import java.sql.Connection; // importa la interfaz Connection de JDBC
import java.sql.DriverManager; // importa DriverManager para obtener conexiones JDBC
import java.sql.SQLException; // importa la excepción para errores SQL

public final class DbInit { // clase final: utilidad para inicializar la BD (no se puede heredar)
    private static final String URL = "jdbc:h2:file:C:/Users/juanc/OneDrive/Escritorio/Proyectos Facultad/BackEnd/MuseoObras/src/main/java/ar/edu/utnfrc/backend/resources/museo"; // URL JDBC para H2 en memoria, con persistencia hasta cierre de la JVM, que esta ubicado en el archivo persistence.xml, en la linea que aparece url
    private static final String USER = "sa"; // usuario por defecto para H2
    private static final String PASS = ""; // contraseña por defecto (vacía) para H2

    private DbInit() { // constructor privado para evitar instanciación (clase utilitaria)
    }

    public static void run() {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASS)) {
            System.out.println(" Conexión exitosa a la base de datos H2 museo.mv.db");


        } catch (SQLException e) {
            System.err.println(" Error al conectar con la base de datos:");
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println(" Error inesperado:");
            e.printStackTrace();
        }
    }

    // private static void exec(Connection conn, String file) throws IOException, SQLException { // método auxiliar que lee y ejecuta un script SQL desde un archivo
    //     String sql = Files.readString(Path.of(file), StandardCharsets.UTF_8); // lee todo el contenido del archivo como String usando UTF-8
    //     try (Statement st = conn.createStatement()) { // crea un Statement JDBC dentro de try-with-resources
    //         st.execute(sql); // ejecuta el SQL leído (puede contener varias sentencias si el driver lo soporta)
    //     } // el Statement se cierra automáticamente al salir del try
    // }
}