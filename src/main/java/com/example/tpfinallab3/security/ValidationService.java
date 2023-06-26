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

    //VALIDACION CREAR NUEVO USUARIO DESDE REGISTRO O DESDE ADMINISTRATIVO
    public void validarDatosNuevoUsuario(Usuario usuario) throws ValidationException {
        //mensaje en el que se van a acumular distintos errores en el ingreso de datos
        StringBuilder mensaje = new StringBuilder();
        //si existe registrado el nombre de usuario, si está vacío y si tiene números o caracteres especiales
        mensaje.append(validarUsuario(usuario.getNombreUsuario()));
        //si la contraseña está vacía y si es demasiado corta
        mensaje.append(validarContrasena(usuario.getContrasena()));
        //si el nombre está vacío y si tiene números
        mensaje.append(validarNombre(usuario.getNombre()));
        //si el apellido está vacío y si tiene números
        mensaje.append(validarApellido(usuario.getApellido()));
        //si el mail está vacío y si tiene formato válido
        mensaje.append(validarMail(usuario.getMail()));
        //en caso que el usuario sea paciente
        if (usuario instanceof Paciente) {
            Paciente paciente = (Paciente) usuario;
            //si el dni está vacío y si tiene caracteres que no sean números
            mensaje.append(validarDni(paciente.getDni()));
            //si teléfono tiene caracteres distintos de números
            mensaje.append(validarTelefono(paciente.getTelefono()));
        }
        //en caso que el usuario sea médico
        if (usuario instanceof Medico) {
            Medico medico = (Medico) usuario;
            //si no se seleccionó especialidad
            mensaje.append(validarEspecialidad(medico.getEspecialidad()));
        }
        //si el mensaje no está vacío es porque se detectó algún error en el ingreso de datos y se lanza excepción
        if (!mensaje.toString().isEmpty()) {
            throw new ValidationException (mensaje.toString());
        }
    }

    //VALIDACION EDITAR PERFIL PACIENTE
    public void validarDatosEditarPerfilPaciente(String nombre, String apellido, String mail, String telefono, String obraSocial, String numeroAfiliado, String contrasena) throws ValidationException {
        //mensaje en el que se van a acumular distintos errores en el ingreso de datos
        StringBuilder mensaje = new StringBuilder();
        //si el nombre está vacío y si tiene números
        mensaje.append(validarNombre(nombre));
        //si el apellido está vacío y si tiene números
        mensaje.append(validarApellido(apellido));
        //si el mail está vacío y si tiene formato válido
        mensaje.append(validarMail(mail));
        //si teléfono tiene caracteres distintos de números
        mensaje.append(validarTelefono(telefono));
        //si la contraseña está vacía y si es demasiado corta
        mensaje.append(validarContrasena(contrasena));
        //si el mensaje no está vacío es porque se detectó algún error en el ingreso de datos y se lanza excepción
        if (!mensaje.toString().isEmpty()) {
            throw new ValidationException (mensaje.toString());
        }
    }

    //VALIDACION EDITAR PERFIL ADMINISTRATIVO
    public void validarDatosEditarPerfilAdmin(String nombre, String apellido, String mail, String contrasena) throws ValidationException {
        //mensaje en el que se van a acumular distintos errores en el ingreso de datos
        StringBuilder mensaje = new StringBuilder();
        //si el nombre está vacío y si tiene números
        mensaje.append(validarNombre(nombre));
        //si el apellido está vacío y si tiene números
        mensaje.append(validarApellido(apellido));
        //si el mail está vacío y si tiene formato válido
        mensaje.append(validarMail(mail));
        //si la contraseña está vacía y si es demasiado corta
        mensaje.append(validarContrasena(contrasena));
        //si el mensaje no está vacío es porque se detectó algún error en el ingreso de datos y se lanza excepción
        if (!mensaje.toString().isEmpty()) {
            throw new ValidationException (mensaje.toString());
        }
    }

    //VALIDACIÓN EDITAR USUARIO DESDE ADMINISTRATIVO
    public void validarDatosEditarUsuario(String nombre, String apellido, String mail, String contrasena) throws ValidationException {
        //mensaje en el que se van a acumular distintos errores en el ingreso de datos
        StringBuilder mensaje = new StringBuilder();
        //si el nombre está vacío y si tiene números
        mensaje.append(validarNombre(nombre));
        //si el apellido está vacío y si tiene números
        mensaje.append(validarApellido(apellido));
        //si el mail está vacío y si tiene formato válido
        mensaje.append(validarMail(mail));
        //si la contraseña está vacía y si es demasiado corta
        mensaje.append(validarContrasena(contrasena));
        //si el mensaje no está vacío es porque se detectó algún error en el ingreso de datos y se lanza excepción
        if (!mensaje.toString().isEmpty()) {
            throw new ValidationException (mensaje.toString());
        }
    }
}
