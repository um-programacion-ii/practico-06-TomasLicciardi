package DAO;

import org.example.DAO.implementations.RecetaDAOIm;
import org.example.entities.Receta;
import org.example.entities.Paciente;
import org.example.entities.Medico;
import org.example.entities.Medicamento;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.HashMap;
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
        Paciente paciente = new Paciente();
        Medico medico = new Medico();

        Medicamento medicamento1 = new Medicamento(1, "Ibuprofeno", "Bayer", "Aspirina");
        Medicamento medicamento2 = new Medicamento(2, "Paracetamol", "Bayer", "Dioxaflex");
        Map<Medicamento, Integer> medicamento = new HashMap<>();
        medicamento.put(medicamento1, 20);
        medicamento.put(medicamento2, 50);

        receta.setPaciente(paciente);
        receta.setMedico(medico);
        receta.setMedicamentos(medicamento);

        recetaDAO.crearReceta(receta);

        assertEquals(receta, recetaDAO.obtenerRecetaPorId(receta.getId()));
    }

    @Test
    public void testActualizarReceta() {
        receta = new Receta();
        Paciente paciente = new Paciente();
        Medico medico = new Medico();

        Medicamento medicamento1 = new Medicamento(1, "Ibuprofeno", "Bayer", "Aspirina");
        Medicamento medicamento2 = new Medicamento(2, "Paracetamol", "Bayer", "Dioxaflex");
        Map<Medicamento, Integer> medicamento = new HashMap<>();
        medicamento.put(medicamento1, 20);
        medicamento.put(medicamento2, 50);

        receta.setPaciente(paciente);
        receta.setMedico(medico);
        receta.setMedicamentos(medicamento);

        recetaDAO.crearReceta(receta);

        receta.setMedicamentos(medicamento);

        recetaDAO.actualizarReceta(receta);

        assertEquals(receta, recetaDAO.obtenerRecetaPorId(receta.getId()));
    }

    @Test
    public void testEliminarReceta() {
        receta = new Receta();
        Paciente paciente = new Paciente();
        Medico medico = new Medico();

        Medicamento medicamento1 = new Medicamento(1, "Ibuprofeno", "Bayer", "Aspirina");
        Medicamento medicamento2 = new Medicamento(2, "Paracetamol", "Bayer", "Dioxaflex");
        Map<Medicamento, Integer> medicamento = new HashMap<>();
        medicamento.put(medicamento1, 20);
        medicamento.put(medicamento2, 50);

        receta.setPaciente(paciente);
        receta.setMedico(medico);
        receta.setMedicamentos(medicamento);

        recetaDAO.crearReceta(receta);

        recetaDAO.eliminarReceta(receta.getId());

        assertEquals(null, recetaDAO.obtenerRecetaPorId(receta.getId()));
    }
}
