package ar.edu.utnfc.backend;

public class App {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        biblioteca.cargarDesdeCSV("c:\\Users\\juanc\\OneDrive\\Escritorio\\Apps de Escritorio\\Proyectos Facultad\\BackEnd\\Ejercicio4_POO\\libros.csv");

        System.out.println("Libros cargados:");
        biblioteca.mostrarLibros();

        System.out.println("\nRecaudación estimada: " + biblioteca.recaudacionEstimada());
        System.out.println("Autores con >18 años de carrera: " + biblioteca.autoresConTrayectoria());
        System.out.println("Promedio de páginas en estantes pares: " + biblioteca.promedioPaginasEstantePar());
    }
}
