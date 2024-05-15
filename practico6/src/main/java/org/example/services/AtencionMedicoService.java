package org.example.services;

import org.example.DAO.implementations.*;
import org.example.entities.*;
import org.example.services.GestionTurnoService;
import java.util.*;


public class AtencionMedicoService {

    private static AtencionMedicoService instance;
    private TurnoDAOIm turnoDao;
    private PacienteDAOIm pacienteDao;
    private MedicoDAOIm medicoDao;
    private RecetaDAOIm recetaDao;
    private GestionTurnoService gestionTurnoService;

    public static AtencionMedicoService getInstance() {
        if (instance == null) {
            instance = new AtencionMedicoService();
        }
        return instance;
    }

    public AtencionMedicoService(){
        turnoDao = new TurnoDAOIm();
        pacienteDao = new PacienteDAOIm();
        medicoDao = new MedicoDAOIm();
        recetaDao = new RecetaDAOIm();
        gestionTurnoService = GestionTurnoService.getInstance();
    }

    private void verificarDatos(Medico medico, Paciente paciente, Turno turno) {
        if (!medico.getTurnos().contains(turno) || !paciente.getTurnos().contains(turno) || medico.getEstaAtendiendo()) {
            throw new IllegalArgumentException("Los datos introducidos no coinciden con el turno del paciente o del médico.");
        }
    }

    private boolean deberiaHacerReceta() {
        Random rand = new Random();
        return rand.nextInt(8) != 0;
    }

    private void finalizarTurno(Paciente paciente, Turno turno, Medico medico) {
        medico.dejarDeAtender();
        gestionTurnoService.finalizarTurno(paciente, turno, medico);
    }

    private List<Medicamento> obtenerMedicamentosAleatorios() {
        List<Medicamento> medicamentos = new ArrayList<>();
        Medicamento medicamento1 = new Medicamento(1, "Ibuprofeno", "Bayer", "Aspirina");
        Medicamento medicamento2 = new Medicamento(2, "Paracetamol", "Bayer", "Dioxaflex");
        Medicamento medicamento3 = new Medicamento(3, "Amoxicilina", "Roemmers", "Amoxidal");
        Medicamento medicamento4 = new Medicamento(4, "Omeprazol", "Roemmers", "Omeprazol");
        Medicamento medicamento5 = new Medicamento(5, "Diazepam", "Bago", "Valium");
        Medicamento medicamento6 = new Medicamento(6, "Lorazepam", "Bago", "Ativan");

        medicamentos.add(medicamento1);
        medicamentos.add(medicamento2);
        medicamentos.add(medicamento3);
        medicamentos.add(medicamento4);
        medicamentos.add(medicamento5);
        medicamentos.add(medicamento6);

        return medicamentos;
    }

    private Receta generarReceta(Medico medico,Paciente paciente) {
        Random rand = new Random();
        int numMedicamentos = rand.nextInt(3) + 1;
        List<Medicamento> medicamentos = obtenerMedicamentosAleatorios();
        Map<Medicamento, Integer> medicamentosRecetados = new HashMap<>();

        for (int i = 0; i < numMedicamentos; i++) {
            int obtenerMedicamento = rand.nextInt(medicamentos.size());
            int cantidad = rand.nextInt(10) + 1;
            Medicamento medicamento = medicamentos.get(obtenerMedicamento);
            medicamentosRecetados.put(medicamento, cantidad);
        }

        Receta receta = new Receta();
        receta.setMedico(medico);
        receta.setMedicamentos(medicamentosRecetados);
        receta.setPaciente(paciente);

        return recetaDao.crearReceta(receta);
    }

    public Receta atenderPaciente(Medico medico, Paciente paciente, Turno turno) {
        verificarDatos(medico, paciente, turno);
        medico.atenderPaciente();
        if (deberiaHacerReceta()) {
            Receta receta = generarReceta(medico,paciente);
            finalizarTurno(paciente, turno, medico);
            return receta;
        } else {
            finalizarTurno(paciente, turno, medico);
            return null;
        }
    }
}
