package com.pilae.pilae.servicio.repositorio;

import com.pilae.pilae.servicio.dominio.Torneo;

import java.util.List;

public interface TorneoRepositorio {
    List<Torneo> obtenerTorneos() throws Exception;
    Torneo obtenerTroneoPorId(Long id);

}
