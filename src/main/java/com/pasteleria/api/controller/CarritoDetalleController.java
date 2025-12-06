package com.pasteleria.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.*;

import com.pasteleria.api.entidades.CarritoDetalle;
import com.pasteleria.api.repository.CarritoDetalleRepository;

@RestController
@RequestMapping("/api/carrito_detalle")
@CrossOrigin(origins = "*")
public class CarritoDetalleController {
    private final CarritoDetalleRepository repo;

    public CarritoDetalleController(CarritoDetalleRepository repo){
        this.repo=repo;
    }

    @GetMapping
    public List<CarritoDetalle> getProductos(){
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public CarritoDetalle getById(@PathVariable Long id){
        return repo.findById(id).orElse(null);
    }

    @PostMapping
    public CarritoDetalle agreProducto(@RequestBody CarritoDetalle carrito_detalle){
        return repo.save(carrito_detalle);
    }
    
    @PutMapping("/{id}")
    public CarritoDetalle actualizar(@PathVariable Long id, @RequestBody CarritoDetalle carrito_detalle){
        Optional<CarritoDetalle> data = repo.findById(id);

        if(data.isPresent()){
            CarritoDetalle cd = data.get();
            cd.setCantidad(carrito_detalle.getCantidad());
            cd.setId__carrito(carrito_detalle.getId__carrito());
            cd.setId_carrito_detalle(carrito_detalle.getId_carrito_detalle());
            cd.setId_producto(carrito_detalle.getId_producto());
            cd.setSubtotal(carrito_detalle.getSubtotal());
            return repo.save(cd);
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
