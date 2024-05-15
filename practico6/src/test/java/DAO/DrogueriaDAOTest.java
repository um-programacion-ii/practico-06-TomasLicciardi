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
        Drogueria drogueriaNueva = drogueriaDAO.crearDrogueria(drogueria);
        assertEquals(drogueria, drogueriaNueva);
    }

    @Test
    public void testActualizarDrogueria() {
        drogueria = new Drogueria(1, "Farmacity", "Av. Rivadavia 1234", 123456789);
        drogueriaDAO.crearDrogueria(drogueria);
        drogueria.setNombre("Farmacity 2");
        drogueriaDAO.actualizarDrogueria(drogueria);
        assertEquals(drogueria, drogueriaDAO.obtenerDrogueriaPorId(drogueria.getId()));
    }

    @Test
    public void testEliminarDrogueria() {
        drogueria = new Drogueria(1, "Farmacity", "Av. Rivadavia 1234", 123456789);
        drogueriaDAO.crearDrogueria(drogueria);
        drogueriaDAO.eliminarDrogueria(drogueria.getId());
        assertEquals(null, drogueriaDAO.obtenerDrogueriaPorId(drogueria.getId()));
    }

}
