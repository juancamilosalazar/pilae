package com.example.multimodule.repository.servicio.ensamblador.dto.implementacion;

import java.util.ArrayList;
import java.util.List;

import com.example.multimodule.dominio.EquipoDominio;
import com.example.multimodule.dto.Equipo;
import com.example.multimodule.repository.servicio.ensamblador.dto.EnsambladorDTO;
import com.example.multimodule.transversal.excepciones.PILAEDominioExcepcion;
import com.example.multimodule.transversal.excepciones.base.TipoExcepcionEnum;
import com.example.multimodule.transversal.utilitarios.UtilObjeto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EquipoEnsamblador implements EnsambladorDTO<Equipo, EquipoDominio> {

	private ModelMapper modelMapper = new ModelMapper();

	private static final EnsambladorDTO<Equipo, EquipoDominio> instancia = new EquipoEnsamblador();

	private EquipoEnsamblador() {
	}

	public static EnsambladorDTO<Equipo, EquipoDominio> obtenerEquipoEnsambladorDTO() {
		return instancia;
	}

	@Override
	public EquipoDominio ensamblarDominio(Equipo dto) {
		if (UtilObjeto.objetoEsNulo(dto)) {
			String mensajeUsuario = "El objeto es nullo";
			String mensajeTecnico = "El objeto es nullo";
			throw PILAEDominioExcepcion.crear(TipoExcepcionEnum.NEGOCIO, mensajeUsuario, mensajeTecnico);
		}
		return modelMapper.map(dto,EquipoDominio.class);
	}

	@Override
	public Equipo ensamblarDTO(EquipoDominio dominio) {

		if (UtilObjeto.objetoEsNulo(dominio)) {
			String mensajeUsuario = "El objeto es nullo";
			String mensajeTecnico = "El objeto es nullo";
			throw PILAEDominioExcepcion.crear(TipoExcepcionEnum.NEGOCIO, mensajeUsuario, mensajeTecnico);
		}

		return modelMapper.map(dominio,Equipo.class);
	}

	@Override
	public List<Equipo> ensamblarListaDTO(List<EquipoDominio> listaDominios) {

		List<Equipo> listaDTOs = new ArrayList<>();

		if (!UtilObjeto.objetoEsNulo(listaDominios)) {
			for (EquipoDominio equipoDominio : listaDominios) {
				listaDTOs.add(ensamblarDTO(equipoDominio));
			}
		}
		return listaDTOs;
	}
}
