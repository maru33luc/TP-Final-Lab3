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
        /*usuarios = new HashMap<>();
        // Aquí puedes agregar usuarios de ejemplo con sus contraseñas
        usuarios.put("usuario1", "$2a$10$0fSNAM1CVFCTdScXG6Cq0u2.BkDG1SajY6gbKqQvIc.2GmDEtylxS"); // Contraseña: password1
        usuarios.put("usuario2", "$2a$10$Mpbhc6IByKmD0eIzR1bg4uAK5egbYe8aK7yrbXH1JyfaUqXwGG9L6"); // Contraseña: password2
        usuarios.put("juanperez", "12345678"); //*/
        cargarUsuariosDesdeJson(RUTA_JSON);
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
        if (usuarios.containsKey(nombreUsuario)) {
            //String contrasenaAlmacenada = usuarios.get(nombreUsuario);
            String contrasenaAlmacenada = obtenerContrasenaAlmacenada(nombreUsuario);
            return BCrypt.checkpw(contrasena, contrasenaAlmacenada);
        }
        return false;
    }

    private void cargarUsuariosDesdeJson() {
        List<UsuarioInfo> listaUsuarios = JsonService.getInstance().leerJson(RUTA_JSON, UsuarioInfo.class);
        usuarios = new HashMap<>();
        for (UsuarioInfo usuario : listaUsuarios) {
            usuarios.put(usuario.getUsuario(), usuario);
        }
    }

    private String obtenerContrasenaAlmacenada(String nombreUsuario) {
        // Implementa la lógica para obtener la contraseña almacenada del archivo JSON
        // Puedes utilizar la librería Jackson para leer el archivo JSON y extraer los datos necesarios

        // Retorna la contraseña almacenada para el usuario


        return "contraseñaAlmacenada";
    }

    /*public void guardarUsuarios(Map<String, UsuarioInfo> mapaUsuarios) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(new File(RUTA_JSON), mapaUsuarios.values());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/

    public void guardarDatosEnJson(String nombreUsuario, String contrasenaCifrada) {
        // Implementa la lógica para guardar los datos en el archivo JSON
        // Puedes utilizar la librería Jackson para escribir el archivo JSON


    }

}
