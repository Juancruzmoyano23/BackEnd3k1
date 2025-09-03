package ar.edu.utnfc.backend;

public class AplicacionFraccion {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        Fraccion f1 = new Fraccion(1, 2);
        Fraccion f2 = new Fraccion(3, 4);
        Fraccion f3 = new Fraccion(5, 6);

        Fraccion f4 = f1.sumar(f2);

        mostrarFracciones(f1, f2, f3, f4);
    }

    public static void mostrarFracciones(Fraccion f1, Fraccion f2, Fraccion f3, Fraccion f4) {
        System.out.println("Fraccion 1: " + f1);
        System.out.println("Fraccion 2: " + f2);
        System.out.println("Fraccion 3: " + f3);
        System.out.println("Fraccion 4 (suma): " + f4);
    }
}