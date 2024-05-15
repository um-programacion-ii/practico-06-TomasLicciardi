package DAO;

import org.example.DAO.implementations.RecetaDAOIm;
import org.example.entities.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RecetaDAOTest {
    private RecetaDAOIm recetaDAO;

    private Receta receta;
    @BeforeEach
    public void setUp() {
        recetaDAO = new RecetaDAOIm();
    }

    @Test
    public void testCrearReceta() {
        receta = new Receta();
        List<Receta> recetas = new ArrayList<>();
        List<ObraSocial> obrasSociales = new ArrayList<>();
        ObraSocial obraSocial1 = new ObraSocial(1, "OSDE");
        ObraSocial obraSocial2 = new ObraSocial(2, "OSEP");
        obrasSociales.add(obraSocial1);
        obrasSociales.add(obraSocial2);

        List<Turno> turnos = new ArrayList<>();

        Especialidad especialidad = new Especialidad(1, "Cardiología");

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

        Medicamento medicamento1 = new Medicamento(1, "Ibuprofeno", "Bayer", "Aspirina");
        Medicamento medicamento2 = new Medicamento(2, "Paracetamol", "Bayer", "Dioxaflex");
        Map<Medicamento, Integer> medicamento = new HashMap<>();
        medicamento.put(medicamento1, 20);
        medicamento.put(medicamento2, 50);

        receta.setPaciente(paciente);
        receta.setMedico(medico);
        receta.setMedicamentos(medicamento);

        Receta recetaNueva = recetaDAO.crearReceta(receta);

        assertEquals(receta, recetaNueva);
    }

    @Test
    public void testActualizarReceta() {
        receta = new Receta();
        List<Receta> recetas = new ArrayList<>();
        List<ObraSocial> obrasSociales = new ArrayList<>();
        ObraSocial obraSocial1 = new ObraSocial(1, "OSDE");
        ObraSocial obraSocial2 = new ObraSocial(2, "OSEP");
        obrasSociales.add(obraSocial1);
        obrasSociales.add(obraSocial2);

        List<Turno> turnos = new ArrayList<>();

        Especialidad especialidad = new Especialidad(1, "Cardiología");

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

        Medicamento medicamento1 = new Medicamento(1, "Ibuprofeno", "Bayer", "Aspirina");
        Medicamento medicamento2 = new Medicamento(2, "Paracetamol", "Bayer", "Dioxaflex");
        Map<Medicamento, Integer> medicamento = new HashMap<>();
        medicamento.put(medicamento1, 20);
        medicamento.put(medicamento2, 50);

        receta.setPaciente(paciente);
        receta.setMedico(medico);
        receta.setMedicamentos(medicamento);

        Receta recetaNueva = recetaDAO.crearReceta(receta);

        receta.setMedicamentos(medicamento);

        recetaDAO.actualizarReceta(receta);

        assertEquals(receta, recetaDAO.obtenerRecetaPorId(receta.getId()));
    }

    @Test
    public void testEliminarReceta(){
        receta = new Receta();
        List<Receta> recetas = new ArrayList<>();
        List<ObraSocial> obrasSociales = new ArrayList<>();
        ObraSocial obraSocial1 = new ObraSocial(1, "OSDE");
        ObraSocial obraSocial2 = new ObraSocial(2, "OSEP");
        obrasSociales.add(obraSocial1);
        obrasSociales.add(obraSocial2);

        List<Turno> turnos = new ArrayList<>();

        Especialidad especialidad = new Especialidad(1, "Cardiología");

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

        Medicamento medicamento1 = new Medicamento(1, "Ibuprofeno", "Bayer", "Aspirina");
        Medicamento medicamento2 = new Medicamento(2, "Paracetamol", "Bayer", "Dioxaflex");
        Map<Medicamento, Integer> medicamento = new HashMap<>();
        medicamento.put(medicamento1, 20);
        medicamento.put(medicamento2, 50);

        receta.setPaciente(paciente);
        receta.setMedico(medico);
        receta.setMedicamentos(medicamento);

        Receta recetaNueva = recetaDAO.crearReceta(receta);

        recetaDAO.eliminarReceta(receta.getId());

        assertEquals(null, recetaDAO.obtenerRecetaPorId(receta.getId()));
    }
}
