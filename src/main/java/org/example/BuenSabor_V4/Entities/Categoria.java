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
public class Categoria extends Base {
    private String denominacion;
    private Categoria categoriaPadre; //null
    @Builder.Default
    private Set<Categoria> subcategorias = new HashSet<>();
    @Builder.Default
    private Set<Articulo> articulos = new HashSet<>();

    public void agregarSubcategoria(Categoria subcategoria){
        subcategorias.add(subcategoria);
    }

    public void agregarArticulo(Articulo articulo){
        articulos.add(articulo);
    }

    @Override
    public String toString() {
        return "Categoria{" +
                "denominacion='" + denominacion + '\'' +
                ", categoriaPadre=" + (categoriaPadre != null ? categoriaPadre.getDenominacion() : "Ninguna") +
                ", subcategorias=" + (subcategorias != null ? subcategorias.stream().map(Categoria::getDenominacion).collect(Collectors.joining(", ")):"Null") +
                ", articulos=" + (articulos != null ? articulos.stream().map(Articulo::getDenominacion).collect(Collectors.joining(", ")):"Null") +
                '}';
    }
}
