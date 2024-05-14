package DAO;

import org.example.entities.Especialidad;
import org.example.DAO.implementations.EspecialidadDAOIm;
import org.example.DAO.interfaces.EspecialidadDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;
public class EspecialidadDAOTest {
    private EspecialidadDAO especialidadDAO;
    private Especialidad especialidad;

    @BeforeEach
    public void setUp() {
        especialidadDAO = new EspecialidadDAOIm();
    }

    @Test
    public void testCrearEspecialidad() {
        especialidad = new Especialidad(1,"Cardiología");
        especialidadDAO.crearEspecialidad(especialidad);
        assertEquals(especialidad, especialidadDAO.obtenerEspecialidadPorId(1));
    }

    @Test
    public void testObtenerEspecialidadPorId() {
        especialidad = new Especialidad(1,"Cardiología");
        especialidadDAO.crearEspecialidad(especialidad);
        assertEquals(especialidad, especialidadDAO.obtenerEspecialidadPorId(1));
    }

    @Test
    public void testActualizarEspecialidad() {
        especialidad = new Especialidad(1,"Cardiología");
        especialidadDAO.crearEspecialidad(especialidad);
        especialidad.setNombre("Traumatología");
        especialidadDAO.actualizarEspecialidad(especialidad);
        assertEquals(especialidad, especialidadDAO.obtenerEspecialidadPorId(1));
    }

    @Test
    public void testEliminarEspecialidad() {
        especialidad = new Especialidad(1,"Cardiología");
        especialidadDAO.crearEspecialidad(especialidad);
        especialidadDAO.eliminarEspecialidad(1);
        assertEquals(null, especialidadDAO.obtenerEspecialidadPorId(1));
    }

}
