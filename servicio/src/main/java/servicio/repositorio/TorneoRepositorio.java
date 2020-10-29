package servicio.repositorio;

import servicio.dominio.Torneo;

import java.util.List;

public interface TorneoRepositorio {
    List<Torneo> obtenerTorneos() throws Exception;
    Torneo obtenerTroneoPorId(Long id);

}
