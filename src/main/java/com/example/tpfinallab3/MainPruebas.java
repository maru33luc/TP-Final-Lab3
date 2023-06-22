package com.example.tpfinallab3;

import com.example.tpfinallab3.models.Administrativo;
import com.example.tpfinallab3.models.Especialidad;
import com.example.tpfinallab3.models.Medico;
import com.example.tpfinallab3.models.Paciente;
import com.example.tpfinallab3.security.SessionManager;
import com.example.tpfinallab3.services.AdministrativoService;
import com.example.tpfinallab3.services.MedicoService;
import com.example.tpfinallab3.services.PacienteService;

public class MainPruebas {

    public static void main(String[] args) {

        // PROBANDO GUARDADO PACIENTES JSON Y AUTENTICACION

        /*Paciente paciente1 = new Paciente("juanperez", "12345678", "Juan", "Perez", "juan@gmail.com", "12345678", "12345678", "OSDE", "12345678");
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

        System.out.println("Autenticacion de ceciliagomez despues de agregarla" + authenticationService.autenticarUsuario("ceciliagomez","12345678"));*/

        // PROBANDO EL SESSION MANAGER

        /*System.out.println();
        System.out.println("Probando el SessionManager" + "\n");
        SessionManager sessionManager = SessionManager.getInstance();
        boolean inicioSesionExitoso = sessionManager.iniciarSesion("ceciliagomez","12345678");
        System.out.println("inicioSesionExitoso = " + inicioSesionExitoso);
        if (inicioSesionExitoso) {
            Autenticable entidadLogueada = sessionManager.getEntidadLogueada();
            String tipoEntidad = sessionManager.getTipoEntidad();
            System.out.println("Inicio de sesión exitoso");
            System.out.println("Tipo de entidad: " + tipoEntidad);
            System.out.println("Entidad logueada: " + entidadLogueada);
        } else {
            System.out.println("Inicio de sesión fallido");
        }
        sessionManager.cerrarSesion();
        System.out.println("Fin de sesión exitoso");
        System.out.println("Entidad logueada: " + sessionManager.getEntidadLogueada());
        System.out.println("Tipo de entidad: " + sessionManager.getTipoEntidad());


        // PROBANDO HABILITAR TURNOS

        LocalDate dia = LocalDate.of(2023, 6, 16);
        LocalTime horaInicio = LocalTime.of(10, 0);
        LocalTime horaFin = LocalTime.of(11, 0);
        Medico medico = new Medico("fgildemuro", "123456", "Federico", "Gil de Muro", "fgildemuro@hotmail.com", Especialidad.CARDIOLOGIA);
        TurnoService.getInstance().habilitarTurnos(dia, horaInicio, horaFin, medico );
        dia = LocalDate.of(2023, 6, 17);
        TurnoService.getInstance().habilitarTurnos(dia, horaInicio, horaFin, medico );
        dia = LocalDate.of(2023, 6, 19);
        System.out.println(TurnoService.getInstance().buscarTurnosPorDiaPorMedico(dia, medico));*/

        // PROBANDO PERMISOS DE ADMINISTRATIVO

        Administrativo administrativo = new Administrativo("carlosfuentes", "74185296", "Carlos", "Fuentes", "carlos@gmail.com");
        AdministrativoService.getInstance().agregarAdministrativo(administrativo);
        Medico medico = new Medico("fgildemuro", "12345611", "Federico", "Gil de Muro", "fede@gmail.com", Especialidad.CARDIOLOGIA);
        SessionManager.getInstance().iniciarSesion("carlosfuentes","74185296");
        MedicoService.getInstance().agregarMedico(medico);
        System.out.println("Administrativos: " + AdministrativoService.getInstance().getAdministrativos());
        SessionManager.getInstance().cerrarSesion();

        Paciente paciente1 = new Paciente("juanperez", "12345678", "Juan", "Perez", "juan@gmail.com", "12345678", "12345678", "OSDE", "12345678");
        PacienteService.getInstance().agregarPaciente(paciente1);
        SessionManager.getInstance().iniciarSesion("juanperez","12345678");
        System.out.println("Entidad logueada: " + SessionManager.getInstance().getEntidadLogueada());
        System.out.println("Tipo de entidad: " + SessionManager.getInstance().getTipoEntidad());



    }
}
