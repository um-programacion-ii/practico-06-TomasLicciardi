package DAO;

import org.example.DAO.implementations.FarmaciaDAOIm;
import org.example.entities.Farmacia;
import org.example.entities.Medicamento;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Map;


public class FarmaciaDAOTest {
    private FarmaciaDAOIm farmaciaDAO;
    private Farmacia farmacia;

    @BeforeEach
    public void setUp() {
        farmaciaDAO = new FarmaciaDAOIm();
    }

    @Test
    public void testCrearFarmacia() {
        Medicamento medicamento = new Medicamento(1, "Ibuprofeno", "Antiinflamatorio", "Aspirina");
        farmacia = new Farmacia(1, "Farmacity", "Av. Rivadavia 1234",261212957, Map.of(medicamento, 10));
        Farmacia farmaciaNueva = farmaciaDAO.crearFarmacia(farmacia);
        assertEquals(farmacia,farmaciaNueva);
    }

    @Test
    public void testActualizarFarmacia() {
        Medicamento medicamento = new Medicamento(1, "Ibuprofeno", "Antiinflamatorio", "Aspirina");
        farmacia = new Farmacia(1, "Farmacity", "Av. Rivadavia 1234",261212957, Map.of(medicamento, 10));
        farmaciaDAO.crearFarmacia(farmacia);
        farmacia.setNombre("Farmacity 2");
        farmaciaDAO.actualizarFarmacia(farmacia);
        assertEquals(farmacia, farmaciaDAO.obtenerFarmaciaPorId(farmacia.getId()));
    }

    @Test
    public void testEliminarFarmacia() {
        Medicamento medicamento = new Medicamento(1, "Ibuprofeno", "Antiinflamatorio", "Aspirina");
        farmacia = new Farmacia(1, "Farmacity", "Av. Rivadavia 1234",261212957, Map.of(medicamento, 10));
        farmaciaDAO.crearFarmacia(farmacia);
        farmaciaDAO.eliminarFarmacia(farmacia.getId());
        assertEquals(null, farmaciaDAO.obtenerFarmaciaPorId(farmacia.getId()));
    }
}
