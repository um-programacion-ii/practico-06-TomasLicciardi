package DAO;

import org.example.DAO.implementations.DrogueriaDAOIm;
import org.example.entities.Drogueria;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DrogueriaDAOTest {

    private DrogueriaDAOIm drogueriaDAO;
    private Drogueria drogueria;

    @BeforeEach
    public void setUp() {
        drogueriaDAO = new DrogueriaDAOIm();
    }

    @Test
    public void testCrearDrogueria() {
        drogueria = new Drogueria(1, "Farmacity", "Av. Rivadavia 1234", 123456789);
        drogueriaDAO.crearDrogueria(drogueria);
        assertEquals(drogueria, drogueriaDAO.obtenerDrogueriaPorId(1));
    }

    @Test
    public void testActualizarDrogueria() {
        drogueria = new Drogueria(1, "Farmacity", "Av. Rivadavia 1234", 123456789);
        drogueriaDAO.crearDrogueria(drogueria);
        drogueria.setNombre("Farmacity 2");
        drogueriaDAO.actualizarDrogueria(drogueria);
        assertEquals(drogueria, drogueriaDAO.obtenerDrogueriaPorId(1));
    }

    @Test
    public void testEliminarDrogueria() {
        drogueria = new Drogueria(1, "Farmacity", "Av. Rivadavia 1234", 123456789);
        drogueriaDAO.crearDrogueria(drogueria);
        drogueriaDAO.eliminarDrogueria(1);
        assertEquals(null, drogueriaDAO.obtenerDrogueriaPorId(1));
    }

}
