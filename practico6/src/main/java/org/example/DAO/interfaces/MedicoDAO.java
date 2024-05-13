package org.example.DAO.interfaces;

import org.example.entities.Medico;

public interface MedicoDAO {
    Medico crearMedico(Medico medico);
    Medico obtenerMedicoPorId(int id);
    void actualizarMedico(Medico medico);
    void eliminarMedico(int id);
}
