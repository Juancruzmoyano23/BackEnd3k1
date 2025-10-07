package main.java.ar.edu.utnfrc.backend.menu;

@FunctionalInterface
public interface MenuAction {
    void run(ApplicationContext ctx);
}
