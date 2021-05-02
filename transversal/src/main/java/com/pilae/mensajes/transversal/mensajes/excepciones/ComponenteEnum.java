package com.pilae.mensajes.transversal.mensajes.excepciones;

public enum ComponenteEnum {
	DATOS, NEGOCIO, API, DOMINIO, ENTIDAD, DTO, TRANSVERSAL, GENERAL;
	
	public static ComponenteEnum obtenerDefecto() {
		return GENERAL;
	}
}
