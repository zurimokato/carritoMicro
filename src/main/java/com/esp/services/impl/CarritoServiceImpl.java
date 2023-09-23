package com.esp.services.impl;

import com.esp.converter.CarritoConverter;
import com.esp.model.CarritoModel;
import com.esp.model.ProductoModel;
import com.esp.model.dto.CarritoDTO;
import com.esp.repository.CarritoRepository;
import com.esp.repository.ProductoRepository;
import com.esp.services.CarritoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CarritoServiceImpl implements CarritoService {

    private final CarritoRepository carritoRepository;
    private final ProductoRepository productoRepository;
    @Override
    public List<CarritoDTO> getCarritos(Long idUsuario) {

        if (idUsuario==null){
            throw new  NullPointerException("id usuario es un campo obligatorio");
        }
        return CarritoConverter.entityToDTO(carritoRepository.findAllByIdUsuario(idUsuario));

    }

    @Override
    public CarritoDTO guardarCarrito(CarritoDTO carrito) {
        if(carrito==null){
            throw new NullPointerException();
        }

        if(carrito.getIdUsuario()==null){
            throw new NullPointerException();
        }
        CarritoModel model= new CarritoModel();
        model.setIdUsuario(carrito.getIdUsuario());
        model.setTotal(carrito.getTotal());
        final CarritoModel fCarrito =carritoRepository.save(model);
        if(!carrito.getProductos().isEmpty()){
          List<ProductoModel>productoModels=  carrito.getProductos().stream().map(productoDTO -> {
                ProductoModel pModel= new ProductoModel();
                pModel.setCantidad(productoDTO.getCantidad());
                pModel.setIdProducto(productoDTO.getIdProducto());
                pModel.setCarrito(fCarrito);
                pModel.setPrecio(productoDTO.getPrecio());
                return pModel;
            }).toList();
          productoRepository.saveAll(productoModels);

        }

        return CarritoConverter.entityToDTO(fCarrito);

    }
}
