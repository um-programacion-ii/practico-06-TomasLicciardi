package org.example.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Receta {
    private Integer id;
    private Paciente paciente;
    private Medico medico;
    private Map<Medicamento,Integer> medicamentos;

    public void eliminarMedicamento(Medicamento medicamento) {
        this.medicamentos.remove(medicamento);
    }
}
