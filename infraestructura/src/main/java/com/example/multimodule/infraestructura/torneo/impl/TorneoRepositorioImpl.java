package com.example.multimodule.infraestructura.torneo.impl;

import com.example.multimodule.dto.Torneo;
import com.example.multimodule.entidad.TorneoEntidad;
import com.example.multimodule.infraestructura.torneo.TorneoRepositorio;
import com.example.multimodule.infraestructura.torneo.TorneoRepositorioJpa;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TorneoRepositorioImpl implements TorneoRepositorio {

    private TorneoRepositorioJpa torneoRepositorio;
    private ModelMapper modelMapper = new ModelMapper();
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public TorneoRepositorioImpl(TorneoRepositorioJpa torneoRepositorio) {
        this.torneoRepositorio = torneoRepositorio;
    }

    @Override
    public List<Torneo> obtenerTorneos() throws Exception {
        try{
            return torneoRepositorio.findAll().parallelStream()
                    .map(entity -> modelMapper.map(entity, Torneo.class))
                    .collect(Collectors.toList());
        }catch (Exception e){
            logger.debug(e.getMessage());
            throw new  Exception(e.getMessage());
        }

    }

    @Override
    public Torneo obtenerTroneoPorId(Long id) throws Exception {
        TorneoEntidad equipoEntity = torneoRepositorio
                .findById(id).orElseThrow(() -> {
                    logger.debug("entidad con id: "+id+"no encontrada");
                    return new Exception("Entidad no encontrada");
                });
        return modelMapper.map(equipoEntity, Torneo.class);
    }

}

