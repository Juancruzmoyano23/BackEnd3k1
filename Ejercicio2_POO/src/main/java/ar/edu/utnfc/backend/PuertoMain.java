package ar.edu.utnfc.backend;

public class PuertoMain {
    public static void main(String[] args) {
        Puerto puerto = new Puerto();
        puerto.cargarDesdeCSV("barcos.csv");

        System.out.println("Recaudación total: " + puerto.calcularRecaudacionTotal());

        System.out.println("\n Barcos con capitanes > 18 años:");
        puerto.barcosCapitanesConExperiencia().forEach(System.out::println);

        System.out.println("\nPromedio carga muelles pares: " + puerto.promedioCargaMuellesPares());
    }
}

