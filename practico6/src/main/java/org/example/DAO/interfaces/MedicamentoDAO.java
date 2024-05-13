package org.example.DAO.interfaces;

import org.example.entities.Medicamento;

public interface MedicamentoDAO {
    Medicamento crearMedicamento(Medicamento medicamento);
    Medicamento obtenerMedicamentoPorId(int id);
    void actualizarMedicamento(Medicamento medicamento);
    void eliminarMedicamento(int id);
}
