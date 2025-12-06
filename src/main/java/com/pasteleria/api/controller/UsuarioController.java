package com.pasteleria.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.pasteleria.api.service.UsuarioService;
import com.pasteleria.api.entidades.LoginRequest;
import com.pasteleria.api.entidades.LoginResponse;
import com.pasteleria.api.entidades.Usuario;
import com.pasteleria.api.repository.UsuarioRepository;

@RestController
@RequestMapping("api/usuarioNormal")
@CrossOrigin(origins = "*")
public class UsuarioController {

    private final PasswordEncoder passwordEncoder;
    @Autowired
    private final UsuarioRepository repo;

    @Autowired
    private UsuarioService usuarioService;

    public UsuarioController(UsuarioRepository repo, PasswordEncoder passwordEncoder){
        this.repo=repo;
        this.passwordEncoder = passwordEncoder;
    }
    
    @GetMapping
    public List<Usuario>getUsuarios(){
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public Usuario getbyId(@PathVariable Long id){
        return repo.findById(id).orElse(null);
    }

    @PostMapping
    public Usuario agreUsuario(@RequestBody Usuario usuario){
        usuario.setPass(passwordEncoder.encode(usuario.getPass()));

        String correoLower=usuario.getCorreo().toLowerCase();
        
        if(correoLower.contains("admin")||correoLower.endsWith("@admin.com")){
            usuario.setId_tipo_usu(1);
        }else{
            usuario.setId_tipo_usu(2);
        }

        return repo.save(usuario);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest){

        LoginResponse response= usuarioService.login(loginRequest.getCorreo(), loginRequest.getPass());

        if (response.isSuccess()) {
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }
    }

    @PutMapping("/{id}")
    public Usuario actualizar(@PathVariable Long id, @RequestBody Usuario usuario){
        Optional<Usuario> data = repo.findById(id);

        if( data.isPresent()){
            Usuario usu = data.get();
            usu.setNombre(usuario.getNombre());
            usu.setId_tipo_usu(usuario.getId_tipo_usu());
            usu.setApellido(usuario.getApellido());
            usu.setCorreo(usuario.getCorreo());
            return repo.save(usu);
        }

        return null;
    }

    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable Long id){
        if(repo.existsById(id)){
            repo.deleteById(id);
            return "eliminado correctamente";
        }
        return "no existe registro";
    }
}
