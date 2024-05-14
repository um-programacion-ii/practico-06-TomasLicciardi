package org.example.DAO.implementations;

import org.example.entities.Drogueria;
import java.util.HashMap;
import java.util.Map;

public class DrogueriaDAOIm implements org.example.DAO.interfaces.DrogueriaDAO {
    private final Map<Integer, Drogueria> droguerias = new HashMap<>();
    private int proximoId = 1;

    private DrogueriaDAOIm() {}

    @Override
    public Drogueria crearDrogueria(Drogueria drogueria) {
        drogueria.setId(proximoId++);
        droguerias.put(drogueria.getId(), drogueria);
        return drogueria;
    }

    @Override
    public Drogueria obtenerDrogueriaPorId(int id) {
        return droguerias.get(id);
    }

    @Override
    public void actualizarDrogueria(Drogueria drogueria) {
        droguerias.put(drogueria.getId(), drogueria);
    }

    @Override
    public void eliminarDrogueria(int id) {
        droguerias.remove(id);
    }
}
