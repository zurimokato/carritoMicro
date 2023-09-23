package com.esp.converter;

import com.esp.model.CarritoModel;
import com.esp.model.dto.CarritoDTO;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.stream.Collectors;


@Slf4j
public class CarritoConverter {

    public static CarritoDTO entityToDTO (CarritoModel entity){
        CarritoDTO carritoDTO = new CarritoDTO();
        if(entity == null){
            throw new EntityNotFoundException("Parametro de entrada nula, registro no localizado con los datos suministrados");
        }
        try {
            log.debug("EntidadHashcode: "+ entity.hashCode());
        }catch(EntityNotFoundException e) {
            throw new EntityNotFoundException("Parametro de entrada nula, registro no localizado con los datos suministrados");
        }
        carritoDTO.setIdentificadorCarrito(entity.getIdentificadorCarrito());
        carritoDTO.setIdUsuario(entity.getIdUsuario());
        carritoDTO.setTotal(entity.getTotal());
        if(entity.getProductos().size()>0){
            carritoDTO.setProductos(ProductoConverter.entityToDTO(entity.getProductos()));
        }


        return carritoDTO;
    }

    public static List<CarritoDTO> entityToDTO (List<CarritoModel> entities){
        return entities.stream().map(CarritoConverter::entityToDTO).collect(Collectors.toList());
    }


}
