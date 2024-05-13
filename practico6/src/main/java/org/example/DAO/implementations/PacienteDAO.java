package org.example.DAO.implementations;

import org.example.entities.Paciente;
import java.util.HashMap;
import java.util.Map;

public class PacienteDAO implements org.example.DAO.interfaces.PacienteDAO {
    private static PacienteDAO instancia;
    private final Map<Integer, Paciente> pacientes = new HashMap<>();
    private int proximoId = 1;

    private PacienteDAO() {}

    public static PacienteDAO getInstance() {
        if (instancia == null) {
            instancia = new PacienteDAO();
        }
        return instancia;
    }

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
    public void actualizarPaciente(Paciente paciente) {
        pacientes.put(paciente.getId(), paciente);
    }

    @Override
    public void eliminarPaciente(int id) {
        pacientes.remove(id);
    }
}
