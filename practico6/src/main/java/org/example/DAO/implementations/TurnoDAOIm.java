package org.example.DAO.implementations;

import org.example.entities.Turno;
import java.util.HashMap;
import java.util.Map;

public class TurnoDAOIm implements org.example.DAO.interfaces.TurnoDAO {
    private final Map<Integer, Turno> turnos = new HashMap<>();
    private int proximoId = 1;

    private TurnoDAOIm() {}

    @Override
    public Turno crearTurno(Turno turno) {
        turno.setId(proximoId++);
        turnos.put(turno.getId(), turno);
        return turno;
    }

    @Override
    public Turno obtenerTurnoPorId(int id) {
        return turnos.get(id);
    }

    @Override
    public void actualizarTurno(Turno turno) {
        turnos.put(turno.getId(), turno);
    }

    @Override
    public void eliminarTurno(int id) {
        turnos.remove(id);
    }
}
