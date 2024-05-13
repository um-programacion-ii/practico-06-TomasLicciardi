package org.example.DAO.implementations;

import org.example.entities.Medicamento;
import java.util.HashMap;
import java.util.Map;

public class MedicamentoDAO implements org.example.DAO.interfaces.MedicamentoDAO {
    private static MedicamentoDAO instancia;
    private final Map<Integer, Medicamento> medicamentos = new HashMap<>();
    private int proximoId = 1;

    private MedicamentoDAO() {}

    public static MedicamentoDAO getInstance() {
        if (instancia == null) {
            instancia = new MedicamentoDAO();
        }
        return instancia;
    }

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
