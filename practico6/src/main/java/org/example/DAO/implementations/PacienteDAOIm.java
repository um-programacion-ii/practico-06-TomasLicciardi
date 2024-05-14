package org.example.DAO.implementations;

import org.example.entities.Paciente;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PacienteDAOIm implements org.example.DAO.interfaces.PacienteDAO {
    private final Map<Integer, Paciente> pacientes = new HashMap<>();
    private int proximoId = 1;

    private PacienteDAOIm() {}

    @Override
    public Paciente crearPaciente(Paciente paciente) {
        paciente.setId(proximoId++);
        pacientes.put(paciente.getId(), paciente);
        return paciente;
    }

    @Override
    public Paciente obtenerPacientePorId(int id) {
        return pacientes.get(id);
    }

    @Override
    public List<Paciente> obtenerPacientes() {
        return new ArrayList<>(pacientes.values());
    }

    @Override
    public void actualizarPaciente(Paciente paciente) {
        pacientes.put(paciente.getId(), paciente);
    }

    @Override
    public void eliminarPaciente(int id) {
        pacientes.remove(id);
    }
}
