package com.example.multimodule.repository.application;

import com.example.multimodule.dto.Equipo;
import com.example.multimodule.repository.application.utilitario.ConversorDeDataUtilitario;
import com.example.multimodule.repository.servicio.EquipoServicio;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@ComponentScan(basePackages = "com.example.multimodule")
@EntityScan(basePackages = "com.example.multimodule.entidad")
@EnableJpaRepositories(basePackages = "com.example.multimodule.infraestructura")
@SpringBootApplication(scanBasePackages = "com.example.multimodule")
@RestController
public class EquipoControlador {

	private EquipoServicio equipoServicio;
	private final ConversorDeDataUtilitario conversorDeData;

	@Autowired
	public EquipoControlador(EquipoServicio equipoServicio, ConversorDeDataUtilitario conversorDeData) {
		this.equipoServicio = equipoServicio;
		this.conversorDeData = conversorDeData;
	}

	@GetMapping
	public List<Equipo> obtenerTodos() throws Exception {
		return equipoServicio.obtenerTodos();
	}

	@GetMapping(params = {"id"})
	public Equipo obtenerPorId(@RequestParam("id") final Long id) throws Exception {
		return equipoServicio.obtenerPorId(id);
	}



	@PostMapping(params = {"torneoId"})
	public ResponseEntity<String> crear(@RequestParam(value = "torneoId") final Long torneoId, @RequestBody final Equipo equipo) {
		try {
			final Equipo created = equipoServicio
					.crear(Objects
									.requireNonNull(equipo, "Ocurrio un error al procesar el Body de la peticion")
							, torneoId);
			return buildResponse(created);
		} catch (final Exception exception) {
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED)
					.body(exception.getMessage());
		}
	}


	@PutMapping(params = {"id"})
	public ResponseEntity<String> actualizar(@RequestParam(value = "id") final Long id, @RequestBody final Equipo equipoNuevo) {
		try {
			final Equipo actualizado = equipoServicio.actualizar(id,equipoNuevo);
			return buildResponse(actualizado);
		} catch (final Exception ex) {
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED)
					.body(ex.getMessage());
		}
	}

	@DeleteMapping(params = {"id"})
	public ResponseEntity borrarEquipo(@RequestParam("id") final Long id) throws Exception {
		final Equipo borrado = equipoServicio.borrar(id);
		return buildResponse(borrado);
	}

	private ResponseEntity<String> buildResponse(final Equipo entity) throws Exception {
		final String jsonResponse = conversorDeData.dtoToJson(entity);
		return ResponseEntity.ok(jsonResponse);
	}


	public static void main(String[] args) {
		SpringApplication.run(EquipoControlador.class, args);
	}
}
