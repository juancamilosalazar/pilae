package com.pilae.pilae.repositorio.postgres.torneo;

import com.pilae.pilae.repositorio.postgres.Entity.TorneoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface TorneoRepositorioJpa  extends JpaRepository<TorneoEntity, Long> {

}
