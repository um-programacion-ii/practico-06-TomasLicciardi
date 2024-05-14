package org.example.DAO.implementations;

import org.example.entities.ObraSocial;
import java.util.HashMap;
import java.util.Map;

public class ObraSocialDAOIm implements org.example.DAO.interfaces.ObraSocialDAO {
    private final Map<Integer, ObraSocial> obrasSociales = new HashMap<>();
    private int proximoId = 1;

    public ObraSocialDAOIm() {}

    @Override
    public ObraSocial crearObraSocial(ObraSocial obraSocial) {
        obraSocial.setId(proximoId++);
        obrasSociales.put(obraSocial.getId(), obraSocial);
        return obraSocial;
    }

    @Override
    public ObraSocial obtenerObraSocialPorId(int id) {
        return obrasSociales.get(id);
    }

    @Override
    public void actualizarObraSocial(ObraSocial obraSocial) {
        obrasSociales.put(obraSocial.getId(), obraSocial);
    }

    @Override
    public void eliminarObraSocial(int id) {
        obrasSociales.remove(id);
    }
}
