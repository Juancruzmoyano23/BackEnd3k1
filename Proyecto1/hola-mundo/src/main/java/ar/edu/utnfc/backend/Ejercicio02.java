/* 2. El problema del ISBN (International Standard Book Number)
Necesita realizar un procedimiento para diferenciar cuáles son libros publicados por una editorial fantasma y cuáles corresponden a editoriales reales.

El formato del ISBN de 10 dígitos para libros fue desarrollado por la ISO (Organización Internacional de Estandarización) y publicado en 1970.

Este código ISBN consiste de varias partes (grupo, editorial, título más un dígito de comprobación), separadas por guiones (“-”) y se conoce que sus dígitos  satisfacen la condición:

(x1 * 10 + x2 * 9 + x3 * 8 + x4 * 7 + x5 * 6 + x6 * 5 + x7 * 4 + x8 * 3 + x9 * 2 + x10 * 1) mod 11 == 0

Entrada
La entrada es una cadena de caracteres que corresponde a un número isbn con los guiones incluidos.

Salida
La salida es un valor verdadero o falso indicando si el isbn ingresado es válido o no.
 * 
 * 
 */
package ar.edu.utnfc.backend;

import java.util.Scanner;

public class Ejercicio02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el ISBN: ");
        String isbn = sc.nextLine();
        if (esISBNValido(isbn)) {
            System.out.println("válido");
        } else {
            System.out.println("inválido");
        }
    }

    public static boolean esISBNValido(String isbn) {
        // Elimina los guiones
        String limpio = isbn.replace("-", "");
        if (limpio.length() != 10) return false;
        int suma = 0;
        for (int i = 0; i < 10; i++) {
            char c = limpio.charAt(i); 
            int valor;
            if (i == 9 && (c == 10)) {
                valor = 10; // El último dígito puede ser 'X'
            } else if (Character.isDigit(c)) {
                valor = c - '0';
            } else {
                return false;
            }
            suma += valor * (10 - i);
        }
        return suma % 11 == 0;
    }
}
