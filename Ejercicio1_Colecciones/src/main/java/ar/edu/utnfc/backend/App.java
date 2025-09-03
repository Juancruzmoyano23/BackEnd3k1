/* 2. Gestión Logística de Viajes
📝 Enunciado: Gestión Logística de Viajes
Contexto
Una empresa de logística administra distintos tipos de viajes para transporte de pasajeros y carga.
Cada viaje puede ser aéreo, terrestre o marítimo, y debe registrarse con sus datos generales más los específicos de cada tipo.

Requisitos del modelo
Clases:

 Viaje

String codigo (alfanumérico, único por viaje).

int nroReserva

double precio

int tipo (1=Aéreo, 2=Terrestre, 3=Marítimo)

Cliente cliente

Aereo

int millasAcumuladas

String codAerolinea

Terrestre

int provinciasVisitadas

int cantidadPasajeros

Maritimo

int cantidadContenedores

double costoPorKilo

double pesoTransportado

Cliente

String nombreEmpresa

String cuit

Entrada de datos (CSV)

Se recibe un archivo .csv (viajes.csv) con N líneas (1 línea = 1 viaje).

Cada fila tiene todas las columnas, y los valores de las columnas no aplicables a un tipo se completan con 0.

Almacenamiento

Se debe verificar la creación de clientes con una estructura HashMap<String, Cliente>, donde la clave sea el cuit. Si un cliente ya existe, se asigna el preexistente.

Los objetos Viaje se guardan en una estructura que derive de Collection (por ejemplo, ArrayList, HashSet, etc.).

Las clases Viaje, Aereo, Terrestre y Maritimo deben implementarse utilizando herencia.

Consignas (una vez procesados los datos)
Mostrar por pantalla la cantidad única de clientes cargados.

Solicitar y mostrar la cantidad de cada tipo de viaje (Aéreo, Terrestre, Marítimo).

Mostrar:

Cantidad total de pasajeros transportados.

Cantidad total de millas acumuladas.

Cantidad total de contenedores transportados.

Implementar un método de clase que calcule el costo total de un viaje como costoPorKilo * pesoTransportado para los viajes marítimos.

Una vez creado el método anterior, mostrar el costo acumulado total de aquellos viajes marítimos que transporten 5 o más contenedores.
*/

package ar.edu.utnfc.backend;

import java.io.File;
import java.util.Scanner;

public class App
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        String ruta = "src/main/resources/viajes.csv";
        preocesarArchivo(ruta);
    }

    public static void preocesarArchivo(String ruta){
        // tengo que definir los arrays por asi decirlo
        ClientesManager clienteM = new ClientesManager();
        ViajesArrays viajeA = new ViajesArrays();

        try (Scanner sn = new Scanner(new File(ruta))){
            sn.nextLine(); // Saltear la primera línea (encabezados)
            while (sn.hasNextLine()){
                String linea = sn.nextLine();
                String[] datos = linea.split(";");
                String codigo = datos[0];
                int nroReserva = Integer.parseInt(datos[1]);
                double precio = Double.parseDouble(datos[2]);
                int tipo = Integer.parseInt(datos[3]);       
                int provinciasVisitadas = Integer.parseInt(datos[6]);
                int cantidadPasajeros = Integer.parseInt(datos[7]);
                int cantidadContenerdores = Integer.parseInt(datos[8]);
                double costoPorKilo = Double.parseDouble(datos[9]);
                double pesoTransportado = Double.parseDouble(datos[10]);
                String nombreEmpresa = datos[11];
                String cuit = datos[12];

                // le paso a clientes lo que retorne ClientesManager
                // Cliente cliente = ClientesManager.obtenerExistenciaCliente(cuit, nombreEmpresa);

                // creo los viajes segun el tipo
                // Viajes viaje = null;
                if (tipo == 1){
                    // Viajes viaje = new Aereo(codigo, nroReserva, precio, tipo, cliente, millasAcumuladas, codAerolinea);
                }
            }
            
        } catch (Exception e) {
            System.out.println("Error al procesar el archivo: " + e.getMessage());
        }
    }
}
