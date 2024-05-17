package org.example;

import org.example.DAO.implementations.*;
import org.example.DAO.interfaces.*;
import org.example.entities.*;
import org.example.services.*;

import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Creación de instancias de los DAO y servicios necesarios
        PacienteDAO pacienteDAO = new PacienteDAOIm();
        MedicoDAO medicoDAO = new MedicoDAOIm();
        TurnoDAO turnoDAO = new TurnoDAOIm();
        GestionTurnoService gestionTurnoService = GestionTurnoService.getInstance();
        GestionFarmaciaService gestionFarmaciaService = GestionFarmaciaService.getInstance();
        AtencionMedicoService atencionMedicoService = AtencionMedicoService.getInstance();

        List<ObraSocial> obraSociales1 = new ArrayList<ObraSocial>();
        List<ObraSocial> obraSociales2 = new ArrayList<ObraSocial>();

        // Creación de obras sociales
        ObraSocial obraSocial1 = new ObraSocial();
        obraSocial1.setId(1);
        obraSocial1.setNombre("OSDE");

        ObraSocial obraSocial2 = new ObraSocial();
        obraSocial2.setId(2);
        obraSocial2.setNombre("Swiss Medical");

        ObraSocial obraSocial3 = new ObraSocial();
        obraSocial3.setId(3);
        obraSocial3.setNombre("Galeno");

        obraSociales1.add(obraSocial1);
        obraSociales1.add(obraSocial2);
        obraSociales1.add(obraSocial3);

        obraSociales2.add(obraSocial1);
        obraSociales2.add(obraSocial2);

        // Creación de especialidades
        Especialidad especialidad1 = new Especialidad();
        especialidad1.setId(1);
        especialidad1.setNombre("Cardiología");

        Especialidad especialidad2 = new Especialidad();
        especialidad2.setId(2);
        especialidad2.setNombre("Traumatología");

        List<Turno> turnos = new ArrayList<Turno>();
        List<Receta> recetas = new ArrayList<Receta>();

        // Creación de médicos
        Medico medico1 = new Medico();
        medico1.setId(1);
        medico1.setNombre("Tomas");
        medico1.setApellido("Licciardi");
        medico1.setEspecialidad(especialidad1);
        medico1.setObraSociales(obraSociales1);
        medico1.setAtenderParticulares(true);
        medico1.setEstaAtendiendo(false);
        medico1.setTurnos(turnos);

        Medico medico2 = new Medico();
        medico2.setId(2);
        medico2.setNombre("Martin");
        medico2.setApellido("Gonzales");
        medico2.setEspecialidad(especialidad2);
        medico2.setObraSociales(obraSociales1);
        medico2.setAtenderParticulares(false);
        medico2.setEstaAtendiendo(false);
        medico2.setTurnos(turnos);

        Medico medico3 = new Medico();
        medico3.setId(3);
        medico3.setNombre("Micaela");
        medico3.setApellido("Gomez");
        medico3.setEspecialidad(especialidad1);
        medico3.setObraSociales(obraSociales2);
        medico3.setAtenderParticulares(true);
        medico3.setEstaAtendiendo(false);
        medico3.setTurnos(turnos);

        Medico medico4 = new Medico();
        medico4.setId(4);
        medico4.setNombre("Lucas");
        medico4.setApellido("Perez");
        medico4.setEspecialidad(especialidad2);
        medico4.setObraSociales(obraSociales2);
        medico4.setAtenderParticulares(false);
        medico4.setEstaAtendiendo(false);
        medico4.setTurnos(turnos);

        // Creación de pacientes
        Paciente paciente1 = new Paciente();
        paciente1.setId(1);
        paciente1.setNombre("Maria");
        paciente1.setApellido("Gomez");
        paciente1.setObraSocial(obraSocial1);
        paciente1.setRecetas(recetas);
        paciente1.setTurnos(turnos);

        Paciente paciente2 = new Paciente();
        paciente2.setId(2);
        paciente2.setNombre("Juan");
        paciente2.setApellido("Perez");
        paciente2.setObraSocial(obraSocial2);
        paciente2.setRecetas(recetas);
        paciente2.setTurnos(turnos);

        Paciente paciente3 = new Paciente();
        paciente3.setId(3);
        paciente3.setNombre("Lucia");
        paciente3.setApellido("Martinez");
        paciente3.setObraSocial(obraSocial3);
        paciente3.setRecetas(recetas);
        paciente3.setTurnos(turnos);

        // Creación de turnos
        Turno turno1 = gestionTurnoService.crearTurno(paciente1, medico1, especialidad1);
        Turno turno2 = gestionTurnoService.crearTurno(paciente2, medico2, especialidad2);
        Turno turno3 = gestionTurnoService.crearTurno(paciente3, medico3, especialidad1);

        System.out.println("Turnos de " + medico1.getNombre() + " " + medico1.getApellido() + ": " + medico1.getTurnos());

        // Atención de pacientes
        atencionMedicoService.atenderPaciente(medico1, paciente1, turno1);
        atencionMedicoService.atenderPaciente(medico2, paciente2, turno2);
        atencionMedicoService.atenderPaciente(medico3, paciente3, turno3);

        // Creación de una farmacia
        Farmacia farmacia1 = new Farmacia();
        farmacia1.setId(1);
        farmacia1.setNombre("Farmacity");
        farmacia1.setDireccion("Av. Rivadavia 1234");
        farmacia1.setTelefono(261212957);
//
        // Compra de medicamentos según receta
        gestionFarmaciaService.comprarMedicamentosSegunReceta(paciente1, farmacia1);
        gestionFarmaciaService.comprarMedicamentosSegunReceta(paciente2, farmacia1);
        gestionFarmaciaService.comprarMedicamentosSegunReceta(paciente3, farmacia1);

        // Impresión de recetas de los pacientes
        System.out.println("Recetas de " + paciente1.getNombre() + " " + paciente1.getApellido() + ": " + paciente1.getRecetas());
        System.out.println("Recetas de " + paciente2.getNombre() + " " + paciente2.getApellido() + ": " + paciente2.getRecetas());
        System.out.println("Recetas de " + paciente3.getNombre() + " " + paciente3.getApellido() + ": " + paciente3.getRecetas());
    }
}
