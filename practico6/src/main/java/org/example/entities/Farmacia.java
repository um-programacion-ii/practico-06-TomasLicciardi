package org.example.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Farmacia {
    private Integer id;
    private String nombre;
    private String direccion;
    private Integer telefono;
    private Map<Medicamento, Integer> medicamentos;

    public Map<Medicamento,Integer> solicitarMedicamento(Medicamento medicamento, Integer cantidad) {
        Map<Medicamento,Integer> medicamentosSolicitados = new HashMap<>();
        medicamentosSolicitados.put(medicamento, cantidad);
        return medicamentosSolicitados;
    }

    public void agregarMedicamento(Medicamento medicamento, Integer cantidad) {
        if (medicamentos.containsKey(medicamento)) {
            medicamentos.put(medicamento, medicamentos.get(medicamento) + cantidad);
        } else {
            medicamentos.put(medicamento, cantidad);
        }
    }

    public void entregarMedicamento(Medicamento medicamento, Integer cantidad) {
        if (medicamentos.containsKey(medicamento)) {
            medicamentos.put(medicamento, medicamentos.get(medicamento) - cantidad);
        }
    }

}
