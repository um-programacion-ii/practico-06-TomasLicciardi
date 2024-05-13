package org.example.DAO.interfaces;

import org.example.entities.Paciente;

public interface PacienteDAO {
    Paciente crearPaciente(Paciente paciente);
    Paciente obtenerPacientePorId(int id);
    void actualizarPaciente(Paciente paciente);
    void eliminarPaciente(int id);
}