package servicio.repositorio;

import servicio.dominio.Equipo;

import java.util.List;

public interface EquipoRepositorio {
    List<Equipo> obtenerTodos() throws Exception;
    Equipo obtenerEquipoPorId(Long id);
    Equipo crear(Equipo equipo);
    Equipo actualizar(Equipo equipo);
    void borrar(Equipo equipo);
}
