package com.frc.isi.csv.colecciones.entities;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Venta {
    private String codigo;
    private String producto;
    private int cantidadVendida;
    private double precioUnitario;
    private double descuento;
    private TipoProducto tipoProducto;

    //public double calcularPrecioVenta() {}

    public toSttring() {
        return "Venta{" +
                "codigo='" + codigo + '\'' +
                ", producto='" + producto + '\'' +
                ", cantidadVendida=" + cantidadVendida +
                ", precioUnitario=" + precioUnitario +
                ", descuento=" + descuento +
                ", tipoProducto=" + (tipoProducto != null ? tipoProducto.getDescripcion() : "null") +
                '}';
    }
}
