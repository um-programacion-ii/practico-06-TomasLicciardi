package org.example.DAO.interfaces;

import org.example.entities.Farmacia;
import org.example.entities.Medicamento;

import java.util.List;

public interface FarmaciaDAO {
    Farmacia crearFarmacia(Farmacia farmacia);
    Farmacia obtenerFarmaciaPorId(int id);

    List<Medicamento> obtenerMedicamentosPorFarmacia(Farmacia farmacia);

    void actualizarFarmacia(Farmacia farmacia);
    void eliminarFarmacia(int id);
}
