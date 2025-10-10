package ar.edu.utnfrc.backend.menu; // declara el paquete

import java.util.ArrayList; // importa ArrayList
import java.util.List; // importa List
import java.util.Optional; // importa Optional para resultados de búsquedas
import java.util.Scanner; // importa Scanner para entrada por consola

public class Menu { // clase pública Menu

    private final String titulo; // título del menú (inmutable)
    private final List<ItemMenu> opciones = new ArrayList<>(); // lista de opciones del menú

    public Menu(String titulo) { // constructor que recibe el título
        this.titulo = titulo; // asigna el título
    }

    // API simple: índice, mensaje y Runnable (lambda / method ref)
    public void addOpcion(int indice, String mensaje, Runnable accion) { // agrega una opción al menú
        opciones.add(new ItemMenu(indice, mensaje, accion)); // crea y añade ItemMenu a la lista
    }

    private int leerEntero(Scanner in) { // método auxiliar que lee un entero validado desde Scanner
        System.out.print("> Opción: "); // prompt inicial
        while (!in.hasNextInt()) { // mientras no haya un entero disponible
            in.next(); // descarta el token inválido
            System.out.print("> Opción: "); // vuelve a pedir
        }
        int n = in.nextInt(); // lee el entero válido
        in.nextLine(); // limpia el salto de línea restante en el buffer
        return n; // devuelve el número leído
    }

    public void ejecutar() { // método principal que muestra el menú y procesa opciones
        try (Scanner lector = new Scanner(System.in)) { // abre Scanner en try-with-resources para cerrarlo al terminar
            while (true) { // bucle principal del menú
                System.out.println("\n" + titulo); // imprime título con línea en blanco previa
                System.out.println("======================================"); // separador visual
                opciones.forEach(o -> System.out.printf("%2d) %s%n", o.indice(), o.mensaje())); // lista las opciones registradas formateadas
                System.out.println(" 0) Salir"); // opción de salida fija

                int opcion = leerEntero(lector); // lee la opción del usuario validada
                if (opcion == 0) break; // si es 0 sale del bucle y termina

                Optional<ItemMenu> elegido = opciones.stream() // busca la opción seleccionada por índice
                        .filter(o -> o.indice() == opcion) // filtra por índice
                        .findFirst(); // obtiene la primera coincidencia (si existe)

                if (elegido.isPresent()) { // si la opción existe
                    try {
                        elegido.get().accion().run(); // ejecuta la acción (Runnable)
                    } catch (Exception e) { // captura excepciones lanzadas por la acción
                        System.out.println("Error al ejecutar la opción: " + e.getMessage()); // muestra mensaje de error
                        e.printStackTrace(); // imprime stacktrace para debug
                    }
                } else {
                    System.out.println(" Opción inválida"); // notifica opción inválida si no se encontró
                }
            }
        }
        System.out.println("Aplicación terminada."); // mensaje final al cerrar el Scanner y salir del menú
    }
}