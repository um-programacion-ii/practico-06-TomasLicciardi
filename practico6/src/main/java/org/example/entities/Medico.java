package org.example.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Medico {
    private int id;
    private String nombre;
    private Especialidad especialidad;
    private ObraSocial obraSocial;
    private boolean atencionParticular;
}
