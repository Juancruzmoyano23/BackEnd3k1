package ar.edu.utnfc.backend;

import java.util.Scanner;

public class App {
public static void main(String[] args) {
        //System.out.println("=== TIPOS, DECLARACIONES Y ASIGNACIONES ===");
        //tiposYAsignaciones();

         //System.out.println("\n=== INFERENCIA CON var (Java 10+) ===");
         //usoDeVar();

         //System.out.println("\n=== CONVERSIONES, PROMOCIONES Y CASTING ===");
         //conversionesYCasting();

         //System.out.println("\n=== OPERADORES ARITMÉTICOS Y PROMOCIÓN DE TIPOS ===");
         //operadoresAritmeticos();

         //System.out.println("\n=== OPERADORES RESUMIDOS Y ++ / -- (pre/post) ===");
         //operadoresResumidosYUnarios();

        //System.out.println("\n=== CONDICIONALES: if/else, switch y ternario ===");
        //condicionales();

        //System.out.println("\n=== CICLOS: for, while, do-while, break/continue ===");
        // ciclos();

         System.out.println("\n=== SCANNER: teclado (comentado) y demo sin bloqueo ===");
         scannerDemo();

        // System.out.println("\nFin de la demo.");
    }

    static void tiposYAsignaciones() {
        // Primitivos
        byte by = 127; // [-128, 127]
        short sh = 32_000;
        int i = 2_000_000_000;
        long lo = 9_000_000_000L;
        float f = 3.5f;     // sufijo 'f' para float
        double d = 0.123456789;
        char ch = 'A';      // código de carácter
        boolean ok = true;

        // Referencias
        String nombre = "Ana";

        // Asignaciones y “char a int”
        int a = ch;         // char -> int (código de 'A')
        System.out.println(a);
        System.out.println("byte=" + by + ", short=" + sh + ", int=" + i +
                ", long=" + lo + ", float=" + f + ", double=" + d +
                ", char='A'(" + a + "), boolean=" + ok + ", String=" + nombre);
    }

    static void usoDeVar() {
        var edad = 25;          // infiere int
        var nom = "John";       // infiere String
        System.out.println("Nombre: " + nom + ", Edad: " + edad);
    }

    static void conversionesYCasting() {
        short c = 15;
        int a = c;              // promoción implícita (no hay pérdida)
        System.out.println("Promoción short->int OK: a=" + a);

        int grande = 123_456;
        short b = (short)grande; // casting explícito, posible pérdida
        System.out.println("Casting int(123456)->short da: " + b);

        // Caso particular byte: overflow controlado por 2's complement
        byte minimo = -128;
        // ¡OJO! Operaciones entre byte/short se promueven a int, hay que castear:
        byte wrap = (byte) (minimo - 1);  // -128 - 1 -> 127 (desborde)
        System.out.println("byte wrap: -128 - 1 = " + wrap);

        // char a int (código Unicode)
        char ch = 'c';
        int code = ch;
        System.out.println("'c' como int = " + code);
    }

    static void operadoresAritmeticos() {
        int x = 11, y = 2;
        int divisionEntera = x / y;   // 11 / 2 = 5 (trunca)
        int resto = x % y;            // 11 % 2 = 1
        double divisionReal = x / 2.0; // promoción a double -> 5.5

        // Nota: byte/short/int en una misma expresión dan int
        byte b1 = 10, b2 = 20;
        int sumaBytes = b1 + b2;      // resultado es int

        System.out.println("Div entera 11/2 = " + divisionEntera + ", resto = " + resto +
                ", real 11/2.0 = " + divisionReal + ", sumaBytes(int) = " + sumaBytes);
        // Apunte: operadores + reglas de promoción y ejemplo de división entera. :contentReference[oaicite:7]{index=7} :contentReference[oaicite:8]{index=8}
    }

    static void operadoresResumidosYUnarios() {
        int a = 0;
        //a = a + 1;
        a += 1;      // contador
        a *= 3;      // acumulador (producto)
        a -= 2;
        System.out.println("Compuestos => a=" + a);

        int p = 5, c1, c2, c3, c4;
        c1 = ++p;
        System.out.println(p);    // pre-incremento: primero incrementa (p=6), luego asigna (c1=6)
        p = 5;
        c2 = p++; 
        System.out.println(p);    // post-incremento: primero asigna (c2=5), luego incrementa (p=6)
        int q = 5;
        c3 = --q;    // pre-decremento (q=4, c3=4)
        q = 5;
        c4 = q--;    // post-decremento (c4=5, q=4)
        System.out.println("++a=" + c1 + ", a++=" + c2 + ", --b=" + c3 + ", b--=" + c4);
    }

    static void condicionales() {
        int n = 7;
        if (n % 2 == 0)
            System.out.println("n es par");
        else
            System.out.println("n es impar");

        // Operador ternario
        String paridad = (n % 2 == 0) ? "PAR" : "IMPAR";
        System.out.println("Ternario => " + paridad);

        // switch (ejemplo con fallthrough y break)
        String day = "MON";
        switch (day) {
            case "MON":
            case "TUE":
            case "WED":
            case "THU":
            case "FRI":
                System.out.println("Día hábil");
                break;
            case "SAT":
            case "SUN":
                System.out.println("Fin de semana");
                break;
            default:
                System.out.println("Día no reconocido");
        }
    }

    static void ciclos() {
        // for: 1..5
        System.out.print("for: {");
        for (int i = 1; i <= 5; i++) {
            System.out.print(i + (i < 5 ? ", " : ""));
        }
        System.out.println("");

        // while: 1..5
        int cont = 0;
        while (cont < 5) {
            cont++;
            System.out.println("while vuelta: " + cont);
        }

        // do-while: se ejecuta al menos una vez
        int k = 0;
        do {
            System.out.println("do-while imprime al menos una vez. k=" + k);
        } while (k > 0);

        // break / continue: imprimir impares hasta 7
        System.out.print("break/continue: {");
        for (int i = 1; i <= 10; i++) {
            if (i % 2 == 0) continue; // salta pares
            System.out.print(i);
            if (i == 7) { System.out.println("} (corte en 7)"); break; }
            System.out.print(", ");
        }
        // Apunte: for/while/do-while, 0–N vs 1–N, y break/continue. :contentReference[oaicite:11]{index=11} :contentReference[oaicite:12]{index=12} :contentReference[oaicite:13]{index=13} :contentReference[oaicite:14]{index=14}
    }

    static void scannerDemo() {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Ingrese a: ");
            int a = sc.nextInt();
            System.out.print("Ingrese b: ");
            int b = sc.nextInt();
            System.out.println("Suma = " + (a + b));
        }
    }
}
