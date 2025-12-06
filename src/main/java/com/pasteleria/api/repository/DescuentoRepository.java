package com.pasteleria.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.pasteleria.api.entidades.Descuento;

public interface DescuentoRepository extends JpaRepository<Descuento,Long>{
}
