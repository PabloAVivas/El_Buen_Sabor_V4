package org.example.BuenSabor_V4.Entities;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Cliente extends Base{
    private String nombre;
    private String apellido;
    private String telefono;
    private String email;
    private LocalDate fechaNacimiento;

    private Usuario usuario;
    private Imagen imagen;
    @Builder.Default
    private Set<Domicilio> domicilios = new HashSet<>();

    public void agregarDomicilio(Domicilio domicilio){
        domicilios.add(domicilio);
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", telefono='" + telefono + '\'' +
                ", email='" + email + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                ", usuario=" + (usuario != null ? usuario.getUserName():"Null") +
                ", imagen=" + (imagen != null ? imagen.getDenominacion():"Null") +
                ", domicilios=" + (domicilios != null ? domicilios.stream().map(Domicilio::getCalle).collect(Collectors.joining(", ")):"Null") +
                '}';
    }
    public String toStringCorto() {
        return "Cliente{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", telefono='" + telefono + '\'' +
                '}';
    }
}
