package com.pilae.pilae.service.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Equipo implements java.io.Serializable{

    private Long codigo;
    private String nombre;
    private String locacion;
    private String genero;
    private Torneo fkTorneo;
}
