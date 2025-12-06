package com.pasteleria.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.*;

import com.pasteleria.api.repository.PedidoRepository;
import com.pasteleria.api.entidades.Pedido;

@RestController
@RequestMapping("/api/pedido")
@CrossOrigin(origins = "*")
public class PedidoController {
    private final PedidoRepository repo;

    public PedidoController(PedidoRepository repo){
        this.repo=repo;
    }
    
    @GetMapping
    public List<Pedido> getPedidos(){
        return repo.findAll();
    }
    
    @GetMapping("/{id}")
    public Pedido getById(@PathVariable Long id){
        return repo.findById(id).orElse(null);
    }
    
    @PostMapping
    public Pedido agrePedido(@RequestBody Pedido pedido){
        return repo.save(pedido);
    }
    
    @PutMapping("/{id}")
    public Pedido actualizar(@PathVariable Long id,@RequestBody Pedido pedido){
        Optional<Pedido> data= repo.findById(id);

        if(data.isPresent()){
            Pedido p = data.get();
            p.setEstado_pedido(pedido.getEstado_pedido());
            p.setDireccion_entrga(pedido.getDireccion_entrga());
            p.setFec_entrega(pedido.getFec_entrega());
            return repo.save(p);
        }
        return null;
    }
    
    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable Long id){
        if(repo.existsById(id)){
            repo.deleteById(id);
            return "El pedido a sido eliminado";
        }
        return "No exite el pedido";
    }
}
