package org.example.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Turno {
    private Integer id;
    private Paciente paciente;
    private Medico medico;
    private ObraSocial obraSocial;
    private Especialidad especialidad;
}
