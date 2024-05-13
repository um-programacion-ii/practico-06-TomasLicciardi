package org.example.DAO.implementations;

import org.example.entities.Farmacia;
import java.util.HashMap;
import java.util.Map;

public class FarmaciaDAO implements org.example.DAO.interfaces.FarmaciaDAO {
    private static FarmaciaDAO instancia;
    private final Map<Integer, Farmacia> farmacias = new HashMap<>();
    private int proximoId = 1;

    private FarmaciaDAO() {}

    public static FarmaciaDAO getInstance() {
        if (instancia == null) {
            instancia = new FarmaciaDAO();
        }
        return instancia;
    }

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
    public void actualizarFarmacia(Farmacia farmacia) {
        farmacias.put(farmacia.getId(), farmacia);
    }

    @Override
    public void eliminarFarmacia(int id) {
        farmacias.remove(id);
    }
}
