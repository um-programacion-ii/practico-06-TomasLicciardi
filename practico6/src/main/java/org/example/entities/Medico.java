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
    private List<Turno> turnos;
    private List<Paciente> pacientes;
    private Boolean atenderParticulares;

    public void hacerReceta(Paciente paciente, Map<Medicamento, Integer> medicamentos) {
        Receta receta = new Receta();
        receta.setMedicamentos(medicamentos);
        receta.setPaciente(paciente);
        receta.setMedico(this);
    }

    public void agregarTurno(Turno turno) {
        this.turnos.add(turno);
    }

    public void atenderPaciente() {
        this.estaAtendiendo = true;
    }

    public void dejarDeAtender() {
        this.estaAtendiendo = false;
    }

    public void finalizarTurno(Turno turno) {
        this.turnos.remove(turno);
    }

}


