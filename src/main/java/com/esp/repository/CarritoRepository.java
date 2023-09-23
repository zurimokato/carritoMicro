package com.esp.repository;

import com.esp.model.CarritoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CarritoRepository extends JpaRepository<CarritoModel,Long> {

    List<CarritoModel>findAllByIdUsuario(Long idUsuario);
}
