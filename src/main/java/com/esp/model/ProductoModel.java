package com.esp.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
public class ProductoModel implements Serializable {
    @Id
    private String idProducto;
    private Integer cantidad;
    private BigDecimal precio;
    @ManyToOne
    private CarritoModel carrito;
}
