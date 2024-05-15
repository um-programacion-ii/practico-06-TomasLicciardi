package DAO;

import org.example.DAO.implementations.ObraSocialDAOIm;
import org.example.entities.ObraSocial;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ObraSocialDAOTest {

    private ObraSocialDAOIm obraSocialDAO;
    private ObraSocial obraSocial;

    @BeforeEach
    public void setUp() {
        obraSocialDAO = new ObraSocialDAOIm();
    }

    @Test
    public void testCrearObraSocial() {
        obraSocial = new ObraSocial(1, "OSDE");
        ObraSocial obraSocialNueva =  obraSocialDAO.crearObraSocial(obraSocial);
        assertEquals(obraSocial, obraSocialNueva);
    }

    @Test
    public void testActualizarObraSocial() {
        obraSocial = new ObraSocial(1, "OSDE");
        obraSocialDAO.crearObraSocial(obraSocial);
        obraSocial.setNombre("Swiss Medical");
        obraSocialDAO.actualizarObraSocial(obraSocial);
        assertEquals(obraSocial, obraSocialDAO.obtenerObraSocialPorId(1));
    }

    @Test
    public void testEliminarObraSocial() {
        obraSocial = new ObraSocial(1, "OSDE");
        obraSocialDAO.crearObraSocial(obraSocial);
        obraSocialDAO.eliminarObraSocial(1);
        assertEquals(null, obraSocialDAO.obtenerObraSocialPorId(1));
    }

}
