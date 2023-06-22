package com.example.tpfinallab3.security;

import com.example.tpfinallab3.exceptions.CampoObligatorioException;
import com.example.tpfinallab3.exceptions.ContrasenaException;
import com.example.tpfinallab3.exceptions.NombreUsuarioException;
import com.example.tpfinallab3.models.Paciente;
import com.example.tpfinallab3.models.Usuario;

public class ValidationService {
    private static ValidationService instance;

    private ValidationService() {
    }

    public static ValidationService getInstance() {
        if (instance == null) {
            synchronized (ValidationService.class) {
                if (instance == null) {
                    instance = new ValidationService();
                }
            }
        }
        return instance;
    }

    public void validarDatosNuevoUsuario(Usuario usuario) throws NombreUsuarioException, ContrasenaException, CampoObligatorioException {
        if(AuthenticationService.getInstance().usuarioExiste(usuario.getNombreUsuario())) {
            throw new NombreUsuarioException("Ya existe un usuario registrado con el mismo nombre");
        }
        if(!usuario.getNombreUsuario().matches("[a-zA-Z]*")) {
            throw new NombreUsuarioException("El nombre de usuario no puede contener caracteres especiales ni números");
        }
        if(usuario.getContrasena().length() >= 1 && usuario.getContrasena().length() < 6) {
            throw new ContrasenaException("La contraseña es demasiado corta (mínimo 6 caracteres)");
        }
        StringBuilder mensaje = new StringBuilder("Debe completar todos los campos obligatorios:\n");
        if(usuario.getNombreUsuario().isEmpty()) {
            mensaje.append("Nombre de usuario\n");
        }
        if(usuario.getContrasena().isEmpty()) {
            mensaje.append("Contraseña\n");
        }
        if(usuario.getNombre().isEmpty()) {
            mensaje.append("Nombre\n");
        }
        if(usuario.getApellido().isEmpty()) {
            mensaje.append("Apellido\n");
        }
        if(usuario.getMail().isEmpty()) {
            mensaje.append("Correo electrónico\n");
        }
        if(usuario instanceof Paciente) {
            Paciente paciente = (Paciente) usuario;
            if(paciente.getDni().isEmpty()) {
                mensaje.append("Número de documento\n");
            }
        }
        if(!mensaje.isEmpty()) {
            throw new CampoObligatorioException(mensaje.toString());
        }
    }
}

