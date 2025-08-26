/* 5. Estadísticas con Input
Crear un programa en Java que lea desde teclado una lista de notas numéricas (enteros entre 0 y 10, una por una) y calcule:

La nota máxima
La nota mínima
El promedio (con decimales)
La cantidad de aprobados (nota ≥ 6)
La cantidad de desaprobados (nota < 6)
El ingreso finaliza cuando el usuario ingresa -1.


Si se ingresan valores fuera de rango (por ejemplo, 20 o -5), deben ignorarse mostrando un mensaje de advertencia por consola.*/

import java.util.Scanner;

public class Ejercicio05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nota, max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        int suma = 0, cantidad = 0, aprobados = 0, desaprobados = 0;

        System.out.println("Ingrese notas entre 0 y 10. Finalice con -1.");

        while (true) {
            System.out.print("Nota: ");
            nota = sc.nextInt();
            if (nota == -1) break;
            if (nota < 0 || nota > 10) {
                System.out.println("Valor fuera de rango, se ignora.");
                continue;
            }
            if (nota > max) max = nota;
            if (nota < min) min = nota;
            suma += nota;
            cantidad++;
            if (nota >= 6) {
                aprobados++;
            } else {
                desaprobados++;
            }
        }

        if (cantidad == 0) {
            System.out.println("No se ingresaron notas válidas.");
        } else {
            double promedio = (double) suma / cantidad;
            System.out.println("\n--- Estadísticas ---");
            System.out.println("Nota máxima: " + max);
            System.out.println("Nota mínima: " + min);
            System.out.println("Promedio: " + promedio);
            System.out.println("Cantidad de aprobados: " + aprobados);
            System.out.println("Cantidad de desaprobados: " + desaprobados);
        }
    }
}
