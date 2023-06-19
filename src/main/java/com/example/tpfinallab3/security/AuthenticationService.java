package com.example.tpfinallab3.security;
import com.example.tpfinallab3.models.UsuarioInfo;
import com.example.tpfinallab3.services.JsonService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.mindrot.jbcrypt.BCrypt;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AuthenticationService {

    private static AuthenticationService instance;
    private static final String RUTA_JSON = "src/main/resources/json/usuariosYContraseñas.json";
    private Map<String, UsuarioInfo> usuarios;

    private AuthenticationService() {
        cargarUsuariosDesdeJson();
    }

    public static AuthenticationService getInstance() {
        if (instance == null) {
            synchronized (AuthenticationService.class) {
                if (instance == null) {
                    instance = new AuthenticationService();
                }
            }
        }
        return instance;
    }

    public boolean autenticarUsuario(String nombreUsuario, String contrasena) {
        cargarUsuariosDesdeJson();
        if (usuarios.containsKey(nombreUsuario)) {
            //String contrasenaAlmacenada = usuarios.get(nombreUsuario);
            String contrasenaAlmacenada = obtenerContrasenaAlmacenada(nombreUsuario);
            return BCrypt.checkpw(contrasena, contrasenaAlmacenada);
        }
        return false;
    }

    private void cargarUsuariosDesdeJson() {
        try{
            Map<String, UsuarioInfo> usuariosMap = JsonService.getInstance().leerJsonUsuarios(RUTA_JSON, UsuarioInfo.class);
            usuarios = new HashMap<>(usuariosMap);
        }catch (Exception e) {
            System.out.println("Error al cargar usuarios desde el archivo JSON");
        }

    }
    private String obtenerContrasenaAlmacenada(String nombreUsuario) {
        cargarUsuariosDesdeJson();
        return usuarios.get(nombreUsuario).getContrasena();
    }

}
