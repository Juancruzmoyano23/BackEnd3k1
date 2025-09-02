package Ejercicio3_POO.src.main.java.ar.edu.utnfc.backend;

public class App {
    public static void main(String[] args) {
        CafeteraInteligente cafetera = new CafeteraInteligente("Philips", "SmartCoffee", 1000);

        cafetera.encender();
        cafetera.cargarAgua(800);
        cafetera.calentar();
        cafetera.calentar(); // Temperatura llega a 100

        boolean servido = cafetera.servirCafe();

        System.out.println(cafetera);
        System.out.println("¿Se sirvió café?: " + (servido ? "Sí" : "No"));

        cafetera.apagar();
        System.out.println(cafetera);
    }
}
