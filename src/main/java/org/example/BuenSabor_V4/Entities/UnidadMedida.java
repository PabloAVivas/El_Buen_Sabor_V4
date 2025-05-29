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
public class UnidadMedida extends Base {
    private String denominacion;

    @Override
    public String toString() {
        return "UnidadMedida{" +
                "denominacion='" + denominacion + '\'' +
                '}';
    }
}
