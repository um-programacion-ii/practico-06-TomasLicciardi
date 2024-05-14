package DAO;

import org.example.DAO.implementations.TurnoDAOIm;
import org.example.entities.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TurnoDAOTest {

    private TurnoDAOIm turnoDAO;
    private Turno turno;

    @BeforeEach
    public void setUp() {
        turnoDAO = new TurnoDAOIm();
    }

    @Test
    public void testCrearTurno() {
        turno = new Turno();
        Medico medico = new Medico();
        Paciente paciente = new Paciente();
        ObraSocial obraSocial = new ObraSocial();
        turno.setMedico(medico);
        turno.setPaciente(paciente);
        turno.setObraSocial(obraSocial);

        turnoDAO.crearTurno(turno);

        assertEquals(turno, turnoDAO.obtenerTurnoPorId(turno.getId()));
    }

    @Test
    public void testActualizarTurno() {
        turno = new Turno();
        Medico medico1 = new Medico();
        Paciente paciente1 = new Paciente();
        ObraSocial obraSocial1 = new ObraSocial();
        turno.setMedico(medico1);
        turno.setPaciente(paciente1);
        turno.setObraSocial(obraSocial1);

        turnoDAO.crearTurno(turno);

        Medico medico2 = new Medico();
        Paciente paciente2 = new Paciente();
        ObraSocial obraSocial2 = new ObraSocial();

        turno.setMedico(medico2);
        turno.setPaciente(paciente2);
        turno.setObraSocial(obraSocial2);

        turnoDAO.actualizarTurno(turno);

        assertEquals(turno, turnoDAO.obtenerTurnoPorId(turno.getId()));
    }

    @Test
    public void testEliminarTurno() {
        turno = new Turno();
        Medico medico = new Medico();
        Paciente paciente = new Paciente();
        ObraSocial obraSocial = new ObraSocial();
        turno.setMedico(medico);
        turno.setPaciente(paciente);
        turno.setObraSocial(obraSocial);

        turnoDAO.crearTurno(turno);
        turnoDAO.eliminarTurno(turno.getId());

        assertEquals(null, turnoDAO.obtenerTurnoPorId(turno.getId()));
    }
}
