package org.example.services;

import org.example.DAO.implementations.MedicoDAOIm;
import org.example.DAO.implementations.PacienteDAOIm;
import org.example.DAO.implementations.TurnoDAOIm;
import org.example.DAO.interfaces.*;
import org.example.entities.*;

import java.util.List;

public class GestionTurnoService {
    private static GestionTurnoService instance;
    private TurnoDAO turnoDao;
    private PacienteDAO pacienteDao;
    private MedicoDAO medicoDao;

    private GestionTurnoService(TurnoDAO turnoDao, PacienteDAO pacienteDao, MedicoDAO medicoDao) {
        turnoDao = new TurnoDAOIm();
        pacienteDao = new PacienteDAOIm();
        medicoDao = new MedicoDAOIm();
    }

    public static synchronized GestionTurnoService getInstance(TurnoDAO turnoDao, PacienteDAO pacienteDao, MedicoDAO medicoDao) {
        if (instance == null) {
            instance = new GestionTurnoService(turnoDao, pacienteDao, medicoDao);
        }
        return instance;
    }

    public Turno crearTurno(Paciente paciente, Medico medico, Especialidad especialidad) {
        if (((paciente.getObraSocial() == null && medico.getAtenderParticulares()) || medico.getObraSociales().contains(paciente.getObraSocial())) && medico.getEspecialidad() == especialidad) {
            Turno turno = paciente.solicitarTurno(medico, paciente.getObraSocial(), medico.getEspecialidad());
            return turnoDao.crearTurno(turno);
        } else {
            throw new IllegalArgumentException("Datos introducidos incorrectos");
        }
    }


    public void finalizarTurno(Paciente paciente, Turno turno, Medico medico) {
        if (paciente != null && medico != null) {
            medico.finalizarTurno(turno);
        } else if (paciente != null && medico == null) {
            paciente.cancelarTurno(turno);
        } else {
            throw new IllegalArgumentException("Paciente o médico no pueden ser nulos");
        }
        turnoDao.eliminarTurno(turno.getId());
    }

}

