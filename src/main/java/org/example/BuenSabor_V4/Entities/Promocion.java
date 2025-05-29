package org.example.BuenSabor_V4.Entities;

import lombok.*;
import lombok.experimental.SuperBuilder;
import org.example.BuenSabor_V4.Entities.Enums.TipoPromocion;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Promocion {
    private String denominacion;
    private LocalDate FechaDesde;
    private LocalDate FechaHasta;
    private LocalDate HoraDesde;
    private LocalDate HoraHasta;
    private String descripcionDescuento;
    private Double precioPromocional;
    private TipoPromocion tipoPromocion;
    @Builder.Default
    private Set<Imagen> imagenes = new HashSet<>();
    @Builder.Default
    private Set<Articulo> articulos = new HashSet<>();
    @Builder.Default
    private Set<Sucursal> sucursales = new HashSet<>();

    public void agregarImagen(Imagen imagen){
        imagenes.add(imagen);
    }

    public void agregarArticulo(Articulo articulo){
        articulos.add(articulo);
    }

    public void agregarSucursal(Sucursal sucursal){
        sucursales.add(sucursal);
    }


    @Override
    public String toString() {
        return "Promocion{" +
                "denominacion='" + denominacion + '\'' +
                ", FechaDesde=" + FechaDesde +
                ", FechaHasta=" + FechaHasta +
                ", HoraDesde=" + HoraDesde +
                ", HoraHasta=" + HoraHasta +
                ", descripcionDescuento='" + descripcionDescuento + '\'' +
                ", precioPromocional=" + precioPromocional +
                ", tipoPromocion=" + tipoPromocion +
                ", imagenes=" + (imagenes != null ? imagenes.stream().map(Imagen::getDenominacion).collect(Collectors.joining(", ")):"Null") +
                ", articulos=" + (articulos != null ? articulos.stream().map(Articulo::getDenominacion).collect(Collectors.joining(", ")):"Null") +
                ", sucursales=" + (sucursales != null ? sucursales.stream().map(Sucursal::getNombre).collect(Collectors.joining(", ")):"Null") +
                '}';
    }
}
