package com.esp.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;


@Getter
@Setter
public class ProductoDTO {
    private String idProducto;
    private Integer cantidad;
    private BigDecimal precio;
    private Long idCarrito;

}
