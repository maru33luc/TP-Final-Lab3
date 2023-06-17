package com.example.tpfinallab3.entities;

import java.util.Objects;
import java.util.Scanner;

public class Administrativo extends Usuario {
    private String puesto;
    private Boolean isAdmin;

    public Administrativo() {
    }
    public Administrativo(String nombreUsuario, String contrasena, String nombre, String apellido, String mail, String puesto) {
        super(nombreUsuario, contrasena, nombre, apellido, mail);
        this.puesto = puesto;
        this.isAdmin = false;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public Boolean getAdmin() {
        return isAdmin;
    }

    public void setAdmin(Boolean admin) {
        isAdmin = admin;
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
                super.toString() +
                "Puesto: " + puesto + "\n" +
                "Permisos de administrador: " + (isAdmin? "si" : "no");
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
        System.out.println("Ingrese puesto: ");
        setPuesto(scanner.nextLine());
        setAdmin(false);
    }
}
