package com.example.tpfinallab3;

import com.example.tpfinallab3.models.Paciente;
import com.example.tpfinallab3.security.AuthenticationService;
import com.example.tpfinallab3.services.PacienteService;

import java.util.ArrayList;
import java.util.List;

import static com.example.tpfinallab3.models.Clinica.guardarJson;
import static com.example.tpfinallab3.models.Clinica.leerJson;

public class MainPruebas {

    public static void main(String[] args) {

        String rutaPacientes = "src/main/resources/json/pacientes.json";

        Paciente paciente1 = new Paciente("juanperez", "12345678", "Juan", "Perez", "juan@gmail.com", "DNI", "12345678", "12345678", "OSDE", "12345678");
        Paciente paciente2 = new Paciente("mariagomez", "12345689", "Maria", "Gomez", "maria@gmail.com", "DNI", "12345689", "12345689", "FEDERADA", "12345689");
        Paciente paciente3 = new Paciente("jorgelopez", "12345679", "Jorge", "Lopez", "jorge@gmail.com", "DNI", "12345679", "12345679", "OSDE", "12345679");

        List<Paciente> pacientes = new ArrayList<>();
        pacientes.add(paciente1);
        pacientes.add(paciente2);
        pacientes.add(paciente3);

        guardarJson(pacientes,rutaPacientes);

        List<Paciente> pacientes2 = leerJson(rutaPacientes, Paciente.class);
        System.out.println(pacientes2);

        PacienteService pacienteService = new PacienteService();
        pacienteService.setPacientes(pacientes2);
        pacienteService.agregarPaciente(new Paciente("ceciliagomez","12345678","Cecilia","Gomez","cecilia@gmail.com","DNI","12345670","12345670","OSPE","12345670"));
        guardarJson(pacienteService.getPacientes(),rutaPacientes);
        List <Paciente> pacientes3 = leerJson(rutaPacientes,Paciente.class);
        System.out.println("-------------------------");
        System.out.println(pacientes3);

        AuthenticationService authenticationService = AuthenticationService.getInstance();
        authenticationService.guardarUsuario("ceciliagomez","12345678");
        System.out.println(authenticationService.autenticarUsuario("ceciliagomez","12345678"));





    }
}
