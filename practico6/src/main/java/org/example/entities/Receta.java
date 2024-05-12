package org.example.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Receta {
    private int id;
    private List<Medicamento> medicamentos; // Puede contener uno o más medicamentos
}
