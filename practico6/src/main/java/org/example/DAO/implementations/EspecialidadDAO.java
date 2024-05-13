package org.example.DAO.implementations;

import org.example.entities.Especialidad;
import java.util.HashMap;
import java.util.Map;

public class EspecialidadDAO implements org.example.DAO.interfaces.EspecialidadDAO {
    private static EspecialidadDAO instancia;
    private final Map<Integer, Especialidad> especialidades = new HashMap<>();
    private int proximoId = 1;

    private EspecialidadDAO() {}

    public static EspecialidadDAO getInstance() {
        if (instancia == null) {
            instancia = new EspecialidadDAO();
        }
        return instancia;
    }

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
