package com.pilae.pilae.repository.postgres.equipo;

import com.pilae.pilae.repository.postgres.Entity.EquipoEntity;
import com.pilae.pilae.service.repository.EquipoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EquipoRepositoryImpl implements EquipoRepository {

    EquipoRepositoryJpa equipoRepository;

    @Autowired
    public EquipoRepositoryImpl(EquipoRepositoryJpa equipoRepository) {
        this.equipoRepository = equipoRepository;
    }

    @Override
    public List<EquipoEntity> getEquipos() {
        return equipoRepository.findAll();
    }
}
