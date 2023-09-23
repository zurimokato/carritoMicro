package com.esp.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;


@Getter
@Setter
public class ProductoDTO {
    private String id;
    private Integer cantidad;
    private BigDecimal valor;
    private Long idCarrito;
    private String dije;
    private String material;
    private String tipo;

}
