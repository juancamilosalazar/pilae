package com.example.multimodule.repository.servicio.impl;

import com.example.multimodule.dto.Equipo;
import com.example.multimodule.dto.Torneo;
import com.example.multimodule.infraestructura.equipo.EquipoRepositorio;
import com.example.multimodule.infraestructura.torneo.TorneoRepositorio;
import com.example.multimodule.repository.servicio.EquipoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipoServicioImpl  implements EquipoServicio {

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
    public Equipo obtenerPorId(Long id) throws Exception {
        return equipoRepositorio.obtenerEquipoPorId(id);
    }

    @Override
    public Equipo crear(Equipo equipo, Long torneoId) throws Exception {
        ObtenerTorneoDelPartido(torneoId,equipo);
        return equipoRepositorio.crear(equipo);
    }

    @Override
    public Equipo actualizar(Long id, Equipo equipoNuevo) throws Exception {
        final Equipo equipo = equipoRepositorio.obtenerEquipoPorId(id);
        cambiarValores(equipoNuevo,equipo);
        return equipoRepositorio.actualizar(equipo);
    }

    @Override
    public Equipo borrar(Long id) throws Exception {
        final Equipo equipo = equipoRepositorio.obtenerEquipoPorId(id);
        equipoRepositorio.borrar(equipo);
        return equipo;
    }

    private void cambiarValores(Equipo equipoNuevo, Equipo equipo) {
        equipo.setGenero(equipoNuevo.getGenero());
        equipo.setLocacion(equipoNuevo.getLocacion());
        equipo.setNombre(equipoNuevo.getNombre());
    }

    private void ObtenerTorneoDelPartido(Long torneoId, Equipo equipo) throws Exception {
        Torneo torneo =torneoRepositorio.obtenerTroneoPorId(torneoId);
        equipo.setTorneo(torneo);
    }

}
