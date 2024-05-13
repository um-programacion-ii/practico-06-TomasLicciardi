package org.example.DAO.implementations;

import org.example.entities.Receta;
import java.util.HashMap;
import java.util.Map;

public class RecetaDAO implements org.example.DAO.interfaces.RecetaDAO {
    private static RecetaDAO instancia;
    private final Map<Integer, Receta> recetas = new HashMap<>();
    private int proximoId = 1;

    private RecetaDAO() {}

    public static RecetaDAO getInstance() {
        if (instancia == null) {
            instancia = new RecetaDAO();
        }
        return instancia;
    }

    @Override
    public Receta crearReceta(Receta receta) {
        receta.setId(proximoId++);
        recetas.put(receta.getId(), receta);
        return receta;
    }

    @Override
    public Receta obtenerRecetaPorId(int id) {
        return recetas.get(id);
    }

    @Override
    public void actualizarReceta(Receta receta) {
        recetas.put(receta.getId(), receta);
    }

    @Override
    public void eliminarReceta(int id) {
        recetas.remove(id);
    }
}
