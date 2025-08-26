/*1. Ejercicio 1 - Ciclo For
Desarrollar un programa para cada punto o los cuatro puntos en un programa no 
tiene importancia. El objetivo es lograr imprimir por pantalla las siguientes 
figuras pero solo pudiendo imprimir a la vez uno y solo un asterisco o uno y 
solo un espacio, es decir solo podemos imprimir una variable de tipo char que 
tenga como valor '*' o ' '.
Figuras a generar:

Figura 1
* * * * * *
* * * * * *
* * * * * *
* * * * * *
Figura 3
*
* *
* * *
* * * *
* * * * *
Figura 2
* * * * * *
 * * * * * *
* * * * * *
 * * * * * *
Figura 4
*
* *
* * *
* * * *
* * * * *
* * * *
* * *
* *
*
*/


public class Ejercicio01 {

    public static void main(String[] args) {
        figura1();
        System.out.println();
        figura2();
        System.out.println();
        figura3();
        System.out.println();
        figura4();
    }

    // Figura 1
    public static void figura1() {
        int filas = 4, columnas = 6;
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.print('*');
                System.out.print(' ');
            }
            System.out.println();
        }
    }

    // Figura 2
    public static void figura2() {
        int filas = 4, columnas = 6;
        for (int i = 0; i < filas; i++) {
            if (i % 2 == 1) System.out.print(' ');
            for (int j = 0; j < columnas; j++) {
                System.out.print('*');
                System.out.print(' ');
            }
            System.out.println();
        }
    }

    // Figura 3
    public static void figura3() {
        int filas = 5;
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print('*');
                System.out.print(' ');
            }
            System.out.println();
        }
    }

    // Figura 4
    public static void figura4() {
        int filas = 5;
        // Parte superior
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print('*');
                System.out.print(' ');
            }
            System.out.println();
        }
        // Parte inferior
        for (int i = filas - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                System.out.print('*');
                System.out.print(' ');
            }
            System.out.println();
        }
    }
}
