package org.example.DAO.interfaces;

import org.example.entities.ObraSocial;

public interface ObraSocialDAO {
    ObraSocial crearObraSocial(ObraSocial obraSocial);
    ObraSocial obtenerObraSocialPorId(int id);
    void actualizarObraSocial(ObraSocial obraSocial);
    void eliminarObraSocial(int id);
}