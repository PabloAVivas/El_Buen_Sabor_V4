package org.example.BuenSabor_V4.Entities;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class ArticuloManufacturado extends Articulo{
    private String descripcion;
    private int tiempoEstimadoMinutos;
    private String preparacion;
    @Builder.Default
    private Set<ArticuloManufacturadoDetalle> articuloManufacturadoDetalles = new HashSet<>();

    public void agregarArticuloManufacturadoDetalle(ArticuloManufacturadoDetalle articuloManufacturadoDetalle){
        articuloManufacturadoDetalles.add(articuloManufacturadoDetalle);
    }

    @Override
    public String toString() {
        return "ArticuloManufacturado{" +
                "denominacion='" + denominacion + '\'' +
                ", precioVenta=" + precioVenta +
                ", descripcion='" + descripcion + '\'' +
                ", tiempoEstimadoMinutos=" + tiempoEstimadoMinutos +
                ", preparacion='" + preparacion + '\'' +
                ", articuloManufacturadoDetalles=" +(articuloManufacturadoDetalles!= null ? articuloManufacturadoDetalles.stream().map(ArticuloManufacturadoDetalle::getCantidad).map(String::valueOf).collect(Collectors.joining(", ")):"Null") +
                ", unidadMedida=" +(unidadMedida != null ? unidadMedida.getDenominacion():"Null") +
                ", imagenes=" + (imagenes != null ? imagenes.stream().map(Imagen::getDenominacion).collect(Collectors.joining(", ")):"Null") +
                ", categoria=" + (categoria != null ? categoria.getDenominacion():"Null") +
                '}';
    }
}
