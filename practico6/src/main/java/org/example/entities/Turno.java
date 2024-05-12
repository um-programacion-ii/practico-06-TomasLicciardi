package org.example.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Turno {
    private int id;
    private Medico medico;
    private Paciente paciente;
    private Receta receta; // Puede ser null si no se generó receta
}
