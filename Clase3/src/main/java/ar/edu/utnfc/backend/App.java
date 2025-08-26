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
        int[] v = new int[10]; // [12*n]

        // carga

        for (int i = 0; i < 10; i++){
            int num = ((int) (Math.random()*100))+1;
            v[i] = num;
        }    

        int num = ((int) Math.random()*100)+1;
        v[9] = num;

        // int num = ((int) Math.random()*100)+1;
        // v[10] = num;

        // jerarquia de exepciones
        // 1                                     Throweble
        // 2         Errores                                                 Exepciones
        //        un porblema que                                 son salvables, manejables
        //      no se puede mamenjar                           ej: nullpinterexeption respuesta: (variable distinta de null)
//              ej: pifiar la condicion de corte               ej: indexoutBoundsexeption respuesta: (validar el indice)
//                                                             ej: filenotfoundexeption se maneja con Try and Catch y Finaly
        
        try {
            v[10] = num;
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Error de indice fuera de rango");
        }
    
    }
}
