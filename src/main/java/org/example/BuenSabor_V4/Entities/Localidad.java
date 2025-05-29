package org.example.BuenSabor_V4.Entities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Localidad extends Base{
    private String nombre;

    //muchos a uno
    private Provincia provincia;

    @Override
    public String toString() {
        return "Localidad{" +
                "nombre='" + nombre + '\'' +
                ", provincia=" + (provincia != null ? provincia.getNombre():"Null") +
                '}';
    }
}
