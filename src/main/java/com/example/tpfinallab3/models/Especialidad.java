package com.example.tpfinallab3.models;

import com.fasterxml.jackson.annotation.JsonProperty;


public enum Especialidad {
    @JsonProperty("Cardiología")
    CARDIOLOGIA("Cardiología"),
    @JsonProperty("Clínica")
    CLINICA("Clínica"),
    @JsonProperty("Ginecología")
    GINECOLOGIA("Ginecología"),
    @JsonProperty("Obstetricia")
    OBSTETRICIA("Obstetricia"),
    @JsonProperty("Pediatría")
    PEDIATRIA("Pediatría"),
    @JsonProperty("Traumatología")
    TRAUMATOLOGIA("Traumatología"),
    @JsonProperty("Urología")
    UROLOGIA("Urología");

    private String especialidad;

    Especialidad() {
    }

    Especialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getEspecialidad() {
        return especialidad;
    }



    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public boolean equalsIgnoreCase(String especialidad) {
        return this.especialidad.equalsIgnoreCase(especialidad);
    }
}
