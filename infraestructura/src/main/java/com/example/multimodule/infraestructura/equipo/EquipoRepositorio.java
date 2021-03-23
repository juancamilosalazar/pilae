package com.example.multimodule.infraestructura.equipo;

import com.example.multimodule.dto.Equipo;

import java.util.List;

public interface EquipoRepositorio {

    List<Equipo> obtenerTodos() throws Exception;
    Equipo obtenerEquipoPorId(Long id) throws Exception;
    Equipo crear(Equipo equipo);
    Equipo actualizar(Equipo equipo);
    void borrar(Equipo equipo);
}
