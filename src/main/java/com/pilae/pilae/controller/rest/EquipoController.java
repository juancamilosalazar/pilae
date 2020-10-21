package com.pilae.pilae.controller.rest;

import com.pilae.pilae.service.EquipoService;
import com.pilae.pilae.service.domain.Equipo;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/equipo")
public class EquipoController {

    EquipoService equipoService;

    public EquipoController(EquipoService equipoService) {
        this.equipoService = equipoService;
    }

    @GetMapping
    public List<Equipo> findAll() {
    return equipoService.getEquipos();
    }
}
