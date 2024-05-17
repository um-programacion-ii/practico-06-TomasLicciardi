package org.example.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Especialidad {
    private Integer id;
    private String nombre;

    public Especialidad(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
}
