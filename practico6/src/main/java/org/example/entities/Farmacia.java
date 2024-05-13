package org.example.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    public void solicitarMedicamento(Medicamento medicamento, Integer cantidad) {
        if (medicamentos.containsKey(medicamento)) {
            medicamentos.put(medicamento, medicamentos.get(medicamento) + cantidad);
        } else {
            medicamentos.put(medicamento, cantidad);
        }
    }
}
