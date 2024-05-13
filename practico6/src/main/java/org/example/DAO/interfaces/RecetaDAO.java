package org.example.DAO.interfaces;

import org.example.entities.Receta;

public interface RecetaDAO {
    Receta crearReceta(Receta receta);
    Receta obtenerRecetaPorId(int id);
    void actualizarReceta(Receta receta);
    void eliminarReceta(int id);
}