package org.example.DAO.interfaces;

import org.example.entities.Especialidad;

public interface EspecialidadDAO {
    Especialidad crearEspecialidad(Especialidad especialidad);
    Especialidad obtenerEspecialidadPorId(int id);
    void actualizarEspecialidad(Especialidad especialidad);
    void eliminarEspecialidad(int id);
}
