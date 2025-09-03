/*4. Productividad
Escribir un programa en Java que Le pida al usuario:

Su nombre (texto)
La cantidad de horas trabajadas en el día (entero)
La cantidad de tareas completadas (entero) 
Luego:

Calcule un índice de productividad usando esta fórmula
(tareas completadas * 10) - (5 puntos por cada hora faltante si trabajó menos de 8 horas).
Si trabajó más de 8 horas, agregar 5 puntos extra
Se deberá mostrar por pantalla un resumen con los siguientes datos:

Nombre del empleado
Horas trabajadas
Tareas completadas
Índice de productividad */

package ar.edu.utnfc.backend;

import java.util.Scanner;

public class Ejercicio04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Solicitar datos al usuario
        System.out.print("Ingrese su nombre: ");
        String nombre = sc.nextLine();

        System.out.print("Ingrese la cantidad de horas trabajadas en el día: ");
        int horas = sc.nextInt();

        System.out.print("Ingrese la cantidad de tareas completadas: ");
        int tareas = sc.nextInt();

        // Calcular índice de productividad
        int productividad = tareas * 10;
        if (horas < 8) {
            productividad -= (8 - horas) * 5;
        } else if (horas > 8) {
            productividad += 5;
        }

        // Mostrar resumen
        System.out.println("\n--- Resumen de Productividad ---");
        System.out.println("Nombre del empleado: " + nombre);
        System.out.println("Horas trabajadas: " + horas);
        System.out.println("Tareas completadas: " + tareas);
        System.out.println("Índice de productividad: " + productividad);
    }
}
