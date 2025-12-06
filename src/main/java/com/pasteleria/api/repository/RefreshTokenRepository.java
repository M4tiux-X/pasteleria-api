package com.pasteleria.api.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.pasteleria.api.entidades.RefreshToken;
import com.pasteleria.api.entidades.Usuario;

public interface RefreshTokenRepository extends JpaRepository<RefreshToken,Long>{
    Optional<RefreshToken> findByToken(String token);
    Optional<RefreshToken> findByUsuario(Usuario usuario);
    void deleteByUsuario(Usuario usuario);
}
