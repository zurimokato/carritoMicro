package com.esp.services;


import com.esp.model.dto.CarritoDTO;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CarritoService {

    List<CarritoDTO> getCarritos(Long idUsuario);

    CarritoDTO guardarCarrito(CarritoDTO carrito);

}
