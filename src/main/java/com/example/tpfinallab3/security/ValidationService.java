package com.example.tpfinallab3.security;

import com.example.tpfinallab3.exceptions.EdadException;
import com.example.tpfinallab3.exceptions.NombreException;
import com.example.tpfinallab3.exceptions.TelefonoException;

public class ValidationService {

    public void validarNombres(String nombre) throws NombreException {

        boolean contieneNumeros = nombre.matches(".*\\d.*");

        if (nombre == null || nombre.trim().isEmpty()  ||  contieneNumeros ) {
            throw new NombreException("El nombre no puede ser nulo, vacio o tener numeros");
        }
    }

    public void validarEdad(Integer edad) throws EdadException {
        if (edad == null || edad <= 0 || edad.toString().matches(".*\\D.*")) {
            throw new EdadException("La edad no puede tener letras ni ser nula, ingresar solo numeros positivos");
        }
    }

    public void validarTelefono(String telefono) throws TelefonoException {
        if (telefono == null || telefono.trim().isEmpty() || !telefono.matches("\\d+")) {
            throw new TelefonoException("El telefono no puede ser nulo, vacio, tener letras o tener mas de 10 digitos");
        }
    }

    public void validarNombreUsuario(String nombreUsuario) throws NombreException {

        // El nombre de usuario puede tener letras y numeros, no puede tener arrobas o espacios o caracteres especiales salvo guion bajo o guion medio
        boolean contieneArroba = nombreUsuario.matches(".*@.*");
        boolean contieneEspacio = nombreUsuario.matches(".*\\s.*");
        boolean contieneCaracteresEspeciales = nombreUsuario.matches(".*[^a-zA-Z0-9_-].*");

        if (nombreUsuario == null || nombreUsuario.trim().isEmpty() || contieneArroba || contieneEspacio || contieneCaracteresEspeciales) {
            throw new NombreException("El nombre de usuario no puede ser nulo, vacio, tener arrobas, espacios o caracteres especiales");
        }
    }

    public void validarMail (String mail) throws NombreException {
        boolean contieneArroba = mail.matches(".*@.*");
        boolean contieneEspacio = mail.matches(".*\\s.*");
        boolean contieneCaracteresEspeciales = mail.matches(".*[^a-zA-Z0-9_-].*");

        if (mail == null || mail.trim().isEmpty() || contieneEspacio || contieneCaracteresEspeciales || !contieneArroba) {
            throw new NombreException("El mail no puede ser nulo, vacio, tener espacios o caracteres especiales");
        }
    }

    // valida que la contraseña no sea vacia, con espacios, con menos de 8 caracteres y que tenga al menos una mayuscula, una minuscula y un numero y sin caracteres especiales salvo guion bajo o guion medio
    public void validarPassword (String password) throws NombreException {
        boolean contieneEspacio = password.matches(".*\\s.*");
        boolean contieneCaracteresEspeciales = password.matches(".*[^a-zA-Z0-9_-].*");
        boolean contieneMayuscula = password.matches(".*[A-Z].*");
        boolean contieneMinuscula = password.matches(".*[a-z].*");
        boolean contieneNumero = password.matches(".*\\d.*");

        if (password == null || password.trim().isEmpty() || contieneEspacio || contieneCaracteresEspeciales || !contieneMayuscula || !contieneMinuscula || !contieneNumero) {
            throw new NombreException("La contraseña no puede ser nula, vacia, tener espacios, menos de 8 caracteres, sin mayusculas, minusculas o numeros o caracteres especiales");
        }
    }




}
