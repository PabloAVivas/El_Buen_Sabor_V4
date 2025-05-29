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
public class Provincia extends Base{
    private String nombre;

    //muchos a uno
    private Pais pais;

    @Override
    public String toString() {
        return "Provincia{" +
                "nombre='" + nombre + '\'' +
                ", pais=" + (pais!= null ? pais.getNombre():"Null") +
                '}';
    }
}
