package ar.edu.utnfc.backend;

/*1. Ejercicio Tamagotchi
Introducción
Modelar e implementar en java la clase "Mascota" a partir de la cual se puedan instanciar objetos que representan una mascota virtual en una aplicación que emula este tipo de juegos.
Esencialmente la mascota tiene energía un número entero entre 0 y 100 y humor un valor entero entre 1 y 5 que significa: muy enojado, enojado, neutral, contento y chocho respectivamente desde el 1 hasta el 5.
Dicha mascota debe responder a los siguientes mensajes implementados en comportamientos que están divididos en comportamientos de ingesta, comportamientos de actividad y otros.
Comportamientos de ingesta:
comer => incrementa la energía (que es un número entre 0 y 100 unidades) en 10% de la energía que tiene la mascota y incrementa el humor en 1 nivel.
beber => incrementa la energía (que es un número entre 0 y 100 unidades) en 5% de la energía que tiene la mascota y incrementa el humor en 1 nivel.
Comportamientos de actividades:
correr => decrementa la energía en un 35% de la energía que tiene la mascota. Y decrementa el humor en 2 niveles.
saltar => decrementa la energía en un 15% de la energía que tiene la mascota. Y decrementa el humor en 2 niveles.
Otros comportamientos:
dormir => la mascota pasa a estado durmiendo y no responde a ningún otro comportamiento excepto despertar. Además la energía se incrementa en 25 unidades y el humor en 2 niveles.
despertar => la mascota pasa a estado despierta y comienza a responder a los demás comportamientos. Además el humor se decrementa en un nivel.

Por otro lado se deben respetar las siguientes reglas adicionales para todos los comportamientos en general:
1 - A partir de la 3 ingesta consecutiva el nivel de humor comienza a decrementar en 1 por cada ingesta.
2 - Cuando la energía llega a 0 la mascota muere de cansada.
3 - Si la mascota realiza 5 ingestas consecutivas muere de empacho.
4 - Si la mascota realiza 3 actividades consecutivas se empaca y se duerme.

Agregar además el comportamiento toString que devuelva una representación de cadena de la mascota incluyendo su nombre, unidades de energía, nivel de alegría, si duerme y si vive.
Notas:
1. la energía no puede superar 100 unidades, es decir si está en 100 no aumenta y si baja de cero la mascota muere y ya no responde más a ningún comportamiento.
2. el nivel de alegría fluctúa entre 1 muuuuy enojado y 5 chocho y si la alegría llega a 0 la mascota se va a dormir por propia iniciativa.
3. cuando la mascota está en un estado que no responde a cierto comportamiento el mismo debe retornar false y si el comportamiento se pudo realizar correctamente retorna true.

Ejercicio
Escribir la clase MascotaVirtual de forma que implemente comportamientos para contemplar todos los casos mencionados y responda al Test Unitario que agregaremos.*/

public class Mascota {
    private String nombre;
    private int energia;
    private int humor;
    private boolean durmiendo;
    private boolean viva;
    private int ingestasConsecutivas;
    private int actividadesConsecutivas;

    // Constructor
    public Mascota(String nombre) {
        this.nombre = nombre;
        this.energia = 100;
        this.humor = 5;
        this.durmiendo = false;
        this.viva = true;
        this.ingestasConsecutivas = 0;
        this.actividadesConsecutivas = 0;
    }

    // Comportamientos de ingesta
    public boolean comer() {
        if (!puedeResponder()) return false;

        energia = Math.min(energia + (int) (energia * 0.1), 100); // aca lo que hago es calcular el 10% de la energia, sumarselo y despues testear que el valor resultante no supere al maximo
        humor = Math.min(humor + 1, 5); // aca lo que hace es lo mismo que el de energia nada mas que le suma 1 al valor del humor y testea que el valor resultante no supere 5

        ingestasConsecutivas++;
        actividadesConsecutivas = 0;

        if (ingestasConsecutivas >= 3) humor = Math.max(humor - 1, 1);
        if (ingestasConsecutivas >= 5) morir("empacho");

        return true;
    }

    public boolean beber() {
        if (!puedeResponder()) return false;

        energia = Math.min(energia + (int) (energia * 0.05), 100);
        humor = Math.min(humor + 1, 5);
        ingestasConsecutivas++;
        actividadesConsecutivas = 0;

        if (ingestasConsecutivas >= 3) humor = Math.max(humor - 1, 1);
        if (ingestasConsecutivas >= 5) morir("empacho");

        return true;
    }

    // Comportamientos de actividades
    public boolean correr() {
        if (!puedeResponder()) return false;

        energia = (int) Math.max((energia - (int) energia* 0.35), 0); // al valor de la energia le saca el 35% de el valor actual que tenga
        humor = Math.max(humor - 2, 1);
        actividadesConsecutivas++;
        ingestasConsecutivas = 0;

        verificarMuerte();
        return true;
    }

    public boolean saltar() {
        if (!puedeResponder()) return false;

        energia = (int) Math.max((energia - (int) energia* 0.15), 0); // al valor de la energia le saca el 35% de el valor actual que tenga
        humor = Math.max(humor - 2, 1);
        actividadesConsecutivas++;
        ingestasConsecutivas = 0;

        verificarMuerte();
        return true;
    }

    // Otros comportamientos
    public boolean dormir() {
        if (!puedeResponder()) return false;

        boolean durmiendo = true;
        energia = Math.min(energia + 25, 100);
        humor = Math.min(humor + 2, 5);
        return true;
    }

    public boolean despertar() {
        if (!viva || !durmiendo) return false;

        boolean durmiendo = false;
        humor = Math.max(humor - 1, 1);
        return true;
    }

    // Métodos auxiliares
    private boolean puedeResponder() {
        return viva && !durmiendo;
    }

    private void verificarMuerte() {
        if (energia <= 0) {
            morir("cansancio");
        } else if (actividadesConsecutivas >= 3) {
            dormir();
        } else if (humor <= 0) {
            dormir();
        }
    }

    private void morir(String causa) {
        viva = false;
        durmiendo = false;
        System.out.println("La mascota ha muerto por " + causa + ".");
    }

    @Override
    public String toString() {
        return "Mascota{" +
                "nombre='" + nombre + '\'' +
                ", energia=" + energia +
                ", humor=" + humor +
                ", durmiendo=" + durmiendo +
                ", viva=" + viva +
                '}';
    }
}
