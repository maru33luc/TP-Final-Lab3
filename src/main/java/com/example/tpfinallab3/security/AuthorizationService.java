package com.example.tpfinallab3.security;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AuthorizationService {
    private static AuthorizationService instance;
    private Map<String, List<String>> permisos;

    private AuthorizationService() {
        permisos = new HashMap<>();
        // Inicializar los permisos de los usuarios
        permisos.put("Administrativo", Arrays.asList("crearTurno", "editarTurno", "eliminarTurno", "agregarMedico", "eliminarMedico","habilitarTurnos","darDeBajaMedico", "darDeAltaMedico","darDeBajaAdministrativo", "darDeAltaAdministrativo"));
        permisos.put("Medico", Arrays.asList("verTurnos", "editarPaciente"));
        permisos.put("Paciente", Arrays.asList("solicitarTurno"));
    }

    public static AuthorizationService getInstance() {
        if (instance == null) {
            instance = new AuthorizationService();
        }
        return instance;
    }

    public boolean verificarPermiso(String tipoUsuario, String permiso) {

        for (Map.Entry<String, List<String>> entry : permisos.entrySet()) {
            if (entry.getKey().equalsIgnoreCase(tipoUsuario)) {
                List<String> permisosUsuario = entry.getValue();
                return permisosUsuario.contains(permiso);
            }
        }
        return false;
    }
}
