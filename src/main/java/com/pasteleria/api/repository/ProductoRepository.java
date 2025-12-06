package com.pasteleria.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.pasteleria.api.entidades.Producto;

public interface ProductoRepository extends JpaRepository<Producto,Long>{
}
