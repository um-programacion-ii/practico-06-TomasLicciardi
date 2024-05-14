package org.example.DAO.interfaces;

import org.example.entities.Paciente;

import java.util.List;

public interface PacienteDAO {
    Paciente crearPaciente(Paciente paciente);
    Paciente obtenerPacientePorId(int id);
    List<Paciente> obtenerPacientes();

    void actualizarPaciente(Paciente paciente);
    void eliminarPaciente(int id);
}