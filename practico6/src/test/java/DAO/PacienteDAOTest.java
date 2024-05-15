package DAO;

import org.example.DAO.implementations.PacienteDAOIm;
import org.example.entities.Paciente;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.example.entities.ObraSocial;
import org.example.entities.Turno;
import org.example.entities.Receta;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PacienteDAOTest {
    private PacienteDAOIm pacienteDAO;
    private Paciente paciente;

    @BeforeEach
    public void setUp() {
        pacienteDAO = new PacienteDAOIm();
    }

    @Test
    public void testCrearPaciente() {
        paciente = new Paciente();
        ObraSocial obraSocial = new ObraSocial();
        List<Receta> recetas = new ArrayList<>();
        List<Turno> turnos = new ArrayList<>();
        paciente.setNombre("Juan");
        paciente.setApellido("Perez");
        paciente.setId(12345678);
        paciente.setObraSocial(obraSocial);
        paciente.setTurnos(turnos);
        paciente.setRecetas(recetas);

        Paciente pacienteNuevo = pacienteDAO.crearPaciente(paciente);

        assertEquals(paciente, pacienteNuevo);
    }

    @Test
    public void testActualizarPaciente() {
        paciente = new Paciente();
        ObraSocial obraSocial = new ObraSocial();
        List<Receta> recetas = new ArrayList<>();
        List<Turno> turnos = new ArrayList<>();
        paciente.setNombre("Juan");
        paciente.setApellido("Perez");
        paciente.setId(12345678);
        paciente.setObraSocial(obraSocial);
        paciente.setTurnos(turnos);
        paciente.setRecetas(recetas);

        pacienteDAO.crearPaciente(paciente);

        paciente.setNombre("Pedro");
        pacienteDAO.actualizarPaciente(paciente);

        assertEquals(paciente, pacienteDAO.obtenerPacientePorId(paciente.getId()));
    }

    @Test
    public void testObtenerPacientes(){
        paciente = new Paciente();
        ObraSocial obraSocial = new ObraSocial();
        List<Receta> recetas = new ArrayList<>();
        List<Turno> turnos = new ArrayList<>();
        paciente.setNombre("Juan");
        paciente.setApellido("Perez");
        paciente.setId(12345678);
        paciente.setObraSocial(obraSocial);
        paciente.setTurnos(turnos);
        paciente.setRecetas(recetas);
        Paciente paciente2 = new Paciente();
        paciente2.setNombre("Pedro");
        paciente2.setApellido("Gomez");
        paciente2.setId(12345679);
        paciente2.setObraSocial(obraSocial);
        paciente2.setTurnos(turnos);
        paciente2.setRecetas(recetas);

        pacienteDAO.crearPaciente(paciente);
        pacienteDAO.crearPaciente(paciente2);

        List<Paciente> pacientes = pacienteDAO.obtenerPacientes();

        assertEquals(pacientes, pacienteDAO.obtenerPacientes());
    }

    @Test
    public void testEliminarPaciente() {
        paciente = new Paciente();
        ObraSocial obraSocial = new ObraSocial();
        List<Receta> recetas = new ArrayList<>();
        List<Turno> turnos = new ArrayList<>();
        paciente.setNombre("Juan");
        paciente.setApellido("Perez");
        paciente.setId(12345678);
        paciente.setObraSocial(obraSocial);
        paciente.setTurnos(turnos);
        paciente.setRecetas(recetas);

        pacienteDAO.crearPaciente(paciente);

        pacienteDAO.eliminarPaciente(paciente.getId());

        assertEquals(null, pacienteDAO.obtenerPacientePorId(paciente.getId()));
    }

}
