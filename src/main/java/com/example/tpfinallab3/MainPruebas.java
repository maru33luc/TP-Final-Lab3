package com.example.tpfinallab3;

import com.example.tpfinallab3.models.Administrativo;
import com.example.tpfinallab3.models.Especialidad;
import com.example.tpfinallab3.models.Medico;
import com.example.tpfinallab3.security.SessionManager;
import com.example.tpfinallab3.services.AdministrativoService;
import com.example.tpfinallab3.services.MedicoService;
import com.example.tpfinallab3.services.TurnoService;

import java.time.LocalDate;
import java.time.LocalTime;

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
        */



        // PROBANDO PERMISOS DE ADMINISTRATIVO

        Administrativo administrativo = new Administrativo("carlosfuentes", "74185296", "Carlos", "Fuentes", "carlos@gmail.com");
        AdministrativoService.getInstance().agregarAdministrativo(administrativo);
        Medico medico = new Medico("fgildemuro", "12345611", "Federico", "Gil de Muro", "fede@gmail.com", Especialidad.CARDIOLOGIA);
        SessionManager.getInstance().iniciarSesion("carlosfuentes","74185296");
        System.out.println("Contraseña de la entidad logueada: " + SessionManager.getInstance().getEntidadLogueada().getContrasena());
        MedicoService.getInstance().agregarMedico(medico);
        Medico medico2 = new Medico("soniabazan","147258","Sonia","Bazan","sonia@gmail.com",Especialidad.PEDIATRIA);
        MedicoService.getInstance().agregarMedico(medico2);
        System.out.println("medico2 = " + medico2);

        //  PROBANDO DAR DE ALTA Y BAJA MEDICO
        
        MedicoService.getInstance().darDeAltaMedico(medico2);
        //MedicoService.getInstance().darDeBajaMedico(medico2);
        MedicoService.getInstance().chequearEstadoMedico(medico2);
        System.out.println("---------------- CHEQUEANDO ESTADO MEDICO DADO DE BAJA  ----------------------------");
        System.out.println("Medico dado de baja: " + MedicoService.getInstance().chequearEstadoMedico(medico2));
        System.out.println("Medico dado de baja: " + MedicoService.getInstance().buscarMedicoPorNombreYApellido("Sonia", "Bazan").toString());
        System.out.println("Administrativos: " + AdministrativoService.getInstance().getAdministrativos());
        AdministrativoService.getInstance().modificarAdministrativo("carlosfuentes",  "Carlos", "Fuentes", "carlosFuentes@gmail.com");
        System.out.println("Administrativos: " + AdministrativoService.getInstance().getAdministrativos());
       // SessionManager.getInstance().cerrarSesion();

        // PROBANDO HABILITAR TURNOS

        LocalDate dia = LocalDate.of(2023, 6, 16);
        LocalTime horaInicio = LocalTime.of(10, 0);
        LocalTime horaFin = LocalTime.of(11, 0);
        TurnoService.getInstance().habilitarTurnos(dia, horaInicio, horaFin, medico2 );
        System.out.println("Los turnos de Sonia son: " + TurnoService.getInstance().buscarTurnosPorDiaPorMedico(dia, medico2));

        //Medico medico = new Medico("fgildemuro", "123456", "Federico", "Gil de Muro", "fgildemuro@hotmail.com", Especialidad.CARDIOLOGIA);
        TurnoService.getInstance().habilitarTurnos(dia, horaInicio, horaFin, medico );
        /*dia = LocalDate.of(2023, 6, 17);
        TurnoService.getInstance().habilitarTurnos(dia, horaInicio, horaFin, medico );
        dia = LocalDate.of(2023, 6, 19);
        System.out.println(TurnoService.getInstance().buscarTurnosPorDiaPorMedico(dia, medico));
        //Medico medico = new Medico("fgildemuro", "123456", "Federico", "Gil de Muro", "fgildemuro@hotmail.com", Especialidad.CARDIOLOGIA);

        // imprimir todos los turnos existentes
        System.out.println(TurnoService.getInstance().getTurnos());


        Turno turno = TurnoService.getInstance().buscarTurnosPorDiaPorMedico(dia, medico).get(0);
        System.out.println(turno);
        PacienteService.getInstance().agregarPaciente(new Paciente("lauragonzalez","22334455","Laura","Gonzalez","laura@gmail.com","22334455","22334455","OSDE","22334455"));
        Optional<Paciente> paciente = PacienteService.getInstance().buscarPacientePorNombreUsuario("lauragonzalez");
        SessionManager.getInstance().iniciarSesion("lauragonzalez","22334455");
        TurnoService.getInstance().solicitarTurno(turno,paciente.get());
        System.out.println(TurnoService.getInstance().buscarTurnosPorPaciente(paciente.get()));
        System.out.println("turno "+ turno.toString());
        Turno turno2 = TurnoService.getInstance().buscarTurnoPorPacienteMedicoDiaYHora(paciente.get(), medico, turno.getDia(), turno.getHora());
        TurnoService.getInstance().marcarTurnoComoDisponible(turno2);
        System.out.println("turno2.toString() = " + turno2.toString());*/


        /*Paciente paciente1 = new Paciente("juanperez", "12345678", "Juan", "Perez", "juan@gmail.com", "12345678", "12345678", "OSDE", "12345678");
        PacienteService.getInstance().agregarPaciente(paciente1);
        SessionManager.getInstance().iniciarSesion("juanperez","12345678");
        System.out.println("Entidad logueada: " + SessionManager.getInstance().getEntidadLogueada());
        System.out.println("Tipo de entidad: " + SessionManager.getInstance().getTipoEntidad());*/

       /* Medico medico3 = new Medico("fgildemuro", "123456", "Federico", "Gil de Muro", "fgildemuro@hotmail.com", Especialidad.CARDIOLOGIA);
        MedicoService.getInstance().agregarMedico(medico3);
*/


    }
}
