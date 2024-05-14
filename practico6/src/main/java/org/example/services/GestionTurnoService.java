package org.example.services;

import org.example.DAO.implementations.MedicoDAOIm;
import org.example.DAO.implementations.PacienteDAOIm;
import org.example.DAO.implementations.TurnoDAOIm;
import org.example.entities.*;

import java.util.List;

public class GestionTurnoService {

    private static GestionTurnoService instance;
    private TurnoDAOIm turnoDao;
    private PacienteDAOIm pacienteDao;
    private MedicoDAOIm medicoDao;

    public static  GestionTurnoService getInstance() {
        if (instance == null) {
            instance = new GestionTurnoService();
        }
        return instance;
    }

    public GestionTurnoService(){
        turnoDao = new TurnoDAOIm();
        pacienteDao = new PacienteDAOIm();
        medicoDao = new MedicoDAOIm();
    }

    public Turno crearTurno(Paciente paciente, Medico medico, Especialidad especialidad) {
        if (((paciente.getObraSocial() == null && medico.getAtenderParticulares()) || medico.getObraSociales().contains(paciente.getObraSocial())) && medico.getEspecialidad() == especialidad) {
//            paciente.agregarTurno(paciente.solicitarTurno(medico, paciente.getObraSocial(), medico.getEspecialidad()));
//            medico.agregarTurno(paciente.solicitarTurno(medico, paciente.getObraSocial(), medico.getEspecialidad()));
            return turnoDao.crearTurno(paciente.solicitarTurno(medico, paciente.getObraSocial(), medico.getEspecialidad()));
        } else {
            throw new IllegalArgumentException("Datos introducidos incorrectos");
        }
    }


    public void finalizarTurno(Paciente paciente, Turno turno, Medico medico) {
        medico.finalizarTurno(turno);
        paciente.cancelarTurno(turno);
        turnoDao.eliminarTurno(turno.getId());
    }

}

