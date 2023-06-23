package com.example.tpfinallab3.security;

import com.example.tpfinallab3.exceptions.ContrasenaException;
import com.example.tpfinallab3.exceptions.NombreUsuarioException;
import com.example.tpfinallab3.exceptions.ValidationException;
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

    public void validarDatosNuevoUsuario(Usuario usuario) throws NombreUsuarioException, ContrasenaException, ValidationException {

        //si existe registrado el nombre de usuario
        if(AuthenticationService.getInstance().usuarioExiste(usuario.getNombreUsuario())) {
            throw new NombreUsuarioException("Ya existe un usuario registrado con el mismo nombre");
        }

        //si el nombre de usuario tiene números o caracteres especiales
        if(!usuario.getNombreUsuario().matches("[a-zA-Z]*")) {
            throw new NombreUsuarioException("Nombre de usuario no puede contener números ni caracteres especiales");
        }

        //si la contraseña es demasiado corta
        if(usuario.getContrasena().length() >= 1 && usuario.getContrasena().length() < 6) {
            throw new ContrasenaException("Contraseña demasiado corta (mínimo 6 caracteres)");
        }

        //mensaje en el que se van a acumular distintos errores en el ingreso de datos
        StringBuilder mensaje = new StringBuilder();

        //si el nombre de usuario está vacío
        if(usuario.getNombreUsuario().isEmpty()) {
            mensaje.append("Nombre de usuario obligatorio\n");
        }

        //si la contraseña está vacía
        if(usuario.getContrasena().isEmpty()) {
            mensaje.append("Contraseña obligatoria\n");
        }

        //si el nombre está vacío y si tiene números
        if(usuario.getNombre().isEmpty()) {
            mensaje.append("Nombre obligatorio\n");
        }
        else if (usuario.getNombre().matches("[0-9]+")) {
            mensaje.append("Nombre no puede contener números ni caracteres especiales\n");
        }

        //si el apellido está vacío y si tiene números
        if(usuario.getApellido().isEmpty()) {
            mensaje.append("Apellido obligatorio\n");
        }
        else if (usuario.getApellido().matches("[0-9]+")) {
            mensaje.append("Apellido no puede contener números ni caracteres especiales\n");
        }

        //si el mail está vacío y si no tiene arroba y punto
        if(usuario.getMail().isEmpty()) {
            mensaje.append("Correo electrónico obligatorio\n");
        }
        else if(!usuario.getContrasena().contains("@") || !usuario.getContrasena().contains(".")) {
            mensaje.append("Correo electrónico inválido\n");
        }

        //en caso que el usuario sea paciente
        if(usuario instanceof Paciente) {
            Paciente paciente = (Paciente) usuario;

            //si el dni está vacío y si tiene caracteres que no sean números
            if(paciente.getDni().isEmpty()) {
                mensaje.append("Número de documento obligatorio\n");
            } else if (!paciente.getDni().matches("[0-9]+")) {
                mensaje.append("Número de documento inválido\n");
            }

            //si teléfono tiene caracteres distintos de números
            if(!paciente.getTelefono().isEmpty() && !paciente.getTelefono().matches("[0-9]+")) {
                mensaje.append("Teléfono inválido");
            }
        }

        //si el mensaje no está vacío es porque se detectó algún error en el ingreso de datos y se lanza excepción
        if(!mensaje.isEmpty()) {
            throw new ValidationException (mensaje.toString());
        }
    }
}

