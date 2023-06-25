package com.example.tpfinallab3.models;

import java.io.Serializable;
import java.util.Objects;

public abstract class Usuario implements Autenticable, Serializable {
    private String nombreUsuario;
    private String contrasena;
    private String nombre;
    private String apellido;
    private String mail;
    private Boolean isActivo;

    public Usuario() {
    }

    public Usuario(String nombreUsuario, String contrasena, String nombre, String apellido, String mail) {
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
        this.nombre = nombre;
        this.apellido = apellido;
        this.mail = mail;
        this.isActivo = true;
    }

    @Override
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Boolean getActivo() {
        return isActivo;
    }

    public void setActivo(Boolean activo) {
        isActivo = activo;
    }

    public abstract String getNombreEntidad();

    @Override
    public boolean equals(Object o) {
        if(this == o) {
            return true;
        }
        if(o == null) {
            return false;
        }
        if(!(o instanceof Usuario)) {
            return false;
        }
        Usuario usuario = (Usuario) o;
        return this.getNombreUsuario().equalsIgnoreCase(usuario.getNombreUsuario());
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombreUsuario);
    }

    @Override
    public String toString() {
        return "Nombre de usuario: " + nombreUsuario + "\n" +
                "Contraseña: " + contrasena + "\n" +
                "Nombre: " + nombre + "\n" +
                "Apellido: " + apellido + "\n" +
                "Correo electrónico: " + mail + "\n" +
                "Activo: " + isActivo + "\n";
    }

    public void cambiarEstado() {
        if(isActivo) {
            isActivo = false;
        }
        else{
            isActivo = true;
        }
    }

}
