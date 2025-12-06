package com.pasteleria.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.pasteleria.api.service.UsuarioService;
import com.pasteleria.api.service.RefreshTokenService;
import com.pasteleria.api.entidades.LoginRequest;
import com.pasteleria.api.entidades.LoginResponse;
import com.pasteleria.api.entidades.Usuario;
import com.pasteleria.api.entidades.RefreshToken;

import java.util.Optional;

@RestController
@RequestMapping("/api/usuario")
@CrossOrigin(origins = "*")
public class AuthController {
    private final UsuarioService usuarioService;
    private final RefreshTokenService refreshTokenService;

    public AuthController(UsuarioService usuarioService, RefreshTokenService refreshTokenService) {
        this.usuarioService = usuarioService;
        this.refreshTokenService = refreshTokenService;
    }

    @PostMapping("/register")
    public ResponseEntity<LoginResponse> register(@RequestBody Usuario usuario) {
        LoginResponse res = usuarioService.register(usuario);
        return ResponseEntity.ok(res);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest) {
        LoginResponse res = usuarioService.login(loginRequest.getCorreo(), loginRequest.getPass());

        if (res.isSuccess()) return ResponseEntity.ok(res);
        return ResponseEntity.status(401).body(res);
    }

    @PostMapping("/refresh")
    public ResponseEntity<?> refresh(@RequestBody String refreshTokenStr) {
        Optional<RefreshToken> refreshOpt = refreshTokenService.findByToken(refreshTokenStr);
        if (refreshOpt.isEmpty()) {
            return ResponseEntity.status(401).body("Refresh token inválido");
        }
        RefreshToken refresh = refreshOpt.get();
        if (refreshTokenService.isExpired(refresh)) {
            refreshTokenService.deleteByUsuario(refresh.getUsuario());
            return ResponseEntity.status(401).body("Refresh token expirado");
        }

        String newAccess = usuarioService.generateAccessTokenForUser(refresh.getUsuario());
        return ResponseEntity.ok(new java.util.HashMap<String, String>() {{
            put("accessToken", newAccess);
        }});
    }
}
