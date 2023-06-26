package com.example.tpfinallab3.services;

import com.example.tpfinallab3.models.Administrativo;
import com.example.tpfinallab3.security.AuthorizationService;
import com.example.tpfinallab3.security.SessionManager;

import java.util.*;

public class AdministrativoService {
    private static AdministrativoService instance;
    private static final String RUTA_JSON = "src/main/resources/json/administrativos.json";
    private Set<Administrativo> administrativos;

    private AdministrativoService() {
        administrativos = new HashSet<>();
    }

    public static AdministrativoService getInstance() {
        if (instance == null) {
            synchronized (AdministrativoService.class) {
                if (instance == null) {
                    instance = new AdministrativoService();
                    instance.setAdministrativos();
                }
            }
        }
        return instance;
    }

    public void setAdministrativos() {
        Set<Administrativo> listaAdministrativos = JsonService.getInstance().leerJson(RUTA_JSON, Administrativo.class);
        if (listaAdministrativos != null)
            administrativos.addAll(listaAdministrativos);
    }

    public Set<Administrativo> getAdministrativos() {
        return administrativos;
    }

    public void agregarAdministrativo(Administrativo administrativo) {
        administrativos.add(administrativo);
        guardarAdministrativosJson();
    }

    public void modificarAdministrativo(String usuario, String nombre, String apellido, String mail) {
        administrativos.stream()
                .filter(a -> a.getNombreUsuario().equalsIgnoreCase(usuario))
                .findFirst()
                .ifPresent(a -> {
                    a.setNombre(nombre);
                    a.setApellido(apellido);
                    a.setMail(mail);
                });
        guardarAdministrativosJson();
    }

    public void eliminarAdministrativoPorNombreUsuario(String nombreUsuario) {
        administrativos.removeIf(a -> a.getNombreUsuario().equalsIgnoreCase(nombreUsuario));
    }

    public Optional<Administrativo> buscarAdministrativoPorNombreUsuario(String nombreUsuario) {
        return administrativos.stream()
                .filter(a -> a.getNombreUsuario().equalsIgnoreCase(nombreUsuario))
                .findFirst();
    }

    public boolean existeAdministrativoPorNombreUsuario(String nombreUsuario) {
        return administrativos.stream()
                .anyMatch(a -> a.getNombreUsuario().equalsIgnoreCase(nombreUsuario));
    }


    public void darDeBajaAdministrativo(Administrativo administrativo) {
        if (AuthorizationService.getInstance().verificarPermiso(SessionManager.getInstance().getTipoEntidad(), "darDeBajaAdministrativo")) {
            buscarAdministrativoPorNombreUsuario(administrativo.getNombreUsuario())
                    .ifPresentOrElse(
                            administrativoEncontrado -> {
                                administrativoEncontrado.setActivo(false);
                                System.out.println("Administrativo dado de baja correctamente");
                                guardarAdministrativosJson();
                            },
                            () -> System.out.println("No se encontró el administrativo")
                    );
        } else {
            System.out.println("No tiene permisos para dar de baja un administrativo");
        }
    }

    public void darDeAltaAdministrativo(Administrativo administrativo) {
        if (AuthorizationService.getInstance().verificarPermiso(SessionManager.getInstance().getTipoEntidad(), "darDeAltaAdministrativo")) {
            buscarAdministrativoPorNombreUsuario(administrativo.getNombreUsuario())
                    .ifPresentOrElse(
                            administrativoEncontrado -> {
                                administrativoEncontrado.setActivo(true);
                                System.out.println("Administrativo dado de alta correctamente");
                                guardarAdministrativosJson();
                            },
                            () -> System.out.println("No se encontró el administrativo")
                    );
        } else {
            System.out.println("No tiene permisos para dar de alta un administrativo");
        }
    }

    // buscar administrativo por nombre y apellido
   public Administrativo buscarAdministrativoPorNombreYApellido(String nombre, String apellido) {
        Administrativo administrativoEncontrado = null;
        for (Administrativo administrativo : administrativos) {
            if (administrativo.getNombre().equalsIgnoreCase(nombre) && administrativo.getApellido().equalsIgnoreCase(apellido)) {
                administrativoEncontrado = administrativo;
            }
        }
        return administrativoEncontrado;
    }

    public void guardarAdministrativosJson() {
        JsonService.getInstance().guardarJson(administrativos, RUTA_JSON);
    }

    public void modificarContraseñaEnAdministrativo(String nombreUsuario, String nuevaContraseña) {
        buscarAdministrativoPorNombreUsuario(nombreUsuario)
                .ifPresentOrElse(
                        administrativoEncontrado -> {
                            administrativoEncontrado.setContrasena(nuevaContraseña);
                            System.out.println("Contraseña modificada correctamente");
                            guardarAdministrativosJson();
                        },
                        () -> System.out.println("No se encontró el administrativo")
                );
    }
}
