package com.example.tpfinallab3.models;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class TablaUsuario {

    private final StringProperty usuario;

    private final StringProperty nombre;
    private final StringProperty apellido;

    private final StringProperty entidad;

    public TablaUsuario(String nombreUsuario, String nombre, String apellido, String entidad) {
        this.usuario = new SimpleStringProperty(nombreUsuario);
        this.nombre = new SimpleStringProperty(nombre);
        this.apellido = new SimpleStringProperty(apellido);
        this.entidad = new SimpleStringProperty(entidad);
    }

    public String getUsuario() {
        return usuario.get();
    }

    public StringProperty usuarioProperty() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario.set(usuario);
    }

    public String getEntidad() {
        return entidad.get();
    }

    public StringProperty entidadProperty() {
        return entidad;
    }

    public String getNombre() {
        return nombre.get();
    }

    public StringProperty nombreProperty() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre.set(nombre);
    }

    public void setEntidad(String entidad) {
        this.entidad.set(entidad);
    }

    public String getApellido() {
        return apellido.get();
    }

    public StringProperty apellidoProperty() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido.set(apellido);
    }
}
