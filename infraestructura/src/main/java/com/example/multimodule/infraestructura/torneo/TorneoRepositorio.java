package com.example.multimodule.infraestructura.torneo;

import com.example.multimodule.dto.Torneo;
import com.example.multimodule.entidad.TorneoEntidad;

import java.util.List;

public interface TorneoRepositorio {
    List<TorneoEntidad> obtenerTorneos() throws Exception;
    TorneoEntidad obtenerTroneoPorId(Long id) ;
}
