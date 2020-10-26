package com.pilae.pilae.repositorio.postgres.equipo;

import com.pilae.pilae.repositorio.postgres.Entity.EquipoEntity;
import com.pilae.pilae.repositorio.postgres.Entity.TorneoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public interface EquipoRepositorioJpa extends JpaRepository<EquipoEntity, Long> {
    List<EquipoEntity> findByFkTorneo(TorneoEntity fkTorneo);
    List<EquipoEntity> findAllByFkTorneoCodigo(final Long codigo);
}
