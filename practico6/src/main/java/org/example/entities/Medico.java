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
    private Boolean atenderParticulares;
    private List<Paciente> pacientes;

    public void hacerReceta(Paciente paciente, Map<Medicamento, Integer> medicamentos) {
        Receta receta = new Receta();
        receta.setMedicamentos(medicamentos);
        paciente.agregarReceta(receta);
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
        turno.getPaciente().cancelarTurno(turno);
    }

}


