package services;

import org.example.DAO.implementations.PacienteDAOIm;
import org.example.DAO.implementations.TurnoDAOIm;
import org.example.DAO.implementations.MedicoDAOIm;
import org.example.DAO.implementations.ObraSocialDAOIm;
import org.example.DAO.interfaces.ObraSocialDAO;
import org.example.DAO.interfaces.PacienteDAO;
import org.example.DAO.interfaces.TurnoDAO;
import org.example.DAO.interfaces.MedicoDAO;
import org.example.entities.*;
import org.example.services.GestionTurnoService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GestionTurnoTest {

    private GestionTurnoService gestionTurnoService;
    private TurnoDAO turnoDAO;
    private MedicoDAO medicoDAO;
    private PacienteDAO pacienteDAO;
    private ObraSocialDAO obraSocialDAO;

    @BeforeEach
    public void setUp() {
        gestionTurnoService = GestionTurnoService.getInstance();
        turnoDAO = new TurnoDAOIm();
        medicoDAO = new MedicoDAOIm();
        pacienteDAO = new PacienteDAOIm();
        obraSocialDAO = new ObraSocialDAOIm();
    }

    @Test
    public void testCrearTurno() {
        List<ObraSocial> obrasSociales = new ArrayList<>();
        ObraSocial obraSocial1 = new ObraSocial(1,"OSDE");
        ObraSocial obraSocial2 = new ObraSocial(2,"Swiss Medical");
        obrasSociales.add(obraSocial1);
        obrasSociales.add(obraSocial2);

        Especialidad especialidad = new Especialidad(1,"Cardiología");

        Medico medico1 = new Medico();
        medico1.setId(1);
        medico1.setNombre("Juan");
        medico1.setApellido("Perez");
        medico1.setEspecialidad(especialidad);
        medico1.setObraSociales(obrasSociales);
        medico1.setAtenderParticulares(true);
        medico1.setEstaAtendiendo(false);
        List<Turno> turnosMedico = new ArrayList<>();
        medico1.setTurnos(turnosMedico);

        Paciente paciente1 = new Paciente();
        paciente1.setId(1);
        paciente1.setNombre("Maria");
        paciente1.setApellido("Gomez");
        paciente1.setObraSocial(obraSocial1);
        List<Receta> recetas = new ArrayList<>();
        paciente1.setRecetas(recetas);
        List<Turno> turnospaciente = new ArrayList<>();
        paciente1.setTurnos(turnospaciente);

        Turno turno = new Turno();
        turno.setId(1);
        turno.setMedico(medico1);
        turno.setPaciente(paciente1);
        turno.setEspecialidad(especialidad);
        turno.setObraSocial(obraSocial1);

        Turno turnoNuevo = gestionTurnoService.crearTurno(paciente1, medico1,especialidad);

        assertEquals(turno, turnoNuevo);
    }

    @Test
    public void testFinalizarTurno() {
        List<ObraSocial> obrasSociales = new ArrayList<>();
        ObraSocial obraSocial1 = new ObraSocial(1,"OSDE");
        ObraSocial obraSocial2 = new ObraSocial(2,"Swiss Medical");
        obrasSociales.add(obraSocial1);
        obrasSociales.add(obraSocial2);

        Especialidad especialidad = new Especialidad(1,"Cardiología");

        Medico medico1 = new Medico();
        medico1.setId(1);
        medico1.setNombre("Juan");
        medico1.setApellido("Perez");
        medico1.setEspecialidad(especialidad);
        medico1.setObraSociales(obrasSociales);
        medico1.setAtenderParticulares(true);
        medico1.setEstaAtendiendo(false);
        List<Turno> turnosMedico = new ArrayList<>();
        medico1.setTurnos(turnosMedico);

        Paciente paciente1 = new Paciente();
        paciente1.setId(1);
        paciente1.setNombre("Maria");
        paciente1.setApellido("Gomez");
        paciente1.setObraSocial(null);
        List<Receta> recetas = new ArrayList<>();
        paciente1.setRecetas(recetas);
        List<Turno> turnospaciente = new ArrayList<>();
        paciente1.setTurnos(turnospaciente);


        Turno turno = new Turno();
        turno.setId(1);
        turno.setMedico(medico1);
        turno.setPaciente(paciente1);
        turno.setEspecialidad(especialidad);
        turno.setObraSocial(null);

        Turno turnoNuevo = gestionTurnoService.crearTurno(paciente1, medico1,especialidad);


        gestionTurnoService.finalizarTurno(paciente1, turnoNuevo, medico1);
        assertEquals(0, medico1.getTurnos().size());
        assertEquals(0, paciente1.getTurnos().size());
    }
}
