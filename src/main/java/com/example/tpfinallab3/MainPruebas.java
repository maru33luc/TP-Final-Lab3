package com.example.tpfinallab3;

import com.example.tpfinallab3.models.Especialidad;
import com.example.tpfinallab3.models.Medico;
import com.example.tpfinallab3.models.Paciente;
import com.example.tpfinallab3.security.AuthenticationService;
import com.example.tpfinallab3.services.PacienteService;
import com.example.tpfinallab3.services.TurnoService;


import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;



public class MainPruebas {

    public static void main(String[] args) {


        Paciente paciente1 = new Paciente("juanperez", "12345678", "Juan", "Perez", "juan@gmail.com", "12345678", "12345678", "OSDE", "12345678");
        Paciente paciente2 = new Paciente("mariagomez", "12345689", "Maria", "Gomez", "maria@gmail.com",  "12345689", "12345689", "FEDERADA", "12345689");
        Paciente paciente3 = new Paciente("jorgelopez", "12345679", "Jorge", "Lopez", "jorge@gmail.com",  "12345679", "12345679", "OSDE", "12345679");

        PacienteService pacienteService = PacienteService.getInstance();
        pacienteService.agregarPaciente(paciente1);
        pacienteService.agregarPaciente(paciente2);
        pacienteService.agregarPaciente(paciente3);
        System.out.println("lista Pacientes desde PacienteService" + pacienteService.getPacientes().toString());

        pacienteService.guardarPacientesJson();

        AuthenticationService authenticationService = AuthenticationService.getInstance();

        System.out.println("Autenticacion de ceciliagomez " + authenticationService.autenticarUsuario("ceciliagomez","12345678"));


        pacienteService.agregarPaciente(new Paciente("ceciliagomez","12345678","Cecilia","Gomez","cecilia@gmail.com","12345678","12345678","OSDE","12345678"));
        pacienteService.guardarPacientesJson();
        System.out.println();
        System.out.println("lista Pacientes desde PacienteService" + pacienteService.getPacientes().toString());

        System.out.println("Autenticacion de ceciliagomez despues de agregarla" + authenticationService.autenticarUsuario("ceciliagomez","12345678"));


        LocalDate diaInicio = LocalDate.of(2023, 10, 1);
        LocalTime horaInicio = LocalTime.of(10, 0);
        LocalDate diaFin = LocalDate.of(2023, 10, 31);
        LocalTime horaFin = LocalTime.of(16, 0);
        TurnoService.getInstance().habilitarTurnos(diaInicio, diaFin, horaInicio, horaFin, new Medico("fgildemuro", "123456", "Federico", "Gil de Muro", "fgildemuro@hotmail.com", Especialidad.CARDIOLOGIA));
        System.out.println(TurnoService.getInstance().getTurnos());

    }
}
