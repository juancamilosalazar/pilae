package repositorio.torneo.impl;
import repositorio.base.entidad.TorneoEntidad;
import repositorio.base.excepciones.ResourceNotFoundException;
import repositorio.torneo.TorneoRepositorioJpa;
import servicio.dominio.Torneo;
import servicio.repositorio.TorneoRepositorio;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public class TorneoRepositorioImpl implements TorneoRepositorio {

    private TorneoRepositorioJpa torneoRepositorio;
    private ModelMapper modelMapper;
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public TorneoRepositorioImpl(TorneoRepositorioJpa torneoRepositorio, ModelMapper modelMapper) {
        this.torneoRepositorio = torneoRepositorio;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<Torneo> obtenerTorneos() throws Exception {
        try{
            return torneoRepositorio.findAll().parallelStream()
                    .map(entity -> modelMapper.map(entity, Torneo.class))
                    .collect(Collectors.toList());
        }catch (Exception e){
            logger.debug(e.getMessage());
            throw new  Exception(e.getMessage());
        }

    }

    @Override
    public Torneo obtenerTroneoPorId(Long id) {
        TorneoEntidad equipoEntity = torneoRepositorio
                .findById(id).orElseThrow(() -> {
                    logger.debug("entidad con id: "+id+"no encontrada");
                    return new ResourceNotFoundException("torneo", "torneo", id);
                });
        return modelMapper.map(equipoEntity, Torneo.class);
    }

}
