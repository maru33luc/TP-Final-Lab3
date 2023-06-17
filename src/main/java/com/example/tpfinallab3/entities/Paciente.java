package com.example.tpfinallab3.entities;

import java.time.LocalDate;
import java.util.*;

public class Paciente extends Usuario {

    private String tipoDocumento;
    private String numeroDocumento;
    private String telefono;
    private String obraSocial;
    private String numeroAfiliado;

    private Map<LocalDate, Turno> turnos;

    public Paciente() {
    }

    public Paciente(String nombreUsuario, String contrasena, String nombre, String apellido, String mail, String tipoDocumento, String numeroDocumento, String telefono, String obraSocial, String numeroAfiliado) {
        super(nombreUsuario, contrasena, nombre, apellido, mail);
        this.tipoDocumento = tipoDocumento;
        this.numeroDocumento = numeroDocumento;
        this.telefono = telefono;
        this.obraSocial = obraSocial;
        this.numeroAfiliado = numeroAfiliado;
        this.turnos = new HashMap<>();
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
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

    public Map<LocalDate, Turno> getTurnos() {
        return turnos;
    }

    public void setTurnos(Map<LocalDate, Turno> turnos) {
        this.turnos = turnos;
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
                "Tipo y numero de documento: " + tipoDocumento + " " + numeroDocumento + "\n" +
                "Telefono: " + telefono + "\n" +
                "Obra Social: " + obraSocial + "\n" +
                "Numero de afiliado: " + numeroAfiliado;
    }

    @Override
    public void cargar() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese nombre de usuario: ");
        setNombreUsuario(scanner.nextLine());
        System.out.println("Ingrese contraseña: ");
        setContrasena(scanner.nextLine());
        System.out.println("Ingrese nombre: ");
        setNombre(scanner.nextLine());
        System.out.println("Ingrese apellido: ");
        setApellido(scanner.nextLine());
        System.out.println("Ingrese tipo de documento: ");
        setTipoDocumento(scanner.nextLine());
        System.out.println("Ingrese número de documento: ");
        setNumeroDocumento(scanner.nextLine());
        System.out.println("Ingrese teléfono: ");
        setTelefono(scanner.nextLine());
        System.out.println("Ingrese obra social: ");
        setObraSocial(scanner.nextLine());
        System.out.println("Ingrese número de afiliado: ");
        setNumeroAfiliado(scanner.nextLine());
    }
}
