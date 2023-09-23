package com.esp.model.dto;

import com.esp.model.ProductoModel;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;


@Getter
@Setter
public class CarritoDTO {

    private Long identificadorCarrito;
    private Long  idUsuario;
    private List<ProductoDTO> productos;
    private BigDecimal total;
}
