package org.example.services;

import org.example.entities.*;
import org.example.DAO.implementations.*;
import org.example.DAO.interfaces.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GestionFarmaciaService {
    private static GestionFarmaciaService instance;
    private RecetaDAO recetaDAO;
    private MedicamentoDAO medicamentoDAO;
    private PacienteDAO pacienteDAO;
    private ObraSocialDAO obraSocialDAO;
    private FarmaciaDAO farmaciaDAO;
    private DrogueriaDAO drogueriaDAO;

    public static GestionFarmaciaService getInstance() {
        if (instance == null) {
            instance = new GestionFarmaciaService();
        }
        return instance;
    }

    public GestionFarmaciaService() {
        recetaDAO = new RecetaDAOIm();
        medicamentoDAO = new MedicamentoDAOIm();
        pacienteDAO = new PacienteDAOIm();
        obraSocialDAO = new ObraSocialDAOIm();
        farmaciaDAO = new FarmaciaDAOIm();
        drogueriaDAO = new DrogueriaDAOIm();
    }

    public void comprarMedicamentosSegunReceta(Paciente paciente, Farmacia farmacia) {
        List<Receta> recetas = paciente.getRecetas();
        for (Receta receta : recetas) {
            if (receta != null) {
                Map<Medicamento, Integer> medicamentosRecetados = new HashMap<>(receta.getMedicamentos()); // Copia del HashMap original
                boolean haySuficientesMedicamentos = true;
                for (Map.Entry<Medicamento, Integer> entry : medicamentosRecetados.entrySet()) {
                    Medicamento medicamento = entry.getKey();
                    int cantidadNecesaria = entry.getValue();
                    if (farmacia.getMedicamentos().containsKey(medicamento)) {
                        int cantidadDisponible = farmacia.getMedicamentos().get(medicamento);
                        if (cantidadDisponible < cantidadNecesaria) {
                            haySuficientesMedicamentos = false;
                            farmacia.agregarMedicamento(medicamento, cantidadNecesaria - cantidadDisponible);
                        }
                    } else {
                        haySuficientesMedicamentos = false;
                        farmacia.agregarMedicamento(medicamento, cantidadNecesaria);
                    }
                }
                if (haySuficientesMedicamentos) {
                    // Entregar medicamentos al paciente
                    for (Map.Entry<Medicamento, Integer> entry : medicamentosRecetados.entrySet()) {
                        Medicamento medicamento = entry.getKey();
                        int cantidadNecesaria = entry.getValue();
                        farmacia.entregarMedicamento(medicamento, cantidadNecesaria);
                        receta.eliminarMedicamento(medicamento);
                    }
                    paciente.eliminarReceta(receta);
                } else {
                    System.out.println("No hay suficientes medicamentos en stock. Se ha solicitado a la droguería.");
                }
            } else {
                System.out.println("El paciente no tiene ninguna receta.");
            }
        }
    }

}
