package com.esp.converter;

import com.esp.model.ProductoModel;
import com.esp.model.dto.ProductoDTO;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class ProductoConverter {

    public static ProductoDTO entityToDTO (ProductoModel entity){
        ProductoDTO productoDTO = new ProductoDTO();
        if(entity == null){
            throw new EntityNotFoundException("Parametro de entrada nula, registro no localizado con los datos suministrados");
        }
        try {
            log.debug("EntidadHashcode: "+ entity.hashCode());
        }catch(EntityNotFoundException e) {
            throw new EntityNotFoundException("Parametro de entrada nula, registro no localizado con los datos suministrados");
        }
        productoDTO.setIdCarrito(entity.getCarrito().getIdentificadorCarrito());
        productoDTO.setIdProducto(entity.getIdProducto());
        productoDTO.setCantidad(entity.getCantidad());


        return productoDTO;
    }

    public static List<ProductoDTO> entityToDTO (List<ProductoModel> entities){
        return entities.stream().map(ProductoConverter::entityToDTO).collect(Collectors.toList());
    }
}
