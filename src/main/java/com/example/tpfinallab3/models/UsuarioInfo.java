package com.example.tpfinallab3.models;

import java.io.Serializable;

public class UsuarioInfo implements Serializable {
    private String usuario;
    private String contrasena;
    private String claseEntidad;
    
    public UsuarioInfo(String usuario, String contrasena, String claseEntidad) {
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.claseEntidad = claseEntidad;
    }

    public UsuarioInfo() {
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getClaseEntidad() {
        return claseEntidad;
    }

    public void setClaseEntidad(String claseEntidad) {
        this.claseEntidad = claseEntidad;
    }

    @Override
    public String toString() {
        return "USUARIOINFO" + "\n" +
                "Usuario: " + usuario + "\n" +
                "Contraseña: " + contrasena + "\n" +
                "Clase: " + claseEntidad;
    }
}
