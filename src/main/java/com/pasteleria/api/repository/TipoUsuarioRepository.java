package com.pasteleria.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.pasteleria.api.entidades.TipoUsuario;

public interface TipoUsuarioRepository extends JpaRepository<TipoUsuario,Long> {
}
