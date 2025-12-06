package com.pasteleria.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.pasteleria.api.entidades.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido,Long>{
}
