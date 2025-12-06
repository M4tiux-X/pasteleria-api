package com.pasteleria.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.*;

import com.pasteleria.api.repository.BoletaRepository;
import com.pasteleria.api.entidades.Boleta;

@RestController
@RequestMapping("/api/boleta")
@CrossOrigin(origins = "*")
public class BoletaController {

    private final BoletaRepository repo;

    public BoletaController(BoletaRepository repo){
        this.repo=repo;
    }

    @GetMapping
    public List<Boleta> getBoleta(){
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public Boleta getById(@PathVariable Long id){
        return repo.findById(id).orElse(null);
    }

    @PostMapping
    public Boleta agreProducto(@RequestBody Boleta boleta){
        return repo.save(boleta);
    }

    @PutMapping("/{id}")
    public Boleta actualizar(@PathVariable Long id, @RequestBody Boleta boleta){
        Optional<Boleta> data = repo.findById(id);

        if(data.isPresent()){
            Boleta b = data.get();
            b.setFec_emision(boleta.getFec_emision());
            b.setId_boleta(boleta.getId_boleta());
            b.setId_pedido(boleta.getId_pedido());
            b.setImpuestos(b.getImpuestos());
            b.setMedio_pago(b.getMedio_pago());
            b.setTotal(boleta.getTotal());
            return repo.save(b);
        }

        return null;
    }

    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable Long id){
        if(repo.existsById(id)){
            repo.deleteById(id);
            return "Eliminado correctamente";
        }
        return "No existe registro";
    }
}
