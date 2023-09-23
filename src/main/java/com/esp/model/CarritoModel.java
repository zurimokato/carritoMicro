package com.esp.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Getter
@Setter
public class CarritoModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long identificadorCarrito;
    private Long  idUsuario;
    private String moneda;
    private BigDecimal total;
    @OneToMany
    private List<ProductoModel> productos;



}
