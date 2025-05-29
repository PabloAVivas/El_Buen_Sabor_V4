package org.example.BuenSabor_V4.Entities;

import lombok.*;
import lombok.experimental.SuperBuilder;
import org.example.BuenSabor_V4.Entities.Enums.Estado;
import org.example.BuenSabor_V4.Entities.Enums.*;
import org.example.BuenSabor_V4.Entities.Enums.TipoEnvio;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Pedido extends Base {
    private LocalTime horaEstimadaFinalizacion;
    private Double costo;
    private Double costoTotal;
    private Estado estado;
    private TipoEnvio tipoEnvio;
    private FormaPago formaPago;
    private LocalDate FechaPedido;

    private Cliente cliente;
    @Builder.Default
    private Set<DetallePedido> detallesPedido = new HashSet<>();

    private Factura factura;

    private Domicilio domicilio;

    private Sucursal sucursal;

    public void agregarDetallePedido(DetallePedido detallePedido){
        detallesPedido.add(detallePedido);
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "horaEstimadaFinalizacion=" + horaEstimadaFinalizacion +
                ", costo=" + costo +
                ", costoTotal=" + costoTotal +
                ", estado=" + estado +
                ", tipoEnvio=" + tipoEnvio +
                ", formaPago=" + formaPago +
                ", FechaPedido=" + FechaPedido +
                ", cliente=" + (cliente != null ? cliente.toStringCorto():"Null") +
                ", detallesPedido=" + (detallesPedido != null ? detallesPedido.stream().map(DetallePedido::toStringCorto).map(String::valueOf).collect(Collectors.joining(", ")):"Null") +
                ", factura=" + (factura != null ? factura.toStringCorto():"Null") +
                ", domicilio=" + (domicilio != null ? domicilio.getCalle():"Null") +
                ", sucursal=" + (sucursal != null ? sucursal.getNombre():"Null") +
                '}';
    }
    public String toStringCorto() {
        return "Pedido{" +
                "horaEstimadaFinalizacion=" + horaEstimadaFinalizacion +
                ", costo=" + costo +
                ", costoTotal=" + costoTotal +
                ", estado=" + estado +
                ", tipoEnvio=" + tipoEnvio +
                ", formaPago=" + formaPago +
                ", FechaPedido=" + FechaPedido +
                '}';
    }
}
