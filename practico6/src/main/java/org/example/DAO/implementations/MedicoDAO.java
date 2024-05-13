package org.example.DAO.implementations;

import org.example.entities.Medico;
import java.util.HashMap;
import java.util.Map;

public class MedicoDAO implements org.example.DAO.interfaces.MedicoDAO {
    private static MedicoDAO instancia;
    private final Map<Integer, Medico> medicos = new HashMap<>();
    private int proximoId = 1;

    private MedicoDAO() {}

    public static MedicoDAO getInstance() {
        if (instancia == null) {
            instancia = new MedicoDAO();
        }
        return instancia;
    }

    @Override
    public Medico crearMedico(Medico medico) {
        medico.setId(proximoId++);
        medicos.put(medico.getId(), medico);
        return medico;
    }

    @Override
    public Medico obtenerMedicoPorId(int id) {
        return medicos.get(id);
    }

    @Override
    public void actualizarMedico(Medico medico) {
        medicos.put(medico.getId(), medico);
    }

    @Override
    public void eliminarMedico(int id) {
        medicos.remove(id);
    }
}
