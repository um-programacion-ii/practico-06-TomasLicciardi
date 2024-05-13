package org.example.DAO.interfaces;

import org.example.entities.Drogueria;

public interface DrogueriaDAO {
    Drogueria crearDrogueria(Drogueria drogueria);
    Drogueria obtenerDrogueriaPorId(int id);
    void actualizarDrogueria(Drogueria drogueria);
    void eliminarDrogueria(int id);
}
