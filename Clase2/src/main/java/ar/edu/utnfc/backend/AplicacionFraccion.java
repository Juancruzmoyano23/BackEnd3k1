public class AplicacionFraccion

{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        Fraccion();
        Fraccion f4 = f1.sumar(f2);
        // f1 = f1.sumar(f2);
    }

    public static void Fraccion() {
        Fraccion f1 = new Fraccion(1, 2);
        Fraccion f2 = new Fraccion(3, 4);
        Fraccion f3 = new Fraccion(5, 6);
    }

    public void MostrarFracciones() {
        System.out.println("Numerador: " + f1.toString());
        System.out.println("Denominador: " + f2.toString());
        System.out.println("Fraccion: " + f3.toString());
    }

}
