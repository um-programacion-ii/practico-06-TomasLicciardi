package services;

import org.example.DAO.implementations.*;
import org.example.DAO.interfaces.*;
import org.example.entities.*;
import org.example.services.GestionTurnoService;
import org.example.services.AtencionMedicoService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;


public class AtencionMedicoTest {

    private AtencionMedicoService atencionMedicoService;
    private TurnoDAO turnoDAO;
    private MedicoDAO medicoDAO;
    private PacienteDAO pacienteDAO;
    private RecetaDAO recetaDAO;
    private ObraSocialDAO obraSocialDAO;
    private EspecialidadDAO especialidadDAO;
    private MedicamentoDAO medicamentoDAO;
    private GestionTurnoService gestionTurnoService;

    @BeforeEach
    public void setUp() {
        atencionMedicoService = AtencionMedicoService.getInstance();
        turnoDAO = new TurnoDAOIm();
        medicoDAO = new MedicoDAOIm();
        pacienteDAO = new PacienteDAOIm();
        recetaDAO = new RecetaDAOIm();
        obraSocialDAO = new ObraSocialDAOIm();
        especialidadDAO = new EspecialidadDAOIm();
        medicamentoDAO = new MedicamentoDAOIm();
        gestionTurnoService = GestionTurnoService.getInstance();
    }

    @Test
    public void testAtenderPaciente() {
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
        paciente1.setNombre("Juan");
        paciente1.setApellido("Perez");
        paciente1.setId(12345678);
        paciente1.setObraSocial(obraSocial1);
        List<Receta> recetas = new ArrayList<>();
        paciente1.setRecetas(recetas);
        List<Turno> turnos = new ArrayList<>();
        paciente1.setTurnos(turnos);

        Turno turno = new Turno();
        turno.setId(1);
        turno.setMedico(medico1);
        turno.setPaciente(paciente1);
        turno.setEspecialidad(especialidad);
        turno.setObraSocial(obraSocial1);
        Turno turnoNuevo = gestionTurnoService.crearTurno(paciente1, medico1,especialidad);

        Map<Medicamento,Integer> medicamentos = new HashMap<>();

        Receta recetaNueva = atencionMedicoService.atenderPaciente(medico1, paciente1, turnoNuevo);


        assertEquals(recetaNueva.getMedico(), medico1);
        assertEquals(recetaNueva.getPaciente(), paciente1);
        assertNotNull(recetaNueva);
        assertFalse(recetaNueva.getMedicamentos().isEmpty());
        assertTrue(paciente1.getRecetas().contains(recetaNueva));
        assertFalse(medico1.getEstaAtendiendo());
    }
}