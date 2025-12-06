package com.pasteleria.api.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.pasteleria.api.entidades.LoginResponse;
import com.pasteleria.api.entidades.Usuario;
import com.pasteleria.api.repository.UsuarioRepository;
import com.pasteleria.api.config.JwtUtil;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private RefreshTokenService refreshTokenService;

    public LoginResponse register(Usuario usuario) {
        if (usuario.getCorreo().contains("admin") || usuario.getCorreo().endsWith("@admin.com")) {
            usuario.setId_tipo_usu(1);
        } else {
            usuario.setId_tipo_usu(2);
        }

        usuario.setPass(passwordEncoder.encode(usuario.getPass()));
        usuarioRepository.save(usuario);

        LoginResponse res = new LoginResponse();
        res.setSuccess(true);
        res.setMessage("Usuario registrado");
        res.setUsuario(usuario);
        return res;
    }

    public LoginResponse login(String correo, String pass) {
        LoginResponse response = new LoginResponse();

        Optional<Usuario> usuarioOpt = usuarioRepository.findByCorreo(correo.toLowerCase());
        if (usuarioOpt.isEmpty()) {
            response.setSuccess(false);
            response.setMessage("Correo o contraseña incorrectos");
            return response;
        }

        Usuario usuario = usuarioOpt.get();

        if (!passwordEncoder.matches(pass, usuario.getPass())) {
            response.setSuccess(false);
            response.setMessage("Correo o contraseña incorrectos");
            return response;
        }

        String accessToken = jwtUtil.generateAccessToken(usuario.getCorreo(), usuario.getId_tipo_usu());
        var refresh = refreshTokenService.createRefreshToken(usuario);

        response.setSuccess(true);
        response.setMessage("Login exitoso");
        response.setUsuario(usuario);
        response.setToken(accessToken);
        response.setRefreshToken(refresh.getToken());
        return response;
    }

    public String generateAccessTokenForUser(Usuario usuario) {
        return jwtUtil.generateAccessToken(usuario.getCorreo(), usuario.getId_tipo_usu());
    }
}
