package com.pasteleria.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.*;

import com.pasteleria.api.entidades.Categoria;
import com.pasteleria.api.repository.CategoriaRepository;

@RestController
@RequestMapping("/api/categoria")
@CrossOrigin(origins = "*")
public class CategoriaController {
    private final CategoriaRepository repo;

    public CategoriaController(CategoriaRepository repo){
        this.repo=repo;
    }

    @GetMapping
    public List<Categoria>getCategoria(){
        return repo.findAll();
    }
    
    @GetMapping("/{id}")
    public Categoria getById(@PathVariable Long id){
        return repo.findById(id).orElse(null);
    }
    
    @PostMapping
    public Categoria agreCategoria(@RequestBody Categoria categoria){
        return repo.save(categoria);
    }
    
    @PutMapping("/{id}")
    public Categoria actualizar(@PathVariable Long id,@RequestBody Categoria categoria){
        Optional<Categoria> data = repo.findById(id);
        if(data.isPresent()){
            Categoria c = data.get();
            c.setNombre_cat(categoria.getNombre_cat());
            c.setDescripcion(categoria.getDescripcion());
            return repo.save(c);
        }
        return null;
    }
    
    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable Long id){
        if(repo.existsById(id)){
            repo.deleteById(id);
            return "categoria eliminada";
        }
        return "categoria no encotrada";
    }
}
