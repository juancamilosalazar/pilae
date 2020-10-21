package com.pilae.pilae.service.repository;

import com.pilae.pilae.repository.postgres.Entity.EquipoEntity;
import com.pilae.pilae.service.domain.Equipo;

import java.util.List;

public interface EquipoRepository {
    public List<EquipoEntity> getEquipos();
}
