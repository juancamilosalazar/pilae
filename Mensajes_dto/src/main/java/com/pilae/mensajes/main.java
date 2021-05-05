package com.pilae.mensajes;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pilae.mensajes.dto.AplicacionDTO;
import com.pilae.mensajes.dto.MensajeDTO;
import com.pilae.mensajes.enumerador.CategoriaMensajeEnum;
import com.pilae.mensajes.enumerador.TipoMensajeEnum;

import java.util.ArrayList;
import java.util.List;

public class main {

    public static void main(String[] args) throws JsonProcessingException {
        System.out.println("dasda");
        List<MensajeDTO> mensajeDTOList = new ArrayList<>();
        MensajeDTO mensajeDTO= new MensajeDTO();
        AplicacionDTO aplicacionDTO = new AplicacionDTO();
        aplicacionDTO.setCodigo("pilae");
        aplicacionDTO.setMensajes(mensajeDTOList);
        aplicacionDTO.setNombre("pilae");
        mensajeDTO.setAplicacion(aplicacionDTO);
        mensajeDTO.setCategoria(CategoriaMensajeEnum.INFORMACION);
        mensajeDTO.setCodigo("1");
        mensajeDTO.setTipoMensaje(TipoMensajeEnum.USUARIO);
        mensajeDTO.setTitulo("1");
        ObjectMapper objectMapper = new ObjectMapper();

        objectMapper.writeValueAsString(mensajeDTO);
    }
}
