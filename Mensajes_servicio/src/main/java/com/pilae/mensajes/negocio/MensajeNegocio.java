package com.pilae.mensajes.negocio;


import com.pilae.mensajes.dto.MensajeDTO;

import java.util.List;


public interface MensajeNegocio {

	void crear(MensajeDTO mensaje);

	void modificar(MensajeDTO mensaje);

	void eliminar(MensajeDTO mensaje);

	List<MensajeDTO> consultar(MensajeDTO mensaje);
}
