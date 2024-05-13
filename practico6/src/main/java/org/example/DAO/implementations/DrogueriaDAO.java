package org.example.DAO.implementations;

import org.example.entities.Drogueria;
import java.util.HashMap;
import java.util.Map;

public class DrogueriaDAO implements org.example.DAO.interfaces.DrogueriaDAO {
    private static DrogueriaDAO instancia;
    private final Map<Integer, Drogueria> droguerias = new HashMap<>();
    private int proximoId = 1;

    private DrogueriaDAO() {}

    public static DrogueriaDAO getInstance() {
        if (instancia == null) {
            instancia = new DrogueriaDAO();
        }
        return instancia;
    }

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
