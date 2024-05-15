package org.example.DAO.implementations;

import org.example.entities.Farmacia;
import org.example.entities.Medicamento;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FarmaciaDAOIm implements org.example.DAO.interfaces.FarmaciaDAO {
    private final Map<Integer, Farmacia> farmacias = new HashMap<>();
    private int proximoId = 1;

    public FarmaciaDAOIm() {}

    @Override
    public Farmacia crearFarmacia(Farmacia farmacia) {
        farmacia.setId(proximoId++);
        farmacias.put(farmacia.getId(), farmacia);
        return farmacia;
    }

    @Override
    public Farmacia obtenerFarmaciaPorId(int id) {
        return farmacias.get(id);
    }

    @Override
    public List<Medicamento> obtenerMedicamentosPorFarmacia(Farmacia farmacia) {
        return farmacia.getMedicamentos().keySet().stream().toList();
    }

    @Override
    public void actualizarFarmacia(Farmacia farmacia) {
        farmacias.put(farmacia.getId(), farmacia);
    }

    @Override
    public void eliminarFarmacia(int id) {
        farmacias.remove(id);
    }
}
