package com.example.multimodule.infraestructura.torneo;

import com.example.multimodule.dto.Torneo;

import java.util.List;

public interface TorneoRepositorio {
    List<Torneo> obtenerTorneos() throws Exception;
    Torneo obtenerTroneoPorId(Long id) throws Exception;
}
