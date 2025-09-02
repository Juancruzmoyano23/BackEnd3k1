package Ejercicio4_POO.src.main.java.ar.edu.utnfc.backend;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Biblioteca {
    private static final int MAX_LIBROS = 1000;
    private Libro[] libros = new Libro[MAX_LIBROS];
    private int cantidadLibros = 0;

    public void cargarDesdeCSV(String rutaArchivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            br.readLine(); // Saltear encabezado
            while ((linea = br.readLine()) != null && cantidadLibros < MAX_LIBROS) {
                String[] datos = linea.split(",");
                if (datos.length != 9) {
                    System.out.println("Fila inválida: " + linea);
                    continue;
                }
                try {
                    String isbn = datos[0];
                    String titulo = datos[1];
                    int nroEstante = Integer.parseInt(datos[2]);
                    int paginas = Integer.parseInt(datos[3]);
                    double precioPorDia = Double.parseDouble(datos[4]);
                    String autorId = datos[5];
                    String autorNombre = datos[6];
                    String autorApellido = datos[7];
                    int autorAniosCarrera = Integer.parseInt(datos[8]);

                    Autor autor = new Autor(autorId, autorNombre, autorApellido, autorAniosCarrera);
                    libros[cantidadLibros++] = new Libro(isbn, titulo, nroEstante, paginas, precioPorDia, autor);
                } catch (Exception e) {
                    System.out.println("Error en fila: " + linea);
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    public double recaudacionEstimada() {
        double total = 0;
        for (int i = 0; i < cantidadLibros; i++) {
            total += libros[i].getPrecioPorDia() * 15;
        }
        return total;
    }

    public int autoresConTrayectoria() {
        int count = 0;
        for (int i = 0; i < cantidadLibros; i++) {
            if (libros[i].getAutor().getAniosCarrera() > 18) {
                count++;
            }
        }
        return count;
    }

    public double promedioPaginasEstantePar() {
        int suma = 0, cant = 0;
        for (int i = 0; i < cantidadLibros; i++) {
            if (libros[i].getNroEstante() % 2 == 0) {
                suma += libros[i].getPaginas();
                cant++;
            }
        }
        return cant == 0 ? 0 : (double) suma / cant;
    }

    public void mostrarLibros() {
        for (int i = 0; i < cantidadLibros; i++) {
            System.out.println(libros[i]);
        }
    }
}
