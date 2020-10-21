package com.pilae.pilae.service.impl;

import com.pilae.pilae.service.domain.Equipo;
import com.pilae.pilae.service.EquipoService;
import com.pilae.pilae.service.repository.EquipoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EquipoServiceImpl implements EquipoService {

    private EquipoRepository equipoRepository;
    private ModelMapper modelMapper;

    @Autowired
    public EquipoServiceImpl(EquipoRepository equipoRepository, ModelMapper modelMapper) {
        this.equipoRepository = equipoRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<Equipo> getEquipos() {
        return equipoRepository.getEquipos().parallelStream()
                .map(entity -> modelMapper.map(entity, Equipo.class))
                .collect(Collectors.toList());
    }
}
