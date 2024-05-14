package org.example.DAO.implementations;

import org.example.entities.Medicamento;
import java.util.HashMap;
import java.util.Map;

public class MedicamentoDAOIm implements org.example.DAO.interfaces.MedicamentoDAO {
    private final Map<Integer, Medicamento> medicamentos = new HashMap<>();
    private int proximoId = 1;

    public MedicamentoDAOIm() {}

    @Override
    public Medicamento crearMedicamento(Medicamento medicamento) {
        medicamento.setId(proximoId++);
        medicamentos.put(medicamento.getId(), medicamento);
        return medicamento;
    }

    @Override
    public Medicamento obtenerMedicamentoPorId(int id) {
        return medicamentos.get(id);
    }

    @Override
    public void actualizarMedicamento(Medicamento medicamento) {
        medicamentos.put(medicamento.getId(), medicamento);
    }

    @Override
    public void eliminarMedicamento(int id) {
        medicamentos.remove(id);
    }
}
