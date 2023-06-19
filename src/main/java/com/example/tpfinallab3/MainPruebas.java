package com.example.tpfinallab3;

import com.example.tpfinallab3.models.Especialidad;
import com.example.tpfinallab3.models.Medico;
import com.example.tpfinallab3.models.Paciente;
import com.example.tpfinallab3.security.AuthenticationService;
import com.example.tpfinallab3.services.JsonService;
import com.example.tpfinallab3.services.PacienteService;
import com.example.tpfinallab3.services.TurnoService;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;


public class MainPruebas {

    public static void main(String[] args) {

        LocalDate diaInicio = LocalDate.of(2023, 10, 1);
        LocalTime horaInicio = LocalTime.of(10, 0);
        LocalDate diaFin = LocalDate.of(2023, 10, 31);
        LocalTime horaFin = LocalTime.of(16, 0);
        TurnoService.getInstance().habilitarTurnos(diaInicio, diaFin, horaInicio, horaFin, new Medico("fgildemuro", "123456", "Federico", "Gil de Muro", "fgildemuro@hotmail.com", Especialidad.CARDIOLOGIA));
        System.out.println(TurnoService.getInstance().getTurnos());

    }
}
