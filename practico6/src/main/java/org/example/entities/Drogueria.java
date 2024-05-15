package org.example.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.example.entities.Farmacia;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Drogueria {
    private Integer id;
    private String nombre;
    private String direccion;
    private Integer telefono;

    public Map<Medicamento,Integer> entregarMedicamentos(Farmacia farmacia, Medicamento medicamento, Integer cantidad) {
        Map<Medicamento,Integer> entregarMedicamentos = farmacia.solicitarMedicamento(medicamento, cantidad);
        entregarMedicamentos.put(medicamento, cantidad);
        return entregarMedicamentos;
    }
}
