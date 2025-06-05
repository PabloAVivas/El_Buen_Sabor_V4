package org.example.BuenSabor_V4.Entities;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder

public class Sucursal extends Base{
    private String nombre;
    private LocalTime horarioApertura;
    private LocalTime horarioCierre;

    //muchos a uno
    private Empresa empresa;

    //uno a muchos
    private Domicilio domicilio;
    @Builder.Default
    private Set<Promocion> promociones = new HashSet<>();
    @Builder.Default
    private Set<Pedido> pedidos = new HashSet<>();
    @Builder.Default
    private Set<Categoria> categorias = new HashSet<>();

    public void agregarPromocion(Promocion promocion){
        promociones.add(promocion);
    }

    public void agregarPedido(Pedido pedido){
        pedidos.add(pedido);
    }

    public void agregarCategoria(Categoria categoria){
        categorias.add(categoria);
    }

    @Override
    public String toString() {
/*       String nombreEmpresa = (empresa != null) ? empresa.getNombre() : "null";
        String calleDomicilio = (domicilio != null) ? domicilio.getCalle() : "null";

        // Si promociones es null, inicializa como una lista vacía
        String promocionesString = (promociones != null && !promociones.isEmpty())
                ? promociones.stream()
                .map(Promocion::getNombre)
                .collect(Collectors.joining(", "))
                : "[]"; // O "null"*/

        return "Sucursal{" +
                "nombre='" + nombre + '\'' +
                ", horarioApertura=" + horarioApertura +
                ", horarioCierre=" + horarioCierre +
                ", empresa=" + (empresa != null ? empresa.getNombre():"Null") +
                ", domicilio=" + (domicilio != null ? domicilio.getCalle():"Null") +
                ", promociones=" + (promociones != null ? promociones.stream().map(Promocion::getDenominacion).collect(Collectors.joining(", ")):"Null") +
                ", categorias=" + (categorias != null ? categorias.stream().map(Categoria::getDenominacion).collect(Collectors.joining(", ")):"Null") +
                '}';
    }
}
