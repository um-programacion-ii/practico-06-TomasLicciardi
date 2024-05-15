package DAO;

import org.example.DAO.implementations.MedicamentoDAOIm;
import org.example.entities.Medicamento;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class MedicamentoDAOTest {
    private MedicamentoDAOIm medicamentoDAO;
    private Medicamento medicamento;

    @BeforeEach
    public void setUp() {
        medicamentoDAO = new MedicamentoDAOIm();
    }

    @Test
    public void testCrearMedicamento() {
        medicamento = new Medicamento(1, "Ibuprofeno", "Bayer", "Aspirina");
        Medicamento medicamentoNuevo = medicamentoDAO.crearMedicamento(medicamento);
        assertEquals(medicamento, medicamentoNuevo);
    }

    @Test
    public void testActualizarMedicamento() {
        medicamento = new Medicamento(1, "Ibuprofeno", "Bayer", "Aspirina");
        medicamentoDAO.crearMedicamento(medicamento);
        medicamento.setNombre("Paracetamol");
        medicamentoDAO.actualizarMedicamento(medicamento);
        assertEquals(medicamento, medicamentoDAO.obtenerMedicamentoPorId(1));
    }

    @Test
    public void testEliminarMedicamento() {
        medicamento = new Medicamento(1, "Ibuprofeno", "Bayer", "Aspirina");
        medicamentoDAO.crearMedicamento(medicamento);
        medicamentoDAO.eliminarMedicamento(1);
        assertEquals(null, medicamentoDAO.obtenerMedicamentoPorId(1));
    }
}
