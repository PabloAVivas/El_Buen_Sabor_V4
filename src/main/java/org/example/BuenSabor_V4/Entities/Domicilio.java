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
public class Domicilio extends Base{
    private String calle;
    private int numero;
    private int cp;

    //Muchos a uno
    private Localidad localidad;

    @Override
    public String toString() {
        return "Domicilio{" +
                "calle='" + calle + '\'' +
                ", numero=" + numero +
                ", cp=" + cp +
                ", localidad=" + (localidad != null ? localidad.getNombre():"Null") +
                '}';
    }
}
