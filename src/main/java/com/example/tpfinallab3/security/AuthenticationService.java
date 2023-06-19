package com.example.tpfinallab3.security;
import org.mindrot.jbcrypt.BCrypt;

import java.util.HashMap;
import java.util.Map;

public class AuthenticationService {

    private static AuthenticationService instance;
    private static final String RUTA_JSON = "ruta/al/archivo.json";
    private Map<String, String> usuarios;

    private AuthenticationService() {
        usuarios = new HashMap<>();
        // Aquí puedes agregar usuarios de ejemplo con sus contraseñas
        usuarios.put("usuario1", "$2a$10$0fSNAM1CVFCTdScXG6Cq0u2.BkDG1SajY6gbKqQvIc.2GmDEtylxS"); // Contraseña: password1
        usuarios.put("usuario2", "$2a$10$Mpbhc6IByKmD0eIzR1bg4uAK5egbYe8aK7yrbXH1JyfaUqXwGG9L6"); // Contraseña: password2
        usuarios.put("juanperez", "12345678"); //
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
            String contrasenaAlmacenada = usuarios.get(nombreUsuario);

            return BCrypt.checkpw(contrasena, contrasenaAlmacenada);
        }
        return false;
    }

    private String obtenerContrasenaAlmacenada(String nombreUsuario) {
        // Implementa la lógica para obtener la contraseña almacenada del archivo JSON
        // Puedes utilizar la librería Jackson para leer el archivo JSON y extraer los datos necesarios

        // Retorna la contraseña almacenada para el usuario


        return "contraseñaAlmacenada";
    }

    public void guardarUsuario(String nombreUsuario, String contrasena) {
        // Cifrar la contraseña antes de guardarla en el archivo JSON
        String contrasenaCifrada = BCrypt.hashpw(contrasena, BCrypt.gensalt());

        // Guardar el nombre de usuario y la contraseña cifrada en el archivo JSON
       // guardarDatosEnJson(nombreUsuario, contrasenaCifrada);
        usuarios.put(nombreUsuario,contrasenaCifrada);
    }

    public void guardarDatosEnJson(String nombreUsuario, String contrasenaCifrada) {
        // Implementa la lógica para guardar los datos en el archivo JSON
        // Puedes utilizar la librería Jackson para escribir el archivo JSON


    }

}
