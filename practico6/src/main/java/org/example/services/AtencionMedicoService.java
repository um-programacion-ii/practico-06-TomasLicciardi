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

    public Receta atenderPaciente(Medico medico, Paciente paciente, Turno turno) {
        verificarDatos(medico, paciente, turno);
        medico.atenderPaciente();
        if (deberiaHacerReceta()) {
            Receta receta = generarReceta(medico);
            finalizarTurno(paciente, turno, medico);
            return receta;
        } else {
            finalizarTurno(paciente, turno, medico);
            return null;
        }
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

    private Receta generarReceta(Medico medico) {
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

        return recetaDao.crearReceta(receta);
    }

    private List<Medicamento> obtenerMedicamentosAleatorios() {
        List<Medicamento> medicamentos = new ArrayList<>();
        return medicamentos;
    }

    private void finalizarTurno(Paciente paciente, Turno turno, Medico medico) {
        medico.dejarDeAtender();
        gestionTurnoService.finalizarTurno(paciente, turno, medico);
    }
}
