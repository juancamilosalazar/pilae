package servicio.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import servicio.EquipoServicio;
import servicio.dominio.Equipo;
import servicio.dominio.Torneo;
import servicio.repositorio.EquipoRepositorio;
import servicio.repositorio.TorneoRepositorio;

import java.util.List;


@Service
public class EquipoServicioImpl implements EquipoServicio {

    private EquipoRepositorio equipoRepositorio;
    private TorneoRepositorio torneoRepositorio;


    @Autowired
    public EquipoServicioImpl(EquipoRepositorio equipoRepositorio) {
        this.equipoRepositorio = equipoRepositorio;
    }

    @Override
    public List<Equipo> obtenerTodos() throws Exception {
        return equipoRepositorio.obtenerTodos();
    }

    @Override
    public Equipo obtenerPorId(Long id) {
        return equipoRepositorio.obtenerEquipoPorId(id);
    }

    @Override
    public Equipo crear(Equipo equipo, Long torneoId) {
        ObtenerTorneoDelPartido(torneoId,equipo);
        return equipoRepositorio.crear(equipo);
    }

    @Override
    public Equipo actualizar(Long id, Equipo equipoNuevo) {
        final Equipo equipo = equipoRepositorio.obtenerEquipoPorId(id);
        cambiarValores(equipoNuevo,equipo);
        return equipoRepositorio.actualizar(equipo);
    }

    @Override
    public Equipo borrar(Long id) {
        final Equipo equipo = equipoRepositorio.obtenerEquipoPorId(id);
        equipoRepositorio.borrar(equipo);
        return equipo;
    }

    private void cambiarValores(Equipo equipoNuevo, Equipo equipo) {
        equipo.setGenero(equipoNuevo.getGenero());
        equipo.setLocacion(equipoNuevo.getLocacion());
        equipo.setNombre(equipoNuevo.getNombre());
    }

    private void ObtenerTorneoDelPartido(Long torneoId, Equipo equipo) {
        Torneo torneo =torneoRepositorio.obtenerTroneoPorId(torneoId);
        equipo.setTorneo(torneo);
    }

}
