package org.example.BuenSabor_V4.Entities;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.HashSet;
import java.util.Set;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public abstract class Articulo extends Base{

    protected String denominacion;
    protected Double precioVenta;

    protected UnidadMedida unidadMedida;
    @Builder.Default
    protected Set<Imagen> imagenes = new HashSet<>();

    protected Categoria categoria;

    public void agregarImagen(Imagen imagen){
        imagenes.add(imagen);
    }
}
