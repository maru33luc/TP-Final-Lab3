package com.example.tpfinallab3.services;

import com.example.tpfinallab3.models.Administrativo;
import com.example.tpfinallab3.models.Medico;
import com.example.tpfinallab3.models.Paciente;
import com.example.tpfinallab3.models.UsuarioInfo;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JsonService {
    private static JsonService instance;

    private ObjectMapper objectMapper;

    private JsonService() {
        objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
    }

    public static JsonService getInstance() {
        if (instance == null) {
            synchronized (JsonService.class) {
                if (instance == null) {
                    instance = new JsonService();
                }
            }
        }
        return instance;
    }

    public <T> void guardarJson(List<T> lista, String ruta) {
        try {
            objectMapper.writeValue(new File(ruta), lista);
            System.out.println("Json guardado");
            guardarJsonUsuariosYContraseñas(lista, ruta);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public <T> List<T> leerJson(String ruta, Class<T> clase) {
        JavaType javaType = objectMapper.getTypeFactory().constructCollectionType(List.class, clase);
        try {
            return objectMapper.readValue(new File(ruta), javaType);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public <T> void guardarJsonUsuariosYContraseñas(List<T> lista, String ruta) {
        Map<String, UsuarioInfo> usuarioInfoMap = new HashMap<>();

        for (T elemento : lista) {
            if (elemento instanceof Paciente) {
                Paciente paciente = (Paciente) elemento;
                String usuario = paciente.getNombreUsuario();
                String contrasena = paciente.getContrasena();
                String claseEntidad = paciente.getClass().getSimpleName();

                UsuarioInfo usuarioInfo = new UsuarioInfo(usuario, contrasena, claseEntidad);
                usuarioInfoMap.put(usuario, usuarioInfo);
            } else if (elemento instanceof Medico) {
                Medico medico = (Medico) elemento;
                String usuario = medico.getNombreUsuario();
                String contrasena = medico.getContrasena();
                String claseEntidad = medico.getClass().getSimpleName();
            } else if (elemento instanceof Administrativo) {
                Administrativo administrativo = (Administrativo) elemento;
                String usuario = administrativo.getNombreUsuario();
                String contrasena = administrativo.getContrasena();
                String claseEntidad = administrativo.getClass().getSimpleName();
            }
        }

        try {
            objectMapper.writeValue(new File(ruta), usuarioInfoMap);
            System.out.println("Json guardado");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


