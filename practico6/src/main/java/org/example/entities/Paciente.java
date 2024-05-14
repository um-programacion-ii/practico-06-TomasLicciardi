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
    private List<Turno> turnos;

    public void agregarReceta(Receta receta) {
        recetas.add(receta);
    }
    public void agregarTurno(Turno turno) {
        turnos.add(turno);
    }
    public Turno solicitarTurno(Medico medico, ObraSocial obraSocial, Especialidad especialidad) {
            Turno turno = new Turno();
            turno.setMedico(medico);
            turno.setPaciente(this);
            turno.setObraSocial(obraSocial);
            turno.setEspecialidad(especialidad);
            medico.agregarTurno(turno);
            this.agregarTurno(turno);
            return turno;
    }

    public void cancelarTurno(Turno turno) {
        turnos.remove(turno);
        turno.getMedico().finalizarTurno(turno);
    }

}


