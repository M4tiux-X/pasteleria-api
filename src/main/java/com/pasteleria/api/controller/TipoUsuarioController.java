package com.pasteleria.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.*;

import com.pasteleria.api.entidades.TipoUsuario;
import com.pasteleria.api.repository.TipoUsuarioRepository;

@RestController
@RequestMapping("api/tipo_usu")
@CrossOrigin(origins = "*")
public class TipoUsuarioController {
    private final TipoUsuarioRepository repo;

    public TipoUsuarioController(TipoUsuarioRepository repo){
        this.repo=repo;
    }

    @GetMapping
    public List<TipoUsuario> getTipo(){
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public TipoUsuario getById(@PathVariable Long id){
        return repo.findById(id).orElse(null);
    }

    @PostMapping
    public TipoUsuario agreTipo_usu(@RequestBody TipoUsuario tipo_usu){
        return repo.save(tipo_usu);
    }

    @PutMapping("/{id}")
    public TipoUsuario actualizar(@PathVariable Long id, @RequestBody TipoUsuario tipo_usu){
        Optional<TipoUsuario> data = repo.findById(id);

        if (data.isPresent()) {
            TipoUsuario t = data.get();
            t.setTipo_usu(tipo_usu.getTipo_usu());
            return repo.save(t);
        }

        return null;
    }

    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable Long id){
        if (repo.existsById(id)) {
            repo.deleteById(id);
            return "Eliminado correctamente";
        }
        return "No existe el registro";
    }
}
