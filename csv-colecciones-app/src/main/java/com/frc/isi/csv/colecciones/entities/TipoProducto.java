package com.frc.isi.csv.colecciones.entities;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class TipoProducto {
    private int codigo;
    private String descripcion;


    @Override
    public String toString() {
        return "TipoProducto{" +
                "codigo=" + codigo +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
