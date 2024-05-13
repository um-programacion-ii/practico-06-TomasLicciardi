package org.example.DAO.interfaces;

import org.example.entities.Turno;

public interface TurnoDAO {
    Turno crearTurno(Turno turno);
    Turno obtenerTurnoPorId(int id);
    void actualizarTurno(Turno turno);
    void eliminarTurno(int id);
}