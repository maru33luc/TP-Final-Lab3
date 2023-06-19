package com.example.tpfinallab3.services;

import com.example.tpfinallab3.models.Administrativo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AdministrativoService {
    private static AdministrativoService instance;
    private static final String RUTA_JSON = "src/main/resources/json/administrativos.json";
    private List<Administrativo> administrativos;

    private AdministrativoService() {
        administrativos = new ArrayList<>();
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
        List<Administrativo> listaAdministrativos = JsonService.getInstance().leerJson(RUTA_JSON, Administrativo.class);
        administrativos.addAll(listaAdministrativos);
    }

    public List<Administrativo> getAdministrativos() {
        return administrativos;
    }

    public void agregarAdministrativo(Administrativo administrativo) {
        administrativos.add(administrativo);
    }

    public void eliminarAdministrativoPorNombreUsuario(String nombreUsuario) {
        administrativos.removeIf(a -> a.getNombreUsuario().equalsIgnoreCase(nombreUsuario));
    }

    public Optional<Administrativo> buscarAdministrativoPorNombreUsuario(String nombreUsuario) {
        return administrativos.stream()
                .filter(a -> a.getNombreUsuario().equalsIgnoreCase(nombreUsuario))
                .findFirst();
    }
    public List<Administrativo> buscarAdministrativosPorPuesto(String puesto) {
        List<Administrativo> resultado = new ArrayList<>();
        for (Administrativo administrativo : administrativos) {
            if (administrativo.getPuesto().equalsIgnoreCase(puesto)) {
                resultado.add(administrativo);
            }
        }
        return resultado;
    }

   public void guardarAdministrativosJson() {
        JsonService.getInstance().guardarJson(administrativos, RUTA_JSON);
    }
}
