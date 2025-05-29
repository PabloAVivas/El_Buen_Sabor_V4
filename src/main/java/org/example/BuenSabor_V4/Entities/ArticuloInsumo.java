package org.example.BuenSabor_V4.Entities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class ArticuloInsumo extends Articulo{
    private Double precioCompra;
    private int stockActual;
    private int stockMaximo;
    private Boolean esParaElaborar;


    @Override
    public String toString() {
        return "ArticuloInsumo{" +
                "denominacion='" + denominacion + '\'' +
                ", precioVenta=" + precioVenta +
                ", precioCompra=" + precioCompra +
                ", stockActual=" + stockActual +
                ", stockMaximo=" + stockMaximo +
                ", esParaElaborar=" + esParaElaborar +
                ", unidadMedida=" + (unidadMedida != null ? unidadMedida.getDenominacion(): "Null") +
                ", imagenes=" + (imagenes != null ? imagenes.stream().map(Imagen::getDenominacion).collect(Collectors.joining(", ")):"Null") +
                ", categoria=" + (categoria != null ? categoria.getDenominacion(): "Null" )+
                '}';
    }
}
