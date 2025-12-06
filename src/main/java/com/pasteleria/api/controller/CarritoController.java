package com.pasteleria.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.*;

import com.pasteleria.api.repository.CarritoRepository;
import com.pasteleria.api.entidades.Carrito;

@RestController
@RequestMapping("/api/carrito")
@CrossOrigin(origins = "*")
public class CarritoController {
    private final CarritoRepository repo;

    public CarritoController(CarritoRepository repo){
        this.repo=repo;
    }

    @GetMapping
    public List<Carrito> getCarritos(){
        return repo.findAll();
    }
    
    @GetMapping("/{id}")
    public Carrito getById(@PathVariable Long id){
        return repo.findById(id).orElse(null);
    }
    
    @PostMapping
    public Carrito agreCarrito(@RequestBody Carrito carrito){
        return repo.save(carrito);
    }
    
    @PutMapping("/{id}")
    public Carrito actualizar(@PathVariable Long id,@RequestBody Carrito carrito){
        Optional<Carrito> data = repo.findById(id);

        if(data.isPresent()){
            Carrito c = data.get();
            c.setEstado(carrito.getEstado());
            c.setId_Usuario(carrito.getId_Usuario());
            c.setTotal(carrito.getTotal());
            return repo.save(c);
        }
        return null;
    }
    
    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable Long id){
        if(repo.existsById(id)){
            repo.deleteById(id);
            return "carrito eliminado";
        }
        return "No existe";
    }
}
