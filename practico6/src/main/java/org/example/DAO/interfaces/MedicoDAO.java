package org.example.DAO.interfaces;

import org.example.entities.Especialidad;
import org.example.entities.Medico;
import org.example.entities.ObraSocial;

import java.util.List;
import java.util.Map;


public interface MedicoDAO {
    Medico crearMedico(Medico medico);
    Medico obtenerMedicoPorId(int id);

    List<Medico> obtenerMedicos();

    Map<Medico,List<ObraSocial>> obtenerMedicosPorEspecialidadyObraSocial(Especialidad especialidad);

    List<Medico> obtenerMedicosParticulares();

    void actualizarMedico(Medico medico);
    void eliminarMedico(int id);
}
