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
        Especialidad especialidadNueva = especialidadDAO.crearEspecialidad(especialidad);
        assertEquals(especialidad, especialidadNueva);
    }

    @Test
    public void testActualizarEspecialidad() {
        especialidad = new Especialidad(1,"Cardiología");
        especialidadDAO.crearEspecialidad(especialidad);
        especialidad.setNombre("Traumatología");
        especialidadDAO.actualizarEspecialidad(especialidad);
        assertEquals(especialidad, especialidadDAO.obtenerEspecialidadPorId(especialidad.getId()));
    }

    @Test
    public void testEliminarEspecialidad() {
        especialidad = new Especialidad(1,"Cardiología");
        especialidadDAO.crearEspecialidad(especialidad);
        especialidadDAO.eliminarEspecialidad(especialidad.getId());
        assertEquals(null, especialidadDAO.obtenerEspecialidadPorId(especialidad.getId()));
    }



}
