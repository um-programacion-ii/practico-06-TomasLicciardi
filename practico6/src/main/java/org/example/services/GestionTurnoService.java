package org.example.services;

import org.example.DAO.interfaces.*;
import org.example.entities.*;

import java.util.List;

public class GestionTurnoService {
    private static GestionTurnoService instance;
    private TurnoDAO turnoDao;
    private PacienteDAO pacienteDao;
    private MedicoDAO medicoDao;

    private GestionTurnoService(TurnoDAO turnoDao, PacienteDAO pacienteDao, MedicoDAO medicoDao) {
        this.turnoDao = turnoDao;
        this.pacienteDao = pacienteDao;
        this.medicoDao = medicoDao;
    }

    public static synchronized GestionTurnoService getInstance(TurnoDAO turnoDao, PacienteDAO pacienteDao, MedicoDAO medicoDao) {
        if (instance == null) {
            instance = new GestionTurnoService(turnoDao, pacienteDao, medicoDao);
        }
        return instance;
    }

    public void crearTurno(Paciente paciente, Medico medico ) {
        if (paciente.getObraSocial().equals(null) && medico.getAtenderParticulares()) {
            Turno turno = paciente.solicitarTurno(medico, null, medico.getEspecialidad());
            turnoDao.crearTurno(turno);
        } else if (medico.getObraSociales().contains(paciente.getObraSocial()) && !medico.getAtenderParticulares()) {
            Turno turno = paciente.solicitarTurno(medico, paciente.getObraSocial(), medico.getEspecialidad());
            turnoDao.crearTurno(turno);
        }
        else {
            throw new IllegalArgumentException("Datos introducidos incorrectos");
        }
    }

    public void finalizarTurno(Paciente paciente,Turno turno,Medico medico){
        paciente.cancelarTurno(turno);
        medico.finalizarTurno(turno);
        turnoDao.eliminarTurno(turno.getId());
    }

    }
    

