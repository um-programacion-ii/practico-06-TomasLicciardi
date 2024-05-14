package DAO;

import org.example.DAO.implementations.TurnoDAOIm;
import org.example.entities.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;
import java.util.List;

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
        List<ObraSocial> obrasSociales = new ArrayList<>();
        ObraSocial obraSocial1 = new ObraSocial(1, "OSDE");
        ObraSocial obraSocial2 = new ObraSocial(2, "OSEP");
        obrasSociales.add(obraSocial1);
        obrasSociales.add(obraSocial2);

        List<Turno> turnos = new ArrayList<>();

        Especialidad especialidad = new Especialidad(1, "Cardiología");

        List<Receta> recetas = new ArrayList<>();

        Paciente paciente = new Paciente();
        paciente.setNombre("Juan");
        paciente.setApellido("Perez");
        paciente.setObraSocial(obraSocial1);
        paciente.setTurnos(turnos);
        paciente.setRecetas(recetas);

        Medico medico = new Medico();
        medico.setNombre("Juan");
        medico.setApellido("Perez");
        medico.setEspecialidad(especialidad);
        medico.setObraSociales(obrasSociales);
        medico.setAtenderParticulares(true);
        medico.setEstaAtendiendo(false);
        medico.setTurnos(turnos);

        turno = new Turno();
        turno.setPaciente(paciente);
        turno.setMedico(medico);
        turno.setObraSocial(obraSocial1);
        turno.setEspecialidad(especialidad);

        Turno turnoNuevo = turnoDAO.crearTurno(turno);

        assertEquals(turno, turnoNuevo);
    }

    @Test
    public void testActualizarTurno() {
        List<ObraSocial> obrasSociales = new ArrayList<>();
        ObraSocial obraSocial1 = new ObraSocial(1, "OSDE");
        ObraSocial obraSocial2 = new ObraSocial(2, "OSEP");
        obrasSociales.add(obraSocial1);
        obrasSociales.add(obraSocial2);

        List<Turno> turnos = new ArrayList<>();

        Especialidad especialidad = new Especialidad(1, "Cardiología");

        List<Receta> recetas = new ArrayList<>();

        Paciente paciente = new Paciente();
        paciente.setNombre("Juan");
        paciente.setApellido("Perez");
        paciente.setObraSocial(obraSocial1);
        paciente.setTurnos(turnos);
        paciente.setRecetas(recetas);

        Medico medico = new Medico();
        medico.setNombre("Juan");
        medico.setApellido("Perez");
        medico.setEspecialidad(especialidad);
        medico.setObraSociales(obrasSociales);
        medico.setAtenderParticulares(true);
        medico.setEstaAtendiendo(false);
        medico.setTurnos(turnos);

        turno = new Turno();
        turno.setPaciente(paciente);
        turno.setMedico(medico);
        turno.setObraSocial(obraSocial1);
        turno.setEspecialidad(especialidad);

        Turno turnoNuevo = turnoDAO.crearTurno(turno);

        turnoNuevo.setObraSocial(obraSocial2);
        turnoDAO.actualizarTurno(turnoNuevo);

        assertEquals(obraSocial2, turnoNuevo.getObraSocial());

    }

    @Test
    public void testFinalizarTurno() {
        List<ObraSocial> obrasSociales = new ArrayList<>();
        ObraSocial obraSocial1 = new ObraSocial(1, "OSDE");
        ObraSocial obraSocial2 = new ObraSocial(2, "OSEP");
        obrasSociales.add(obraSocial1);
        obrasSociales.add(obraSocial2);

        List<Turno> turnos = new ArrayList<>();

        Especialidad especialidad = new Especialidad(1, "Cardiología");

        List<Receta> recetas = new ArrayList<>();

        Paciente paciente = new Paciente();
        paciente.setNombre("Juan");
        paciente.setApellido("Perez");
        paciente.setObraSocial(obraSocial1);
        paciente.setTurnos(turnos);
        paciente.setRecetas(recetas);

        Medico medico = new Medico();
        medico.setNombre("Juan");
        medico.setApellido("Perez");
        medico.setEspecialidad(especialidad);
        medico.setObraSociales(obrasSociales);
        medico.setAtenderParticulares(true);
        medico.setEstaAtendiendo(false);
        medico.setTurnos(turnos);

        turno = new Turno();
        turno.setPaciente(paciente);
        turno.setMedico(medico);
        turno.setObraSocial(obraSocial1);
        turno.setEspecialidad(especialidad);

        Turno turnoNevo = turnoDAO.crearTurno(turno);

        turnoDAO.eliminarTurno(turnoNevo.getId());

        assertEquals(null, turnoDAO.obtenerTurnoPorId(turnoNevo.getId()));
    }
}
