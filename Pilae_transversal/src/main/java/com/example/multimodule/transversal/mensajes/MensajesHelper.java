package com.example.multimodule.transversal.mensajes;


import com.example.multimodule.transversal.excepciones.PILAEDominioExcepcion;
import com.example.multimodule.transversal.excepciones.base.TipoExcepcionEnum;
import com.example.multimodule.transversal.mensajes.implementacion.CacheMensajes;
import com.example.multimodule.transversal.utilitarios.UtilTexto;
import com.pilae.mensajes.dto.MensajeDTO;

public class MensajesHelper {

	private static String estrategiaMensajeria;

	public static void configurarEstrategiaMensajeria(String estrategia) {
		if (UtilTexto.estaVacia(estrategia)) {
			String textoTecnico = "La estrategia de mensajer�a no puede ser vac�a";
			String textoUsuario = "Se ha presentado un problema tratando de llevar a cabo la operaci�n solicitada";
			throw PILAEDominioExcepcion.crear(TipoExcepcionEnum.APLICACION, textoUsuario, textoTecnico, new Exception());
		}

		estrategiaMensajeria = UtilTexto.aplicarTrim(estrategia);
	}

	private static MensajesEstrategia obtenerMensajesEstrategia() {
		if ("CACHE_MENSAJES".equals(estrategiaMensajeria)) {
			return CacheMensajes.obtenerCacheMensajes();
		} else {
			String textoTecnico = "La estrategia de mensajer�a ".concat(estrategiaMensajeria).concat(" no se encuentra implementada!!!");
			String textoUsuario = "Se ha presentado un problema tratando de llevar a cabo la operaci�n solicitada";

			throw PILAEDominioExcepcion.crear(TipoExcepcionEnum.APLICACION, textoUsuario, textoTecnico, new Exception());
		}
	}
	
	public static MensajeDTO obtenerMensaje(String codigo) {
		return obtenerMensajesEstrategia().obtenerMensaje(codigo);
	}

}
