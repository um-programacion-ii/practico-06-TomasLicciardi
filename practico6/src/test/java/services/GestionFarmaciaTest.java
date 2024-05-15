package services;

import org.example.entities.*;
import org.example.DAO.interfaces.*;
import org.example.DAO.implementations.*;
import org.example.services.GestionFarmaciaService;
import org.example.services.GestionTurnoService;
import org.example.services.AtencionMedicoService;
import org.example.services.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class GestionFarmaciaTest {

    private GestionFarmaciaService gestionFarmaciaService;
    private FarmaciaDAO farmaciaDAO;
    private MedicamentoDAO medicamentoDAO;
    private PacienteDAO pacienteDAO;
    private ObraSocialDAO obraSocialDAO;
    private RecetaDAO recetaDAO;
    private AtencionMedicoService atencionMedicoService;
    private GestionTurnoService gestionTurnoService;

    @BeforeEach
    public void setUp() {
        gestionFarmaciaService = GestionFarmaciaService.getInstance();
        atencionMedicoService = AtencionMedicoService.getInstance();
        farmaciaDAO = new FarmaciaDAOIm();
        medicamentoDAO = new MedicamentoDAOIm();
        pacienteDAO = new PacienteDAOIm();
        obraSocialDAO = new ObraSocialDAOIm();
        recetaDAO = new RecetaDAOIm();
        gestionTurnoService = GestionTurnoService.getInstance();
    }

    @Test
    public void testComprarMedicamentosSegunReceta() {
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

        Medicamento medicamento1 = new Medicamento(1, "Ibuprofeno", "Bayer", "Aspirina");
        Medicamento medicamento2 = new Medicamento(2, "Paracetamol", "Bayer", "Dioxaflex");
        Medicamento medicamento3 = new Medicamento(3, "Amoxicilina", "Roemmers", "Amoxidal");
        Medicamento medicamento4 = new Medicamento(4, "Omeprazol", "Roemmers", "Omeprazol");
        Medicamento medicamento5 = new Medicamento(5, "Diazepam", "Bago", "Valium");
        Medicamento medicamento6 = new Medicamento(6, "Lorazepam", "Bago", "Ativan");

        medicamentos.put(medicamento1,200);
        medicamentos.put(medicamento2,100);
        medicamentos.put(medicamento3,50);
        medicamentos.put(medicamento4,100);
        medicamentos.put(medicamento5,50);
        medicamentos.put(medicamento6,50);


        Receta recetaNueva = atencionMedicoService.atenderPaciente(medico1, paciente1, turnoNuevo);

        Farmacia farmacia = new Farmacia();
        farmacia.setId(1);
        farmacia.setNombre("Farmacity");
        farmacia.setDireccion("Av. Rivadavia 1234");
        farmacia.setTelefono(261212957);
        farmacia.setMedicamentos(medicamentos);

        farmaciaDAO.crearFarmacia(farmacia);
        pacienteDAO.crearPaciente(paciente1);
        recetaDAO.crearReceta(recetaNueva);

        int cantidadInicialMed1 = farmacia.getMedicamentos().get(medicamento1);
        int cantidadInicialMed2 = farmacia.getMedicamentos().get(medicamento2);

        int cantidadRecetasInicial = paciente1.getRecetas().size();


        gestionFarmaciaService.comprarMedicamentosSegunReceta(paciente1, farmacia);


        int cantidadFinalMed1 = farmacia.getMedicamentos().get(medicamento1);
        int cantidadFinalMed2 = farmacia.getMedicamentos().get(medicamento2);

        assertTrue(cantidadFinalMed1 <= cantidadInicialMed1);
        assertTrue(cantidadFinalMed2 <= cantidadInicialMed2);
        assertTrue(farmacia.getMedicamentos().get(medicamento1) > 0);
        assertTrue(farmacia.getMedicamentos().get(medicamento2) > 0);
        assertEquals(cantidadRecetasInicial - 1, paciente1.getRecetas().size());

    }

}
