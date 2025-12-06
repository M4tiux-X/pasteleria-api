package com.pasteleria.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.*;

import com.pasteleria.api.entidades.Descuento;
import com.pasteleria.api.repository.DescuentoRepository;

@RestController
@RequestMapping("/api/descuento")
@CrossOrigin(origins = "*")
public class DescuentoController {
    private final DescuentoRepository repo;

    public DescuentoController(DescuentoRepository repo){
        this.repo=repo;
    }

    @GetMapping
    public List<Descuento> getDescuentos(){
        return repo.findAll();
    }
    
    @GetMapping("/{id}")
    public Descuento getById(@PathVariable Long id){
        return repo.findById(id).orElse(null);
    }
    
    @PostMapping
    public Descuento agreDescuento(@RequestBody Descuento descuentos){
        return repo.save(descuentos);
    }
    
    @PutMapping("/{id}")
    public Descuento actualizar(@PathVariable Long id, @RequestBody Descuento descuentos){
        Optional<Descuento> data = repo.findById(id);

        if(data.isPresent()){
            Descuento d = data.get();
            d.setCodigo(descuentos.getCodigo());
            d.setDescripcion(descuentos.getDescripcion());
            d.setFec_fin(descuentos.getFec_fin());
            d.setEstado(descuentos.getEstado());
            return repo.save(d);
        }
        return null;
    }
    
    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable Long id){
        if(repo.existsById(id)){
            repo.deleteById(id);
            return "descuento eliminado";
        }
        return "no existe el descuento";
    }
}
