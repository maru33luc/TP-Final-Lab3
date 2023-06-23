package com.example.tpfinallab3.models;

import java.util.Objects;

public class Medico extends Usuario {
    private Especialidad especialidad;

    public Medico() {
    }

    public Medico(String nombreUsuario, String contrasena, String nombre, String apellido, String mail, Especialidad especialidad) {
        super(nombreUsuario, contrasena, nombre, apellido, mail);
        this.especialidad = especialidad;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad;
    }



    @Override
    public String getNombre() {
        return super.getNombre();
    }

    @Override
    public String getApellido() {
        return super.getApellido();
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
        if(!(o instanceof Medico)) {
            return false;
        }
        Medico medico = (Medico) o;
        return this.getNombreUsuario().equalsIgnoreCase(medico.getNombreUsuario());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getNombreUsuario());
    }

    @Override
    public String toString() {
        return "MEDICO\n" +
                super.toString() +
                "Especialidad: " + especialidad.getEspecialidad();
    }

}
