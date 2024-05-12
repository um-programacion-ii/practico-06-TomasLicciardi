package org.example.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Medico {
    private Integer id;
    private String nombre;
    private String apellido;
    private Especialidad especialidad;
    private Boolean estaAtendiendo;
    private List<Receta> recetas;
    private List<ObraSocial> obraSociales;
}
