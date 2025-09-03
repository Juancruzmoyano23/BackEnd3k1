/*3. Divisores y Multiplos
Escribir un programa en Java que:
Solicite al usuario un número entero positivo n.
Muestre por pantalla todos los números entre 1 y n que sean múltiplos de 3 o múltiplos de 5, pero no de ambos.
Si el usuario ingresa un valor no válido (≤ 0), mostrar un mensaje de error y volver a pedir el número.
*/

package ar.edu.utnfc.backend;


import java.util.Scanner;

public class Ejercicio03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        do {
            System.out.print("Ingrese un número entero positivo: ");
            n = sc.nextInt();
            if (n <= 0) {
                System.out.println("Error, ingrese un número mayor a 0.");
            }
        } while (n <= 0);

        System.out.println("Números entre 1 y " + n + " que son múltiplos de 3 o 5, pero no de ambos:");
        for (int i = 1; i <= n; i++) {
            boolean multiplo3 = i % 3 == 0;
            boolean multiplo5 = i % 5 == 0;
            if (multiplo3 ^ multiplo5) { // XOR: solo uno de los dos
                System.out.println(i);
            }
        }
    }
}
