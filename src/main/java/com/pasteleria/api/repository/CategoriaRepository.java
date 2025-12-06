package com.pasteleria.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.pasteleria.api.entidades.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria,Long>{
}
