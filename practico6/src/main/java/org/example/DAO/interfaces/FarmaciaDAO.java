package org.example.DAO.interfaces;

import org.example.entities.Farmacia;

public interface FarmaciaDAO {
    Farmacia crearFarmacia(Farmacia farmacia);
    Farmacia obtenerFarmaciaPorId(int id);
    void actualizarFarmacia(Farmacia farmacia);
    void eliminarFarmacia(int id);
}
