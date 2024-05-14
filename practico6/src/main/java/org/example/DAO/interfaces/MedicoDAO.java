package org.example.DAO.interfaces;

import org.example.entities.Especialidad;
import org.example.entities.Medico;
import org.example.entities.ObraSocial;

import java.util.List;


public interface MedicoDAO {
    Medico crearMedico(Medico medico);
    Medico obtenerMedicoPorId(int id);

    List<Medico> obtenerMedicos();
    List<Medico> obtenerMedicosPorEspecialidad(Especialidad especialidad);

    List<Medico> obtenerMedicosParticulares();

    List<Medico> obtenerMedicosPorObrasSociales(ObraSocial obraSocial);

    void actualizarMedico(Medico medico);
    void eliminarMedico(int id);
}
