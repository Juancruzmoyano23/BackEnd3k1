package ar.edu.utnfc.backend;

public class App {
    public static void main(String[] args) {
        Puerto puerto = new Puerto();
        puerto.cargarDesdeCSV("c:\\Users\\juanc\\OneDrive\\Escritorio\\Apps de Escritorio\\Proyectos Facultad\\BackEnd\\Ejercicio2_POO\\src\\main\\java\\ar\\edu\\utnfc\\backend\\barcos.csv");

        System.out.println("Recaudación total: " + puerto.calcularRecaudacionTotal());

        System.out.println("\nBarcos con capitanes > 18 años:");
        puerto.barcosCapitanesConExperiencia().forEach(System.out::println);

        System.out.println("\nPromedio carga muelles pares: " + puerto.promedioCargaMuellesPares());
    }
}