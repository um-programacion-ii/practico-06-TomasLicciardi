package org.example.DAO.implementations;

import org.example.entities.Especialidad;
import org.example.entities.Medico;
import org.example.entities.ObraSocial;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MedicoDAOIm implements org.example.DAO.interfaces.MedicoDAO {
    private final Map<Integer, Medico> medicos = new HashMap<>();
    private int proximoId = 1;

    @Override
    public Medico crearMedico(Medico medico) {
        medico.setId(proximoId++);
        medicos.put(medico.getId(), medico);
        return medico;
    }

    @Override
    public Medico obtenerMedicoPorId(int id) {
        return medicos.get(id);
    }

    @Override
    public List<Medico> obtenerMedicos() {
        return new ArrayList<>(medicos.values());
    }

    @Override
    public List<Medico> obtenerMedicosPorEspecialidad(Especialidad especialidad) {
        List<Medico> medicosPorEspecialidad = new ArrayList<>();
        for (Medico medico : medicos.values()) {
            if (medico.getEspecialidad().equals(especialidad)) {
                medicosPorEspecialidad.add(medico);
            }
        }
        return medicosPorEspecialidad;
    }

    @Override
    public List<Medico> obtenerMedicosParticulares() {
        List<Medico> medicosParticulares = new ArrayList<>();
        for (Medico medico : medicos.values()) {
            if (medico.getAtenderParticulares()) {
                medicosParticulares.add(medico);
            }
        }
        return medicosParticulares;
    }

    @Override
    public List<Medico> obtenerMedicosPorObrasSociales(ObraSocial obraSocial) {
        List<Medico> medicosPorObraSocial = new ArrayList<>();
        for (Medico medico : medicos.values()) {
            if (medico.getObraSociales().contains(obraSocial)) {
                medicosPorObraSocial.add(medico);
            }
        }
        return medicosPorObraSocial;
    }

    @Override
    public void actualizarMedico(Medico medico) {
        medicos.put(medico.getId(), medico);
    }

    @Override
    public void eliminarMedico(int id) {
        medicos.remove(id);
    }
}

