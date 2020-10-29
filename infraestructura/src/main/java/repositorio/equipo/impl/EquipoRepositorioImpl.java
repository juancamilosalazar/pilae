package repositorio.equipo.impl;

import repositorio.base.entidad.EquipoEntidad;
import repositorio.equipo.EquipoRepositorioJpa;
import repositorio.base.excepciones.ResourceNotFoundException;
import servicio.dominio.Equipo;
import servicio.repositorio.EquipoRepositorio;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EquipoRepositorioImpl implements EquipoRepositorio {

    private EquipoRepositorioJpa equipoRepository;
    private ModelMapper modelMapper;
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public EquipoRepositorioImpl(EquipoRepositorioJpa equipoRepository, ModelMapper modelMapper) {
        this.equipoRepository = equipoRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public List<Equipo> obtenerTodos() throws Exception {
        try{
            return equipoRepository.findAll().parallelStream()
                    .map(entity -> modelMapper.map(entity, Equipo.class))
                    .collect(Collectors.toList());
        }catch (Exception e){
            logger.debug(e.getMessage());
            throw new  Exception(e.getMessage());
        }

    }

    @Override
    public Equipo obtenerEquipoPorId(Long id) {
         EquipoEntidad equipoEntidad = equipoRepository
                 .findById(id).orElseThrow(() -> {
                     logger.debug("entidad con id: "+id+"no encontrada");
                     return new ResourceNotFoundException("equipo_tbl", "equipo_tbl", id);
                 });
         return modelMapper.map(equipoEntidad, Equipo.class);
    }

    @Override
    public Equipo crear(Equipo equipo) {
        return guardarEquipoBaseDeDatos(equipo);
    }

    @Override
    public Equipo actualizar(Equipo equipo) {
        return guardarEquipoBaseDeDatos(equipo);
    }

    @Override
    public void borrar(Equipo equipo) {
        equipoRepository.delete(modelMapper.map(equipo, EquipoEntidad.class));
    }

    private Equipo guardarEquipoBaseDeDatos(Equipo equipo) {
        EquipoEntidad equipoEntidad = modelMapper.map(equipo, EquipoEntidad.class);
        return modelMapper.map(equipoRepository.saveAndFlush(equipoEntidad),Equipo.class);
    }
}
