package com.pilae.pilae.controlador.rest;

import com.pilae.pilae.controlador.rest.util.ConversorDeDataUtil;
import com.pilae.pilae.servicio.EquipoServicio;
import com.pilae.pilae.servicio.dominio.Equipo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping(path = "/equipo")
public class EquipoControlador {

    private EquipoServicio equipoServicio;
    private final ConversorDeDataUtil conversorDeData;

    @Autowired
    public EquipoControlador(EquipoServicio equipoServicio, ConversorDeDataUtil conversorDeData) {
        this.equipoServicio = equipoServicio;
        this.conversorDeData = conversorDeData;
    }

    @GetMapping
    public List<Equipo> obtenerTodosLosEquipos() throws Exception {
        return equipoServicio.obtenerEquipos();
    }

    @GetMapping(params = {"id"})
    public Equipo buscarPorId(@RequestParam("id") final Long id) {
        return equipoServicio.obtenerEquipoPorId(id);
    }

    /*@GetMapping(params = {"idTorneo"})
    public List<Equipo> buscarEquiposPorTorneo(@RequestParam("idTorneo") final Long id) {
        return equipoServicio.obtenerEquipoPorTorneo(id);
    }*/

    @PostMapping(params = {"torneoId"})
    public ResponseEntity<String> crearEquipo(@RequestParam(value = "torneoId") final Long torneoId, @RequestBody final Equipo equipo) {
        try {
            final Equipo created = equipoServicio
                    .crearEquipo(Objects
                            .requireNonNull(equipo, "Ocurrio un error al procesar el Body de la peticion")
                            , torneoId);
            return buildResponse(created);
        } catch (final Exception ex) {
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED)
                    .body(ex.getMessage());
        }
    }


    @PutMapping(params = {"id"})
    public ResponseEntity<String> actualizar(@RequestParam(value = "id") final Long id, @RequestBody final Equipo equipoNuevo) {
        try {
            final Equipo actualizado = equipoServicio.actualizarEquipo(id,equipoNuevo);
            return buildResponse(actualizado);
        } catch (final Exception ex) {
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED)
                    .body(ex.getMessage());
        }
    }

    @DeleteMapping(params = {"id"})
    public ResponseEntity borrarEquipo(@RequestParam("id") final Long id) throws Exception {
        final Equipo borrado = equipoServicio.borrarEquipo(id);
        return buildResponse(borrado);
    }

    private ResponseEntity<String> buildResponse(final Equipo entity) throws Exception {
        final String jsonResponse = conversorDeData.dtoToJson(entity);
        return ResponseEntity.ok(jsonResponse);
    }
}
