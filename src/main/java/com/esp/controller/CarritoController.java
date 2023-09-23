package com.esp.controller;

import com.esp.model.dto.CarritoDTO;
import com.esp.services.CarritoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/carritos")
@AllArgsConstructor
public class CarritoController {
    private final CarritoService carritoService;



    @GetMapping("/{idUsuario}")
    public ResponseEntity<List<CarritoDTO>>getCarritosUsuario(@PathVariable Long idUsuario){
        return ResponseEntity.ofNullable(carritoService.getCarritos(idUsuario));
    }

    @PostMapping("/")
    public ResponseEntity<CarritoDTO>guardarCarrito(@RequestBody CarritoDTO carritoDTO){
        return ResponseEntity.ok(carritoService.guardarCarrito(carritoDTO));
    }

}
