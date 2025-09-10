package ar.edu.utnfc.backend;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

        
        Menu menu = new Menu();
        Accionnes acciones = new Acciones();

        menu.addOpcione(new Opcion(1, "Cargar Persona", () -> acciones::cargar));
        Menu.addOpcion(new Opcion(2, "hola", () -> acciones.mostrar()));

        // dame tofas las persona que son mayor de edad

        List<personas> person = personas.stream()
            .filtrer(p -> p.getEdad() >= 10)
            .collect(Colector.tolist());

        resultado.stream().forEach(System.out::println);
        menu.ejecutar();

        /* operacionMatematica[] operacion = new operacionMatematica[]{
                (double a, double b) -> a + b,
                (double a, double b) -> a - b,
                (double a, double b) -> a % b,
                (double a, double b) -> {
                    if (b < 0){
                        throw new IllegalArgumentException("El segundo numero no puede ser negativo");
                    }
                    return a / b;
                }
        };

        double n1 = (Math.random() * 1500) + 1;
        double n2 = (Math.random() * 1500) + 1;
        operacion[1].calcular(n1, n2);
    } */

}
