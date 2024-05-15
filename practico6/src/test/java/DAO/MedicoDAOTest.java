package DAO;

import org.example.DAO.implementations.MedicoDAOIm;
import org.example.entities.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class MedicoDAOTest {
    private MedicoDAOIm medicoDAO;
    private Medico medico;
    @BeforeEach
    public void setUp() {
        medicoDAO = new MedicoDAOIm();
    }

    @Test
    public void testCrearMedico() {
        List<ObraSocial> obrasSociales = new ArrayList<>();
        List<Receta> recetas = new ArrayList<>();
        List<Turno> turnos = new ArrayList<>();
        List<Paciente> pacientes = new ArrayList<>();
        Especialidad especialidad = new Especialidad(1, "Cardiología");

        medico = new Medico();
        medico.setNombre("Juan");
        medico.setApellido("Perez");
        medico.setEstaAtendiendo(false);
        medico.setEspecialidad(especialidad);
        medico.setObraSociales(obrasSociales);
        medico.setTurnos(turnos);
        medico.setPacientes(pacientes);
        medico.setAtenderParticulares(true);

        Medico medicoNuevo = medicoDAO.crearMedico(medico);

        assertEquals(medico, medicoNuevo);

    }

    @Test
    public void testActualizarMedico() {
        List<ObraSocial> obrasSociales = new ArrayList<>();
        List<Receta> recetas = new ArrayList<>();
        List<Turno> turnos = new ArrayList<>();
        List<Paciente> pacientes = new ArrayList<>();
        Especialidad especialidad = new Especialidad(1, "Cardiología");

        medico = new Medico();
        medico.setNombre("Juan");
        medico.setApellido("Perez");
        medico.setEstaAtendiendo(false);
        medico.setEspecialidad(especialidad);
        medico.setObraSociales(obrasSociales);
        medico.setTurnos(turnos);
        medico.setPacientes(pacientes);
        medico.setAtenderParticulares(true);

        medicoDAO.crearMedico(medico);

        medico.setNombre("Pedro");
        medicoDAO.actualizarMedico(medico);

        assertEquals(medico, medicoDAO.obtenerMedicoPorId(medico.getId()));
    }

    @Test
    public void testEliminarMedico() {
        List<ObraSocial> obrasSociales = new ArrayList<>();
        List<Receta> recetas = new ArrayList<>();
        List<Turno> turnos = new ArrayList<>();
        List<Paciente> pacientes = new ArrayList<>();
        Especialidad especialidad = new Especialidad(1, "Cardiología");

        medico = new Medico();
        medico.setNombre("Juan");
        medico.setApellido("Perez");
        medico.setEstaAtendiendo(false);
        medico.setEspecialidad(especialidad);
        medico.setObraSociales(obrasSociales);
        medico.setTurnos(turnos);
        medico.setPacientes(pacientes);
        medico.setAtenderParticulares(true);

        medicoDAO.crearMedico(medico);

        medicoDAO.eliminarMedico(medico.getId());

        assertEquals(null, medicoDAO.obtenerMedicoPorId(medico.getId()));
    }

    @Test
    public void testObtenerMedicos(){
        List<ObraSocial> obrasSociales = new ArrayList<>();
        List<Receta> recetas = new ArrayList<>();
        List<Turno> turnos = new ArrayList<>();
        List<Paciente> pacientes = new ArrayList<>();
        Especialidad especialidad = new Especialidad(1, "Cardiología");

        medico = new Medico();
        medico.setNombre("Juan");
        medico.setApellido("Perez");
        medico.setEstaAtendiendo(false);
        medico.setEspecialidad(especialidad);
        medico.setObraSociales(obrasSociales);
        medico.setTurnos(turnos);
        medico.setPacientes(pacientes);
        medico.setAtenderParticulares(true);

        medicoDAO.crearMedico(medico);

        List<Medico> medicos = new ArrayList<>();
        medicos.add(medico);

        assertEquals(medicos, medicoDAO.obtenerMedicos());
    }

    @Test
    public void testObtenerMedicosParticulares(){
        List<ObraSocial> obrasSociales = new ArrayList<>();
        List<Receta> recetas = new ArrayList<>();
        List<Turno> turnos = new ArrayList<>();
        List<Paciente> pacientes = new ArrayList<>();
        Especialidad especialidad = new Especialidad(1, "Cardiología");

        medico = new Medico();
        medico.setNombre("Juan");
        medico.setApellido("Perez");
        medico.setEstaAtendiendo(false);
        medico.setEspecialidad(especialidad);
        medico.setObraSociales(obrasSociales);
        medico.setTurnos(turnos);
        medico.setPacientes(pacientes);
        medico.setAtenderParticulares(true);

        medicoDAO.crearMedico(medico);

        List<Medico> medicos = new ArrayList<>();
        medicos.add(medico);

        assertEquals(medicos, medicoDAO.obtenerMedicosParticulares());
    }

    @Test
    public void testObtenerMedicosPorEspecialidadyObraSocial() {
        Especialidad especialidad = new Especialidad(1, "Cardiología");
        List<ObraSocial> obrasSociales1 = new ArrayList<>();
        List<ObraSocial> obrasSociales2 = new ArrayList<>();
        ObraSocial obraSocial1 = new ObraSocial(1, "OSDE");
        ObraSocial obraSocial2 = new ObraSocial(2, "Swiss Medical");
        ObraSocial obraSocial3 = new ObraSocial(3, "OSEP");
        obrasSociales1.add(obraSocial1);
        obrasSociales1.add(obraSocial2);
        obrasSociales1.add(obraSocial3);
        obrasSociales2.add(obraSocial1);
        obrasSociales2.add(obraSocial2);

        Medico medico1 = new Medico();
        medico1.setNombre("Juan");
        medico1.setApellido("Perez");
        medico1.setEstaAtendiendo(false);
        medico1.setEspecialidad(especialidad);
        medico1.setObraSociales(obrasSociales1);
        Medico medico2 = new Medico();
        medico2.setNombre("Pedro");
        medico2.setApellido("Gomez");
        medico2.setEstaAtendiendo(true);
        medico2.setEspecialidad(especialidad);
        medico2.setObraSociales(obrasSociales2);


        medicoDAO.crearMedico(medico1);
        medicoDAO.crearMedico(medico2);

        Map<Medico, List<ObraSocial>> medicos = new HashMap<>();
        medicos.put(medico1, obrasSociales1);
        medicos.put(medico2, obrasSociales2);

        assertEquals(medicos, medicoDAO.obtenerMedicosPorEspecialidadyObraSocial(especialidad));
    }

}
