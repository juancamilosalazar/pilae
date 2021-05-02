package com.pilae.mensajes.dao;

import com.pilae.mensajes.dto.AplicacionDTO;

import java.util.List;



public interface AplicacionDAO {

	void crear(AplicacionDTO aplicacion);

	void modificar(AplicacionDTO aplicacion);

	void eliminar(AplicacionDTO aplicacion);

	List<AplicacionDTO> consultar(AplicacionDTO aplicacion);

}
