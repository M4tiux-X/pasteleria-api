package com.pasteleria.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.pasteleria.api.entidades.CarritoDetalle;

public interface CarritoDetalleRepository extends JpaRepository<CarritoDetalle,Long>{
}
