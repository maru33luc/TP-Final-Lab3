package com.example.tpfinallab3.models;

import java.util.*;

public class Paciente extends Usuario {
    private String dni;
    private String telefono;
    private String obraSocial;
    private String numeroAfiliado;

    public Paciente() {
    }

    public Paciente(String nombreUsuario, String contrasena, String nombre, String apellido, String mail, String dni, String telefono, String obraSocial, String numeroAfiliado) {
        super(nombreUsuario, contrasena, nombre, apellido, mail);
        this.dni = dni;
        this.telefono = telefono;
        this.obraSocial = obraSocial;
        this.numeroAfiliado = numeroAfiliado;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getObraSocial() {
        return obraSocial;
    }

    public void setObraSocial(String obraSocial) {
        this.obraSocial = obraSocial;
    }

    public String getNumeroAfiliado() {
        return numeroAfiliado;
    }

    public void setNumeroAfiliado(String numeroAfiliado) {
        this.numeroAfiliado = numeroAfiliado;
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
    public boolean equals(Object o) {
        if(this == o) {
            return true;
        }
        if(o == null) {
            return false;
        }
        if(!(o instanceof Paciente)) {
            return false;
        }
        Paciente paciente = (Paciente) o;
        return this.getNombreUsuario().equalsIgnoreCase(paciente.getNombreUsuario());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getNombreUsuario());
    }

    @Override
    public String toString() {
        return "PACIENTE\n" +
                super.toString() +
                "DNI: " + dni + "\n" +
                "Telefono: " + telefono + "\n" +
                "Obra Social: " + obraSocial + "\n" +
                "Numero de afiliado: " + numeroAfiliado;
    }


}
