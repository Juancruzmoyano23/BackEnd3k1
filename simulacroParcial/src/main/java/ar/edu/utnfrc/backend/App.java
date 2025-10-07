package ar.edu.utnfrc.backend;

import java.net.URL;

import ar.edu.utnfrc.backend.menu.ApplicationContext;
import ar.edu.utnfrc.backend.menu.ItemMenu;
import ar.edu.utnfrc.backend.menu.Menu;
import ar.edu.utnfrc.backend.services.EmpleadoService;
import main.java.ar.edu.utnfrc.backend.Acciones;

public class App {
    public static void main(String[] args) {
        var ctx = ApplicationContext.getInstance();
        Menu menu = new Menu();
        menu.setTitulo("Menu de Opciones de Empleados");

        Acciones acciones = new Acciones();

        URL folderPath = App.class.getResource("/files"); //Puede definir la ruta que desee
        ctx.put("path", folderPath);
        ctx.registerService(EmpleadoService.class, new EmpleadoService());

        menu.addOpcion(new ItemMenu(1, "Cargar Empleados", acciones::importarCsv));

        menu.ejecutar(ctx);
    }
}
