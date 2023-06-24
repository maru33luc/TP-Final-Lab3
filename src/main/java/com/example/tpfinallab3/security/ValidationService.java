package com.example.tpfinallab3.security;

import com.example.tpfinallab3.exceptions.NombreUsuarioException;
import com.example.tpfinallab3.exceptions.ValidationException;
import com.example.tpfinallab3.models.Medico;
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

    public void validarDatosNuevoUsuario(Usuario usuario) throws NombreUsuarioException, ValidationException {

        //si existe registrado el nombre de usuario
        if (AuthenticationService.getInstance().usuarioExiste(usuario.getNombreUsuario())) {
            throw new NombreUsuarioException("Ya existe un usuario registrado con el mismo nombre");
        }

        //mensaje en el que se van a acumular distintos errores en el ingreso de datos
        StringBuilder mensaje = new StringBuilder();

        //si el nombre de usuario está vacío y si tiene números o caracteres especiales
        if (usuario.getNombreUsuario().isEmpty()) {
            mensaje.append("Usuario obligatorio\n");
        }
        else if (usuario.getNombreUsuario().matches("[^a-zA-Z]*")) {
            mensaje.append("Usuario no puede contener números ni caracteres especiales\n");
        }

        //si la contraseña está vacía y si es demasiado corta
        if (usuario.getContrasena().isEmpty()) {
            mensaje.append("Contraseña obligatoria\n");
        }
        else if (usuario.getContrasena().length() >= 1 && usuario.getContrasena().length() < 6) {
            mensaje.append("Contraseña demasiado corta (mínimo 6 caracteres)\n");
        }

        //si el nombre está vacío y si tiene números
        if (usuario.getNombre().isEmpty()) {
            mensaje.append("Nombre obligatorio\n");
        }
        else if (usuario.getNombre().matches("^\\d")) {
            mensaje.append("Nombre no puede contener números\n");
        }

        //si el apellido está vacío y si tiene números
        if (usuario.getApellido().isEmpty()) {
            mensaje.append("Apellido obligatorio\n");
        }
        else if (usuario.getApellido().matches("^\\d")) {
            mensaje.append("Apellido no puede contener números\n");
        }

        //si el mail está vacío y si tiene formato válido
        if (usuario.getMail().isEmpty()) {
            mensaje.append("Correo electrónico obligatorio\n");
        }
        else if (!usuario.getMail().matches("[\\w-]+(\\.[\\w-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")) {
            mensaje.append("Correo electrónico inválido\n");
        }

        //en caso que el usuario sea paciente
        if (usuario instanceof Paciente) {
            Paciente paciente = (Paciente) usuario;

            //si el dni está vacío y si tiene caracteres que no sean números
            if (paciente.getDni().isEmpty()) {
                mensaje.append("Número de documento obligatorio\n");
            }
            else if (!paciente.getDni().matches("\\d")) {
                mensaje.append("Número de documento inválido\n");
            }

            //si teléfono tiene caracteres distintos de números
            if (!paciente.getTelefono().isEmpty() && !paciente.getTelefono().matches("\\d")) {
                mensaje.append("Teléfono inválido");
            }
        }

        //en caso que el usuario sea médico
        if (usuario instanceof Medico) {
            Medico medico = (Medico) usuario;

            //si no se seleccionó especialidad
            if (medico.getEspecialidad() == null) {
                mensaje.append("Especialidad obligatoria\n");
            }
        }

        //si el mensaje no está vacío es porque se detectó algún error en el ingreso de datos y se lanza excepción
        if (!mensaje.toString().isEmpty()) {
            throw new ValidationException (mensaje.toString());
        }
    }

    public void validarDatosEditarPerfilAdmin(String nombre, String apellido, String mail) throws ValidationException {

        StringBuilder mensaje = new StringBuilder();

        //si el nombre está vacío y si tiene números
        if (nombre.isEmpty()) {
            mensaje.append("Nombre obligatorio\n");
        }
        else if (nombre.matches("^\\d")) {
            mensaje.append("Nombre no puede contener números\n");
        }

        //si el apellido está vacío y si tiene números
        if (apellido.isEmpty()) {
            mensaje.append("Apellido obligatorio\n");
        }
        else if (apellido.matches("^\\d")) {
            mensaje.append("Apellido no puede contener números\n");
        }

        //si el mail está vacío y si tiene formato válido
        if (mail.isEmpty()) {
            mensaje.append("Correo electrónico obligatorio\n");
        }
        else if (!mail.matches("[\\w-]+(\\.[\\w-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")) {
            mensaje.append("Correo electrónico inválido\n");
        }

        //si el mensaje no está vacío es porque se detectó algún error en el ingreso de datos y se lanza excepción
        if (!mensaje.toString().isEmpty()) {
            throw new ValidationException (mensaje.toString());
        }
    }
}
