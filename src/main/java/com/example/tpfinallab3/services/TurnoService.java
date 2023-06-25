package com.example.tpfinallab3.services;

import com.example.tpfinallab3.models.Medico;
import com.example.tpfinallab3.models.Paciente;
import com.example.tpfinallab3.models.Turno;
import com.example.tpfinallab3.security.AuthorizationService;
import com.example.tpfinallab3.security.SessionManager;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class TurnoService {
    private static TurnoService instance;
    private static final String RUTA_JSON = "src/main/resources/json/turnos.json";
    private Set<Turno> turnos;

    private TurnoService() {
        turnos = new HashSet<>();
    }

    public static TurnoService getInstance() {
        if (instance == null) {
            synchronized (TurnoService.class) {
                if (instance == null) {
                    instance = new TurnoService();
                    instance.setTurnos();
                }
            }
        }

        return instance;
    }

    public Set<Turno> getTurnos() {
        return turnos;
    }

    public void setTurnos() {
        turnos = JsonService.getInstance().leerJson(RUTA_JSON, Turno.class);
    }

    public void habilitarTurnos(LocalDate dia, LocalTime hora, LocalTime horaFin, Medico medico) {
        if(AuthorizationService.getInstance().verificarPermiso(SessionManager.getInstance().getTipoEntidad(), "habilitarTurnos")) {

            if(MedicoService.getInstance().chequearEstadoMedico(medico)){
                if (dia.getDayOfWeek().equals(DayOfWeek.SATURDAY)) { //si el día de inicio es sábado lo pasa a lunes
                    dia = dia.plusDays(2);
                } else if (dia.getDayOfWeek().equals(DayOfWeek.SUNDAY)) {// si el día de inicio es domingo lo pasa a lunes
                    dia = dia.plusDays(1);
                }
                do {//agrega turnos en el día cada media hora
                    turnos.add(new Turno(dia, hora, medico));
                    hora = hora.plusMinutes(30);//agrega media hora para el siguiente turno
                } while (hora.isBefore(horaFin) || hora.equals(horaFin));//el bucle termina cuando la hora es anterior o igual a la final
                System.out.println("Turnos habilitados correctamente");
                guardarTurnosJson();
            }else{
                System.out.println("El medico no esta activo");
            }
        }else{
            System.out.println("No tiene permisos para habilitar turnos");
        }
    }

    public List<Turno> buscarTurnosPorDiaPorMedico(LocalDate dia, Medico medico) {
        if(medico.getActivo()) {
            return turnos.stream()
                    .filter(turno -> turno.getDia().equals(dia) && turno.getMedico().equals(medico))
                    .collect(Collectors.toList());
        }else{
            System.out.println("El medico no esta activo");
            return null;
        }
    }

    public Turno buscarTurnoPorMedicoDiaYHora (Medico medico, LocalDate dia, LocalTime hora){
        if(medico.getActivo()){
            return turnos.stream()
                    .filter(turno -> turno.getMedico().equals(medico) && turno.getDia().equals(dia) && turno.getHora().equals(hora))
                    .findFirst()
                    .orElse(null);
        }else{
            System.out.println("El medico no esta activo");
            return null;
        }
    }

    public List<Turno> buscarTurnosPorMedico(Medico medico) {
        if(medico.getActivo()){
            return turnos.stream()
                    .filter(turno -> turno.getMedico().equals(medico))
                    .collect(Collectors.toList());
        }else{
            System.out.println("El medico no esta activo");
            return null;
        }
    }

    public List<Turno> buscarTurnosPorPaciente(Paciente paciente) {
        if (paciente == null) {
            return null;
        } else {
            return turnos.stream()
                    .filter(turno -> {
                        Paciente pacienteTurno = turno.getPaciente();
                        return pacienteTurno != null && pacienteTurno.equals(paciente);
                    })
                    .collect(Collectors.toList());
        }
    }

    public List<Turno> buscarTurnosPorDia(LocalDate dia) {
        return turnos.stream()
                .filter(turno -> turno.getDia().equals(dia) && turno.getMedico().getActivo())
                .collect(Collectors.toList());
    }

    public List<Turno> buscarTurnosDisponibles() {
        return turnos.stream()
                .filter(turno -> turno.getDisponible() && turno.getMedico().getActivo())
                .collect(Collectors.toList());
    }

    // lista de turnos de medicos activos
    public List<Turno> buscarTurnosPorMedicoActivo(Medico medico) {
        return turnos.stream()
                .filter(turno -> turno.getMedico().getActivo())
                .collect(Collectors.toList());
    }

    public void solicitarTurno(Turno turno, Paciente paciente) {
        if(AuthorizationService.getInstance().verificarPermiso(SessionManager.getInstance().getTipoEntidad(), "solicitarTurno")) {

            if(turno.getDisponible() && turno.getMedico().getActivo()){
                turno.setPaciente(paciente);
                marcarTurnoComoOcupado(turno);
                System.out.println("Se ha solicitado un turno");
            }else{
                System.out.println("El turno no esta disponible");
            }

        }else{
            System.out.println("No tiene permisos para solicitar un turno");
        }
        guardarTurnosJson();
    }

    public void marcarTurnoComoOcupado(Turno turno) {
        turno.setDisponible(false);
    }

    public void marcarTurnoComoDisponible(Turno turno) {
        turno.setDisponible(true);
        turno.setPaciente(null);
    }

    public void guardarTurnosJson(){
        JsonService.getInstance().guardarJson(turnos, RUTA_JSON);
    }

    public Turno buscarTurnoPorPacienteMedicoYFecha(Paciente paciente, Medico medico, LocalDate dia, LocalTime hora) {
        for(Turno turno : turnos){

            if(turno.getPaciente()!=null && turno.getMedico()!=null && turno.getDia()!=null && turno.getHora()!=null && !turno.getDisponible()){
                if(turno.getPaciente().equals(paciente) && turno.getMedico().equals(medico) && turno.getDia().equals(dia) && turno.getHora().equals(hora)){
                    return turno;
                }
            }
        }
        return null;
    }
}

