package org.example.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Farmacia {
    private Integer id;
    private String nombre;
    private String direccion;
    private Integer telefono;
    private Map<String, Integer> medicamentos;
}
