package com.example.tpfinallab3.models;

public class UsuarioInfo {
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
}
