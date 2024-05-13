package org.example.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Medico {
    private Integer id;
    private String nombre;
    private String apellido;
    private Boolean estaAtendiendo;
    private Especialidad especialidad;
    private List<ObraSocial> obraSociales;

    public void atenderPaciente() {
        this.estaAtendiendo = true;
    }

    public void dejarDeAtender() {
        this.estaAtendiendo = false;
    }
}
