package ar.edu.utnfc.backend;

public class App {
    public static void main(String[] args) {
        Mascota m = new Mascota("Firulais");
        System.out.println(m);

        m.comer();
        m.beber();
        m.correr();
        m.saltar();
        m.dormir();

        System.out.println(m);
    }
}