//package services;
//
//import org.example.DAO.implementations.*;
//import org.example.DAO.interfaces.*;
//import org.example.entities.*;
//import org.example.services.GestionTurnoService;
//import org.example.services.AtencionMedicoService;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.BeforeEach;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//
//public class AtencionMedicoTest {
//
//    private AtencionMedicoService atencionMedicoService;
//    private TurnoDAO turnoDAO;
//    private MedicoDAO medicoDAO;
//    private PacienteDAO pacienteDAO;
//    private RecetaDAO recetaDAO;
//    private ObraSocialDAO obraSocialDAO;
//    private EspecialidadDAO especialidadDAO;
//    private MedicamentoDAO medicamentoDAO;
//    private GestionTurnoService gestionTurnoService;
//
//    @BeforeEach
//    public void setUp() {
//        atencionMedicoService = AtencionMedicoService.getInstance();
//        turnoDAO = new TurnoDAOIm();
//        medicoDAO = new MedicoDAOIm();
//        pacienteDAO = new PacienteDAOIm();
//        recetaDAO = new RecetaDAOIm();
//        obraSocialDAO = new ObraSocialDAOIm();
//        especialidadDAO = new EspecialidadDAOIm();
//        medicamentoDAO = new MedicamentoDAOIm();
//        gestionTurnoService = GestionTurnoService.getInstance();
//    }
//
//    @Test
//    public void testAtenderPaciente() {
//        List<ObraSocial> obrasSociales = new ArrayList<>();
//        ObraSocial obraSocial1 = new ObraSocial(1,"OSDE");
//        ObraSocial obraSocial2 = new ObraSocial(2,"Swiss Medical");
//        obrasSociales.add(obraSocial1);
//        obrasSociales.add(obraSocial2);
//
//        Especialidad especialidad = new Especialidad(1,"Cardiología");
//
//        Medico medico1 = new Medico();
//        medico1.setId(1);
//        medico1.setNombre("Juan");
//        medico1.setApellido("Perez");
//        medico1.setEspecialidad(especialidad);
//        medico1.setObraSociales(obrasSociales);
//        medico1.setAtenderParticulares(true);
//        medico1.setEstaAtendiendo(false);
//        List<Turno> turnosMedico = new ArrayList<>();
//        medico1.setTurnos(turnosMedico);
//
//        Paciente paciente1 = new Paciente();
//        paciente1.setId(1);
//        paciente1.setNombre("Maria");
//        paciente1.setApellido("Gomez");
//        paciente1.setObraSocial(obraSocial1);
//        List<Turno> turnosPaciente = new ArrayList<>();
//        paciente1.setTurnos(turnosPaciente);
//        List<Receta> recetas = new ArrayList<>();
//        paciente1.setRecetas(recetas);
//
//        Turno turno = gestionTurnoService.crearTurno(paciente1, medico1, especialidad);
//
//        Receta receta = atencionMedicoService.atenderPaciente(medico1, paciente1, turno);
//
//        assertEquals(receta.getMedico(), medico1);
//        assertEquals(receta.getPaciente(), paciente1);
//        assertEquals(receta.getMedicamentos().size(), 1);
//    }
//
//}
