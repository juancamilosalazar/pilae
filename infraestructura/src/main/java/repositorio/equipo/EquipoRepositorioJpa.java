package repositorio.equipo;

import org.springframework.data.jpa.repository.JpaRepository;
import repositorio.base.entidad.EquipoEntidad;
import repositorio.base.entidad.TorneoEntidad;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public interface EquipoRepositorioJpa extends JpaRepository<EquipoEntidad, Long> {
    List<EquipoEntidad> findByFkTorneo(TorneoEntidad fkTorneo);
    List<EquipoEntidad> findAllByFkTorneoCodigo(final Long codigo);
}
