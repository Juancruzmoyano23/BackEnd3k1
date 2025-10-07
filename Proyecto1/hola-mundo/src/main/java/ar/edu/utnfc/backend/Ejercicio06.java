/*6. Estadísticas con archivo de texto
Crear un programa en Java que lea desde un archivo de texto llamado numeros.txt una lista de enteros (uno por línea) y calcule:
Cantidad total de números leídos
Cantidad total de líneas no válidas
Cantidad de números pares
Cantidad de números impares
Promedio de todos los números (con decimales)
Consideraciones:
Si el archivo no existe, mostrar un mensaje de error (Si aún no tienen claro como hacerlo, omitirlo y revisar luego la solución).
Si alguna línea no contiene un número válido, aumentar el contador de líneas no válidas y continuar con el resto. */

package ar.edu.utnfc.backend;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Ejercicio06 {
    public static void main(String[] args) {
        String archivo = "src/main/java/ar/edu/utnfc/backend/numeros.txt";
        int totalNumeros = 0, lineasInvalidas = 0, pares = 0, impares = 0, suma = 0;

        try (Scanner sc = new Scanner(new File(archivo))) {
            while (sc.hasNextLine()) {
                String linea = sc.nextLine();
                try {
                    int num = Integer.parseInt(linea);
                    totalNumeros++;
                    suma += num;
                    if (num % 2 == 0) {
                        pares++;
                    } else {
                        impares++;
                    }
                } catch (NumberFormatException e) {
                    lineasInvalidas++;
                }

            }
        } catch (FileNotFoundException e) {
            System.out.println("Error al leer el archivo: " + archivo);
            return;
        }

        System.out.println("--- Estadísticas ---");
        System.out.println("Cantidad total de números leídos: " + totalNumeros);
        System.out.println("Cantidad total de líneas no válidas: " + lineasInvalidas);
        System.out.println("Cantidad de números pares: " + pares);
        System.out.println("Cantidad de números impares: " + impares);
        if (totalNumeros > 0) {
            double promedio = (double) suma / totalNumeros;
            System.out.println("Promedio de todos los números: " + promedio);
        } else {
            System.out.println("No se leyeron números válidos.");
        }
    }
}
