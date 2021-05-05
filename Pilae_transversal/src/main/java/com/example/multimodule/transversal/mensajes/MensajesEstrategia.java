package com.example.multimodule.transversal.mensajes;


import com.pilae.mensajes.dto.MensajeDTO;

public interface MensajesEstrategia {

	void sincronizar(MensajeDTO mensaje);

	MensajeDTO obtenerMensaje(String codigo);

}
