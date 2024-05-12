package org.example.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Drogueria {
    private Integer id;
    private String nombre;
    private String direccion;
    private Integer telefono;
}
