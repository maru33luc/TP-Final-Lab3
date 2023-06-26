package com.example.tpfinallab3.security;

import com.example.tpfinallab3.models.UsuarioInfo;
import com.example.tpfinallab3.services.AdministrativoService;
import com.example.tpfinallab3.services.JsonService;
import com.example.tpfinallab3.services.MedicoService;
import com.example.tpfinallab3.services.PacienteService;
import org.mindrot.jbcrypt.BCrypt;

import java.util.HashMap;
import java.util.Map;

public class AuthenticationService {

    private static AuthenticationService instance;
    private static final String RUTA_JSON = "src/main/resources/json/usuariosYContraseñas.json";
    private Map<String, UsuarioInfo> usuarios;

    private AuthenticationService() {
        cargarUsuariosDesdeJson();
    }

    public Map<String, UsuarioInfo> getUsuarios() {
        return usuarios;
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
        if(this.usuarios!=null){
            if (usuarios.containsKey(nombreUsuario)) {
                String contrasenaAlmacenada = obtenerContrasenaAlmacenada(nombreUsuario);
                String contraseña2= BCrypt.hashpw(contrasena, BCrypt.gensalt());  ///-----------ESTO ES PARA VER SI ANDA EL HASH
                return BCrypt.checkpw(contrasena, contrasenaAlmacenada);
            }
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

    public boolean usuarioExiste(String nombreUsuario) {
        if(usuarios.containsKey(nombreUsuario)) {
            return true;
        }
        return false;
    }

    public void modificarContraseña(String nombreUsuario, String nuevaContraseña) {
        cargarUsuariosDesdeJson();
        if (usuarios.containsKey(nombreUsuario)) {
            String contraseñaHasheada = BCrypt.hashpw(nuevaContraseña, BCrypt.gensalt());
            UsuarioInfo usuarioInfo = usuarios.get(nombreUsuario);
            usuarioInfo.setContrasena(contraseñaHasheada);
            PacienteService.getInstance().modificarContraseñaEnPaciente(nombreUsuario, nuevaContraseña);
            MedicoService.getInstance().modificarContraseñaEnMedico(nombreUsuario, nuevaContraseña);
            AdministrativoService.getInstance().modificarContraseñaEnAdministrativo(nombreUsuario, nuevaContraseña);
            JsonService.getInstance().cambiarContraseñaJson(nombreUsuario, contraseñaHasheada, RUTA_JSON);
            System.out.println("Contraseña modificada correctamente");
        } else {
            System.out.println("El usuario no existe");
        }
    }

    public String getContraseñaEntidadLogueada(String nombreUsuario) {
        cargarUsuariosDesdeJson();
        /*UsuarioInfo usuarioInfo = usuarios.get(nombreUsuario);
        if (usuarioInfo != null) {
            return usuarioInfo.getContrasena();
        } else {
            // Manejar el caso cuando el usuario no existe
            throw new IllegalArgumentException("El usuario no existe");
        }*/
        //obtener la contraseña guardada del usuario logueado
        System.out.println("usuarios " + usuarios.toString());
        return usuarios.get(nombreUsuario).getContrasena();
    }

}
