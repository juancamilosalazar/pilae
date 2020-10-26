package com.pilae.pilae.repositorio.postgres.equipo.impl;

import com.pilae.pilae.repositorio.postgres.Entity.EquipoEntity;
import com.pilae.pilae.repositorio.postgres.equipo.EquipoRepositorioJpa;
import com.pilae.pilae.repositorio.postgres.excepciones.ResourceNotFoundException;
import com.pilae.pilae.servicio.dominio.Equipo;
import com.pilae.pilae.servicio.repositorio.EquipoRepositorio;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EquipoRepositorioImpl implements EquipoRepositorio {

    private EquipoRepositorioJpa equipoRepository;
    private ModelMapper modelMapper;
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public EquipoRepositorioImpl(EquipoRepositorioJpa equipoRepository, ModelMapper modelMapper) {
        this.equipoRepository = equipoRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public List<Equipo> obtenerEquipos() throws Exception {
        try{
            return equipoRepository.findAll().parallelStream()
                    .map(entity -> modelMapper.map(entity, Equipo.class))
                    .collect(Collectors.toList());
        }catch (Exception e){
            logger.debug(e.getMessage());
            throw new  Exception(e.getMessage());
        }

    }

    @Override
    public Equipo obtenerEquipoPorId(Long id) {
         EquipoEntity equipoEntity = equipoRepository
                 .findById(id).orElseThrow(() -> {
                     logger.debug("entidad con id: "+id+"no encontrada");
                     return new ResourceNotFoundException("equipo_tbl", "equipo_tbl", id);
                 });
         return modelMapper.map(equipoEntity, Equipo.class);
    }

    @Override
    public Equipo crearEquipo(Equipo equipo) {
        return guardarEquipoBaseDeDatos(equipo);
    }

    @Override
    public Equipo actualizarEquipo(Equipo equipo) {
        return guardarEquipoBaseDeDatos(equipo);
    }

    @Override
    public void borrarEquipo(Equipo equipo) {
        equipoRepository.delete(modelMapper.map(equipo,EquipoEntity.class));
    }

    private Equipo guardarEquipoBaseDeDatos(Equipo equipo) {
        EquipoEntity equipoEntity = modelMapper.map(equipo, EquipoEntity.class);
        return modelMapper.map(equipoRepository.saveAndFlush(equipoEntity),Equipo.class);
    }
}
