package com.example.tpfinallab3.models;

import java.util.Objects;

public class Administrativo extends Usuario {
    private boolean admin;

    public Administrativo() {
    }

    public Administrativo(String nombreUsuario, String contrasena, String nombre, String apellido, String mail) {
        super(nombreUsuario, contrasena, nombre, apellido, mail);
        this.admin = false;
    }

    public Boolean getAdmin() {
        return admin;
    }

    @Override
    public String getContrasena() {
        return super.getContrasena();
    }

    @Override
    public void setContrasena(String contrasena) {
        super.setContrasena(contrasena);
    }

    @Override
    public String obtenerNombreEntidad() {
        return this.getClass().toString();
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) {
            return true;
        }
        if(o == null) {
            return false;
        }
        if(!(o instanceof Administrativo)) {
            return false;
        }
        Administrativo administrativo = (Administrativo) o;
        return this.getNombreUsuario().equalsIgnoreCase(administrativo.getNombreUsuario());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getNombreUsuario());
    }

    @Override
    public String toString() {
        return "ADMINISTRATIVO\n" +
                super.toString();
    }
}
