package com.example.multimodule.repository.servicio.negocio;

import com.example.multimodule.dominio.EquipoDominio;
import com.example.multimodule.dto.Equipo;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@SpringBootApplication(scanBasePackages = "com.example.multimodule")
public interface EquipoServicio {

    List<EquipoDominio> obtenerTodos() ;
    EquipoDominio obtenerPorId(Long id) ;
    void crear(EquipoDominio equipo, Long torneoId) ;
    void actualizar( EquipoDominio equipoNuevo);
    void borrar(Long id);
}
