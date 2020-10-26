package com.pilae.pilae.servicio.impl;

import com.pilae.pilae.repositorio.postgres.Entity.EquipoEntity;
import com.pilae.pilae.servicio.dominio.Equipo;
import com.pilae.pilae.servicio.EquipoServicio;
import com.pilae.pilae.servicio.dominio.Torneo;
import com.pilae.pilae.servicio.repositorio.EquipoRepositorio;
import com.pilae.pilae.servicio.repositorio.TorneoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public List<Equipo> obtenerEquipos() throws Exception {
        return equipoRepositorio.obtenerEquipos();
    }

    @Override
    public Equipo obtenerEquipoPorId(Long id) {
        return equipoRepositorio.obtenerEquipoPorId(id);
    }

    @Override
    public Equipo crearEquipo(Equipo equipo, Long torneoId) {
        ObtenerTorneoDelPartido(torneoId,equipo);
        return equipoRepositorio.crearEquipo(equipo);
    }

    @Override
    public Equipo actualizarEquipo(Long id, Equipo equipoNuevo) {
        final Equipo equipo = equipoRepositorio.obtenerEquipoPorId(id);
        cambiarValores(equipoNuevo,equipo);
        return equipoRepositorio.actualizarEquipo(equipo);
    }

    @Override
    public Equipo borrarEquipo(Long id) {
        final Equipo equipo = equipoRepositorio.obtenerEquipoPorId(id);
        equipoRepositorio.borrarEquipo(equipo);
        return equipo;
    }

    private void cambiarValores(Equipo equipoNuevo, Equipo equipo) {
        equipo.setGenero(equipoNuevo.getGenero());
        equipo.setLocacion(equipoNuevo.getLocacion());
        equipo.setNombre(equipoNuevo.getNombre());
    }

    private void ObtenerTorneoDelPartido(Long torneoId, Equipo equipo) {
        Torneo torneo =torneoRepositorio.obtenerTroneoPorId(torneoId);
        equipo.setFkTorneo(torneo);
    }

}
