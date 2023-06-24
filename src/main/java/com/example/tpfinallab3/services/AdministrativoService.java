package com.example.tpfinallab3.services;

import com.example.tpfinallab3.models.Administrativo;

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

    public void eliminarAdministrativoPorNombreUsuario(String nombreUsuario) {
        administrativos.removeIf(a -> a.getNombreUsuario().equalsIgnoreCase(nombreUsuario));
    }

    public Optional<Administrativo> buscarAdministrativoPorNombreUsuario(String nombreUsuario) {
        return administrativos.stream()
                .filter(a -> a.getNombreUsuario().equalsIgnoreCase(nombreUsuario))
                .findFirst();
    }

    public void modificarAdministrativo(String usuario, String nombre, String apellido, String mail) {
        /*Iterator iterator = administrativos.iterator();
        while (iterator.hasNext()) {
            Administrativo administrativo = (Administrativo) iterator.next();
            if (administrativo.getNombreUsuario().equalsIgnoreCase(usuario)) {
                administrativo.setNombre(nombre);
                administrativo.setApellido(apellido);
                administrativo.setMail(mail);
                guardarAdministrativosJson();
            }
        }*/

        // buscar en la lista de administrativos y setear los datos
        administrativos.stream()
                .filter(a -> a.getNombreUsuario().equalsIgnoreCase(usuario))
                .findFirst()
                .ifPresent(a -> {
                    a.setNombre(nombre);
                    a.setApellido(apellido);
                    a.setMail(mail);
                    guardarAdministrativosJson();
                });
        System.out.println("Lista de administrativos dentro del service: " + administrativos);

    }

    public boolean existeAdministrativoPorNombreUsuario(String nombreUsuario) {
        return administrativos.stream()
                .anyMatch(a -> a.getNombreUsuario().equalsIgnoreCase(nombreUsuario));
    }

    /*public List<Administrativo> buscarAdministrativosPorPuesto(String puesto) {
>>>>>>> 79ac0773243faa9247ec7f90ca0cdd752dbfa074
        List<Administrativo> resultado = new ArrayList<>();
        for (Administrativo administrativo : administrativos) {
            if (administrativo.getPuesto().equalsIgnoreCase(puesto)) {
                resultado.add(administrativo);
            }
        }
        return resultado;
    }*/

   public void guardarAdministrativosJson() {
        JsonService.getInstance().guardarJson(administrativos, RUTA_JSON);
    }
}
