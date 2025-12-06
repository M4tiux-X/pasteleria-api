package com.pasteleria.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.pasteleria.api.entidades.Carrito;

public interface CarritoRepository extends JpaRepository<Carrito,Long>{
}
