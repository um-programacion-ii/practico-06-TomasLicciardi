package org.example.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Paciente {
    private Integer id;
    private String nombre;
    private String apellido;
    private ObraSocial obraSocial;
    private List<Receta> recetas;
}
