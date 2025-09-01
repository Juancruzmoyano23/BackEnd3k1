package ar.edu.utnfc.backend;

import java.util.ArrayList;
import java.util.List;
// import ar.edu.utnfc.backend.Cliente;
import java.io.File;
import java.util.Scanner;

public class App {
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

        // CREO EL ARREGLO CLIENTE
        List<Cliente> lista = new ArrayList<>();

        String ruta = "clientes.csv";

        try (Scanner sn = new Scanner(new File(ruta))) {
            // leo la primera linea y la salteo 
            if (sn.hasNextLine()) {
                sn.nextLine();
            }

            // Recorremos línea por línea
            while (sn.hasNextLine()) {
                String linea = sn.nextLine();
                String[] datos = linea.split(",");

                // Crear objeto Cliente
                Cliente cliente = new Cliente(
                    datos[0], // nombre
                    Integer.parseInt(datos[1]), // dni
                    Short.parseShort(datos[2]), // edad
                    datos[3], // ocupacion
                    Integer.parseInt(datos[4]), // cantidadPosteos
                    Float.parseFloat(datos[5]), // horasEnPlataforma
                    Boolean.parseBoolean(datos[6]) // verificado
                );

                lista.add(cliente);
            }

            System.out.println("Archivo leído correctamente.");

            // Mostrar los clientes usando toString()
            for (Cliente c : lista) {
                System.out.println(c);
            }

        } catch (Exception e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}
