package repositorio.torneo;

import repositorio.base.entidad.TorneoEntidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TorneoRepositorioJpa  extends JpaRepository<TorneoEntidad, Long> {

}
