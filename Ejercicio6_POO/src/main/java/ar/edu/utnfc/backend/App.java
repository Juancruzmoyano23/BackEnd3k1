/* 6. Viajes de Trenes - CSV
Ejercicio: Procesamiento de archivos CSV - Transporte de trenes

En este trabajo práctico vamos a simular el procesamiento de información de viajes de trenes a partir de un archivo CSV.


Link del proyecto base: https://labsys.frc.utn.edu.ar/gitlab/backend-app/profes/valen-martini/transporte-trenes

El archivo se llama viajes.csv y tiene la siguiente estructura (separado por comas):

id_viaje,linea,origen,destino,horario_salida,horario_llegada,pasajeros

1,Mitre,Tigre,Retiro,06:00,07:05,320

2,Mitre,Retiro,Tigre,07:30,08:40,280

3,Sarmiento,Once,Castelar,06:15,07:05,450 

4,San Martín,Pilar,Retiro,05:50,07:20,390

5,Sarmiento,Castelar,Once,07:30,08:20,470 ...

 Cada fila representa un viaje realizado, con los siguientes datos:

id_viaje: identificador único del viaje
linea: nombre de la línea de tren
origen: estación de salida
destino: estación de llegada
horario_salida: hora de partida (formato HH:mm)
horario_llegada: hora de llegada (formato HH:mm)
pasajeros: cantidad de pasajeros transportados en ese viaje
Consignas
1.Lectura del archivo CSV

Leer el archivo viajes.csv y cargar los datos en una lista de objetos Viaje.
2. Duración de cada viaje

Calcular la duración de cada viaje en minutos (diferencia entre horario_salida y horario_llegada).  
Agregar este dato al objeto Viaje.
3. Reportes 

Implementar métodos que permitan obtener:  

Cantidad total de pasajeros transportados por cada línea.  
Promedio de duración de los viajes por cada línea.  
Viaje con mayor cantidad de pasajeros.  
Viaje más largo en duración.
4. Exportar resultados

Generar un nuevo archivo resumen.csv con el siguiente formato:
linea,total_pasajeros,promedio_duracion

Mitre,600,67.5

Sarmiento,920,55.0

San Martín,390,90.0

5. Bonus (opcional)

Permitir filtrar los viajes por línea y exportar solo esos resultados a un nuevo archivo.
  FRC-UTN - Backend de Aplicaciones*/

package main.java.ar.edu.utnfc.backend;

import java.io.File;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.Comparator;
import java.util.Optional;
import static main.java.ar.edu.utnfc.backend.Reportes.viajeMasLargo;


/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

        String ruta = "C:\\Users\\juanc\\OneDrive\\Escritorio\\Proyectos Facultad\\BackEnd\\Ejercicio6_POO\\src\\main\\java\\ar\\edu\\utnfc\\backend\\viajes.csv";

        // creo la lista de viajes por que Reportes necesita una lista de viajes
        List<Viaje> viajes = new ArrayList<>();

        try (Scanner sn = new Scanner(new File(ruta))){
            sn.nextLine(); // salteo primera linea

            while (sn.hasNextLine()){
                String linea = sn.nextLine();
                String[] datos = linea.split(",");

            
                int id_viaje = Integer.parseInt(datos[0]);
                String lineaa = datos[1];
                String origen = datos[2];
                String destino = datos[3];
                String horario_salida = datos[4];
                String horario_llegada = datos[5];
                int pasajeros = Integer.parseInt(datos[6]);
                
                // Crear objeto Viaje
                Viaje v = new Viaje(id_viaje, lineaa, origen, destino, horario_salida, horario_llegada, pasajeros);
                
                // mostrar los viajes cargados
                System.out.println(v);
            }

        } catch (Exception e) {
            System.out.println("Error al procesar el archivo: " + e.getMessage());
        }

        // Reportes
        var paxPorLinea = Reportes.pasajerosPorLinea(viajes);
        System.out.println("\nPasajeros por línea: " + paxPorLinea);

        var promDuracion = Reportes.promedioDuracionPorLinea(viajes);
        System.out.println("Promedio de duración por línea (min): " + promDuracion);

    // OJO: pasar 'viajes' (lista), no 'viaje' (objeto)
    Reportes.viajeConMasPasajeros(viajes)
            .ifPresent(v -> System.out.println("Viaje con más pasajeros: " + v));

    Reportes.viajeMasLargo(viajes)
        .ifPresent(v -> System.out.println("Viaje más largo: " + v));
        
    }
}
