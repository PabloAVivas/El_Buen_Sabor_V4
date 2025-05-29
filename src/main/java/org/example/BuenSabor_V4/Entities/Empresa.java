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
public class Empresa extends Base{
    private String nombre;
    private String razonSocial;
    private Integer cuil;

    //uno a muchos
    @Builder.Default
    private Set<Sucursal> sucursales = new HashSet<>();

    public void agregarSucursal(Sucursal sucursal){
        sucursales.add(sucursal);
    }

    @Override
    public String toString() {
        return "Empresa{" +
                "nombre='" + nombre + '\'' +
                ", razonSocial='" + razonSocial + '\'' +
                ", cuil=" + cuil +
                ", sucursales=" + (sucursales != null ? sucursales.stream().map(Sucursal::getNombre).collect(Collectors.joining(", ")):"Null") +
                '}';
    }
}
