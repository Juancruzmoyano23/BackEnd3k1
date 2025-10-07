package main.java.ar.edu.utnfrc.backend.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;

import entities.Empleado;
import main.java.ar.edu.utnfrc.backend.entities.repositories.EmpleadoRepository;

public class EmpleadoService {
    private final EmpleadoRepository empleadoRepository;

    public EmpleadoService() {
        empleadoRepository = new EmpleadoRepository();
    }

    public void bulkInsert(File fileToImport) throws IOException {
        Files.lines(Paths.get(fileToImport.toURI()))
                .skip(1)
                .forEach(linea -> {
                    Empleado empleado = procesarLinea(linea);
                    this.empleadoRepository.add(empleado);
                });
    }

    private Empleado procesarLinea(String linea) {
        String[] valores = linea.split(","); //Podria ser otro caracter de division
        Empleado empleado = new Empleado();

        //No conozco en que posicion vendran los valores
        //No conozco si habra algun tipo de chequeo extra o logica asociada
        empleado.setNombre(valores[0]);
        empleado.setEdad(Integer.parseInt(valores[1]));
        empleado.setFechaIngreso(LocalDate.parse(valores[2]));
        empleado.setSalario(Double.parseDouble(valores[3]));
        empleado.setEmpleadoFijo(Boolean.parseBoolean(valores[4]));

        //No conozco como llegaran los datos de Departamento/Puesto
        //empleado.setDepartamento();
        //empleado.setPuesto();

        return empleado;
    }
}
