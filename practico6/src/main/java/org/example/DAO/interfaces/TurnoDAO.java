package org.example.DAO.interfaces;

import org.example.entities.Turno;

import java.util.List;

public interface TurnoDAO {
    Turno crearTurno(Turno turno);
    Turno obtenerTurnoPorId(int id);

    List<Turno> obtenerTurnos();
    void actualizarTurno(Turno turno);
    void eliminarTurno(int id);
}