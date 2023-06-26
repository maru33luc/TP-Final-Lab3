package com.example.tpfinallab3.security;

import com.example.tpfinallab3.exceptions.ValidationException;
import com.example.tpfinallab3.models.Especialidad;
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

//VALIDACIONES PARTICULARES//////////////////////////////////////////////////////////////////////////////////

    private String validarUsuario(String usuario) {
        StringBuilder mensaje = new StringBuilder();
        if (usuario.isEmpty()) {
            mensaje.append("Usuario obligatorio\n");
        }
        else if (!usuario.matches("[a-zA-Z]*")) {
            mensaje.append("Usuario no puede contener números ni caracteres especiales\n");
        }
        else if (AuthenticationService.getInstance().usuarioExiste(usuario)) {
            mensaje.append("Ya existe un usuario registrado con el mismo nombre\n");
        }
        return mensaje.toString();
    }

    private String validarContrasena(String contrasena) {
        StringBuilder mensaje = new StringBuilder();
        if (contrasena.isEmpty()) {
            mensaje.append("Contraseña obligatoria\n");
        }
        else if (contrasena.length() >= 1 && contrasena.length() < 6) {
            mensaje.append("Contraseña demasiado corta (mínimo 6 caracteres)\n");
        }
        return mensaje.toString();
    }

    private String validarNombre(String nombre) {
        StringBuilder mensaje = new StringBuilder();
        if (nombre.isEmpty()) {
            mensaje.append("Nombre obligatorio\n");
        }
        else if (nombre.matches("^\\d")) {
            mensaje.append("Nombre no puede contener números\n");
        }
        return mensaje.toString();
    }

    private String validarApellido(String apellido) {
        StringBuilder mensaje = new StringBuilder();
        if (apellido.isEmpty()) {
            mensaje.append("Apellido obligatorio\n");
        }
        else if (apellido.matches("^\\d")) {
            mensaje.append("Apellido no puede contener números\n");
        }
        return mensaje.toString();
    }

    private String validarMail(String mail) {
        StringBuilder mensaje = new StringBuilder();
        if (mail.isEmpty()) {
            mensaje.append("Correo electrónico obligatorio\n");
        }
        else if (!mail.matches("[\\w-]+(\\.[\\w-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")) {
            mensaje.append("Correo electrónico inválido\n");
        }
        return mensaje.toString();
    }

    private String validarDni(String dni) {
        StringBuilder mensaje = new StringBuilder();
        if (dni.isEmpty()) {
            mensaje.append("Número de documento obligatorio\n");
        }
        else if (!dni.matches("\\d+")) {
            mensaje.append("Número de documento inválido\n");
        }

        return mensaje.toString();
    }

    private String validarTelefono(String telefono) {
        StringBuilder mensaje = new StringBuilder();
        if (!telefono.isEmpty() && !telefono.matches("\\d+")) {
            mensaje.append("Teléfono inválido\n");
        }
        return mensaje.toString();
    }

    private String validarEspecialidad(Especialidad especialidad) {
        StringBuilder mensaje = new StringBuilder();
        if (especialidad == null) {
            mensaje.append("Especialidad obligatoria\n");
        }
        return mensaje.toString();
    }

//VALIDACIONES GENERALES//////////////////////////////////////////////////////////////////////////////////

    //VALIDACION NUEVO USUARIO
    public void validarDatosNuevoUsuario(Usuario usuario) throws ValidationException {
        StringBuilder mensaje = new StringBuilder();
        mensaje.append(validarUsuario(usuario.getNombreUsuario()));
        mensaje.append(validarContrasena(usuario.getContrasena()));
        mensaje.append(validarNombre(usuario.getNombre()));
        mensaje.append(validarApellido(usuario.getApellido()));
        mensaje.append(validarMail(usuario.getMail()));
        if (usuario instanceof Paciente) {
            Paciente paciente = (Paciente) usuario;
            mensaje.append(validarDni(paciente.getDni()));
            mensaje.append(validarTelefono(paciente.getTelefono()));
        }
        if (usuario instanceof Medico) {
            Medico medico = (Medico) usuario;
            mensaje.append(validarEspecialidad(medico.getEspecialidad()));
        }
        if (!mensaje.toString().isEmpty()) {
            throw new ValidationException (mensaje.toString());
        }
    }

    //VALIDACION EDITAR PERFIL PACIENTE
    public void validarDatosEditarPerfilPaciente(String nombre, String apellido, String mail, String telefono, String obraSocial, String numeroAfiliado, String contrasena) throws ValidationException {
        StringBuilder mensaje = new StringBuilder();
        mensaje.append(validarNombre(nombre));
        mensaje.append(validarApellido(apellido));
        mensaje.append(validarMail(mail));
        mensaje.append(validarTelefono(telefono));
        mensaje.append(validarContrasena(contrasena));
        if (!mensaje.toString().isEmpty()) {
            throw new ValidationException (mensaje.toString());
        }
    }

    //VALIDACION EDITAR PERFIL ADMINISTRATIVO
    public void validarDatosEditarPerfilAdmin(String nombre, String apellido, String mail, String contrasena) throws ValidationException {
        StringBuilder mensaje = new StringBuilder();
        mensaje.append(validarNombre(nombre));
        mensaje.append(validarApellido(apellido));
        mensaje.append(validarMail(mail));
        mensaje.append(validarContrasena(contrasena));
        if (!mensaje.toString().isEmpty()) {
            throw new ValidationException (mensaje.toString());
        }
    }

    //VALIDACIÓN EDITAR MEDICO
    public void validarDatosEditarMedico(String nombre, String apellido, String mail, String contrasena, Especialidad especialidad) throws ValidationException {
        StringBuilder mensaje = new StringBuilder();
        mensaje.append(validarNombre(nombre));
        mensaje.append(validarApellido(apellido));
        mensaje.append(validarMail(mail));
        mensaje.append(validarContrasena(contrasena));
        mensaje.append(validarEspecialidad(especialidad));
        if (!mensaje.toString().isEmpty()) {
            throw new ValidationException (mensaje.toString());
        }
    }

    //VALIDACIÓN EDITAR ADMINISTRATIVO
    public void validarDatosEditarAdministrativo(String nombre, String apellido, String mail, String contrasena) throws ValidationException {
        StringBuilder mensaje = new StringBuilder();
        mensaje.append(validarNombre(nombre));
        mensaje.append(validarApellido(apellido));
        mensaje.append(validarMail(mail));
        mensaje.append(validarContrasena(contrasena));
        if (!mensaje.toString().isEmpty()) {
            throw new ValidationException (mensaje.toString());
        }
    }
}
