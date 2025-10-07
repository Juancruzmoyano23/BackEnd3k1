package main.java.ar.edu.utnfrc.backend.menu;

import java.util.*;

public class Menu {
    private String titulo;
    private final List<ItemMenu> opciones = new ArrayList<>();

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void addOpcion(ItemMenu opcion) {
        opciones.add(opcion);
    }

    public void ejecutar(ApplicationContext ctx) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n" + titulo);
            for (ItemMenu op : opciones) {
                System.out.printf("%d. %s%n", op.code(), op.label());
            }
            System.out.println("0. Salir");
            System.out.print("Elija una opción: ");
            String input = sc.nextLine();
            int code;
            try {
                code = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Entrada no numérica. Intente de nuevo.");
                continue;
            }
            if (code == 0) break;
            Optional<ItemMenu> opt = opciones.stream().filter(o -> o.code() == code).findFirst();
            if (opt.isPresent()) {
                opt.get().action().run(ctx);
            } else {
                System.out.println("Opción inválida.");
            }
        }
        System.out.println("¡Hasta luego!");
    }
}
