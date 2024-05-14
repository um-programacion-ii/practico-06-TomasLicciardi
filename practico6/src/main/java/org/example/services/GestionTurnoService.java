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

    public Turno crearTurno(Paciente paciente, Medico medico, Especialidad especialidad)  {
        if (paciente.getObraSocial() == null && medico.getAtenderParticulares() && medico.getEspecialidad() == especialidad) {
            Turno turno = paciente.solicitarTurno(medico, null, medico.getEspecialidad());
            return turnoDao.crearTurno(turno);
        } else if (paciente.getObraSocial() != null && medico.getObraSociales().contains(paciente.getObraSocial()) && medico.getEspecialidad() == especialidad){
            Turno turno = paciente.solicitarTurno(medico, paciente.getObraSocial(), medico.getEspecialidad());
            return turnoDao.crearTurno(turno);
        }
        else {
            throw new IllegalArgumentException("Datos introducidos incorrectos");
        }
    }

    public void finalizarTurno(Paciente paciente,Turno turno,Medico medico){

        medico.finalizarTurno(turno);
        turnoDao.eliminarTurno(turno.getId());
    }
    }
    

