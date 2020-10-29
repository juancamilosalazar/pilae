package servicio;
import servicio.dominio.Equipo;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface EquipoServicio {

    List<Equipo> obtenerTodos() throws Exception;
    Equipo obtenerPorId(Long id);
    Equipo crear(Equipo equipo, Long torneoId);
    Equipo actualizar(Long id, Equipo equipoNuevo);
    Equipo borrar(Long id);
}
