package org.example.DAO.implementations;

import org.example.entities.Especialidad;

import java.util.HashMap;
import java.util.Map;

public class EspecialidadDAOIm implements org.example.DAO.interfaces.EspecialidadDAO {
    private final Map<Integer, Especialidad> especialidades = new HashMap<>();
    private int proximoId = 1;

    private EspecialidadDAOIm() {}
    @Override
    public Especialidad crearEspecialidad(Especialidad especialidad) {
        especialidad.setId(proximoId++);
        especialidades.put(especialidad.getId(), especialidad);
        return especialidad;
    }

    @Override
    public Especialidad obtenerEspecialidadPorId(int id) {
        return especialidades.get(id);
    }

    @Override
    public void actualizarEspecialidad(Especialidad especialidad) {
        especialidades.put(especialidad.getId(), especialidad);
    }

    @Override
    public void eliminarEspecialidad(int id) {
        especialidades.remove(id);
    }
}
