package com.frc.isi.csv.colecciones.menu;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Menu<T> implements IMenu<T> {

    private Map<integer, OpcionMenu<T>> acciones = new LinkedHashMap<>();
    // creo el mapa de opciones -> acciones (con LinkedHashMap conservo el orden de insercion)

    private List<ItemMenu> items = new ArrayList<>();
    // creo la lista visible de items del menu



    // implemento los metodos de la interfaz IMenu<T>

    @Override
    public void registrarOpcion(Integer indice, String textoAMostrar, OpcionDeMenu<T> action) {
        // agrego elemento a la collecion, guardo una accion por us numero y su accion
        acciones.put(opcion, action);
        // agrego el elemento visible a la lista
        items.add(new ItemMenu(opcion, textoAMostrar));
    } 

    @Override
    public void invocarAction(T contexto, Scanner lector) {
        // creamos el Menu
        while (true) {
            System.out.println("\n==== " + titulo + " ====");
            // recorro la lista para mostrarlas
            items.foreach(System.out::println);
            System.out.println("Elige una opcion:");
            System.out.println("0: ---------- salir");

            String entrada = lector.nextLine().trim();
            int op;

            try {
                op = Integer.parseInt(entrada);  // se parsea el valor de que se ingresa por teclado
            } catch (NumberFormatException e) {
                System.out.println("Error: Debe ingresar un numero valido.");
                continue;
            }

            if (op == 0) {
                System.out.println("Gracias por ingresar... Hasta Luego !!");
                break;
            }

            // busco la accion determinada por la opcion ingresada
            OpcionDeMenu<T> accion = acciones.get(op);






        }




    }
}
