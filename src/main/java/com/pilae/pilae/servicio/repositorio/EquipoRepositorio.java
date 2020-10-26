package com.pilae.pilae.servicio.repositorio;

import com.pilae.pilae.servicio.dominio.Equipo;

import java.util.List;

public interface EquipoRepositorio {
    List<Equipo> obtenerEquipos() throws Exception;
    Equipo obtenerEquipoPorId(Long id);
    Equipo crearEquipo(Equipo equipo);
    Equipo actualizarEquipo(Equipo equipo);
    void borrarEquipo(Equipo equipo);
}
