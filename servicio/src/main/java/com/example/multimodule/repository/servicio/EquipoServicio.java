package com.example.multimodule.repository.servicio;

import com.example.multimodule.dto.Equipo;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@SpringBootApplication(scanBasePackages = "com.example.multimodule")
public interface EquipoServicio {

    List<Equipo> obtenerTodos() throws Exception;
    Equipo obtenerPorId(Long id) throws Exception;
    Equipo crear(Equipo equipo, Long torneoId) throws Exception;
    Equipo actualizar(Long id, Equipo equipoNuevo) throws Exception;
    Equipo borrar(Long id) throws Exception;
}
