package com.pilae.pilae.servicio;
import com.pilae.pilae.repositorio.postgres.Entity.EquipoEntity;
import com.pilae.pilae.servicio.dominio.Equipo;
import java.util.List;

public interface EquipoServicio {

    List<Equipo> obtenerEquipos() throws Exception;
    Equipo obtenerEquipoPorId(Long id);
    Equipo crearEquipo(Equipo equipo, Long torneoId);
    Equipo actualizarEquipo(Long id, Equipo equipoNuevo);
    Equipo borrarEquipo(Long id);
}
