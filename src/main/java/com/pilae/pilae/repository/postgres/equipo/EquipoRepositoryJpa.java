package com.pilae.pilae.repository.postgres.equipo;

import com.pilae.pilae.repository.postgres.Entity.EquipoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface EquipoRepositoryJpa extends JpaRepository<EquipoEntity, Long> {
}
